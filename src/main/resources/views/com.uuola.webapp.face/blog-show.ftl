<#assign basePath = "${context_path}" />
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="keywords" content="${blog.info.keywords!},久富农客,互联网+农业">
        <meta name="description" content="${blog.info.summary!},久富农客-986001.com-关注互联网+农业">
        <meta name="author" content="">
        <title>【${blog.info.title}】-久富农客-986001.com-关注互联网+农业</title>
        <link href="${basePath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="${basePath}/css/main.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <!-- Fixed navbar -->
            <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-success">
              <a class="navbar-brand" href="#">
                <img src="${basePath}/image/logo.png" class="img-fluid logo"/> 久富农客网<span class="sr-only">986001.com</span>
              </a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav mr-auto">
                  <li class="nav-item active">
                    <a class="nav-link" href="#">首页</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">农业数据</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">供求信息</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">农业网站导航</a>
                  </li>
                </ul>
                <form class="form-inline mt-2 mt-md-0">
                  <input class="form-control mr-sm-2" type="text" placeholder="搜索" aria-label="搜索">
                  <button class="btn btn-outline-warning my-2 my-sm-0" type="submit">搜索</button>
                </form>
              </div>
            </nav>
        </header>

        <main role="main" class="container">
            <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                          <li class="breadcrumb-item"><a href="${basePath}/">首页</a></li>
                          <li class="breadcrumb-item"><a href="${basePath}/blog/list?cid=${blog.blogCatalog.id}&cname=${blog.blogCatalog.name}" title="${blog.blogCatalog.name}">${blog.blogCatalog.name}</a></li>
                          <li class="breadcrumb-item active" aria-current="page">文章正文</li>
                        </ol>
            </nav>
            <h1 class="title">${blog.info.title}</h1>
            <p class="lead">${blog.info.summary}</p>
            ${blog.post.content}
            <ul class="list-unstyled">
                    <li class="media">
                      <img class="mr-3" src="${basePath}/image/1.jpg" alt="Generic placeholder image">
                      <div class="media-body">
                        <h5 class="mt-0 mb-1">List-based media object</h5>
                        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                      </div>
                    </li>
                    <li class="media my-4">
                      <img class="mr-3" src="${basePath}/image/1.jpg" alt="Generic placeholder image">
                      <div class="media-body">
                        <h5 class="mt-0 mb-1">List-based media object</h5>
                        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                      </div>
                    </li>
                    <li class="media">
                      <img class="mr-3" src="${basePath}/image/1.jpg" alt="Generic placeholder image">
                      <div class="media-body">
                        <h5 class="mt-0 mb-1">List-based media object</h5>
                        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                      </div>
                    </li>
            </ul>
        </main>

        <footer class="footer">
            <div class="container">
              <span class="text-muted">2008~2018&copy;986001.com 久富农客网</span>
            </div>
        </footer>

        <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
        <script src="${basePath}/bootstrap/bootstrap.min.js"></script>
        <script>

        </script>
    </body>
</html>