<form action="/edit-profile" method="post">
    <div class = "container mt-2">
        <div class = "row mt-4">
            <div class = "col-12 mx-auto">
                <label for="basic-url" class="form-label">Full Name :</label>
                <div class="input-group mb-3">
                    <span class="" ></span>
                    <input type="text" name="user_id" hidden="hidden" value="<%=currentUser.getId()%>">
                    <input type="text" name = "fullName" placeholder="New Name" class="form-control"  id="basic-url"
                           aria-describedby="basic-addon3" value="<%=currentUser.getFullName()%>">
                </div>

                <label for="basic-url1" class="form-label">Password :</label>
                <div class="input-group mb-3">
                    <span class="" ></span>
                    <input type="text" name = "password" placeholder="New Password" class="form-control"  id="basic-url1"
                           aria-describedby="basic-addon3" value="<%=currentUser.getPassword()%>">
                </div>
                <button class="btn btn-primary mt-3" type="submit">Save</button>
            </div>
        </div>
    </div>
</form>

</body>
</html>