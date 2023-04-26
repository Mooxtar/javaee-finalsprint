<%@ page import="techorda.bitlab.kz.db.User" %>
<html>
<head>
    <title>Title</title>
    <link rel = "stylesheet" type = "text/css" href = "/css/bootstrap.css">
    <link rel = "stylesheet" type = "text/css" href = "/css/style.css">
    <script defer src="/js/bootstrap.js"></script>
</head>
<body>

<%
    User user = (User)session.getAttribute("currentUser");
%>

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
                        <a class="nav-link active" href = "/login"><%=user.getFullName()%></a>

                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <div class = "welcome">
        <div class = "position-absolute start-50 translate-middle mt-5">
            <h1><strong><%=user.getFullName()%></strong></h1>
        </div>
        <div class = "position-absolute start-50 translate-middle-x mt-5">
            <h4 class = "text-secondary mt-5">This is your profile edge</h4>
        </div>

    </div>
</div>
</body>
</html>