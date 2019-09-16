<#include "layout.ftl">
<@html>
<main role="main" class="container">
	<div class="card">
		<div class="card-body">
			<ul class="list-unstyled">
			<#list blogCatalogs as cat>
			<li><a href="/blog/list/${cat.id}/5/1/${cat.name}.shtml">${cat.id}, ${cat.name}</a></li>
			</#list>
			</ul>
		</div>
	</div>
</main>
</@html>
<@script>
<script>
</script>
</@script>