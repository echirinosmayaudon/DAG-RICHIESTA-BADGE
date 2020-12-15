package com.intranet.mef.user.profile.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Roberto Sangiovanni
 */
@ExtendedObjectClassDefinition(
	category = "portlet", 
	scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
@Meta.OCD(
	id = "com.intranet.mef.user.profile.configuration.MyProfileConfiguration",
	localization = "content/Language"
)
public interface MyProfileConfiguration {

	/**
	 * Get the visual style of profile portlet
	 */
	@Meta.AD(required = false)
	public boolean isShort();
	
	/**
	 * Get url of detail page
	 */
	@Meta.AD(deflt="" ,required = false)
	public String  getExtendedPageUrl();
	
	@Meta.AD(deflt="Ripristina immagine di default" ,required = false)
	public String  getLabelRestoreDefault();
	
	@Meta.AD(deflt="Carica foto" ,required = false)
	public String  getLabelUploadImage();
	
	@Meta.AD(deflt="Imposta foto SIAP" ,required = false)
	public String  getLabelSetSIAPImage();
	
	@Meta.AD(deflt="Foto siap non disponibile" ,required = false)
	public String  getLabelNoSIAPImage();
	
	@Meta.AD(deflt="Accetto l'informativa sulla privacy e acconsento alla pubblicazione delle foto nella intranet" ,required = false)
	public String  getLabelPrivacyAcceptance();

}