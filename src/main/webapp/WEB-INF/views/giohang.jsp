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
	h3{
		font-weight: bold;
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
		          		<li><a href="sanpham/${danhmuc.getIddanhmucsanpham() }">${danhmuc.getTendanhmuc() }</a></li>
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
	      		 	<c:when test="${soluongsanpham != 0 && soluongsanpham != null }">
			         	<li><a href="#"><span class="glyphicon glyphicon-shopping-cart" style="font-size:18px;"><span id="soluong" style="color:red; padding-left:5px;">${soluongsanpham }-SP</span></span></a></li>
		      		 </c:when>
		      		 <c:otherwise>
		      		 	<li><a href="#"><span class="glyphicon glyphicon-shopping-cart" style="font-size:18px;"><span id="soluong" style="color:red; padding-left:5px;"></span></span></a></li>
		      		 </c:otherwise>
	      		 </c:choose>
		      </ul>
		    </div>
		  </div>
		</nav>
	</div>
	
	<c:choose>
		<c:when test="${listGioHang != null && listGioHang.size() >0}">
			<div class="container" style="margin-top: 10px;">
				<div class="row">
					<div class="col-sm-6">
						<h3>Danh sách sản phẩm trong giỏ hàng</h3><hr/>
						<table id="giohang" class="table table-condensed">
						    <thead>
						      <tr>
						        <th>Tên sản phẩm</th>
						        <th>Size</th>
						        <th>Số lượng</th>
						        <th>Giá tiền</th>
						      </tr>
						    </thead>
						    <tbody>
				    		  <c:forEach var="sanpham" items="${listGioHang }">
				    		  	<tr data-id="${sanpham.getIdChiTiet() }">
							        <td class="tenSanPham" data-id="${sanpham.getIdSanPham() }">${sanpham.getTenSanPham() }</td>
							        <td class="sizeSanPham" data-size="${sanpham.getSizeSanPham() }">${sanpham.getSizeSanPham() }</td>
							        <td class="soLuongSanPham" data-count="${sanpham.getSoLuongSanPham() }"><input class="count" type="number" min="1" value="${sanpham.getSoLuongSanPham() }"/></td>
							        <td class="giaSanPham" data-price="${sanpham.getGiaSanPham() }">${sanpham.getGiaSanPham()}</td>
							        <td><button class="btn btn-danger btn-delete">Xóa</button></td>
							      </tr>
				    		  </c:forEach>
						    </tbody>
						  </table>
						  <h3>Tổng tiền : <span id="tongTien" style="color:red;">1500000 VNĐ</span></h3>
					 </div>  
					 <div class="col-sm-6">
						<h3>Thông tin người nhận/mua</h3>
						<form action="" method="post">
						  <div class="form-group">
						    <label for="tennguoimua">Tên người mua/nhận :</label>
						    <input type="text" class="form-control" id="tennguoimua" name="tenKhachHang">
						  </div>
						  <div class="form-group">
						    <label for="dienthoai">Điện thoại liên lạc :</label>
						    <input type="text" class="form-control" id="dienthoai" name="soDienThoai">
						  </div>
						  <div class="radio">
							  <label><input type="radio" checked="" name="hinhThucGiaoHang" value="Giao hàng tận nơi">Giao hàng tận nơi</label>
							</div>
							<div class="radio">
							  <label><input type="radio" name="hinhThucGiaoHang" value="Thanh toán trực tuyến">Thanh toán trực tuyến</label>
							</div>
						   <div class="form-group">
						    <label for="diachi">Địa chỉ giao hàng :</label>
						    <input type="text" class="form-control" id="diachi" name="diaChiGiaoHang">
						  </div>
						  <div class="form-group">
							  <label for="ghichu">Ghi chú :</label>
							  <textarea class="form-control" rows="5" id="ghichu" name="ghiChu"></textarea>
							</div>
						  <button type="submit" class="btn btn-primary">Đặt hàng</button>
						</form>
					 </div>
				</div>
			</div>	
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning">
			  <strong>Thông Báo : </strong> Không có sản phẩm nào trong giỏ hàng
			</div>
		</c:otherwise>
	</c:choose>
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
				<button id="btn-send">Gửi</button>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src='<c:url value="/resources/JS/giohang.js"/>'></script>
</body>
</html>