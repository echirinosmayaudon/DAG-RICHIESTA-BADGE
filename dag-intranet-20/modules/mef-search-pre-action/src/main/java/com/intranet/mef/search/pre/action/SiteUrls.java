package com.intranet.mef.search.pre.action;

import com.liferay.portal.kernel.util.GetterUtil;

import java.io.Serializable;

public class SiteUrls implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String searchPageUrl;
	private String applicationManagementPageUrl;
	private String gestioneScrivaniePageUrl;
	private String internalIPs;
	
	public String getSearchPageUrl() {
		return GetterUtil.getString(searchPageUrl);
	}
	public void setSearchPageUrl(String searchPageUrl) {
		this.searchPageUrl = searchPageUrl;
	}
	public String getApplicationManagementPageUrl() {
		return GetterUtil.getString(applicationManagementPageUrl);
	}
	public void setApplicationManagementPageUrl(String applicationManagementPageUrl) {
		this.applicationManagementPageUrl = applicationManagementPageUrl;
	}
	public String getGestioneScrivaniePageUrl() {
		return GetterUtil.getString(gestioneScrivaniePageUrl);
	}
	public void setGestioneScrivaniePageUrl(String gestioneScrivaniePageUrl) {
		this.gestioneScrivaniePageUrl = gestioneScrivaniePageUrl;
	}
	public String getInternalIPs() {
		return GetterUtil.getString(internalIPs);
	}
	public void setInternalIPs(String internalIPs) {
		this.internalIPs = internalIPs;
	}
	
	
}
