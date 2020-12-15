package mef.organigramma.portlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LayoutTypePortletFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import mef.organigramma.util.QueryUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.mef.intranet.rubrica.service.SearchDataLocalServiceUtil;
import it.intranetdag.rubrica.services.vo.xsd.*;
import mef.organigramma.beans.*;
//import javax.xml.bind.JAXBElement;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=Mef-Portlet",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=mef-organigramma Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MefOrganigrammaPortlet extends MVCPortlet {
 
	// TODO
	// inserire il nome della rubrica
	private final static String PORTLET_NAME = "com_mef_intranet_rubrica_portlet_portlet_MefRubricaFormmvcportletPortlet";
	private volatile MefOrganigrammaConfig _configuration;
	final Log _log = LogFactoryUtil.getLog(MefOrganigrammaPortlet.class);

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		renderRequest.setAttribute(MefOrganigrammaConfig.class.getName(), _configuration);

		// fullfill the department list
		List<StrutturaBean> listaDipartimenti = getListaStruttureFromOrgchart(Long.parseLong("847"));
		renderRequest.setAttribute("listDipartimenti", listaDipartimenti);

		// fullfill directions list and complete the department list
		// for(StrutturaBean dipartimentoItem:listaDipartimenti){
		//
		// //initialize directions list and office list
		// List<StrutturaBean> listaDirezioni = new ArrayList
		// <StrutturaBean>(0);
		// List<StrutturaBean> listaUffici = new ArrayList <StrutturaBean>(0);

		// \"+dipartimentoItem.getNome() );
		//
		// listaDirezioni = getListaStrutture(dipartimentoItem.getId());
		// dipartimentoItem.setStrutture(listaDirezioni);
		//
		//
		// for(StrutturaBean direzioneItem:listaDirezioni){

		// listaUffici = getListaStrutture(direzioneItem.getId());
		// direzioneItem.setStrutture(listaUffici);
		//
		//
		// }
		// }

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String linkLayout = PrefsParamUtil.getString(renderRequest.getPreferences(), renderRequest, "officeDetailUrl");
		//PortletURL linkLayoutmyUrl = null;
		String porletId_Rubrica = "";

		try {
			Layout layout = LayoutLocalServiceUtil.getLayout(themeDisplay.getSiteGroupId(),
					themeDisplay.getLayout().isPrivateLayout(), Long.parseLong(linkLayout));
			linkLayout = PortalUtil.getLayoutRelativeURL(layout, themeDisplay);	
			LayoutTypePortlet layoutTypePortlet = LayoutTypePortletFactoryUtil.create(layout);
			List<String> portletIdList = layoutTypePortlet.getPortletIds();
			for (String pid : portletIdList) {

				if (pid.indexOf(PORTLET_NAME) != -1) {
					porletId_Rubrica = pid;
					break;
				}
			}
			if (!"".equals(porletId_Rubrica)){
				linkLayout+="?p_p_id="+porletId_Rubrica;
				/*
				linkLayoutmyUrl = PortletURLFactoryUtil.create(renderRequest, porletId_Rubrica, l,
						PortletRequest.RENDER_PHASE);
				linkLayoutmyUrl.setParameter(\"porletId_Rubrica\", porletId_Rubrica);
				*/
			}
			else
				throw new OrganigrammaException("error -> invalid PID");

		} catch (Exception e) {
			_log.warn(e);
		}

		renderRequest.setAttribute("linkLayoutmyUrl", linkLayout);
		renderRequest.setAttribute("porletId_Rubrica", porletId_Rubrica);

		super.doView(renderRequest, renderResponse);
	}

	public void structureForDepartmentId(ActionRequest request, ActionResponse response) throws Exception {
		if (!"".equals(ParamUtil.getString(request, "Dipartimento"))) {
			String id = ParamUtil.getString(request, "Dipartimento");
		
			String nomeDipartimento;
			String nomeDirettoreGenerale;
			String cognomeDirettoreGenerale;
			
			try{
			List<AnagraficaUfficioVO> listaNomeStruttura = SearchDataLocalServiceUtil.servDettagliUfficio(id);
			// get department name
			
			    nomeDipartimento = listaNomeStruttura.get(0).getDescrizione().getValue();
			
			// Getting the name of director/head of the dipartment
				AnagraficaVO nomedirettore = listaNomeStruttura.get(0).getDirigente().getValue();
				 nomeDirettoreGenerale = nomedirettore.getFirstName().getValue();
				 cognomeDirettoreGenerale = nomedirettore.getLastName().getValue();
			}catch(Exception e){
				_log.info(e);
				nomeDirettoreGenerale= "inserire il ";
				cognomeDirettoreGenerale="nominativo del direttore";
				nomeDipartimento="inserire il nome del dipartimento";
			}
			//STUB
//			String nomeDirettoreGenerale = "Piero";
//			String cognomeDirettoreGenerale = "Pieri";
//			String nomeDipartimento = "dip";
			//END STUB

				StringBuilder stringBuilderDirigente = new StringBuilder();
				String dirigenteFullName = null;
				// Creating name of director/administrator of the department
				if(nomeDirettoreGenerale != null && cognomeDirettoreGenerale != null ){
				stringBuilderDirigente.append(nomeDirettoreGenerale);
				stringBuilderDirigente.append(" ");
				stringBuilderDirigente.append(cognomeDirettoreGenerale);
				dirigenteFullName = stringBuilderDirigente.toString();
				}
			
			
			String listaDirezioniJSON;
			
	
			List<StrutturaBean> listaDirezioni = getListaStruttureFromOrgchart(Long.parseLong(id));
			for (StrutturaBean direzioneItem : listaDirezioni) {
				List<StrutturaBean> listaUffici = getListaStruttureFromOrgchart(Long.parseLong(direzioneItem.getId()));
				direzioneItem.setStrutture(listaUffici);
			}

			ObjectMapper mapper = new ObjectMapper();
			
			listaDirezioniJSON = mapper.writeValueAsString(listaDirezioni); 
			_log.info(listaDirezioniJSON);
		
			
			request.setAttribute("structureForDepartment", listaDirezioniJSON);
			//request.setAttribute(\"structureForDepartment\", listaDirezioni);
			request.setAttribute("idDelDipartimento", id);

			request.setAttribute("nomeDipartimento", nomeDipartimento);
			request.setAttribute("paramDipartimento",nomeDipartimento);
			request.setAttribute("nomeDirigente", dirigenteFullName);
			// request.setAttribute(\"dataTarget\", dataTarget);
			// request.setAttribute(\"nomeDipartimentoSenzaCancelleto\",
			// nomeDipartimentoSenzaCancelleto);
		}
	}

	private List<StrutturaBean> getListaStrutture(String id) {
		List<StrutturaBean> listaStrutture = new ArrayList<StrutturaBean>(0);

		String dirigenteFullName = "";

		try {
			List<StrutturaInternaVO> listaIdStrutture = SearchDataLocalServiceUtil.getListStruttureInterne(id);

			for (StrutturaInternaVO idStrutturaObj : listaIdStrutture) {

				// create the srtucture bean
				StrutturaBean strutturaItem = new StrutturaBean();

				// pick id element
				String idStruttura = idStrutturaObj.getCodStruttura().getValue();

				List<AnagraficaUfficioVO> listaNomeStruttura = SearchDataLocalServiceUtil
						.servDettagliUfficio(idStruttura);

				// pick name element
				String nomeStruttura = listaNomeStruttura.get(0).getDescrizione().getValue();

				// Setting Name of the Director General
				AnagraficaVO nomedirettore = listaNomeStruttura.get(0).getDirigente().getValue();
			
			
				String nomeDirettoreGenerale = nomedirettore.getFirstName().getValue();
				String cognomeDirettoreGenerale = nomedirettore.getLastName().getValue();
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(nomeDirettoreGenerale);
				stringBuilder.append(" ");
				stringBuilder.append(cognomeDirettoreGenerale);
				dirigenteFullName = stringBuilder.toString();

				// set the structure bean
				strutturaItem.setId(idStruttura);
				strutturaItem.setNome(nomeStruttura);
				strutturaItem.setDirigente(dirigenteFullName);
				// add structure element in the list
				listaStrutture.add(strutturaItem);

			}

		} catch (Exception e) {

			// e.printStackTrace();
			_log.error(e);
		}

		return listaStrutture;

	}

	private List<StrutturaBean> getListaStruttureFromOrgchart(long id) {
		List<StrutturaBean> listaStrutture = new ArrayList<StrutturaBean>(0);

		try {
			QueryUtil util=new QueryUtil();
			
			
			List<OrganizationChart> listaStructOrg = util.findOrganigrammaFromParent(id);
			
			//List<StrutturaInternaVO> listaIdStrutture = SearchDataLocalServiceUtil.getListStruttureInterne(id);
    
			for (OrganizationChart idStrutturaObj : listaStructOrg) {

				// create the srtucture bean
				StrutturaBean strutturaItem = new StrutturaBean();

				// pick id element
				Long idStruttura = idStrutturaObj.getIdOrgChart();
			
				// pick name element
				String nomeStruttura = idStrutturaObj.getName();
				
				
				 
			
				
//				List<AnagraficaUfficioVO> listaNomeStruttura = SearchDataLocalServiceUtil
//						.servDettagliUfficio(String.valueOf(idStruttura));
				
				// Setting Name of the Director General
				
				
				//AnagraficaVO nomedirettore = listaNomeStruttura.get(0).getDirigente().getValue();
			
			
				//String nomeDirettoreGenerale = nomedirettore.getFirstName().getValue();
				//String cognomeDirettoreGenerale = nomedirettore.getLastName().getValue();
				
				
				//STUB
//				String nomeDirettoreGenerale = "Piero";
//				String cognomeDirettoreGenerale = "Pieri";
				//END  STUB
				
//				StringBuilder stringBuilder = new StringBuilder();
//				stringBuilder.append(nomeDirettoreGenerale);
//				stringBuilder.append(" ");
//				stringBuilder.append(cognomeDirettoreGenerale);
//				dirigenteFullName = stringBuilder.toString();

				// set the structure bean
				strutturaItem.setId(String.valueOf(idStruttura));
				strutturaItem.setNome(nomeStruttura);
//				strutturaItem.setDirigente(dirigenteFullName);
				// add structure element in the list
				listaStrutture.add(strutturaItem);

			}

		} catch (Exception e) {

			// e.printStackTrace();
			_log.error(e);
		}

		
		List<StrutturaBean> sortedListaStrutture= new ArrayList<StrutturaBean>(listaStrutture);
	
		Collections.sort(sortedListaStrutture, new Comparator<StrutturaBean>() {

			@Override
			public int compare(StrutturaBean o1, StrutturaBean o2) {		
				return Integer.parseInt(o1.getId())-Integer.parseInt(o2.getId());
			}
		});
		
		
		
		
		List<StrutturaBean> sortedfoNumbersListaStrutture= new ArrayList<StrutturaBean>(sortedListaStrutture);
		
		Collections.sort(sortedfoNumbersListaStrutture, new Comparator<StrutturaBean>() {

			@Override
			public int compare(StrutturaBean o1, StrutturaBean o2) {		
				return extractInt(o1.getNome())-extractInt(o2.getNome());
			}
			int extractInt(String s) {
		        String num = s.replaceAll("\\D", "");
		        // return 0 if no digits found
		        return num.isEmpty() ? 0 : Integer.parseInt(num);
		    }
		});
		return sortedfoNumbersListaStrutture;

	}
	
	
	
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(MefOrganigrammaConfig.class, properties);
	}

}