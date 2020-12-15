<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.portal.kernel.model.TicketConstants"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.TicketLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Ticket"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntryConstants"%>
<%@ page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.model.Phone"%>
<%@ page import="com.liferay.asset.kernel.model.AssetVocabulary"%>
<%@ page import="com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%

	String itemSelectorURL = ParamUtil.getString(request, "itemSelectorURL");
	List<AssetVocabulary> allCategories = AssetVocabularyLocalServiceUtil.getAssetVocabularies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	AssetVocabulary categoriaMod = null;
	for (AssetVocabulary j : allCategories) {
		if (j.getName().equals("annunci")) {
			categoriaMod = j;
			break;
		}
	} 
 
  	String zonaparam=ParamUtil.getString(renderRequest, "zonaparam");
  	String[] zonalist=zonaparam.split(",");

  	Long annuncioId=ParamUtil.getLong(renderRequest, "annuncioId");
  	Long userId=ParamUtil.getLong(renderRequest, "userId");
  	String titolo=ParamUtil.getString(renderRequest, "titolo");
  	String email=ParamUtil.getString(renderRequest, "email");
  	String topic=ParamUtil.getString(renderRequest, "topic");
  	String type=ParamUtil.getString(renderRequest, "type");
  	String body=ParamUtil.getString(renderRequest, "body");
  	String phoneNumber=ParamUtil.getString(renderRequest, "phone");
  	String sDate=ParamUtil.getString(renderRequest, "startdate");
  	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  	Date startD = format.parse(sDate);
  	format = new SimpleDateFormat("dd/MM/yyyy");
  	String startDate=format.format(startD);
  	String ddate =ParamUtil.getString(renderRequest, "deadline");
  	DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
  	Date dLine = format1.parse(ddate);
  	format1 = new SimpleDateFormat("dd/MM/yyyy");
  	String  deadLine= format1.format(dLine);	 
  	String username=ParamUtil.getString(renderRequest, "username");
  	String zonastr=ParamUtil.getString(renderRequest, "zona");
  	String photo1=ParamUtil.getString(renderRequest, "photo1");
  	String photo2=ParamUtil.getString(renderRequest, "photo2");
  	String photo3=ParamUtil.getString(renderRequest, "photo3");
  	String photo4=ParamUtil.getString(renderRequest, "photo4");
  	int number = 3;
  	boolean cercasi=false;
  	
  	if(type.contains("cercasi"))
		cercasi=true;
  	
  	int bodysize = body.length();
  	long folderId = ParamUtil.getLong(request, "folderId");

%>

<c:set value="<%=topic%>" var="topic"></c:set>
<c:set value="<%=annuncioId%>" var="annuncioId"></c:set>
<c:set value="<%=userId%>" var="userId"></c:set>
<c:set value="<%=zonastr%>" var="zonastring"></c:set>
<c:set value="<%=zonalist%>" var="zonalist"></c:set>
<c:set value="<%=photo1%>" var="photo1"></c:set>
<c:set value="<%=photo2%>" var="photo2"></c:set>
<c:set value="<%=photo3%>" var="photo3"></c:set>
<c:set value="<%=photo4%>" var="photo4"></c:set>

<portlet:actionURL name="updateAdv" var="updateAdv"></portlet:actionURL>

<portlet:actionURL name="annullaAdv" var="annullaAdv">
	<portlet:param name="annuncioId" value="${annuncioId}"/>
	<portlet:param name="navigation" value="advdetail" />
</portlet:actionURL>

<form id="<portlet:namespace/>annulla" action="<%=annullaAdv%>" method="POST"></form>

<portlet:renderURL var="goBackURL">
	<portlet:param name="redirect" value="/annuncioview.jsp" />
</portlet:renderURL>

<div id="modal-upload-file" class="modal modal-custom fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-body">
                <div class="modal-title-box">
                    <a href="#" class="icomoon-close-white" data-dismiss="modal"></a>

                    <div class="title-modal">
                        <h2 class="title">AGGIUNGI L'IMMAGINE</h2>
                    </div>
                </div>
            	<div class="lfr-dynamic-uploader">
					<div class="lfr-upload-container" id="<portlet:namespace />fileUpload"></div>
				<form data-parsley-validate="true"  id="<portlet:namespace/>inputCustomFile" method="post" enctype="multipart/form-data">
					<input type="type" style="display:none" id="<portlet:namespace/>inputCustomFileValid"  data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="bacheca-annunci-error-extension-file" />'>
				</form>
				<form data-parsley-validate="true"  id="<portlet:namespace/>inputCustomFileMaxDim" method="post" enctype="multipart/form-data">
					<input type="type" style="display:none" id="<portlet:namespace/>inputCustomFileMaxDimValid"  data-parsley-required="true" data-parsley-required-message='<liferay-ui:message key="bacheca-annunci-error-max-file" />'>
				</form>
				</div>
            </div>
        </div>

    </div>
