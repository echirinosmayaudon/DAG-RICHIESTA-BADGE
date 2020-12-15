

								 <button id="idTabFiltriAreeTem" class="filtro-top-button open-tab mobile-click-open" data-toggle="collapse" data-target="#filtro-category">
									<span class="button-label">ALTRI FILTRI</span>
									<span class="icomoon-vedi-dark hidden-xs"></span><span class="icomoon-arrow-dx icon-arrow-mobile"></span>
								</button>

									<div id="filtro-category" class="collapse">

									<div class="filtro-content-box filtro-category">

											 <c:forEach items="<%=categ %>" var="areaTem" varStatus="loop">
											 <c:set var="areaTematicaChoosen" value="${areaTem.getPrimaryKey().toString()}"/>

											 <%AssetCategory areaTem=(AssetCategory)  pageContext.getAttribute("areaTem");

											 %>
											<div class="ama-col-md-3 ama-col-sm-4 ama-col-xs-12 filter-category-item-wrap">
											<a href=""  title="${areaTem.getName()}" class="filter-category-item-box <%= ArrayUtil.contains(areeTematiche, (String)pageContext.getAttribute("areaTematicaChoosen")) ? "active" : ""%>">
													<div class="category-item-icon">
													 	<span class="icon-category icomoon-${areaTem.getDescriptionCurrentValue()}"></span>
													</div>
													 <input type="hidden" value="${areaTem.getPrimaryKey()}" id="idArea"></input>
													<div class="category-item-text">${areaTem.getName()}</div>
												</a>
											</div>
											</c:forEach>





											<div class="buttons-wrapper ama-col-xs-12">
												<div class="ama-col-sm-6 ama-col-xs-12 text-center">
													<button class="button button-secondary button-cancel button-filtro" onclick="removeClassActive()">ANNULLA</button>
												</div>
												<div class="ama-col-sm-6 ama-col-xs-12 text-center">
													<button class="button button-primary" onclick='<%= renderResponse.getNamespace() + "search();" %>'>APPLICA</button>
												</div>
											</div>
												 </div>
									</div>
