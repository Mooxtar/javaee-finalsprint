<%@ page import="techorda.bitlab.kz.db.Blog" %>
<%@ page import="techorda.bitlab.kz.db.Comment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="techorda.bitlab.kz.db.Category" %>

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

        Blog blog = (Blog) request.getAttribute("blog");

        if(blog!=null){

      %>

      <div class="row mt-3">

        <div class="col-11 mx-auto p-3" style="background-color: lightgrey;">

          <h2><%=blog.getTitle()%></h2>

          <p class="mt-2"><%=blog.getContent()%></p>

          <p class="mt-2">

            Category: <strong><%=blog.getCategory().getName()%></strong>

            at <strong><%=blog.getPost_date()%></strong>

          </p>

          <%
            if (currentUser != null && currentUser.getRole_id() == 1) {
          %>
          <div class="row mt-3">
            <div class="col-12">
              <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal"
                      data-bs-target="#editBlog">
                Edit Blog
              </button>
              <!-- Button trigger modal -->
              <button type="button" class="btn btn-danger btn-sm ms-2" data-bs-toggle="modal"
                      data-bs-target="#deleteBlog">
                Delete Blog
              </button>
            </div>
          </div>
          <!-- Modal -->
          <div class="modal fade" id="deleteBlog" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
               aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <form action="/deleteblog" method="post">
                  <input type="hidden" name="id" value="<%=blog.getId()%>">
                  <div class="modal-header">
                    <h1 class="modal-title fs-5">Confirm Delete</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <h5 class="text-center">Are you sure?</h5>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
                    <button class="btn btn-danger">YES</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="modal fade" id="editBlog" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
               aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <form action="/saveblog" method="post">
                    <input type="hidden" name="blog_id" value="<%=blog.getId()%>">
                    <div class="row">
                      <div class="col-12">
                        <label>TITLE : </label>
                      </div>
                    </div>
                    <div class="row mt-2">
                      <div class="col-12">
                        <input type="text" class="form-control" name="title"
                               value="<%=blog.getTitle()%>">
                      </div>
                    </div>
                    <div class="row mt-3">
                      <div class="col-12">
                        <label>CATEGORY : </label>
                      </div>
                    </div>
                    <div class="row mt-2">
                      <div class="col-12">
                        <select class="form-select" name="category">
                          <%
                            ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
                            if (categories != null) {
                              for (Category category : categories) {
                          %>
                          <option <%=(category.getId() == blog.getCategory().getId() ? "selected" : "")%>
                                  value="<%=category.getId()%>"><%=category.getName()%>
                          </option>
                          <%
                              }
                            }
                          %>
                        </select>
                      </div>
                    </div>

                    <div class="row mt-3">
                      <div class="col-12">
                        <label>CONTENT : </label>
                      </div>
                    </div>
                    <div class="row mt-2">
                      <div class="col-12">
                                        <textarea name="content" class="form-control"
                                                  rows="10"><%=blog.getContent()%></textarea>
                      </div>
                    </div>
                    <div class="row mt-3">
                      <div class="col-12">
                        <button class="btn btn-primary">SAVE BLOG</button>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
              </div>
            </div>
          </div>
          <%
            }
          %>

          <%

            if(currentUser!=null){

          %>

          <div class="row mt-2">

            <div class="col-12">

              <form action="/addcomment" method="post">

                <input type="hidden" name="blog_id" value="<%=blog.getId()%>">

                <textarea class="form-control" name="comment" placeholder="Write a comment"></textarea>

                <button class="btn btn-success mt-3">ADD COMMENT</button>

              </form>

            </div>

          </div>

          <%

            }

          %>

          <hr>

          <%

            ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");

            if(comments!=null){

              for(Comment comment : comments){

          %>

          <div class="row mt-2">

            <div class="col-12">

              <h5><%=comment.getUser().getFullName()%></h5>

              <p><%=comment.getComment()%></p>

              <p>At <strong><%=comment.getPost_date()%></strong></p>

            </div>

          </div>

          <%

              }

            }

          %>

        </div>

      </div>

      <%

        }

      %>

    </div>

  </div>

</div>

<%@include file="footer.jsp"%>

</body>


</html>