</div>

<c:set value="<%=cercasi%>" var="cercasi"></c:set>
<a href="${goBackURL}" label="${addNewAnnuncio}"></a>
<div class="ama-container-fluid">
	<div class="ama-row">
		<div class="wrapper-form-noticeBoards">
			<div class="ama-row">
				<div class="ama-col-md-12">
					<div class="wrapper-title-noticeBoards">
						<h2 class="title-box borders"><liferay-ui:message key="modifica-annuncio" /></h2>
					</div>
				</div>
			</div>

			<form data-parsley-validate="true" data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
				data-parsley-type-error="<liferay-ui:message key="error-syntactic"/>" class="invia-proposta data-parsley-validated" enctype="multipart/form-data"
				id="<portlet:namespace/>form-modal" action="<%=updateAdv%>"
				method="POST" name="<portlet:namespace/>form-modal"
				onsubmit="closePopup()">
				<div class="ama-row">
					<div class="ama-col-md-8 ama-col-sm-8 ama-col-xs-12">
						<div class="ama-row">
							<div class="ama-col-md-12">
								<label for="argument" class="label-form-notice"><liferay-ui:message key="topic-annuncio" />*</label>
								<select id="argument" name="<portlet:namespace/>Topic"
									label="<%=LanguageUtil.get(themeDisplay.getLocale(), "topic-annuncio")%>"
									class="option-select-notice" required data-parsley-required="true" data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>">
										<c:if test="<%=categoriaMod!= null%>">
											<c:set value="<%=categoriaMod%>" var="catMod" />
											<c:forEach items="${catMod.getCategories()}" var="subCategory">
												<c:set value="${subCategory.getName()}" var="nomecategoria" />
												<c:if test="${topic == subCategory.getName()}">
													<option value="${subCategory.getCategoryId()}" selected="true">${subCategory.getName().toUpperCase()}</option>
												</c:if>
												<c:if test="${topic != subCategory.getName()}">
													<option value="${subCategory.getCategoryId()}">${subCategory.getName().toUpperCase()}</option>
												</c:if>
											</c:forEach>
										</c:if>
								</select>
							</div>
						</div>
						<div class="ama-row">
							<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
								<label for="date" class="label-form-notice margin-top"><liferay-ui:message key="start-date-annuncio" />*</label> 
								<input id="<portlet:namespace/>date" 
									name="<portlet:namespace/>StartDate" onchange="checkStartDate()"
									value="<%=startDate%>"
									label="<%=LanguageUtil.get(themeDisplay.getLocale(), "start-date-annuncio")%>"
									class="input-custom-light datepicker-custom" disabled/>
							</div>
							<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
								<label for="date-deadline" class="label-form-notice margin-top"><liferay-ui:message key="deadline-annuncio" />*</label>
		 						<input id="<portlet:namespace/>date-deadline" 
		 							data-parsley-required="true" data-parsley="date" 
		 							data-parsley-pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$" 
		 							data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
									name="<portlet:namespace/>Deadline" 
									value="<%=deadLine%>"
									label="<%=LanguageUtil.get(themeDisplay.getLocale(), "deadline-annuncio")%>"
									class="input-custom-light datepicker-custom data-parsley-validated" >                       
							</div>
						</div>
						<div class="ama-row">
							<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
								<label for="zone" class="label-form-notice margin-top"><liferay-ui:message key="zona-annuncio" /></label>
								
								<select name="<portlet:namespace/>Zona"
									label="<%=LanguageUtil.get(themeDisplay.getLocale(), "zona-annuncio")%>"
									id="zone" class="option-select-notice option-select-zone">
										
										<option value="" hidden=""><liferay-ui:message key="scegli-elenco" /></option> 
													
									<c:forEach items="${zonalist}" var="zonaitem">
									<%String zonaitem=(String)pageContext.getAttribute("zonaitem"); %>
									
										<c:if test="<%=(zonaitem.trim()).equalsIgnoreCase(zonastr.trim())%>">	
											<option value="<%=zonaitem%>" selected="true"><%=zonaitem.toUpperCase()%></option>	
										</c:if>
										<c:if test="<%=!(zonaitem.trim()).equalsIgnoreCase(zonastr.trim())%>">
											<option value="<%=zonaitem%>"><%=zonaitem.toUpperCase()%></option>
										</c:if>
									</c:forEach>
									
								</select>
							</div>
							<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
								<label for="radio1" class="label-form-notice margin-top"><liferay-ui:message key="type-annuncio" />*</label>
								<c:if test="${cercasi != true }">
									<div class="box-radio-custom radio-form-notice">
										<input checked="true" id="radio1"
											name="<portlet:namespace/>Type" value="offresi" type="radio"
											class="radio-custom-dark">
										<label for="radio1" class="radio-custom-desc"> <span><liferay-ui:message key="offer-annuncio" /></span></label>
										</div>
										<div class="box-radio-custom radio-form-notice">
											<input id="radio2" name="<portlet:namespace/>Type"
												value="cercasi" type="radio" class="radio-custom-dark"
												label="<%=LanguageUtil.get(themeDisplay.getLocale(), "look-up-annuncio") %>">
											<label for="radio2" class="radio-custom-desc"> <span><liferay-ui:message key="look-up-annuncio" /></span></label>
										</div>
								</c:if>
								<c:if test="${cercasi == true }">
									<div class="box-radio-custom radio-form-notice">
										<input id="radio1" type="radio" class="radio-custom-dark"
											label="<%=LanguageUtil.get(themeDisplay.getLocale(), "offer-annuncio") %>"
											name="<portlet:namespace/>Type" value="offresi"> <label
											for="radio1" class="radio-custom-desc"> <span><liferay-ui:message key="offer-annuncio" /></span>
										</label><br>
									</div>
									<div class="box-radio-custom radio-form-notice">
										<input id="radio2" type="radio" class="radio-custom-dark"
											label="<%=LanguageUtil.get(themeDisplay.getLocale(), "look-up-annuncio") %>"
											name="<portlet:namespace/>Type" value="cercasi" checked="">
											<label for="radio2" class="radio-custom-desc"> <span><liferay-ui:message key="look-up-annuncio" /></span></label>
									</div>
								</c:if>
							</div>
						</div>		
						<div class="ama-row">
							<div class="ama-col-md-12 ama-col-xs-12">
								<div class="wrapper-content-textarea">
									<label class="label-form-notice margin-top" for="textarea-detail"><liferay-ui:message key="detail-annuncio" />*</label>
									<textarea class="form-control textarea-custom-light data-parsley-validated"
										data-parsley-minlength="10" 
                                        data-parsley-maxlength="500" 
                                       	data-parsley-minlength-message="<liferay-ui:message key="error-minlength-message"/>" 
                                        data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
                                        data-parsley-validation-threshold="10"
										data-parsley-required="true" data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
										id="<portlet:namespace/>textarea-detail" 
										placeholder="<liferay-ui:message key="placeholder-descrizione-annuncio"/>"
										name="<portlet:namespace/>Body" 
										 required><%=body%></textarea>
									<div class="content-textarea" id="charNum">
										<p class="color-gray"><%=bodysize%>/500</p>
									</div>	
								</div>
							</div>
						</div>
					</div>
					<div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12">
						<div class="ama-row">
							<div class="ama-col-md-12">
								<div class="clearfix pt-30-xs pt-0-md pt-0-lg">
									<label for="date" class="label-form-notice title-image-notice"><liferay-ui:message key="image"/></label>
									<a  title="Some informations"
										class="tooltip-field icon-information"> <span
										class="icomoon-info"></span>
									</a>
								</div>
								<c:forEach begin="1" end="<%=number%>" step="1" var="count">
									<c:set value="${count}" var="count"></c:set>
									<%  int count = (int) pageContext.getAttribute("count"); %>
						     		<input type="hidden" id="<portlet:namespace/>src${count}" name="<portlet:namespace/>src${count}" />
									<div id="<portlet:namespace/>image${count}"
										class="box-image-modified-notice"
										style="display: none">
										<a id="<portlet:namespace/>remove${count}" class="icomoon-trash icon-delete">
		                                	<span class="sr-only"><liferay-ui:message key="remove-image"/></span>
		                                </a>
										<img id="<portlet:namespace/>PhotoSrc${count}" name=="<portlet:namespace/>Photo${count}">
									 	<input type="hidden" id="<portlet:namespace/>Photo${count}"
											name="<portlet:namespace/>Photo${count}" /> <input
											type="hidden" value=""
											readonly="readonly" />
									</div>
									<div id="<portlet:namespace/>noimage${count}" class="box-image" style="display: block">
										<a id="<portlet:namespace/>chooseImage${count}"
										class="icomoon-add-border"></a>
										<p class="label-form-notice text-box-image"><liferay-ui:message key="agg-foto" /></p>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="author-banner">
					<div class="ama-row">
						<div class="ama-col-md-12 ama-col-sm-12 ama-col-xs-12">
							<span class="author-text"><liferay-ui:message key="postato-da" />:</span> 
							<span class="author-avatar" style="background-image:url(<%=PortalUtil.getUser(request).getPortraitURL(themeDisplay)%>)" ></span>
							<span class="author-name"><%=PortalUtil.getUser(request).getFullName()%>
								<input type="hidden" name="<portlet:namespace/>User"
									value="<%=PortalUtil.getUser(request).getFullName()%>"
									id="<portlet:namespace/>User"> 
							</span>
						</div>
					</div>
					<div class="ama-row">
						<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
							<span class="icomoon-phone"></span> 
							<input 
								data-parsley-required="true"
								data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>" 
								data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}" 
								data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>" 
								data-parsley-maxlength="30"
								name="<portlet:namespace/>PhoneNumber" value="<%=phoneNumber%>"
								label="<%=LanguageUtil.get(themeDisplay.getLocale(), "number-phone-annuncio") %>"
								class="input-box-post">
						</div>
						<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
							<span class="icomoon-send-mail"></span> 
							<input 
								data-parsley-required="true" data-parsley-type="email" 
								data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
								name="Email"
								label="<%=LanguageUtil.get(themeDisplay.getLocale(), "email-annuncio") %>"
								value="<%=email%>" class="input-box-post">
						</div>
					</div>
				</div>
				<div class="ama-row">
					<div class="ama-col-md-12">
						<div class="container-button-form-notice">
							<div class="ama-row">
								<div class="ama-col-sm-6">
									<button type="reset" onclick="resetForm()"
										class="button button-secondary"><liferay-ui:message key="annulla-button" /></button>
								</div>
								<div class="ama-col-sm-6">
									<button id="<portlet:namespace/>updateForm" type="button"
										onclick="submitAddAnnuncio()"
										value="<%=LanguageUtil.get(themeDisplay.getLocale(), "update") %>"
										class="button button-primary"><liferay-ui:message key="save-button" /></button>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<input type="hidden" name="<portlet:namespace/>itemSelectorURL" value="<%=itemSelectorURL%>" />
				<input type="hidden" name="<portlet:namespace/>annuncioId" value="${annuncioId}" />
				<input type="hidden" name="<portlet:namespace/>titoloDefault" value="<%=titolo%>" />
				<input type="hidden" name="<portlet:namespace/>userId" value="<%=userId.toString()%>" />
				<input type="hidden" name="<portlet:namespace/>emailDefault" value="<%=email%>" />
				<input type="hidden" name="<portlet:namespace/>typeDefault" value="<%=type%>" />
				<input type="hidden" name="<portlet:namespace/>topicDefault" value="<%=topic%>" />
				<input type="hidden" name="<portlet:namespace/>bodyDefault" value="<%=HtmlUtil.escape(body)%>" />
				<input type="hidden" name="<portlet:namespace/>deadlineDefault" value="<%=ddate.toString()%>" />
				<input type="hidden" name="<portlet:namespace/>startdateDefault" value="<%=sDate.toString()%>" />
				<input type="hidden" name="<portlet:namespace/>phoneDefault" value="<%=phoneNumber%>" />
				<input type="hidden" name="<portlet:namespace/>usernameDefault" value="<%=username%>" />
				<input type="hidden" name="<portlet:namespace/>zonaDefault" value="<%=zonastr%>" />
				<input type="hidden" name="<portlet:namespace/>zonaparamDefault" value="<%=zonaparam%>" />
				<input type="hidden" name="<portlet:namespace/>photoup1" value="<%=photo1%>" />
				<input type="hidden" name="<portlet:namespace/>photoup2" value="<%=photo2%>" />
				<input type="hidden" name="<portlet:namespace/>photoup3" value="<%=photo3%>" />
				<input type="hidden" name="<portlet:namespace/>photoup4" value="<%=photo4%>" />
				<input type="hidden" name="<portlet:namespace/>navigation" value="advdetail" />
				
			</form>
		</div>
	</div>
