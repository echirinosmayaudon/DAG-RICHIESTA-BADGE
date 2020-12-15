<%@ include file="/init.jsp"%>

<c:if test='<%= viewTheme.equals("Classic") %>'>
	<%@ include file="/home.jsp"%>
</c:if>

<c:if test='<%= viewTheme.equals("Categories") %>'>
	<%@ include file="/category.jsp"%>
</c:if>
<portlet:resourceURL var="resourceURL" />
<script>
function callServeResource(x){
	AUI().use('aui-io-request', function(A){           	 
		A.io.request('<%=resourceURL.toString()%>', {
	   		method: 'post',
	        data: {
	        	<portlet:namespace />dlFileId: x          	                  
	        }
	    });
	 
	});
}
</script>