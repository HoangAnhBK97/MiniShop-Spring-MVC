<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Đăng Nhập</title>
<jsp:include page="header.jsp"></jsp:include>
<style>
	#login, #signup :hover{
		{cursor: pointer;}
	}
</style>
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-top-left" class="header-login">
					<span id="text-logo">Welcome</span><br/>
					<span id="hint-text-logo">Hãy tạo nên phong cách cùng BK Shop</span>
				</div>
				<div id="header-bottom-left">
					<p><i class="fas fa-dot-circle"></i><span>Luôn cập nhật xu hướng thời trang mới nhất</span></p>
					<p><i class="fas fa-dot-circle"></i><span>Giảm 50% tất cả các mặt hàng dành cho khách VIP</span></p>
					<p><i class="fas fa-dot-circle"></i><span>Tận tình tư vấn để tạo nên phong cách của bạn</span></p>
				</div>
			</div>
			<div id="container-login-right">
				<div id="header-top-right" class="header-login">
					<span class="actived" id="login" style="cursor:pointer">Đăng Nhập</span> / <span id="signup" style="cursor:pointer">Đăng Ký</span>
				</div>
				<c:if test="${thanhcong != null }">
					<div class="alert alert-success">
					  <strong>${thanhcong }</strong>
					</div>
				</c:if>
				<c:if test="${thatbai != null }">
					<div class="alert alert-danger">
					  <strong>${thatbai }</strong> 
					</div>
				</c:if>
				<div class="container-login-form" id="container-center-login">
					<form action="login" method="post">
						<input id="username" type="text" placeholder="Tên Đăng Nhập" name="username" class="material-text-input input-icon-email" style="width:100%;"/> <br/>
						<input id="password" type="password" placeholder="Mật Khẩu" name="password" class="material-text-input input-icon-password" style="width:100%; margin-top: 8px;"/> <br/>
						<input id="btnDangNhap" type="submit" value="ĐĂNG NHẬP" class="material-text-button"/> <br/>
					</form>
				</div>
				<div class="container-signup-form" id="container-center-login" style="display:none;">
					<form action="dangky" method="post">
						<input id="email" type="email" placeholder="Email" name="email" class="material-text-input input-icon-email" style="width:100%;"/> <br/>
						<input id="username" type="text" placeholder="Tên Đăng Nhập" name="username" class="material-text-input input-icon-email" style="width:100%;"/> <br/>
						<input id="password" type="password" placeholder="Mật Khẩu" name="password" class="material-text-input input-icon-password" style="width:100%; margin-top: 8px;"/> <br/>
						<input id="re-password" type="password" placeholder="Nhập lại mật Khẩu" name="repassword" class="material-text-input input-icon-password" style="width:100%; margin-top: 8px;"/> <br/>
						<input id="btnDangNhap" type="submit" value="ĐĂNG KÝ" class="material-text-button"/> <br/>
					</form>
				</div>
				<div id="container-social-login">
					<span><i class="fab fa-facebook-square fa-3x"></i></span>
					<span><i class="fab fa-google-plus-square fa-3x"></i></span>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>