</div>

<c:forEach begin="1" end="<%=number%>" step="1" var="count">
	<c:set value="${count}" var="count"></c:set>
	<%  int count = (int) pageContext.getAttribute("count"); %>

	<c:if
		test="<%= ParamUtil.getString(renderRequest, "photo"+count)!=null && !ParamUtil.getString(renderRequest, "photo"+count).equals("")%>">
		<%
			String src = ParamUtil.getString(renderRequest, "photo"+count);
		%>

		<c:set value="${count}" var="count"></c:set>

		<script type="text/javascript">
			var count = "<%=count%>";
			var src = "<%=src%>";
			$("#<portlet:namespace/>image" + count).css("display", "block");
			$("#<portlet:namespace/>noimage" + count).css("display","none");	
			$("#<portlet:namespace/>PhotoSrc" + count).attr("src",src);
			$("#<portlet:namespace/>src" + count).val(src);
		</script>
	</c:if>
</c:forEach>


<script type="text/javascript">

	$("#<portlet:namespace/>form-modal").parsley(); 

	function submitAddAnnuncio(){
		$("#<portlet:namespace/>buttonClick").val("add");
		$("#<portlet:namespace/>form-modal").submit();
	}
	
	function closePopup(){
		console.log("dentro closepopup in dialogupdate.jsp");
	};
	
	function resetForm(){

		$("#<portlet:namespace/>annulla").submit();
	}
		


