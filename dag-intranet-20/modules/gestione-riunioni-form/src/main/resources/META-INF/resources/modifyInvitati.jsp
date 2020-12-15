<%
List<StatoInvitato> listStatoInvitatoDB = creatorBean.createListaStatoInvitato();


PortletSession pSession= renderRequest.getPortletSession();
List<Segreteria> listSegreteria=null;

if (pSession.getAttribute("altreSegreterie", pSession.APPLICATION_SCOPE)!=null){
	listSegreteria = (List<Segreteria>)pSession.getAttribute("altreSegreterie", pSession.APPLICATION_SCOPE);
}

List<Segreteria> invitati =null;
if (pSession.getAttribute("invitati", pSession.APPLICATION_SCOPE)!=null){
	invitati = (List<Segreteria>)pSession.getAttribute("invitati", pSession.APPLICATION_SCOPE);
}
Long companyId = ParamUtil.getLong(request, "companyId");
if (companyId==0)
	companyId = (Long) request.getAttribute("companyId");			

%>

<div id="riunioneModificaInvitati" class="tab-pane invitati fade">
	<div class="tab-title-wrapper">
		<div class="title-wrapper">
			<h2 class="title text-uppercase"><%=obj%></h2>
		</div>
		<div class="div-button">
			<span class="label-riunioni-state">
				<span class="label-icon icomoon-meeting"></span>
				<span class="label-state-name"><%= labelStatoRiu.toUpperCase() %></span>
			</span>
			<c:if test="<%= !labelTipoRiu.equals("")%>">
				<span class="label-riunioni-state ml-0-xs ml-20-sm">
					<span class="label-state-name"><%= labelTipoRiu.toUpperCase() %></span>
				</span>
			</c:if>
		</div>
	</div>
	<div class="container-info-riunioni bg-gray">
		<div class="wrapper-info-riunioni">
			<div class="ama-row">
				<div class="ama-col-sm-3 ama-col-xs-6 text-left">
					<span class="icomoon-calendar-date"></span><span
						class="text-bold mobile-hidden"><liferay-ui:message key="gestione-riunione-modifica-invitati-data-inizio"/>:</span><span> <%=data%></span>
				</div>
				<div class="ama-col-sm-3 ama-col-xs-6 mobile-text-right">
					<span class="icomoon-time"></span><span
						class="text-bold mobile-hidden"><liferay-ui:message key="gestione-riunione-modifica-invitati-ora-inizio"/>:</span><span> <%=ora%></span>
				</div>
				<div
					class="ama-col-sm-6 ama-col-xs-12 text-right mobile-text-center mt-20-xs mt-0-md">
					<span class="icomoon-pin"></span><span class="text-bold"><liferay-ui:message key="gestione-riunione-modifica-invitati-luogo"/>:</span><span> <%=luog%></span>
				</div>
			</div>
		</div>
		<div class="wrapper-info-riunioni bg-white">
			<div class="ama-row">
					
				<div
					class="ama-col-xs-12 mobile-text-center">
					<span class="text-bold"><liferay-ui:message key="gestione-riunione-modifica-invitati-amministrazione-convocante"/>:</span><span> <%=admin%></span>
				</div>
				<div class="ama-col-xs-12 mobile-text-center">
					<span class="text-bold"><liferay-ui:message key="gestione-riunione-modifica-invitati-protocollo"/>:</span><span> <%=prot%></span>
				</div>
			</div>
		</div>
	</div>
	<div class="tab-filtri">
		<div class="filtro-tabs-wrapper mt-40-xs">
			<span title='<liferay-ui:message key="gestione-riunione-modifica-invitati-invitati-title"/>' class="tab-title active"><liferay-ui:message key="gestione-riunione-modifica-invitati-invitati"/></span>
		</div>

		<div class="clearfix box-tab-invitati">
			<div class="ama-col-md-3 ama-col-sm-4">
				<div class="invitati-selection-container">
					<div class="invitati-selection-header">
						<span class="header-text">
						<liferay-ui:message key="gestione-riunione-modifica-invitati-ispettorato"/></span>
					</div>
					<div class="invitati-selection-body">
						<div id="selection-item-container" class="selection-item-container"></div>
					</div>
					<div class="invitati-selection-footer">
						<button id="catsubmbtn" type="button" class="button button-primary" onclick='addInvite(".checkbox-custom")'>
						<liferay-ui:message key="gestione-riunione-modifica-invitati-aggiungi"/>
						</button>
					</div>
				</div>
			</div>
			<div id="invitati-item-selected-wrap" class="ama-col-md-9 ama-col-sm-8 invitati-item-selected-wrap mobile-no-padding"></div>
			
			
			
		</div>
		
			<portlet:actionURL name="modificaInvitati" var="modificaInvitati">
				<portlet:param name="idRiunione" value="${idRiunione}" />
			</portlet:actionURL>
		<form action="<%=modificaInvitati%>" method="post" id="modificaInvitati" name="name" enctype="multipart/form-data" class="form-dati-personali">

				<input type="hidden" id="listInvitati" name="<portlet:namespace/>saveInvitati">
				<input type="hidden" id="buttonValueInvitati" name="<portlet:namespace/>buttonValue">
				<input type="hidden" class="changeTab" name="<portlet:namespace/>changeTab">
			<div class="ama-row mt-25-sm"  >
				<div class="ama-col-xs-12 ">
					<div class="wrapper-content-textarea">
						<label class="label-form margin-top" for="textarea-note-invitati"><liferay-ui:message key="gestione-riunione-modifica-dati-note"/></label>
                        <textarea class="form-control textarea-custom-light textarea-note" id="textarea-note-invitati" 
						placeholder='<liferay-ui:message key="gestione-riunione-modifica-dati-note"/>' 
                        data-parsley-maxlength="4000"   name="<portlet:namespace/>Note"
						data-parsley-maxlength-message='<liferay-ui:message key="error-maxlength-char-message" arguments="<%=new String[]{\"4000\"}%>"/>'
						 onkeyup="changeInputInvitati()"><%=dettaglioRiunione.getNote()%></textarea>
                        <div class="content-textarea"> <%=dettaglioRiunione.getNote().length()%>/   
							<p class="color-gray">4000</p>
                        </div>
						
					</div>
				</div>
				</div>
			</form>
		<div class="ama-row">

		<div class="buttons-wrapper ama-col-xs-12 mt-55-xs mb-60-xsg">
				<div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
					<button id="cancel" class="button button-secondary" type="button" onclick="goToDettaglioAnnuncio('#buttonValueInvitati','#modificaInvitati')">
					<liferay-ui:message key="gestione-riunione-modifica-invitati-annulla"/></button>
				</div>
				<div class="ama-col-sm-6 ama-col-xs-12 text-center mobile-no-padding">
					<button id="save" type="button" class="button button-primary" onclick="saveForm()" >
					<liferay-ui:message key="gestione-riunione-modifica-invitati-salva"/></button>			
				</div>
			
		</div>
