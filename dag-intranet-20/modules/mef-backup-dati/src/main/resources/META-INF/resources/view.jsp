<%@ include file="/init.jsp" %>

<portlet:actionURL name="uploadXml" var="uploadXml" >
</portlet:actionURL> 


<form data-parsley-validate="true"  id="<portlet:namespace/>uploadXml" action="<%=uploadXml%>" method="post" enctype="multipart/form-data">
	<div class="wrapper-allegati-general">
		<div class="ama-row">
			<div class="ama-col-md-12">
				<div class="wrapper-title-general">
					<h2 class="title-box borders"><liferay-ui:message key="trasporti-allegati"/> </h2>
					<a href="#" title='<liferay-ui:message key="trasporti-info-allegato"/>' class="tooltip-field">
						<span class="icomoon-info ico-attachments"></span>
					</a>
				</div>
			</div>
		</div>

			<div class="ama-row" style="display:none" id="<portlet:namespace/>fileAttachDivPersonale">

			<div class="ama-col-md-12 mobile-no-padding">
			<div class="wrapper-content">
					<div class="wrapper-white">
						<p class="text" id="<portlet:namespace/>fileNamePersonale"> 
						<a href="#" title="elimina file" id="<portlet:namespace/>removeFilePersonale"  onclick='removeAllegato("Personale")' class="icomoon-close-white ico-delete"></a></p>
					</div>
						
			  
			
			</div>
			</div>
			</div>
			
				 <div class="ama-row"  id="<portlet:namespace/>selectFilePersonale">
					<div class="ama-col-md-12 mobile-no-padding">
						<div class="box-button">
						
							<button href="#" type="button" id="<portlet:namespace/>addAttachFilePersonale" class="button button-primary" ><liferay-ui:message key="backup-selezione-file"/></button>
						</div>
					</div>
				</div>
		<div id="allegatoDivPersonale">
						
		</div>
		<div class="container-button-general-allegati">
			<div class="ama-row">
				<div class="ama-col-sm-12">
					<button href="#" type="button" class="button button-primary margin-top" onclick="saveForm()" ><liferay-ui:message key="backup-prosegui"/></button>
				</div>
			</div>
		</div>    
	</div> 
</form>

<script>



	
	var idButtonAddAttachFile = "#<portlet:namespace/>addAttachFile";
	var idFileAttach = "#<portlet:namespace/>fileAttach";
	var idAttachFileDiv="#<portlet:namespace/>fileAttachDiv";
	var idSelectFile = "#<portlet:namespace/>selectFile";
	var idForm = "#<portlet:namespace/>richiestaRimborso";
	var idFileName= "#<portlet:namespace/>fileName";

	
	addParsleyFile("Personale");


	function addParsleyFile(tab){
		
		$("#allegatoDiv"+tab).text("");
		var input = document.createElement("input");
		
		$(input).attr("id","<portlet:namespace/>fileAttach"+tab);
		$(input).attr("name","<portlet:namespace/>Allegato");
		$(input).attr("type","file");
		$(input).css("display","none");
		$(input).attr("accept",".xml");
		
		$(input).attr("data-parsley-filemaxmegabytes","1");
		$(input).attr("data-parsley-trigger","change");
		$(input).attr("data-parsley-required","true");
		$(input).attr("data-parsley-required-message","<liferay-ui:message key='error-mandatory'/>");
		$(input).attr("data-parsley-check-file-attach-extension",".jpeg,.png,.jpg,.bmp,.pdf");
		
		$(input).change(function() {
			changeDisplay(tab,this.value);
		});
		$("#allegatoDiv"+tab).append(input);
				
		
	}
	
	
	function resetForm(){
	
		
		$(idForm+"Personale").find(".removeFieldFormTrasporti").each(function(){
			$(this).val("");
		});
		

		$(idForm+"Personale").find("textarea").each(function(){
		   $(this).next().text("0/500");
	
		});
		
		resetAllegato("Personale");

		
		
	}
	
	function resetAllegato(tab){
		$(idAttachFileDiv+tab).css("display","none");
		$(idSelectFile+tab).css("display","block");	
		

	}
	
	function removeAllegato(tab){
		event.preventDefault();
		event.stopPropagation();
		$(idFileAttach+tab).val("");
		resetAllegato(tab);
	}

	
	function changeDisplay(tab, val){

		$(idFileAttach+tab).parsley().validate();
		
		if (val!=null && val!="" && $(idFileAttach+tab).parsley().isValid()){
					$(idFileAttach+tab).parsley().destroy();

			var index = val.lastIndexOf('\\');
			var value= val.substring(index+1, val.length);
			$(idAttachFileDiv+tab).css("display","block");
			var arrayFiles=[];
			var insideText = "<a href='#' title='elimina file' onclick='removeAllegato("; 
			
			insideText = insideText.concat('"');
			insideText = insideText.concat(tab);
			insideText = insideText.concat('"');

			insideText = insideText.concat(");' class='icomoon-close-white ico-delete'></a>");
			
			$(idAttachFileDiv+tab).find(idFileName+tab).text(value);
			$(idAttachFileDiv+tab).find(idFileName+tab).append(insideText);
			$(idSelectFile+tab).css("display","none");

		}else{
			if(!$(idFileAttach+tab).parsley().isValid())
				resetAllegato(tab);
		
		}

	}
	
	
	

	$(idButtonAddAttachFile+"Personale").on('click', function(event){
		addParsleyFile("Personale");
		$(idFileAttach+"Personale").click();
	});
	
	
</script>