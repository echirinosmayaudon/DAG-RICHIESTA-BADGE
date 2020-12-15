package mef.richieste.figli.form.util;

import com.intranet.mef.job.siap.model.City;
import com.intranet.mef.job.siap.model.ClassificationLevel;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.CityLocalServiceUtil;
import com.intranet.mef.job.siap.service.ClassificationLevelLocalServiceUtil;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;

import java.text.SimpleDateFormat;
import java.util.List;

import mef.richieste.figli.form.bean.Richiedente;



public class MefFigliUtils {

	private final String _customFieldUserOrg = "idOrgChart";
	private final String _customFieldUserLevel = "levelId";
	
	private  Log _log = LogFactoryUtil.getLog(MefFigliUtils.class);
	
	
	public Richiedente createRichiedente(User user, long companyId) {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		Richiedente richiedente = new Richiedente();
		if(user.getUserId() > 0) {
			richiedente.setUserId(user.getUserId());
		}
		if (user.getFirstName() != null)
			richiedente.setNome(user.getFirstName());
		if (user.getLastName() != null)
			richiedente.setCognome(user.getLastName());
		if (user.getScreenName() != null)
			richiedente.setCodiceFiscale(user.getScreenName());
		try {
			if (user.getBirthday() != null) {
				richiedente.setDataNascita(formatDate.format(user.getBirthday()));
			}
			if (user.getEmailAddress() != null)
				richiedente.setMail(user.getEmailAddress());
			
			List<Address> listaIndirizzi = user.getAddresses();
			List<Phone> listaPhones = user.getPhones();
			_log.debug("LISTA INDIRIZZI" + listaIndirizzi);
			
			for (Address addressItem : listaIndirizzi) {
				
				
				_log.debug("ADDRES ITEM ID RECUPERATO : "  + addressItem.getTypeId());
				
				if (("Personal").equalsIgnoreCase(addressItem.getType().getName()) ) {
					if (addressItem.getStreet1() != null)
						richiedente.setIndirizzo(addressItem.getStreet1());
					if (addressItem.getCity() != null) {
						try {
						City citta = CityLocalServiceUtil.getCity(addressItem.getCity());
						
						if (citta != null) {
							
							if (citta.getProvince() != null)
								richiedente.setProvincia(citta.getProvince());
								
							if (citta.getName() != null)
								richiedente.setCitta(citta.getName());
							richiedente.setCap(addressItem.getZip());
							
						}
						
						}catch(Exception e) {
							_log.debug("RECUPER VALORI DEFAULT PROV E CITTA");
							richiedente.setProvincia("-");
							richiedente.setCitta("-");
							richiedente.setCap(addressItem.getZip());
						}
					}
					
				}else {
					_log.debug("ELSE PERSONAL " + addressItem);
				}
				if (("Other").equalsIgnoreCase(addressItem.getType().getName()) ) {
					try {
					City cittaNatale = CityLocalServiceUtil.getCity(addressItem.getCity());
					if (cittaNatale != null) {
						if (cittaNatale.getProvince() != null)
							richiedente.setProvinciaNascita(cittaNatale.getProvince());
						if (cittaNatale.getName() != null)
							richiedente.setLuogoNascita(cittaNatale.getName());
					}
				}catch(Exception e) {
					_log.debug("ID ADDRESS RECUPERATO " + addressItem.getTypeId());
					_log.debug("RECUPER VALORI PROVNAS  E LUONAS");
					richiedente.setProvinciaNascita("-");
					richiedente.setLuogoNascita("-");
				}
			}else {
				_log.debug("ELSE OTHER " + addressItem + " " + addressItem.getTypeId());
			}
			for (Phone phoneItem : listaPhones) {
				if (("Business").equalsIgnoreCase(phoneItem.getType().getName())) {
					if (phoneItem.getNumber() != null)
						richiedente.setTelefono(phoneItem.getNumber());
					break;
				}
			}
			String levelId = (String) user.getExpandoBridge().getAttribute(_customFieldUserLevel);
			if (levelId != null && !("").equals(levelId)) {
				try {
				ClassificationLevel areaFascia = ClassificationLevelLocalServiceUtil.getClassificationLevel(Long.parseLong(levelId));
				if (areaFascia != null) {
					if (areaFascia.getArea() != null)
						richiedente.setFasciaEconomica(areaFascia.getArea());
					
				}
				}catch(Exception e) {
					_log.debug("RECUPER VALORI DEFAULT FASCIAECO");
					richiedente.setFasciaEconomica(levelId);
				}
			}
			if ((user != null) && (user.getExpandoBridge() != null)
			&& (user.getExpandoBridge().getAttribute(_customFieldUserOrg) != null)) {
				String organizationId = (String) user.getExpandoBridge().getAttribute(_customFieldUserOrg);
				if (organizationId != null && organizationId != "") {
					Long idChart = Long.parseLong(organizationId);
					
					
					try {
					OrganizationChart orgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(idChart);
					if (orgChart != null) {
						int livello = orgChart.getLevel();
						long direzioneId = orgChart.getIdParent();
						if (livello != 2) {
							OrganizationChart direzioneOrgChart = OrganizationChartLocalServiceUtil.getOrganizationChart(direzioneId);
							if (direzioneOrgChart != null) {
								int livelloDipartimento = direzioneOrgChart.getLevel();
								long dipartimentoId = direzioneOrgChart.getIdParent();
								if (livelloDipartimento != 2) {
									OrganizationChart dipartimentoOrgChart = OrganizationChartLocalServiceUtil
									.getOrganizationChart(dipartimentoId);
									if (dipartimentoOrgChart.getName() != null)
										richiedente.setDipartimento(dipartimentoOrgChart.getName());
								} else {
									if (direzioneOrgChart.getName() != null)
										richiedente.setDipartimento(direzioneOrgChart.getName());
								}
							}
						} else {
							if (orgChart.getName() != null)
								richiedente.setDipartimento(orgChart.getName());
						}
					}
					
					}catch(Exception e) {
						_log.debug("RECUPER VALORI DEFAULT DIPARTIMENTO");
						richiedente.setDipartimento(organizationId);
						
					}
					
					
				}
			}  
			
		}
			} catch (Exception e) {
			
			_log.warn(e);
		}
		return richiedente;
	}
	
	
	
	
	
	
	
}