</div>
	</div>

</div>
	

	


 <textarea  id="noteDefaultInvitati" style="display:none"><%=dettaglioRiunione.getNote()%></textarea>





<script type="text/javascript">

var note = $("#noteDefaultInvitati").val();


var arrayStatoInvitato; //contiene tutti gli stati possibili degli invitati
var arrayPartecipanti = []; //array dei partecipanti alla riunione in stato accettata

	
//!!! nell'HTML devono essere presenti due div con i seguenti id
invitatiDiv = "#invitati-item-selected-wrap"; // tutti gli invitati saranno all'interno di un div con id="invitati-item-selected-wra" presente nell'HTML
segreterieDiv = "#selection-item-container"; // tutte le segreterie non ancora invitate saranno all'interno di un div con id="selection-item-container" presente nell'HTML

var arrayInvitati; //contiene la lista di tutti gli invitati alla riunione in formato json
var arraySegreterie; //contiene la lista di tutte le segreterie non ancora invitate in formato json
	
var arrayCurrentInvitati;
	var flagCapoFila = false; 

	resetInvitati(); //ritorna alla visualizzazione iniziale
	
	function resetInvitati(){
		document.getElementById("modificaInvitati").reset(); //resetta tutti i campi del form
//inizializza l'array degli invitati prendendo i valori dall'array invitati scritto in java 
		arrayInvitati = new Array(<%
				for(int i = 0; i < invitati.size(); i++) {
					   out.print(invitati.get(i).toJSON());
					  if(i+1 < invitati.size()) {
					    out.print(",");
					  }
					}	
			%>); 
		arrayInvitati.sort(function(a, b){
				if(a.index < b.index) return -1;
				if(a.index > b.index) return 1;
				return 0;
			});
		
		arrayCurrentInvitati  = new Array(<%
				for(int i = 0; i < invitati.size(); i++) {
					   out.print(invitati.get(i).toJSON());
					  if(i+1 < invitati.size()) {
					    out.print(",");
					  }
					}	
			%>); 
		if (arrayInvitati.length>0){
				for(var i=0; i<arrayInvitati.length;i++){
					arrayInvitati[i].index = parseInt(arrayInvitati[i].index);
					arrayCurrentInvitati[i].index= parseInt(arrayCurrentInvitati[i].index);
				}
				flagCapoFila = true;
			}
		
//inizializza l'array degli invitati prendendo i valori dall'array listSegreteria scritto in java 
		arraySegreteria = new Array(<%
				for(int i = 0; i < listSegreteria.size(); i++) {
				   out.print(listSegreteria.get(i).toJSON());
				  if(i+1 < listSegreteria.size()) {
				    out.print(",");
				  }
				}	
		%>); 
		
		//stato
		arrayStatoInvitato = new Array(<%
				for(int i = 0; i < listStatoInvitatoDB.size(); i++) {
				   out.print("{'id':'" + listStatoInvitatoDB.get(i).getId_stato_invitato()+"', 'nome':'"+ listStatoInvitatoDB.get(i).getNome_stato()+"'}");
				  if(i+1 < listStatoInvitatoDB.size()) {
				    out.print(",");
				  }
				}	
		%>); 
		updateHTML(); //aggiorna la visualizzazione della pagina

		
	}

	function findElement(arr, propName, propValue) {
	  for (var i=0; i < arr.length; i++)
		if (arr[i][propName] == propValue)
		  return i;
	  return -1;
	}
	/*sposta le segreterie selezionate nella lista degli invitati alla riunione
		classCheckbox -> è la variabile che contiene il nome della classe presente nel 
		tag input con l'attributo type=checkbox della segreteria
		ad esempio:
			Se questo tag contiene la segreteria
				<input class="checkbox-custom" type="checkbox" id="segreteria1">
			per richiamare questo metodo occorre scrivere:
				addInvite(".checkbox-custom")
		
	*/
	function addInvite(classCheckbox) {
					

		$(classCheckbox).each(function() {

			if ($(this).is(":Checked")){
				
            	arrayInvitati.push(JSON.parse($(this).val()));
				arrayInvitati.sort(function(a, b){
					if(a.index < b.index) return -1;
					if(a.index > b.index) return 1;
					return 0;
				});
				var index = findElement(arraySegreteria,"id",JSON.parse($(this).val()).id);
            	

            	arraySegreteria.splice(index, 1);

            	updateHTML();
            	checkSameArray(arrayInvitati, arrayCurrentInvitati);
            }
		});

    	

	}
	//rimuove un invitato dalla lista degli invitati e lo aggiunge alla lista delle segreterie
	function deleteInvite(index, item){
			event.preventDefault();
			
			if(item.capofila==true){
				item.capofila = false;
			}
			item.index=0;
			arraySegreteria.push(item);
			arraySegreteria.sort(function(a, b){
					if(a.nome < b.nome) return -1;
					if(a.nome > b.nome) return 1;
					return 0;});
			arrayInvitati.splice(index, 1);
			
			arrayInvitati.sort(function(a, b){
				if(a.index < b.index) return -1;
				if(a.index > b.index) return 1;
				return 0;
			});
					
			if (arrayInvitati.length>0){
				arrayInvitati[0].capofila=true;
			}else
				flagCapoFila = false;
			
			

			updateHTML();
			checkSameArray(arrayInvitati, arrayCurrentInvitati);
	}

