
<html>
<head>
    <title>Title</title>
    <link rel = "stylesheet" type = "text/css" href = "/css/bootstrap.css">
    <link rel = "stylesheet" type = "text/css" href = "/css/style.css">
    <script defer src="/js/bootstrap.js"></script>
</head>
<body>

<div class = "container">

    <nav class="navbar navbar-expand-lg bg-light" style="border-bottom: 1px solid gray">
        <div class="container-fluid">
            <a class="navbar-brand" href="/" ><strong>BITLAB SHOP</strong></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav" style="display: flex; justify-content: flex-end">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Top Sales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">New Sales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">By Category</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active">Sign in</a>

                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <%
        if (request.getAttribute("error") != null) {
    %>
    <div class="alert alert-danger mt-3" style="width: 50%; margin-left: 300px;" role="alert">
        Incorrect <b>email</b> or <b>password</b>
    </div>
    <%
        }
    %>


    <form action = "/login" method = "post">
        <div style="width: 50%; margin-left: 300px; margin-top: 10px; box-shadow:
       inset 0 -2em 2em rgba(0,0,0,0.1),
             2px 2px  2px 2px rgba(0,0,0,0.1),
             0.2em 0.2em 1em rgba(0,0,0,0.1);">
            <div class  = "row">
                <div class = "col-12">
                    <label>Email :</label>
                </div>
            </div>
            <div class = "row mt-2">
                <div class = "col-12">
                    <input type = "email" class="form-control" name = "email" required placeholder="example@gmail.com">
                </div>
            </div>
            <div class = "row mt-3">
                <div class = "col-12">
                    <label>Password :</label>
                </div>
            </div>
            <div class = "row mt-2">
                <div class = "col-12">
                    <input type = "password" class="form-control" name = "password" required >
                </div>
            </div>
            <div class = "row mt-3">
                <div class = "col-12">
                    <button class = "btn btn-success">Sign In</button>
                </div>
            </div>
        </div>
    </form>
</div>


</body>
</html>