package com.intranet.mef.user.profile.portlet;

import com.intranet.mef.job.siap.model.City;
import com.intranet.mef.job.siap.model.Location;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.intranet.mef.job.siap.service.CityLocalServiceUtil;
import com.intranet.mef.job.siap.service.LocationLocalServiceUtil;
import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import com.intranet.mef.job.siap.service.ProfilePictureLocalServiceUtil;
import com.intranet.mef.user.profile.configuration.MyProfileConfiguration;
import com.liferay.image.uploader.web.internal.util.UploadImageUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.TempFileEntryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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

@Component(
		configurationPid = "com.intranet.mef.user.profile.configuration.MyProfileConfiguration",
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=my-profile Portlet",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.name=com_intranet_mef_user_profile_portlet_ProfilePortlet",
				"javax.portlet.init-param.view-template=/user-info.jsp",
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user",
				"com.liferay.portlet.add-default-resource=true"
		},
		service = Portlet.class
		)
public class ProfilePortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(ProfilePortlet.class);


	public void saveImage (ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {

		ThemeDisplay themeDisplay =
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		byte[] bytes = new byte[10];
		String currentLogoURL = ParamUtil.getString(actionRequest, "currentLogoURL");
		_log.info("currentLogoURL: "+currentLogoURL);
		String siapImage = ParamUtil.getString(actionRequest, "siapImage");
		User u = themeDisplay.getUser();
			if ((siapImage == null || "".equals(siapImage)) && !currentLogoURL.contains("img_id=0")){
				
				_log.info("salvataggio dell'immagine scelta dal selettore");
				try{
				FileEntry tempFileEntry = UploadImageUtil.getTempImageFileEntry(
						actionRequest);

				InputStream tempImageStream = tempFileEntry.getContentStream();

				ImageBag imageBag = ImageToolUtil.read(tempImageStream);

				RenderedImage renderedImage = imageBag.getRenderedImage();

				String cropRegionJSON = ParamUtil.getString(
						actionRequest, "cropRegion");

				if (Validator.isNotNull(cropRegionJSON)) {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
							cropRegionJSON);

					int height = jsonObject.getInt("height");
					int width = jsonObject.getInt("width");
					int x = jsonObject.getInt("x");
					int y = jsonObject.getInt("y");

					//boolean saveCrop = true;
					if ((x == 0) && (y == 0) &&
							(renderedImage.getHeight() == height) &&
							(renderedImage.getWidth() == width)) {

						//saveCrop = false;
					}

					if ((height + y) > renderedImage.getHeight()) {
						height = renderedImage.getHeight() - y;
					}

					if ((width + x) > renderedImage.getWidth()) {
						width = renderedImage.getWidth() - x;
					}

					renderedImage = ImageToolUtil.crop(
							renderedImage, height, width, x, y);
				}
				bytes = ImageToolUtil.getBytes(
						renderedImage, imageBag.getType());
				UserLocalServiceUtil.updatePortrait(themeDisplay.getUserId(), bytes);
				//Update Image on socialCollab
				//User e = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
				User user = themeDisplay.getUser();
				updatePortraitSocial(user.getScreenName(), bytes);
				themeDisplay.setUser(user);
				}catch(Exception e){
					_log.error(e);
				}
				}
			else if (currentLogoURL.contains("img_id=0")){	
				_log.info("**setting default user portrait**");
				long imageId = ImageToolUtil.getDefaultUserMalePortrait().getImageId();
				
				u.setPortraitId(imageId);
				UserLocalServiceUtil.updateUser(u);
			}
			else{
				String personalId = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("personalId");
				Blob image=ProfilePictureLocalServiceUtil.fetchProfilePicture(Long.parseLong(personalId)).getFile();
				try {
					if (image!=null) {
						bytes = image.getBytes(1,(int)image.length());				
					}	
					//File file = FileUtil.createTempFile(bytes);
					TempFileEntryUtil.deleteTempFileEntry(
							themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
							UploadImageUtil.getTempImageFolderName(),
							getTempImageFileName(actionRequest));
				}
				catch (Exception e) {
					_log.error("Unable to deleteTempFile : "+e);
				}		
				UserLocalServiceUtil.updatePortrait(themeDisplay.getUserId(), bytes);
				//Update Image on socialCollab
				//User e = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
				User user = themeDisplay.getUser();
				updatePortraitSocial(user.getScreenName(), bytes);
				themeDisplay.setUser(user);	
			}
				 
			PortletURL render = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(),
			PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(render.toString());
		//actionResponse.setRenderParameter("redirect", "/user-info.jsp");

	}

	protected String getTempImageFileName(PortletRequest portletRequest) {
		return ParamUtil.getString(portletRequest, "tempImageFileName");
	}
	
	private void updatePortraitSocial(String userMasterScreenName, byte[] bytesImage) throws PortalException{
		long secondaryCompanyId = Long.valueOf(PropsUtil.get("id.company.social.collaboration")).longValue();
		
		User secondaryUser = UserLocalServiceUtil.fetchUserByScreenName(secondaryCompanyId, userMasterScreenName);
		if (Validator.isNotNull(secondaryUser)){
			long secondaryUserId = secondaryUser.getUserId();
			UserLocalServiceUtil.updatePortrait(secondaryUserId, bytesImage);
		}
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		//long groupId = themeDisplay.getScopeGroupId();
		User currentUser = themeDisplay.getUser();
		List<Phone> phones = currentUser.getPhones();
		List<Role> roles = currentUser.getRoles();
		List<Address> address = currentUser.getAddresses();
		String mobile = "";
		String fax = "";
		String tel = "";
		//String userAddress = "";
		String userRole = "";
		
		for (Phone phone : phones){
			String type = "";			
			try {
				type = phone.getType().getName();
			} catch (PortalException e) {
				_log.error(e);
			}
			if (!"".equals(type) && "mobile-phone".equals(type)){
				mobile = phone.getNumber();
				continue;
			}
			if (!"".equals(type) && "business".equals(type)){
				tel = phone.getNumber();
				continue;
			}
			if (!"".equals(type) && "business-fax".equals(type)){
				fax = phone.getNumber();
				continue;
			}
		}
		
//      PRENDO L'INDIRIZZO DI BUSINESS DAGLI INDIRIZZI DELL'UTENTE 
//		List<Address> addresses = currentUser.getAddresses();
//		for (Address address : addresses){
//			String addressType = address.getType().getName();
//			if (addressType.equals("personal")){
//				userAddress = address.getStreet1()+", "+address.getZip()+" "+address.getCity();
//			}
//		}
			
		
		for (Role role : roles){
			if ("Dipendente".equals(role.getName())){
				userRole = "Dipendente";
				break;
			}
			if ("Dirigente".equals(role.getName())){
				userRole = "Dirigente";
				break;
			}
		}

		String piano = "";
		String scala = "";
		String stanza = "";
		for (Address address2 : address) {
			if("BUSINESS".equalsIgnoreCase(address2.getType().getName())){
				piano = address2.getStreet1();
				stanza = address2.getStreet2();
				scala = address2.getStreet3();
			}
		}
		
		String idOrgChart = (String)currentUser.getExpandoBridge().getAttribute("idOrgChart");
		
		String nameDir = "";
		String nameDip = "";
		String nameUff = "";
		String indirizzo = "";
		try {
			OrganizationChart org = OrganizationChartLocalServiceUtil.getOrganizationChart(Long.parseLong(idOrgChart));
			Location sede = LocationLocalServiceUtil.getLocation(org.getLocationId());
			City city = CityLocalServiceUtil.getCity(sede.getCity());
			indirizzo = sede.getStreet()+", "+city.getName()+" ("+city.getProvince()+")"+" - "+sede.getPostalCode();
			if (org.getLevel()==2){
				nameDip = OrganizationChartLocalServiceUtil.getOrganizationChart(org.getLevel2()).getName();
			}
			else {
				nameDir = OrganizationChartLocalServiceUtil.getOrganizationChart(org.getLevel3()).getName();
				nameDip = OrganizationChartLocalServiceUtil.getOrganizationChart(org.getLevel2()).getName();
				if (org.getLevel3()!=org.getIdOrgChart()){
					nameUff = org.getName();
				}
			}
		} catch (NumberFormatException e1) {
			
			_log.error(e1);
		} catch (PortalException e1) {
			
			_log.error(e1);
		}
		
		
		renderRequest.setAttribute("uffName", nameUff.toUpperCase());
		renderRequest.setAttribute("dirName", nameDir.toUpperCase());
		renderRequest.setAttribute("dipName", nameDip.toUpperCase());
		renderRequest.setAttribute("userAddress", indirizzo);
		renderRequest.setAttribute("piano", piano);
		renderRequest.setAttribute("scala", scala);
		renderRequest.setAttribute("stanza", stanza);
		renderRequest.setAttribute("tel", tel);
		renderRequest.setAttribute("fax", fax);
		renderRequest.setAttribute("mobile", mobile);
		renderRequest.setAttribute("userRole", userRole);
		
		String portraitURL="";
		try {
			portraitURL = themeDisplay.getUser().getPortraitURL(themeDisplay);
		} catch (PortalException e) {
			_log.equals(e);
		}
		renderRequest.setAttribute("currentLogoURL", portraitURL);
		renderRequest.setAttribute("configuration", _myProfileConfiguration);
		//super.doView(renderRequest, renderResponse);
		//String redirect = ParamUtil.getString(renderRequest, "redirect");
//		if (redirect!=null && !redirect.equals("/view.jsp")){
//			include("/user-info.jsp", renderRequest, renderResponse);
//		}
//		else{
//			include("/view.jsp", renderRequest, renderResponse);
//		}
		
		include("/user-info.jsp", renderRequest, renderResponse);
	}
	

	
	public MyProfileConfiguration getMyProfileConfiguration() {
		return _myProfileConfiguration;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_myProfileConfiguration =
			ConfigurableUtil.createConfigurable(
				MyProfileConfiguration.class, properties);
	}

	

	private volatile MyProfileConfiguration
	_myProfileConfiguration;



}