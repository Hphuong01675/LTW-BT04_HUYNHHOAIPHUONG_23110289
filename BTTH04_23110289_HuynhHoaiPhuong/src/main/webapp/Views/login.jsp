<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Login | My App</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
    background: linear-gradient(135deg, #71b7e6, #9b59b6);
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}
.login-card {
    background: #fff;
    padding: 40px;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
    width: 350px;
}
.login-card h2 {
    text-align: center;
    margin-bottom: 30px;
    color: #343a40;
}
.form-control:focus {
    box-shadow: none;
    border-color: #9b59b6;
}
.btn-login {
    background-color: #9b59b6;
    border: none;
}
.btn-login:hover {
    background-color: #8e44ad;
}
</style>
</head>
<body>
<div class="login-card">
    <h2>Đăng nhập</h2>
    <form action="<c:url value='/login' />" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">Tên đăng nhập</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Mật khẩu</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        <button type="submit" class="btn btn-login w-100">Đăng nhập</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
