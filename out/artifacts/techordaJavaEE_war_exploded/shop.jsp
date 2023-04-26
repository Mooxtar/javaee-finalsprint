<%@ page import="techorda.bitlab.kz.db.Item" %>
<%@ page import="java.util.ArrayList" %>
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
        <div class="container-fluid" >
            <a class="navbar-brand" href= "/" ><strong>BITLAB SHOP</strong></a>
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
                        <a class="nav-link active" href = "/login">Sign in</a>

                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <div class = "welcome">
        <div class = "position-absolute start-50 translate-middle mt-5">
            <h2><strong>Welcome to BITLAB SHOP</strong></h2>
        </div>
        <div class = "position-absolute start-50 translate-middle-x mt-5">
            <h5 class = "text-secondary mt-5">Electronic devices with high quality and service</h5>
        </div>

    </div>
    <div style="height: 30px"></div>
    <%
        int index = 0;
        ArrayList<Item> items = (ArrayList<Item>)request.getAttribute("tovary");
        for (Item item : items) {

            if (index%3 == 0) {



    %>
    <div>
        <div class = "row">


            <%
                }
            %>

            <div class = "col mt-5" style ="
box-shadow:
       inset 0 -2em 2em rgba(0,0,0,0.1),
             2px 2px  2px 2px rgba(0,0,0,0.1),
             0.2em 0.2em 1em rgba(0,0,0,0.1);
">
                <div class="card text-center">
                    <h5 class="card-header"><%=item.getName()%></h5>
                    <div class="card-body">
                        <h5 class="card-title"><p class = "display-7 text-success">$<%=item.getPrice()%></p></h5>
                        <p class="card-text"><%=item.getDescription()%></p>
                        <a href="#" class="btn btn-success">Buy Now</a>
                    </div>
                </div>
            </div>


            <%

                if (index == items.size() - 1 || (index + 1)%3 == 0) {

            %>
        </div>
    </div>
    <%
        }
        index++;
    %>


    <%
        }
    %>


</div>

</body>
</html>