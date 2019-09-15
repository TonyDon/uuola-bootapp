<#include "layout.ftl">
<@html>
<main role="main" class="container">
      <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                          <li class="breadcrumb-item"><a href="${basePath}/">首页</a></li>
                          <li class="breadcrumb-item"><a href="${basePath}/blog/list/${blog.blogCatalog.id}/2/1/${blog.blogCatalog.name}.shtml" title="${blog.blogCatalog.name}">${blog.blogCatalog.name}</a></li>
                          <li class="breadcrumb-item active" aria-current="page">文章正文</li>
                        </ol>
       </nav>
       <h1 class="title">${blog.info.title}</h1>
       <p class="lead">${blog.info.summary}</p>
            ${blog.post.content}
       <ul class="list-unstyled">
            <#list recomm as blogInfo>
               <li class="media">
                  <img class="mr-3" src="${basePath}/image/1.jpg" alt="Generic placeholder image">
                  <div class="media-body">
                  	<h5 class="mt-0 mb-1"><a href="${basePath}/blog/${blogInfo.id}/${blogInfo.title}.shtml" target="_blank" title="${blogInfo.title},${blogInfo.keywords!}">${blogInfo.title}</a></h5>
                    ${blogInfo.summary!}
                  </div>
               </li>
            </#list>
        </ul>
</main>
</@html>
<@script>
<script>
</script>
</@script>