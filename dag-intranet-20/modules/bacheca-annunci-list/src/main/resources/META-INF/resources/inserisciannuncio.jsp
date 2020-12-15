<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
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
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
 <%@page import="com.liferay.document.library.kernel.model.DLFileEntryConstants"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.model.Phone"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:actionURL name="addWebContentAction"
	var="addWebContentActionURL"></portlet:actionURL>
	
<portlet:actionURL name="importAnnunciAction"
	var="importAnnunciActionURL"></portlet:actionURL>
	
<%
	String itemSelectorURL = GetterUtil.getString(request.getAttribute("itemSelectorURL"));

	String language = themeDisplay.getLocale().toString();

	int number = 3;

	Calendar today = Calendar.getInstance();
	int mese = today.get(Calendar.MONTH);
	String month;
	if (mese < 9)
		month = "0" + (mese + 1);
	else
		month = (mese + 1) + "";

	String day = today.get(Calendar.DAY_OF_MONTH) + "/" + month + "/" + today.get(Calendar.YEAR);

	String[] zonalist = zona.split(",");
   
	String email = (String) request.getAttribute("email");

	String errorinserimento = (String) request.getParameter("errorInserimento");

	long folderId = ParamUtil.getLong(request, "folderId");
	

	
%>


<portlet:actionURL name="annullaAdv" var="annullaAdv">
</portlet:actionURL>


<form id="<portlet:namespace/>annulla" action="<%=annullaAdv%>"
	method="POST"></form>


<portlet:actionURL var="uploadFile" name="uploadFileAction">
</portlet:actionURL>
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

