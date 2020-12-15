<%@ include file="./init.jsp" %>

<%@page import="com.intranet.mef.assistance.model.Ambito"%>
<%@page import="java.util.List"%>
<%@page import="com.intranet.mef.assistance.service.AmbitoLocalServiceUtil"%>

<%
String description = StringPool.BLANK;

List <Ambito> ambitoArray=AmbitoLocalServiceUtil.getAll();
String ambitoSelected=StringPool.BLANK;
if (!ambitoArray.isEmpty()){
	Ambito ambito =ambitoArray.get(0);
	ambitoSelected = ambito.getAssScopeId();
}

%>	
<portlet:resourceURL id="/assistance/loadFaq" var="AssistanceFaqURL" />

<div id="<portlet:namespace/>assistanceForm" class="ama-container-fluid">
	<div class="ama-row">
		<div class="ama-col-md-12">
			<div class="page-title-wrapper">
				<div class="title-wrapper padding-left">
					<h2 class="title">DATI ASSISTENZA</h2>
				</div>
			</div>
		</div>
	</div>

	<div class="ama-row">
		<div class="ama-col-md-12">
 			<%@ include file="/assistance_container.jsp" %>
		</div>

  	</div>
 
</div>

<div id="<portlet:namespace/>assistanceDetail" class="ama-container-fluid hide">
	<div class="ama-row">
		<div class="ama-col-md-12">
			<div class="page-title-wrapper">
				<div class="title-wrapper padding-left">
					<h2 class="title">RIEPILOGO DELLA SEGNALAZIONE</h2>
				</div>
			</div>
		</div>
	</div>
	
	<div class="ama-row">
		<div class="ama-col-md-12">
			<div class="wrapper-riepilogo-assistenza mt-40-md">
				
					<%@ include file="/details.jsp" %>
				
			</div>
		</div>
	</div>

</div>

