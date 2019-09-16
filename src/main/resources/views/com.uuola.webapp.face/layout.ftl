<#assign basePath = "${context_path}" />
<#import "page-commons.ftl" as commons/>
<#macro html charset="utf-8" lang="zh-CN">
	<#include "header.ftl">
	<#nested>
</#macro>
<#macro script charset="utf-8" lang="zh-CN">
<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
<script src="${basePath}/bootstrap/bootstrap.min.js"></script>
<#nested>
<#include "footer.ftl">
</#macro>