//aggiorna la visualizzazione degli invitati e delle segreterie non ancora invitate
	function updateHTML(){
		$(segreterieDiv).empty();
	    $(invitatiDiv).empty();
		
		
		//crea la struttura HTML per ogni singola segreteria non ancora invitata all'interno del div il cui id è presente nel tag divMaster
		//type:checkbox -> identifica che la segreteria si può selezionare attraverso l'attributo checkbox
		arraySegreteria.forEach(addSegreterieHTML,{type:"checkbox",divMaster:segreterieDiv});
		//crea la struttura HTML per ogni singolo invitato all'interno del div il cui id è presente nel tag divMaster
		arrayInvitati.forEach(addInvitatiHTML,{divMaster: invitatiDiv});
		

	}

	
	function checkSameArray(a,b){
		if (a.length==b.length){
			a.sort(function(a, b){
				if(a.index < b.index) return -1;
				if(a.index > b.index) return 1;
				return 0;
			});
			b.sort(function(a, b){
				if(a.index < b.index) return -1;
				if(a.index > b.index) return 1;
				return 0;
			});
			
			for(var i=0; i<a.length; i++){
				if(a[i].id != b[i].id){
					$("#flagModal").val("openModal");
					return false;
				
				}
			}
			
			if (note == $("#textarea-note-invitati").val().trim()){
				$("#flagModal").val("");
			}else{
				$("#flagModal").val("openModal");
				 $("#textarea-note-invitati").val( $("#textarea-note-invitati").val().trim());
			}
			return true;

		}else{
			$("#flagModal").val("openModal");
			return false;
		}
		
	}

	/*salva tutti gli invitati in un input di tipo hidden, il quale verrà ripreso lato backend 
	per potere aggiungere gli invitati effettivamente alla riunione */
	function saveForm(){	
		if(checkSameArray(arrayInvitati, arrayCurrentInvitati)==false ||  note != $("#textarea-note-invitati").val().trim()){
			if(checkSameArray(arrayInvitati, arrayCurrentInvitati)==false){
				json = {"invitati" : arrayInvitati,"invitatiPrecedenti": arrayCurrentInvitati};
				$("#listInvitati").val(JSON.stringify(json));
				$("#textarea-note-invitati").val($("#textarea-note-invitati").val().trim());
				$("#modificaInvitati").submit();

			}else{
				$("#modificaInvitati").submit();

			}
		}else{
			console.log("non ci sono modifiche");
		}
		
	}
	    
	 /* per ogni invitato contenuto nell'array invitati viene richiamata questa funziona,
	 la quale crea dei tag HTML per la visualizzazione degli invitati nella pagina di riferimento
	
	Ogni invitato avrà questa struttura HTML:
		 <div class="ama-col-md-4 ama-col-sm-6 invitati-item-container">
			 <div class="invitati-item">
				 <div class="invitati-message">DA NOTIFICARE</div>
				 <p class=" invitati-name">IGECOFIP</p>
				 <a href="" class="icomoon-close-white"></a>
			</div>
		</div>
	!!!specificare sempre il div dove saranno inseriti gli invitati, utilizzando la struttura json {divMaster: "#idDivPadre" }

	esempio di richiamo della funzione:
		arrayInvitati.forEach(addInvitatiHTML,{divMaster: "#invitati" });
		arrayInvitati è un array che contiene gli invitati in formato json 
		divMaster è l'id del tag HTML nella quale saranno inseriti gli invitati
	
 */
 
    function getFullName(item,index) {
	    var fullname = [item.nome,item.cognome].join(" ");
	    return fullname;
	}
	
 	function addInvitatiHTML(item,index,arr){

	 		var divContainer = document.createElement("div");
			$(divContainer).addClass('ama-col-md-4 ama-col-sm-6 invitati-item-container');
			var divItem =  document.createElement("div");
			$(divItem).addClass('invitati-item');
			
			var divMessage =  document.createElement("div");
			$(divMessage).addClass('invitati-message');
			var indexStato = findElement(arrayStatoInvitato,"id",item.stato);
			
			if (indexStato==-1)
				stato = "<liferay-ui:message key='gestione-riunione-modifica-invitati-in-attesa'/>";
			else{
				stato = (arrayStatoInvitato[indexStato]).nome.toUpperCase();
			}

			$(divMessage).text(stato);

			/*salva l'invitato in un tag input di tipo 
			hidden per poterlo cancellare successivamente*/
			var input = document.createElement("input");
			$(input).attr("type","hidden");
			$(input).attr("value",item.id);
			
		
			
			var pNomeInvitato = document.createElement("p");
			$(pNomeInvitato).addClass('invitati-name');
			$(pNomeInvitato).text(item.nome);

			
			var aClose = document.createElement("a");
			$(aClose).attr('href','');
			$(aClose).addClass('icomoon-close-white');
			
			$(aClose).click(function() {
				deleteInvite(index,item);
			});
			
			$(divItem).append(divMessage);
			$(divItem).append(pNomeInvitato);
			$(divItem).append(aClose);
			$(divItem).append(input);
			
			if (stato=="accettata") {
				
				var aPartecipanti = document.createElement("a");
				$(aPartecipanti).attr('href','#');
				$(aPartecipanti).attr('id','partecipanti'+item.id+'-'+<%=idRiunioneDefault%>);
				//$(aPartecipanti).attr("title",arrayPartecipanti);
				$(aPartecipanti).addClass('text-position tooltip-field icon-information pull-right');

				var spanPartecipanti = document.createElement("span");
				$(spanPartecipanti).addClass('icomoon-partecipanti');
				
				
					Liferay.Service(
						  '/mef.invitatiriunione/get-invitati-riunione-by-pk',{
								id_segreteria: item.id,
								id_riunione: '<%=idRiunioneDefault%>'
						  },
						function(obj) {
						var partecipantiList;
						if((JSON.parse(obj.partecipanti)).list!= null && (JSON.parse(obj.partecipanti)).list!="") {
							partecipantiList = (JSON.parse(obj.partecipanti)).list;
						}else
							if((JSON.parse(obj.partecipanti)).partecipantiBox!= null && (JSON.parse(obj.partecipanti)).partecipantiBox!="") {
								partecipantiList = (JSON.parse(obj.partecipanti)).partecipantiBox;
							}
						if (partecipantiList!=null && partecipantiList!="" && partecipantiList.length>0){
							$(aPartecipanti).append(spanPartecipanti);
							
							$(divItem).append(aPartecipanti);
							
							for(var i=0; i<partecipantiList.length; i++){
								codiceFiscale = partecipantiList[i].cf;
								if (codiceFiscale==null || codiceFiscale==""){
									codiceFiscale = partecipantiList[i].codiceFiscale;
								}
								
								if (codiceFiscale!=null && codiceFiscale!=""){

									Liferay.Service(
										  '/user/get-user-id-by-screen-name',
										  {
											companyId: "<%= companyId%>",
											screenName: codiceFiscale
										  },
										  function(obj) {
												Liferay.Service(
													  '/user/get-user-by-id',
													  {
														userId: obj
													  },
													  function(obj) {
														nome = obj.firstName + " " + obj.lastName;
														contenutoItem = $('#partecipanti'+item.id+'-'+<%=idRiunioneDefault%>).attr("title");
														if(contenutoItem==null || contenutoItem ==""){
															$('#partecipanti'+item.id+'-'+<%=idRiunioneDefault%>).attr("title",nome);

														}else{
															$('#partecipanti'+item.id+'-'+<%=idRiunioneDefault%>).attr("title",contenutoItem + ", " + nome);

														}

													  }
													);
										  }
									);
								}
							}
						}
							
							
					});
				
				
				
				
			
			}
			
			$(divContainer).append(divItem);
			if 	($(this.divMaster)!= null){
				$(this.divMaster).append(divContainer);
			}else{
			}

		}
		
 /* per ogni segreteria contenuta nell'array segreteria viene richiamata questa funziona,
	 la quale crea dei tag HTML per la visualizzazione delle segreterie non ancora invitate nella pagina di riferimento
	
	Ogni segreteria avrà questa struttura HTML:
		<div class="checkbox-invitati">
			<input class="checkbox-custom" type="checkbox" id="segreterie1">
			<label class="selection-item" for="segreterie1">
				<span class="item-name">LOREM IPSUM DOLOR CONSECTETUR</span>
				<span class="icomoon-riunione-ok item-icon"></span>
			</label>
		
		</div>      
	!!!specificare sempre il div dove saranno inseriti le segreterie, utilizzando la struttura json {divMaster: "#idDivPadre" }

	esempio di richiamo della funzione:
		arraySegreteria.forEach(addSegreterieHTML,{type:"checkbox",divMaster:segreterieDiv});
		arraySegreteria è un array che contiene le segreterie in formato json 
		divMaster è l'id del tag HTML nella quale saranno inseriti gli invitati
		type:checkbox -> identifica che la segreteria si può selezionare attraverso l'attributo checkbox, 
						questo parametro non è obbligatorio, di default viene specificato checkbox
*/
	function addSegreterieHTML(item,index,arr) {

		var div = document.createElement("div");
		$(div).addClass('checkbox-invitati');
		var label = document.createElement("label");
		$(label).addClass('selection-item');
		label.innerHTML= ' <span class="item-name">' + item.nome + '</span><span class="icomoon-riunione-ok item-icon"></span>' ;
		
		var input = document.createElement("input");
		if 	($(this.type)!= null){
			$(input).attr("type", this.type);
		}else{
			$(input).attr("type", "checkbox");	
		}
		$(input).attr("id", index);
		
			//gestione capofila
			$(input).click(function() {
				indexSeg = findElement(arraySegreteria,"id",JSON.parse($(this).val()).id);
				if ( $(this).is(":Checked")){
					
					if(flagCapoFila==false){
						arraySegreteria[indexSeg].capofila=true;
						flagCapoFila = true;
					}
					
					arrayAux = arrayInvitati.slice();
					arraySegAux = arraySegreteria.slice();
											
					arrayAux.sort(function(a, b){
						if(a.index < b.index) return -1;
						if(a.index > b.index) return 1;
						return 0;
					});
					indexInvitato=0;
					if(arrayAux.length >0){
						indexInvitato= arrayAux[arrayAux.length-1].index;
					}
					 
					
					arraySegAux.sort(function(a, b){
						if(a.index < b.index) return -1;
						if(a.index > b.index) return 1;
						return 0;
					});
					indexSegreteria = 0;
					if(arraySegAux.length >0){
						indexSegreteria =arraySegAux[arraySegAux.length-1].index;
					}				
					if (indexSegreteria>indexInvitato)
						arraySegreteria[indexSeg].index=indexSegreteria+1;
					else
						arraySegreteria[indexSeg].index=indexInvitato+1;

				}else{
					if(arraySegreteria[indexSeg].capofila==true){
						arraySegreteria[indexSeg].capofila=false;
						flagCapoFila = false;
					}
					arraySegreteria[indexSeg].index=0;

					
				}
				$(this).val(JSON.stringify(arraySegreteria[indexSeg]));
				
			});
		
		$(input).val(JSON.stringify(item));
		$(input).addClass('checkbox-custom').appendTo(div);
		$(label).attr("for", index);
		$(div).append(label); 

		if 	($(this.divMaster)!= null){
			$(this.divMaster).append(div);
		}else{
		}
		
		
	   
	}
function changeInputInvitati() {
	
	if ((note != $('#textarea-note-invitati').val().trim())) {
		$('#flagModal').val("openModal");
	}
	else {
		if(checkSameArray(arrayInvitati, arrayCurrentInvitati)==true){
			$('#flagModal').val("");

		}
	}
}
</script>
