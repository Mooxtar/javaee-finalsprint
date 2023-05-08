<%@ page import="techorda.bitlab.kz.db.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="header.jsp"%>

    <div class="container" style="min-height: 500px;">

      <div class="row mt-3">

        <div class="col-12">

            <%

                ArrayList<Blog> blogs = (ArrayList<Blog>) request.getAttribute("blogs");

                if(blogs!=null){

                    for(Blog blog : blogs){

            %>

            <div class="row mt-3">

                <div class="col-11 mx-auto p-3" style="background-color: lightgrey;">

                    <h2>

                        <a href="/readblog?id=<%=blog.getId()%>" class="text-dark text-decoration-none">

                            <%=blog.getTitle()%>

                        </a>

                    </h2>

                    <p class="mt-2"><%=blog.getContent()%></p>

                    <p class="mt-2">

                        Category: <strong><%=blog.getCategory().getName()%></strong>

                        at <strong><%=blog.getPost_date()%></strong>

                    </p>

                </div>

            </div>

            <%

                    }

                }

            %>



        </div>

      </div>

    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