<c:set value="<%=zonalist%>" var="zonalist"></c:set>
<c:choose>
	<c:when
		test="<%=SessionErrors.contains(renderRequest, "nome-del-template-non-univoco")%>">
		<liferay-ui:error key="nome-del-template-non-univoco"
			message="nome-del-template-non-univoco"></liferay-ui:error>
	</c:when>

	<c:when
		test="<%=SessionErrors.contains(renderRequest, "nome-della-struttura-non-univoco")%>">

		<liferay-ui:error key="nome-della-struttura-non-univoco"
			message="nome-della-struttura-non-univoco"></liferay-ui:error>

	</c:when>

	<c:when
		test="<%=SessionErrors.contains(renderRequest, "nome-della-categoria-non-univoco")%>">

		<liferay-ui:error key="nome-della-categoria-non-univoco"
			message="nome-della-categoria-non-univoco"></liferay-ui:error>

	</c:when>

	<c:when
		test="<%=SessionErrors.contains(renderRequest, " la-categoria-non-contiene-sottocategorie")%>">
		<liferay-ui:error key=" la-categoria-non-contiene-sottocategorie"
			message="la-categoria-non-contiene-sottocategorie"></liferay-ui:error>
	</c:when>

	<c:otherwise>
		<div class="ama-container-fluid">
			<div class="ama-row">

				<div class="wrapper-form-noticeBoards">
					<div class="ama-row">
						<div class="ama-col-md-12">
							<div class="wrapper-title-noticeBoards">
								<h2 class="title-box borders">
									<liferay-ui:message key="crea-annuncio" />
								</h2>
							</div>
						</div>
					</div>
					<form data-parsley-validate="true" enctype="multipart/form-data"
						action="<%=addWebContentActionURL.toString()%>" method="post"
						name="<portlet:namespace/>myForm" id="<portlet:namespace/>myForm">
						<div class="ama-row">
							<div class="ama-col-md-8 ama-col-sm-8 ama-col-xs-12">
								<div class="ama-row">
									<div class="ama-col-md-12">
										<label for="argument" class="label-form-notice"><liferay-ui:message
												key="topic-annuncio" />*</label> 
										<select
											id="<portlet:namespace/>Topic"
											name="<portlet:namespace/>Topic" var="selectCat"
											data-parsley-required="true"
											data-parsley-error-message="<liferay-ui:message key="error-mandatory"/>"
											class="option-select-notice data-parsley-validated">
											<option value="" hidden=""><liferay-ui:message
													key="scegli-argomento" /></option>
											<c:if test="<%=request.getAttribute("category") != null%>">
												<c:set value="<%=request.getAttribute("category")%>"
													var="catMod" />
												<c:forEach items="${catMod.getCategories()}"
													var="subCategory">
													<option value="${subCategory.getCategoryId()}">
														${subCategory.getName().toUpperCase()}</option>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								
								<div class="ama-row">
									<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
										<label for="date" class="label-form-notice margin-top"><liferay-ui:message key="start-date-annuncio" />*</label> 
										<input
											data-parsley-required="true"
											data-parsley-pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
											data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
											id="StartDate" type="text"
											name="<portlet:namespace/>StartDate"
											class="datepicker-custom input-custom-light data-parsley-validated"
											placeholder="<liferay-ui:message key="placeholder-data-emissione-annuncio" />"			
											data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
											data-parsley-submission-date-check="#StartDate" 
											value=""
											>
									</div>
									<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
										<label for="date-deadline"
											class="label-form-notice margin-top"><liferay-ui:message
												key="deadline-annuncio" />* </label> <input type="text"
											data-parsley-required="true"
											data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
											id="Deadline" name="<portlet:namespace/>Deadline"
											class="datepicker-custom input-custom-light data-parsley-validated"
											placeholder='<liferay-ui:message key="placeholder-data-scadenza-annuncio"/>'
											data-parsley-compare-sumbission-expiration-date="#StartDate" value =""
											data-parsley-check-start-date="#StartDate"
											value="">
									</div>
								</div>

								<div class="ama-row">
									<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
										<label for="zone" class="label-form-notice margin-top"><liferay-ui:message
												key="zona-annuncio" /></label> <select id="Zone"
											name="<portlet:namespace/>Zona"
											class="option-select-notice option-select-zone"
											>
											<option value="" hidden=""><liferay-ui:message
													key="scegli-elenco" /></option>
											<c:forEach items="${zonalist}" var="zonaitem">
												<option 
													 value="${zonaitem}">${zonaitem.toUpperCase()}</option>
											</c:forEach>
										</select>
									</div>
									<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
										<label for="radio1" class="label-form-notice margin-top"><liferay-ui:message
												key="type-annuncio" />*</label>
										<div class="box-radio-custom radio-form-notice">
											<input checked id="radio1" name="<portlet:namespace/>Type"
												value="offresi" type="radio" class="radio-custom-dark">
											<label for="radio1" class="radio-custom-desc"> <span><liferay-ui:message
														key="offer-annuncio" /></span>
											</label>
										</div>
										<div class="box-radio-custom radio-form-notice">
											<input id="radio2" name="<portlet:namespace/>Type"
												value="cercasi" type="radio" class="radio-custom-dark">
											<label for="radio2" class="radio-custom-desc"> <span><liferay-ui:message
														key="look-up-annuncio" /></span>
											</label>
										</div>
									</div>
								</div>
								<div class="ama-row">
									<div class="ama-col-md-12 ama-col-xs-12">
										<div class="wrapper-content-textarea">
											<label class="label-form-notice margin-top"
												for="textarea-detail-bacheca"><liferay-ui:message
													key="detail-annuncio" />*</label>		
													<textarea class="form-control textarea-custom-light data-parsley-validated"
														data-parsley-minlength="10" 
                                       					data-parsley-maxlength="500" 
                                       					data-parsley-minlength-message="<liferay-ui:message key="error-minlength-message"/>" 
                                        				data-parsley-maxlenght-message="<liferay-ui:message key="error-maxlenght-message"/>"
                                        				data-parsley-validation-threshold="10"
														data-parsley-required="true"
														data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
														id="<portlet:namespace/>textarea-detail-bacheca" 
														placeholder="<liferay-ui:message key="placeholder-descrizione-annuncio"/>"
														name="<portlet:namespace/>Body" 
										></textarea>
											<div class="content-textarea" id="charNum">
												<p class='color-gray'>0/500</p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="ama-col-md-4 ama-col-sm-4 ama-col-xs-12">
								<div class="ama-row">
									<div class="ama-col-md-12">
										<div class="clearfix pt-30-xs pt-0-md pt-0-lg">
											<label for="date"
												class="label-form-notice title-image-notice"><liferay-ui:message
													key="image" /></label> <a title="<liferay-ui:message
													key="tooltip-image"/>"
												class="tooltip-field icon-information"> <span
												class="icomoon-info"></span>
											</a>
										</div>
										<c:forEach begin="1" end="<%=number%>" step="1" var="count">
											<div id="<portlet:namespace/>image${count}"
												class="box-image-modified-notice"
												style="display: none">
												<a id="<portlet:namespace/>remove${count}"
													class="icomoon-trash icon-delete"> <span
													class="sr-only">liferay-ui:message
														key="topic-annuncio" /></span>
												</a> <img id="<portlet:namespace/>PhotoSrc${count}"
													name="<portlet:namespace/>Photo${count}"> <input
													type="hidden" id="<portlet:namespace/>Photo${count}"
													name="<portlet:namespace/>Photo${count}" /> <input
													type="hidden" id="<portlet:namespace/>photoName${count}"
													name="<portlet:namespace/>photoName${count}" value=""
													readonly="readonly" />
											</div>
											<div id="<portlet:namespace/>noimage${count}"
												class="box-image" style="display: block">
												<a name="<portlet:namespace/>chooseImage${count}"
													id="<portlet:namespace/>chooseImage${count}"
													value="${photochoose}" class="icomoon-add-border"></a>
												<p class="label-form-notice text-box-image">
													<liferay-ui:message key="agg-foto" />
												</p>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<div class="author-banner">
							<div class="ama-row">
								<div class="ama-col-md-12">
									<span class="author-text"><liferay-ui:message
											key="postato-da" />:</span> <span class="author-avatar"
										style="background-image:url(<%=PortalUtil.getUser(request).getPortraitURL(themeDisplay)%>)"></span>
									<span class="author-name"><%=PortalUtil.getUser(request).getFullName()%>
										<input type="hidden" name="<portlet:namespace/>User"
										value="<%=PortalUtil.getUser(request).getFullName()%>">
									</span>
								</div>
							</div>

							<%
								String s = "393110101000";
							List<Phone> listaPhones =PortalUtil.getUser(request).getPhones();
										if (listaPhones!=null && !listaPhones.isEmpty()){
											
											for (Phone phoneItem: listaPhones){
												if( phoneItem.getType().getName().equalsIgnoreCase("Business")){	
													s = phoneItem.getNumber();
													break;
												}
											}																					
										}
							%>
							<div class="ama-row">
								<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
									<span class="icomoon-phone"></span> <input
										data-parsley-required="true"
										data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
										data-parsley-pattern="(?:\+)?(?:\d+)?[\s-.\/]?\d{7,12}"
										data-parsley-maxlength="30"
										data-parsley-pattern-message="<liferay-ui:message key="error-syntactic"/>"
										type="text" name="<portlet:namespace/>PhoneNumber"
										value="<%=s%>" class="input-box-post data-parsley-validated">
								</div>
								<div class="ama-col-md-6 ama-col-sm-6 ama-col-xs-12">
									<span class="icomoon-send-mail"></span> <input
										data-parsley-required="true"
										data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
										data-parsley-type="email"
										data-parsley-type-message="<liferay-ui:message key="error-syntactic"/>"
										name="<portlet:namespace/>Email" type="text"
										value="<%=PortalUtil.getUser(request).getEmailAddress()%>"
										class="input-box-post data-parsley-validated">
								</div>
							</div>
						</div>
						<div class="container-button-form-notice">
							<div class="ama-row">
								<div class="ama-col-sm-6">
									<button type="reset" onclick="return resetForm();"
										class="button button-secondary">
										<liferay-ui:message key="annulla-button" />
									</button>
								</div>
								<div class="ama-col-sm-6">
									<button type="button" onclick="submitAddAnnuncio()"
										name="<portlet:namespace/>${buttonAdd}" value="${buttonAdd}"
										class="button button-primary">
										<liferay-ui:message key="crea-button" />
									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<% if(request.getAttribute("roleAdministrator")!=null){ %>
			<div class="ama-row">
			    <aui:form id="fm2" name="fm2" action="<%= importAnnunciActionURL.toString() %>">
			 	<label class="label-form-notice margin-top" for="textarea-detail-bacheca">
			 		
					<liferay-ui:message key="bacheca-annunci-importa-annunci"/>
			 	</label>		
				<textarea class="form-control"														
					data-parsley-required="true"
					data-parsley-required-message="<liferay-ui:message key="error-mandatory"/>"
					id="<portlet:namespace/>textarea-import-data" 
					placeholder='<liferay-ui:message key="bacheca-annunci-importa-placeholder"/>'
					name="<portlet:namespace/>listaXML"
					maxlength="7000000"
					value=""
					></textarea>
				<div class="container-button-form-notice" style="margin-bottom:20px;margin-top:20px">
					<div class="ama-row">
						<div class="ama-col-sm-6">
							<button type="reset" onclick="return resetFormImport();"
								class="button button-secondary">
								<liferay-ui:message key="annulla-button" />
							</button>
						</div>
						<div class="ama-col-sm-6">
							<button type="submit"
								value="IMPORTA"
								class="button button-primary">
								
								<liferay-ui:message key="bacheca-annunci-importa"/>

							</button>
						</div>
					</div>
				</div>
				</aui:form>
			</div>
			<% } %>
		</div>
	</c:otherwise>
