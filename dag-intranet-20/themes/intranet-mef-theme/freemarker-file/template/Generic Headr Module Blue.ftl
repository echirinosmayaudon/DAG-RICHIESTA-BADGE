<div class="trasporti-header">
    <div class="ama-container-fluid">
        <div class="ama-row">
            <div class="ama-col-xs-12">
                <div class="title-wrapper">
                    <h2 class="title">${title.getData()}</h2>
                      <#if (includeStar.getData()=="true")>
                        <a class="icomoon-star title-star btn-star-bookmarks">
                        <span class="sr-only">Aggiungi a preferiti</span>
                        </a>
                    </#if>
                    <p class="subtitle dot-point dot-200">${description.getData()}</p>
                </div>
            </div>
        </div>
    </div>
</div>
