<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="card shadow-sm p-4">
            <h2 class="mb-3 text-center">Chào mừng, ${sessionScope.loggedUser.fullname}!</h2>

            <ul class="list-group list-group-flush mb-3">
                <li class="list-group-item"><strong>Username:</strong> ${sessionScope.loggedUser.username}</li>
                <li class="list-group-item"><strong>Phone:</strong> ${sessionScope.loggedUser.phone}</li>
                <c:if test="${not empty sessionScope.loggedUserImageBase64}">
                    <li class="list-group-item text-center">
                        <img src="data:image/png;base64,${sessionScope.loggedUserImageBase64}" 
                             alt="User Image" width="150" class="img-thumbnail"/>
                    </li>
                </c:if>
            </ul>

            <div class="d-flex justify-content-center">
                <a href="${pageContext.request.contextPath}/profile" class="btn btn-primary me-2">Profile</a>
                <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">Logout</a>
            </div>
        </div>
    </div>
</div>