</script>

<%
Date expirationDate = new Date(System.currentTimeMillis() + GetterUtil.getInteger(PropsUtil.get(PropsKeys.SESSION_TIMEOUT)) * Time.MINUTE);

Ticket ticket = TicketLocalServiceUtil.addTicket(user.getCompanyId(), User.class.getName(), user.getUserId(), TicketConstants.TYPE_IMPERSONATE, null, expirationDate, new ServiceContext());
%>

<aui:script use="liferay-upload">

var count = "<%=number%>";
var uploader;
var image,noimage, photoSrc, photoFile;

for (var i = 1; i <= count; i++) {
	$('#<portlet:namespace/>remove' + i).on(
			'click',
			{
				param : i
			},
			function(event) {
				console.log("remove image");
				$("#<portlet:namespace/>image" + event.data.param).css(
						"display", "none");
				$("#<portlet:namespace/>noimage" + event.data.param).css(
						"display", "block");

				$("#<portlet:namespace/>PhotoSrc" + event.data.param).attr(
						"src", "");
			});
	$('#<portlet:namespace/>chooseImage' + i).on(
			'click',
			{
				param : i
			},
			function(event) {
				image = "image" + event.data.param;
				noimage = "noimage"	+ event.data.param;
				photoSrc = "PhotoSrc" + event.data.param
				photoFile = "Photo" + event.data.param;
				photoName = "photoName" + event.data.param;
				upLoaderComponentInit(photoFile, photoName, image, noimage,
						photoSrc)
			});
	$('#<portlet:namespace/>PhotoSrc' + i).on(
			'click',
			{
				param : i
			},
			function(event) {

				image = "image" + event.data.param;
				noimage = "noimage"	+ event.data.param;
				photoSrc = "PhotoSrc" + event.data.param
				photoFile = "Photo" + event.data.param;
				photoName = "photoName" + event.data.param;
				upLoaderComponentInit(photoFile, photoName, image, noimage,
						photoSrc)
			});

}; 

	function upLoaderComponentInit(photoFile, photoName, image, noimage,
			photoSrc){
		
		uploader = new Liferay.Upload(
				{
					boundingBox: '#<portlet:namespace />fileUpload',
					deleteFile: '<liferay-portlet:actionURL doAsUserId="<%= user.getUserId() %>" name="/bacheca_annunci/upload_multiple_file_entries"><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
					fileDescription: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
				//	maxFileSize: '1048576',
					namespace: '<portlet:namespace />',
//					removeOnComplete: true,
					multipleFiles: false,
					
					uploadFile: '<liferay-portlet:actionURL doAsUserId="<%= user.getUserId() %>" name="/bacheca_annunci/upload_multiple_file_entries"><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
				}
			);
			
			
		$('#modal-upload-file').modal('show');
		var inputFile = $("#<portlet:namespace/>uploaderContent").find("[type=file]");
		$(inputFile).attr("accept",".jpg,.jepg,.png");
		$("#<portlet:namespace/>inputCustomFileValid").val("valid");
		$("#<portlet:namespace/>inputCustomFile").parsley().validate();
		
		$("#<portlet:namespace/>inputCustomFileMaxDimValid").val("valid");
		$("#<portlet:namespace/>inputCustomFileMaxDim").parsley().validate();
		
		uploader.on(
				'uploadComplete',
				function(file){
					$("#<portlet:namespace/>fileList").hide();
					var numberPoint =file.name.lastIndexOf(".");
					var ext = file.name.substring(numberPoint);
					ext = ext.toLowerCase();
					var requirement = ".jpeg,.png,.jpg";
					var allowedMimeTypes = requirement.replace(/\s/g, "").split(',');
					
					$("#<portlet:namespace/>inputCustomFileValid").val("");
					$("#<portlet:namespace/>inputCustomFileMaxDimValid").val("");

					if(allowedMimeTypes.indexOf(ext) !== -1)
						$("#<portlet:namespace/>inputCustomFileValid").val("valid");
					
					if(file.size <= 1048576)
						$("#<portlet:namespace/>inputCustomFileMaxDimValid").val("valid");
					$("#<portlet:namespace/>inputCustomFile").parsley().validate();
					$("#<portlet:namespace/>inputCustomFileMaxDim").parsley().validate();

					if ($("#<portlet:namespace/>inputCustomFile").parsley().isValid() &&
					$("#<portlet:namespace/>inputCustomFileMaxDim").parsley().isValid()){
						uploaderEventInitializer(file, photoFile, photoName, image, noimage, photoSrc);	
					}


					
											
				}
			);
	}
	
	function uploaderEventInitializer(file,photoFile, photoName, image, noimage,
			photoSrc){
		$('#modal-upload-file').modal('hide');
// 		console.log(JSON.parse(event._state.data.xhr.value.response).uuid);
		var response = JSON.parse(file._state.data.xhr.value.response);
		var itemValue = "/documents/portlet_file_entry/"+response.groupId+"/"+response.name+"/"+response.uuid;
		var photo = {
				"groupId" : response.groupId,
				"title" : response.title,
				"alt" : response.title,
				"type" : "journal",
				"uuid" : response.uuid,
				"name" : response.title,
				"src" : itemValue
			}

			
			if ($("#<portlet:namespace/>" +image)!=null)
				$("#<portlet:namespace/>" +image).css("display", "block");
			if ($("#<portlet:namespace/>" +noimage)!=null)
				$("#<portlet:namespace/>" +noimage).css("display", "none");

			$("#<portlet:namespace/>" + photoSrc).attr("src",itemValue);
			
			$("#<portlet:namespace/>" + photoFile).val(
					JSON.stringify(photo));
			
			$("#<portlet:namespace/>" + photoName).val(response.title);
			
			
	}
	
</aui:script>




<script type="text/javascript"> 

	function checkStartDate(){
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!
		var yyyy = today.getFullYear();
		
		if(dd<10) {
		    dd = '0'+dd
		} 
		
		if(mm<10) {
		    mm = '0'+mm
		} 
		
		today = yyyy + '-' + mm + '-' + dd;
		console.log(today);
		
	    var sDate = document.getElementById("<portlet:namespace/>StartDate").value;
		console.log(sDate);
		
		if(value<today){			
		}
	}
	    
	function checkDeadline(){
		var sDate = document.getElementById("<portlet:namespace/>StartDate").value;
		console.log(sDate);
		var eDate = document.getElementById("<portlet:namespace/>Deadline").value;
		console.log(eDate);
		
		if(eDate>=sDate){
			console.log("data corretta");
		}
		else {
			console.log("data sbagliata");
		}	
	}

	var hideHeaderBachecaAnnunci = function(){
		jQuery("#header_bacheca_annunci").closest( "section" ).hide();
	}
	
	hideHeaderBachecaAnnunci();
	
</script>