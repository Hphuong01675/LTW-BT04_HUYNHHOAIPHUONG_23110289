<%@ page contentType="text/html;charset=UTF-8" %>
<%
    model.User user = (model.User) request.getAttribute("user");
%>
<form method="post" enctype="multipart/form-data">
    <input type="text" name="fullname" value="<%=user.getFullname()%>" />
    <input type="text" name="phone" value="<%=user.getPhone()%>" />
    <input type="file" name="image" />
    <button type="submit">Cập nhật</button>
</form>
<img src="<%=user.getImage()%>" alt="Ảnh đại diện" width="150"/>
