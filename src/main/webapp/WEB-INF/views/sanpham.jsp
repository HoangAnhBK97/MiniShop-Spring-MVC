<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Real Madrid Shop</title>
<jsp:include page="header.jsp" />
<style type="text/css">
	div#info-footer {
		margin-top: 42px;
		width:102%;
		color: white;
		background-color: black;
		padding: 38px;
		background: linear-gradient(
	      rgba(0, 0, 0, 0.40), 
	      rgba(0, 0, 0, 0.40)
	    ), url("/MiniShop/resources/Image/Real-Madrid-Twitter-header-05.jpg") no-repeat center center;
	    background-size: 100% 100%;
	}
	
	#info-footer p{
		text-align: center;
	}
	#info-footer button{
		width: 100%;
		background-color: #1cad46;
    	border: 1px solid gray;
	}
	
	.span-footer{
		font-size: 32px;
	}	
	#info-footer input{
		width: 100%;
    	background-color: #EAEAEA;
    	margin-bottom: 8px;
	}
	#info-footer textarea{
		width: 100%;
    	background-color: #EAEAEA;
    	margin-bottom: 8px;
	}
</style>
</head>
<body>
	<div class="container-fluid" style="background-color: black; width:102%;">
		<nav class="navbar navbar-default none-nav">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>                        
		      </button>
		      <a class="navbar-brand" href="/MiniShop/"><span id="logo">Real Madrid</span></a>
		    </div>
		    <div class="collapse navbar-collapse" id="myNavbar">
		      <ul class="nav navbar-nav nav-center">
		        <li><a href="/MiniShop/">TRANG CHỦ</a></li>
		        <li class="dropdown">
		          <a class="dropdown-toggle" data-toggle="dropdown" href="#">SẢN PHẨM <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		          	<c:forEach var="danhmuc" items="${danhSachDanhMuc }">
		          		<li><a href="/MiniShop/sanpham/${danhmuc.getIddanhmucsanpham() }">${danhmuc.getTendanhmuc() }</a></li>
		          	</c:forEach>
		          </ul>
		        </li>
		        <li><a href="#">DỊCH VỤ</a></li>
		        <li><a href="#">LIÊN HỆ</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		      <c:choose>
		      	<c:when test="${username != null }">
		      		<li><a><span class="glyphicon glyphicon-user"></span> <span>Hi,</span>  ${username }</a></li>
		      		<li><a href="dangky"><span class="glyphicon glyphicon-log-out"></span>THOÁT</a></li>
		      	</c:when>
		      	<c:otherwise>
			        <li><a href="#"><span class="glyphicon glyphicon-user"></span> ĐĂNG KÝ</a></li>
			        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> ĐĂNG NHẬP</a></li>
		        </c:otherwise>
		      </c:choose>
	      		 <c:choose>
	      		 	<c:when test="${soluongsanpham != null && soluongsanpham >0 }">
			         	<li><a href="/MiniShop/giohang"><span class="glyphicon glyphicon-shopping-cart" style="font-size:18px;"><span id="soluong" style="color:red; padding-left:5px;">${soluongsanpham }-SP</span></span></a></li>
		      		 </c:when>
		      		 <c:otherwise>
		      		 	<li><a href="/MiniShop/giohang"><span class="glyphicon glyphicon-shopping-cart" style="font-size:18px;"><span id="soluong" style="color:red; padding-left:5px;"></span></span></a></li>
		      		 </c:otherwise>
	      		 </c:choose>
		      </ul>
		    </div>
		  </div>
		</nav>
	</div>
	<div class="container-fluid" style="margin-top: 10px;">
		<div class="row">
			<div class="col-sm-2">
				<h3>Danh Mục</h3>
				<ul class="list-group">
					<c:forEach var="danhmuc" items="${danhSachDanhMuc }">
						<li class="list-group-item list-group-item-info"><a href="/MiniShop/sanpham/${danhmuc.getIddanhmucsanpham() }">${danhmuc.getTendanhmuc() }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-sm-10">
				<div class="well well-sm" style="margin-left:20px; color:red; font-family:Monospace; font-weight: bold;">${tenDanhMuc }</div>
				<!--  <div class="container">-->
					<!-- <div class="row"> -->
					<c:forEach var="sanpham" items="${sanPhamTheoDanhMuc}">
						<div class="col-sm-3 wow zoomIn">
							<a href="/MiniShop/chitiet/${sanpham.getIdsanpham() }">
								<div class="motsanpham" style="width:259px; height:415px; margin-bottom:10px;">
									<img class="img-responsive" src='<c:url value="/resources/Image/SanPham/${sanpham.getHinhsanpham() }" />'alt="sản phẩm"/>
									<span class="tensanpham" style="font-size:26px;">${sanpham.getTensanpham() }</span><br/>
									<span class="giasanpham">${sanpham.getGiatien() } VNĐ</span><br/>
									<button type="button" class="btn btn-primary">Xem chi tiết</button>
								</div>
							</a>
						</div>
					</c:forEach>
				<!-- </div> -->
				<!-- </div> -->
			</div>
				
		</div>
	</div>
	
	<div id="info-footer" class="container-fluid" style="padding-bottom: 95px;">
		<div class="row">
			<div class="col-sm-4 wow tada">
				<p><span class="span-footer">THÔNG TIN SHOP</span></p>
				<span>Real Madrid Shop là cửa hàng chuyên cung cấp đồ lưu niệm, áo đấu của CLB Real Madird</span>
			</div>
			<div class="col-sm-4 wow tada">
				<p><span class="span-footer">LIÊN HỆ</span><p>
				<span>Viện Điện Tử Viễn Thông - ĐHBKHN</span><br/>
				<span>team@sis.hust.edu.vn</span><br/>
				<span>0964413059</span>
			</div>
			<div class="col-sm-4 wow tada">
				<p><span class="span-footer">GÓP Ý</span></p>
				<input type="text" placeholder="Email"/>
				<textarea rows=5 cols=40 placeholder="Nội Dung"></textarea>
				<button>Gửi</button>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>