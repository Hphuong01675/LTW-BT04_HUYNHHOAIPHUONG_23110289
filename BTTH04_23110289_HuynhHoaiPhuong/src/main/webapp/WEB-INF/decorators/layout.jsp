<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><sitemesh:write property="title"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">MyApp</a>
        <div class="d-flex">
            <a href="${pageContext.request.contextPath}/profile" class="text-white me-2">Profile</a>
            <a href="${pageContext.request.contextPath}/logout" class="text-white">Logout</a>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <sitemesh:write property="body"/>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center py-3 mt-5">
    <div class="container">
        <p class="mb-0">&copy; 2025 MyApp - All Rights Reserved</p>
    </div>
</footer>
</body>
</html>
