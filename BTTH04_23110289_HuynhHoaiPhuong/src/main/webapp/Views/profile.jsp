<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="card shadow-sm p-4">
            <h2 class="mb-3 text-center">Cập nhật thông tin cá nhân</h2>

            <form action="${pageContext.request.contextPath}/profile" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="fullname" class="form-label">Họ tên</label>
                    <input type="text" name="fullname" id="fullname" class="form-control" value="${user.fullname}" required>
                </div>

                <div class="mb-3">
                    <label for="phone" class="form-label">Số điện thoại</label>
                    <input type="text" name="phone" id="phone" class="form-control" value="${user.phone}">
                </div>

                <div class="mb-3">
                    <label for="image" class="form-label">Ảnh đại diện</label>
                    <input type="file" name="image" id="image" class="form-control">
                    <c:if test="${not empty sessionScope.loggedUserImageBase64}">
                        <div class="mt-2 text-center">
                            <img src="data:image/png;base64,${sessionScope.loggedUserImageBase64}" 
                                 class="img-thumbnail" width="150"/>
                        </div>
                    </c:if>
                </div>

                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-success me-2">Lưu</button>
                    <a href="${pageContext.request.contextPath}/home" class="btn btn-secondary">Hủy</a>
                </div>
            </form>
        </div>
    </div>
</div>
