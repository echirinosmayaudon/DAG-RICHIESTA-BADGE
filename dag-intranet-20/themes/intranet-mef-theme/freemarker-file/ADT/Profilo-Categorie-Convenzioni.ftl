<div class="ama-container-fluid">
	<#if entries?has_content>
		<#list entries as curVocabulary>
			<div class="ama-col-md-12">
	            <div class="wrapper-title title-with-arrow">
	                <h2 class="title-box borders text-uppercase">${curVocabulary.name}</h2>
	                <a class="icomoon-vai" title="Vai alla sezione" href="convenzioni">
	                    <span class="sr-only">Vai alla sezione</span>
	                </a>
	            </div>
	        </div>
		</#list>
	</#if>
	<div class="ama-row wrapper-convenzioni">
	<#if entries?has_content>
		<#list entries as curVocabulary>
			<#list curVocabulary.getCategories() as curCat>
				<#assign categoryName = curCat.getName()>
				<#assign categoryDescription = curCat.getDescription(locale)>
				<#assign categoryId = curCat.getCategoryId()>
				<div class="col-md-3 col-sm-4 col-xs-6 item-convenzioni">
		            <a href="convenzioni?categories=${categoryId}" title="${curCat.name}" class="category-item-conv">
		                <div class="box-item-conv">
		                	<span class="icon-cat-convenzioni icomoon-${categoryDescription}"></span>
		                </div>
		                <div class="box-description">
		                	<p class="text-description dot-point max-dot-70 dot-mobile">${categoryName}</p>
		                </div>
		            </a>
		        </div>
			</#list>
		</#list>
	</#if>
	</div>
</div>