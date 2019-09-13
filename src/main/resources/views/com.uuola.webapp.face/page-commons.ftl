<#macro page pageNo total listSize showPages hrefTpl>
	<#if total%listSize gt 0>
		<#assign totalPage = ((total/listSize)+1)/>
	<#else>
		<#assign totalPage = (total/listSize)/>
	</#if>
	<ul class="pagination justify-content-center">
		<#if pageNo!=1>
        <li class="page-item"><a class="page-link" href="${hrefTpl?replace("@pageNo@","1")}">第一页</a></li>
        <li class="page-item"><a class="page-link" href="${hrefTpl?replace("@pageNo@", pageNo-1)}">上一页</a></li>
        </#if>
        <#if pageNo-showPages/2 gt 0>
        	<#assign start = pageNo-(showPages-1)/2/>
        	<#if showPages gt totalPage>
        		<#assign start = 1/>
        	</#if>
        <#else>
        	<#assign start = 1/>
        </#if>
        <#if totalPage gt showPages>
        	<#assign end = (start+showPages-1)/>
        	<#if end gt totalPage>
        		<#assign start = totalPage-showPages+1/>
        		<#assign end = totalPage/>
        	</#if>
        <#else>
        	<#assign end = totalPage/>
        </#if>
        <#assign pages=start..end/>
        <#list pages as page>
        	<#if page==pageNo>
        	<li class="page-item active" aria-current="page"><a class="page-link" href="#page${page}">${page}</a></li>
        	<#else>
        	<li class="page-item"><a class="page-link" href="${hrefTpl?replace("@pageNo@", page)}">${page}</a></li>
        	</#if>
        </#list>
		<#if pageNo!=totalPage>
        <li class="page-item"><a class="page-link" href="${hrefTpl?replace("@pageNo@", pageNo+1)}">下一页</a></li>
        <li class="page-item"><a class="page-link" href="${hrefTpl?replace("@pageNo@", totalPage)}">最末页</a></li>
        </#if>
    </ul>
    <ul class="nav float-right">
        <li class="nav-item"><span class="d-inline p-2">共 ${total} 条记录</span></li>
    </ul>
</#macro>