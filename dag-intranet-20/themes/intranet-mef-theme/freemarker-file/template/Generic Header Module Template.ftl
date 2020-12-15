<div class="page-title-wrapper">
  <div class="title-wrapper">
    <h2 class="title">${title.getData()}</h2>
    <#if (includeStar.getData()=="true")>
      <a class="icomoon-star title-star btn-star-bookmarks">
        <span class="sr-only">Aggiungi a preferiti</span>
    </#if>
    </a>
    ${description.getData()}
  </div>
</div>
