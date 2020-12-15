<%@ include file="./init.jsp" %>

<%@page import="com.mef.intranet.rubrica.service.SearchDataLocalServiceUtil" %>

	
	<%
	List<String> alfabeto_list;
	alfabeto_list=SearchDataLocalServiceUtil.getAlfabetoTag();
	
	%>
	
	<div class="gestione-riunioni-title-box">
        <div class="ama-container-fluid">
            <div class="ama-row">
                <div class="ama-col-xs-12">
                    <div class="title-wrapper">
                        <h2 class="title"><liferay-ui:message key="rubrica-ricerca-parole-chiave"/></h2>
                        <p class="subtitle"><liferay-ui:message key="rubrica-ricerca-subtitle"/></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
<div class="gestione-riunioni-modifica-wrapper">
        <div class="ama-container-fluid">

            <div class="tab-negative-wrap">
                <ul class="nav nav-pills" >			
                    <li class="active" >
                    <a  name="alf" title="DATI PRINCIPALI" data-toggle="pill"  id="<%=alfabeto_list.get(0)%>" onclick="tagFromChar(this.id)"><%=alfabeto_list.get(0)%></a>
                    </li>
                    <c:forEach items="<%=alfabeto_list.subList(1, alfabeto_list.size()-1)%>" var="lettera">
                     <li >					
                        <a name="alf"  title="alfabeto" data-toggle="pill"  class="border-yellow" id="${lettera}" onclick="tagFromChar(this.id)">${lettera}</a>
                    </li>
                     </c:forEach>                   
                </ul>
            </div>

            <div class="tab-content">           
                <div id="" class="tab-pane fade in active">
                    <div class="tab-filtri">
                    <div class="filtro-tabs-wrapper mt-40-xs">
                        <span title="" class="tab-title active"></span>
                    </div>
                    
                       <div class="box-tab-rubrica" id="tagParolaChiave">
 
                       </div>
                       
                    </div>
                </div>              
            </div>
        </div>
        </div>	
        
        
        
                        <portlet:actionURL var="cercaUfficiUrl" name="cercaUffici">                                                   
                        </portlet:actionURL> 
        <form action="<%=cercaUfficiUrl%>" method="post" id="tagForm">
                    <input type="hidden" id="tagChiave"  name="<portlet:namespace/>tagChiave"/>   
                    </form>
                    
        
        <script>            
        var tagDiv = "#tagParolaChiave";
        var arrayObj=[];
        
   $('.nav-pills').each(function(){
	   $(this).find('li').each(function(){
		   if ($(this).is(".active")){
			   var firstChar=$(this).children().text();
			   tagFromChar(firstChar);
		   }
	   });
	  
	   
   });
        
        function tagFromChar(x){
        
        	$("#tagParolaChiave").html("");
        
        
        	Liferay.Service(
        			  '/mefrubrica.searchdata/get-list-tag-for-char',
        			  {
        			    character: x
        			  },
        			  function(obj) {
        			    $.each(obj,function(key, value){
        			    	var tagNameVar=value.tagName.value;
        			    	var numUff=value.numUffAssoc;

     						$('.tab-title').text(x);
     						arrayObj=onGeneratedRow(tagNameVar, numUff);
     						arrayObj.forEach(addDiv,{divMaster: tagDiv});	
     				   	});        			         			    
        			  } 
        			);           	
      }        
        
        
function addDiv(item,index,arr){
	
	
	       	
	var divTabParola = document.createElement("div");
	$(divTabParola).addClass('tab-rubrica-parola-chiave');
	
	var divContentTab = document.createElement("div");
	$(divContentTab).addClass('content-tab');
	
	var divAmaRow = document.createElement("div");
	$(divAmaRow).addClass('ama-row');
				
	var divAmaCol = document.createElement("div");
	$(divAmaCol).addClass('ama-col-xs-12');
				
	var divWrapper = document.createElement("a");
	$(divWrapper).addClass('wrapper-content-name');		
	$(divWrapper).attr("href",'');
	$(divWrapper).click(function(event) {
		event.preventDefault();
		$('#tagChiave').val(item.tagName);

		$('#tagForm').submit();
	}); 
		
	
	var divName = document.createElement("div");
	$(divName).addClass('name');				
	$(divName).text(item.tagName.toUpperCase()+" ");	
				
	var divNumber = document.createElement("span");		
	$(divNumber).addClass('number');	
	$(divNumber).text(item.numUffAssoc);
	
	$(divName).append($(divNumber));
	$(divWrapper).append($(divName));
	$(divAmaCol).append($(divWrapper));
	$(divAmaRow).append($(divAmaCol));
	$(divContentTab).append($(divAmaRow));
	$(divTabParola).append($(divContentTab));
			
			
			if 	($(this.divMaster)!= null){
				$(this.divMaster).append($(divTabParola));
				
			}else{
				//console.log("ERROR: non è stato specificato il div nella quale verrano inseriti gli invitati");
			}
        }
        
        
function onGeneratedRow(name, number)
        {
        	var employees = [];
        	
        	var name = name;
        	var number = number;
        	var employee = {
        	  "tagName": name,
        	  "numUffAssoc": number
        	}       	
        	employees.push(employee);        
        	return employees;
         }
 

        </script>
        
        
        
        
        
        
        
        