<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <%@include file="head.jsp"%>
</head>
<body>
<%
  User user = (User)session.getAttribute("currentUser");
%>

<%@ include file="header.jsp"%>


<div class = "container">
  <div class = "welcome">
    <div class = "position-absolute start-50 translate-middle mt-5">
      <h1><strong><%=currentUser.getFullName()%></strong></h1>
    </div>
    <div class = "position-absolute start-50 translate-middle-x mt-5">
      <h4 class = "text-secondary mt-5">This is your profile edge</h4>
    </div>

  </div>
</div>
<div class = "container mt-5">
  <div class = "row mt-5">
    <div class = "col-8 mt-5 mx-auto">
      <label for="basic-url" class="form-label">Full Name :</label>
      <div class="input-group mb-3">
        <span class="" ></span>
        <input type="text" name = "title" placeholder="New Name" class="form-control"  id="basic-url"
               aria-describedby="basic-addon3" value="<%=currentUser.getFullName()%>" readonly>
      </div>
      <label for="basic-url2" class="form-label">Email :</label>
      <div class="input-group mb-3">
        <span class="" ></span>
        <input type="text" name = "title" placeholder="New Email" class="form-control"  id="basic-url2"
               aria-describedby="basic-addon3" value="<%=currentUser.getEmail()%>" readonly>
      </div>
      <label for="basic-url1" class="form-label">Password :</label>
      <div class="input-group mb-3">
        <span class="" ></span>
        <input type="text" name = "title" placeholder="New Password" class="form-control"  id="basic-url1"
               aria-describedby="basic-addon3" value="<%=currentUser.getPassword()%>" readonly>
      </div>
      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editBlog">
        <span class="bi bi-pencil-square"></span>Edit
      </button>

      <!-- Modal -->
      <div class="modal fade" id="editBlog" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
           aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="staticBackdropLabel">Edit Profile</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <%@include file="editprofile.jsp"%>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>