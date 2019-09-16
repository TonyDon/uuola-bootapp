<#include "layout.ftl">
<@html>
        <main role="main" class="container">
            <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                          <li class="breadcrumb-item"><a href="${basePath}/">首页</a></li>
                          <li class="breadcrumb-item">${pageData.extra.blogCatalog.name}</li>
                        </ol>
            </nav>
            <ul class="list-unstyled">
            <#list pageData.dataSet as blogInfo>
               <li class="media">
                  <img class="mr-3" src="${basePath}/image/1.jpg" alt="Generic placeholder image">
                  <div class="media-body">
                  	<h5 class="mt-0 mb-1"><a href="${basePath}/blog/${blogInfo.id}/${blogInfo.title}.shtml" target="_blank" title="${blogInfo.title},${blogInfo.keywords!}">${blogInfo.title}</a></h5>
                    ${blogInfo.summary!}
                  </div>
               </li>
            </#list>
            </ul>
            <nav aria-label="Page navigation example">
              <#assign hreftpl = basePath + "/blog/list/"+pageData.extra.blogCatalog.id+"/"+pageData.listSize+"/@pageNo@/"+pageData.extra.blogCatalog.name+".shtml"/>
			  <@commons.page pageNo=pageData.pageNo total=pageData.total listSize=pageData.listSize showPages=3 hrefTpl=hreftpl/>
			</nav>
        </main>
</@html>
<@script>
<script>
</script>
</@script>