<aui:script>
	var cancelAttach = function() {
		var A = AUI();
		var attachmentFile = A.one("#<portlet:namespace/>addAttachFile"); 
		var selectFile = A.one("#<portlet:namespace/>selectFile");
		var fileAttachDiv = A.one("#<portlet:namespace/>fileAttachDiv");
    	attachmentFile.show(); 
    	selectFile.show();
    	fileAttachDiv.hide();
		var fileAttachmentName = A.one("#<portlet:namespace/>fileAttachmentName");
		fileAttachmentName.val('');
		var idFileAttach =  A.one("#<portlet:namespace/>attachmentName");
		idFileAttach.val('');
    }
    
	var loadSelect = function(comboL,comboA) {		
		AUI().use('aui-base','aui-io-request','aui-node', function(A){		
			var selectedValue = A.one("#<portlet:namespace/>"+comboL).val();

	 		A.io.request('<%=AssistanceLoadSelectURL%>',  
			{
			method: 'POST',
			data: {

				"<portlet:namespace/>selectedOption" : selectedValue,
				'<portlet:namespace/>selectedLoad' : comboL

			},
			dataType: 'json',
				on: {
					success: function() {
						var nodo=A.one("#<portlet:namespace/>"+comboA);
						var selectList = this.get('responseData');
						nodo.empty();

						if (comboA=='service'){
							A.one("#<portlet:namespace/>area").empty();
							A.one("#<portlet:namespace/>topic").empty();
							A.one("#<portlet:namespace/>problem").empty();

						}else if (comboA=='area'){
							A.one("#<portlet:namespace/>topic").empty();
							A.one("#<portlet:namespace/>problem").empty();

						}else if (comboA=='topic'){
		 					A.one("#<portlet:namespace/>problem").empty();	

						}

						for(var i in selectList){
							nodo.append("<option value='"+ selectList[i].entityId +"' >"+selectList[i].entityName+"</option> ");
						}
						var divContainer = A.one("#<portlet:namespace/>faqAssistenzaContainer");
						divContainer.hide();
						var divContainer2 = A.one("#<portlet:namespace/>faqAssistenzaContainer2");
						divContainer2.hide();
					}
				}
			});
		});
	}

	var loadFaq = function(comboL) {		
		AUI().use('aui-base','aui-io-request','aui-node', function(A){		
			var selectedValue = A.one("#<portlet:namespace/>"+comboL).val();
			var div = A.one("#faqAssistenza");
			var divContainer = A.one("#<portlet:namespace/>faqAssistenzaContainer");
			var divContainer2 = A.one("#<portlet:namespace/>faqAssistenzaContainer2");
	 		A.io.request('<%=AssistanceFaqURL%>',  
			{
			method: 'POST',
			data: {

				"<portlet:namespace/>keyProblem" : selectedValue

			},
			dataType: 'json',
				on: {
					success: function() {
						console.log("ajax call successfull");
						var selectList = this.get('responseData');
						divContainer.hide();
						var totalDiv = '';
						
						for(var i in selectList){

							var question=selectList[i].question;
							var response=selectList[i].response;
							console.log("response" +response);
							var idResponse=selectList[i].idResponse;
							var divQuestion = "<div class=\"ama-col-xs-12 wrapper-box\" id=\""+ idResponse +"\">"+
								"<p class=\"collapse-title-box-title title-faq dot-mobile dot-point max-dot-60\">"+ question + "</p>"+
								"<a href=\"javascript:void(0)\" title=\"Apri FAQ\" class=\"icon-open icomoon-plus\" data-toggle=\"collapse\" data-target=\"#"+idResponse+"-content\">"+
								"<span class=\"sr-only\">Apri FAQ</span></a></div>";

							var divResponse = "<div class=\"ama-col-xs-12 box-content-faq collapse\" id=\""+idResponse+"-content\" ><p class=\"text-body\">" + response + "</p></div>";
							totalDiv += divQuestion + divResponse

						} 

						if(totalDiv != ''){
							div.html('');
							divContainer.show();
							divContainer2.show();
							div.html(totalDiv);
						}
					}
				}
			});
		});
	}

	var loadAttach = function() {	
		AUI().use('aui-base','aui-io-request','aui-node', function(A){		

			var fileAttachDiv = A.one("#<portlet:namespace/>fileAttachDiv");
			var attachmentFile = A.one("#<portlet:namespace/>attachmentName");
			var selectFile = A.one("#<portlet:namespace/>selectFile");
			var fileAttachmentName = A.one("#<portlet:namespace/>fileAttachmentName");
			fileAttachmentName.val('');
			var nomeFile = A.one("#<portlet:namespace/>nomeFile");

			var form = new FormData($("#<portlet:namespace/>fm")[0]);
			var opts = {
				url: '<%= AttachmentURL %>',
				data: form,
				enctype: 'multipart/form-data',
				cache: false,
				contentType: false,
				processData: false,
				dataType: "json",
				processData: false,
				method: 'POST',
				type: 'POST', // For jQuery < 1.9
				success: function(data){
					var fileNameAttachment = data.fileNameAttachment;
		 			
					if (data.success){
						nomeFile.html(fileNameAttachment);	
						var insideText ="<a href='javascript:cancelAttach();' title='elimina file' id='<portlet:namespace/>removeFile' class='icomoon-close-white ico-delete'></a>";
						nomeFile.append(insideText);
						fileAttachDiv.show();
						fileAttachmentName.val(fileNameAttachment);
						selectFile.hide();
					}else{
						fileAttachDiv.hide();
						selectFile.show();
					}

				},
				error: function(e){
					fileAttachDiv.hide();
					selectFile.show();
				}
			};

			$.ajax(opts);

		});
	}

	var loadDetail = function() {	
		AUI().use('aui-base','aui-io-request','aui-node', function(A){		

			var serviceDescDOM = A.one("#<portlet:namespace/>serviceDesc");
			var areaDescDOM = A.one("#<portlet:namespace/>areaDesc");
			var topicDescDOM = A.one("#<portlet:namespace/>topicDesc");
			var problemDescDOM = A.one("#<portlet:namespace/>problemDesc");
			var descriptionDOM = A.one("#<portlet:namespace/>descriptionDetail");
			var fileNameAttachmentDOM = A.one("#<portlet:namespace/>fileNameAttachment");

			var divForm=A.one("#<portlet:namespace/>assistanceForm");
			var divDetail=A.one("#<portlet:namespace/>assistanceDetail");

		
			var form = new FormData($("#<portlet:namespace/>fm")[0]);
			var opts = {
				url: '<%= DetailsURL %>',
				data: form,
				enctype: 'multipart/form-data',
				cache: false,
				contentType: false,
				processData: false,
				dataType: "json",
				processData: false,
				method: 'POST',
				type: 'POST', // For jQuery < 1.9
				success: function(data){
					var serviceDesc = data.serviceDesc;
					var areaDesc = data.areaDesc;
					var topicDesc = data.topicDesc;
					var problemDesc = data.problemDesc;
					var description = data.description;
	 				var fileNameAttachment = data.fileNameAttachment;

	 				serviceDescDOM.html(serviceDesc);
	 				areaDescDOM.html(areaDesc);
	 				topicDescDOM.html(topicDesc);
	 				problemDescDOM.html(problemDesc);
	 				descriptionDOM.html(description);
	 				fileNameAttachmentDOM.html(fileNameAttachment);

	 				divForm.hide();
	 				divDetail.show();
	 				//document.getElementById("<portlet:namespace/>assistanceDetail").scrollIntoView();
	 				$('html, body').animate({
	 				    scrollTop: ($('.detail-page-item').first().offset().top)
	 				},5);
				}
			};

			$.ajax(opts);

		});
	}

 	function <portlet:namespace/>openResponse(id){
		var A = AUI();
		var divResponse = A.one("#<portlet:namespace/>"+id);
		divResponse.toggleClass('hide');
	}

	function <portlet:namespace/>openBtn(){
		AUI().one("#<portlet:namespace/>btnContinue").set('disabled', true);
 		if (AUI().one("#<portlet:namespace/>description").val().length > 0){
 			AUI().one("#<portlet:namespace/>btnContinue").set('disabled', false);
 		}
	}

	AUI().ready(
		function() {
			loadSelect('ambito','service');
		}
	);

</aui:script>

<script type="text/javascript">
var idButtonAddAttachFile = "#<portlet:namespace/>addAttachFile";
var idFileAttach = "#<portlet:namespace/>attachmentName";

$(idButtonAddAttachFile).on('click', function(event){
	$(idFileAttach).click();
});

$(idFileAttach).change(function(){
	var instanceForm=$("#<portlet:namespace/>fm").parsley();
	instanceForm.validate();

	if(instanceForm.isValid()){
		loadAttach();
		$(idButtonAddAttachFile).css("display","none");
	}
}); 



function validateForm(){
 	var instanceForm=$("#<portlet:namespace/>fm").parsley();
	instanceForm.validate();

	if(instanceForm.isValid()){
		
		loadDetail();
  }
	
}
</script>
