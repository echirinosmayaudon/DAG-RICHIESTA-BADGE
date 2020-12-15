<div class="organigramma-testuale-wrapper">
  <div class="page-title-wrapper">
    <div class="title-wrapper">
      <h2 class="title">${Title.getData()}</h2>
      <#if (IncludeStar.getData()=="true")>
        <a class="icomoon-star title-star btn-star-bookmarks">
          <span class="sr-only">Aggiungi a preferiti</span>
        </a>
      </#if>

      <a href="${LinkToPage.getFriendlyUrl()}" class="organigramma-title-button pull-right">
        <span class="organigramma-title-graph-icon icomoon-graphic-view"></span>
        <span class="pl-15-xs">${TitleLink.getData()}</span></a>
      ${Description.getData()}
    </div>
  </div>
</div>