</c:choose>

<script type="text/javascript">

	//$("#<portlet:namespace/>myForm").parsley();
	
	var hideHeaderBachecaAnnunci = function() {
		jQuery("#header_bacheca_annunci").closest("section").hide();
	}

	hideHeaderBachecaAnnunci();

	function submitAddAnnuncio() {

		$("#<portlet:namespace/>buttonClick").val("add");
		$("#<portlet:namespace/>myForm").submit();
	}

	function chooseImage(i) {
	//	console.log("help" + i);
	}

	function resetForm() {
		$("#<portlet:namespace/>annulla").submit();
	}
	
	//console.log("test" + '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(".png,.jpg", StringPool.COMMA)) %>');

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
				//console.log("remove image");
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
				upLoaderComponentInit(photoFile, photoName, image, noimage,	photoSrc);
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
						photoSrc);
			});

}; 

	function upLoaderComponentInit(photoFile, photoName, image, noimage,
			photoSrc){
		
		uploader = new Liferay.Upload({
					boundingBox: '#<portlet:namespace />fileUpload',
					deleteFile: '<liferay-portlet:actionURL doAsUserId="<%= user.getUserId() %>" name="/bacheca_annunci/upload_multiple_file_entries"><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
					fileDescription: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(".png,.jpg", StringPool.COMMA)) %>',
					//maxFileSize: '1048576',
					namespace: '<portlet:namespace />',
					//removeOnComplete: true,
					multipleFiles: false,
					
					uploadFile: '<liferay-portlet:actionURL doAsUserId="<%= user.getUserId() %>" name="/bacheca_annunci/upload_multiple_file_entries"><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
				}
			);
			
			
		$('#modal-upload-file').modal('show');
		$("#<portlet:namespace/>inputCustomFileValid").val("valid");
		$("#<portlet:namespace/>inputCustomFile").parsley().validate();

		$("#<portlet:namespace/>inputCustomFileMaxDimValid").val("valid");
		$("#<portlet:namespace/>inputCustomFileMaxDim").parsley().validate();
		
		var inputFile = $("#<portlet:namespace/>uploaderContent").find("[type=file]");
		$(inputFile).attr("accept",".jpg,.jepg,.png");

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

			$("#<portlet:namespace/>" + image).css("display",
					"inline-block");
			$("#<portlet:namespace/>" + noimage).css("display",
					"none");

			$("#<portlet:namespace/>" + photoSrc).attr("src",
					itemValue);

			$("#<portlet:namespace/>" + photoFile).val(
					JSON.stringify(photo));

			$("#<portlet:namespace/>" + photoName).val(response.title);
			$('#modal-upload-file').modal('hide');
	}
	
</aui:script>
