<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Trang Quản Trị</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<!-- Bootstrap Core CSS -->
<link href='<c:url value="/resources/Admin/css/bootstrap.css"/>' rel='stylesheet' type='text/css' />

<!-- Custom CSS -->
<link href='<c:url value="/resources/Admin/css/style.css"/>' rel='stylesheet' type='text/css' />

<!-- font-awesome icons CSS -->
<link href='<c:url value="/resources/Admin/css/font-awesome.css"/>' rel="stylesheet"> 
<!-- //font-awesome icons CSS-->

<!-- side nav css file -->
<link href='<c:url value="/resources/Admin/css/SidebarNav.min.css"/>' media='all' rel='stylesheet' type='text/css'/>
<!-- //side nav css file -->
 
 <!-- js-->
<script src='<c:url value="/resources/Admin/js/jquery-1.11.1.min.js" /> '></script>
<script src='<c:url value="/resources/Admin/js/modernizr.custom.js"/>'></script>

<!--webfonts-->
<link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">
<!--//webfonts--> 

<!-- chart -->
<script src='<c:url value="/resources/Admin/js/Chart.js"/>' ></script>
<!-- //chart -->

<!-- Metis Menu -->
<script src='<c:url value="/resources/Admin/js/metisMenu.min.js" />'></script>
<script src='<c:url value="/resources/Admin/js/custom.js"/>'></script>
<link href='<c:url value="/resources/Admin/css/custom.css"/>' rel="stylesheet">
<!--//Metis Menu -->
<style>
body{
	width: 102%;
}
#chartdiv {
  width: 100%;
  height: 295px;
}
</style>
<!--pie-chart --><!-- index page sales reviews visitors pie chart -->
<script src="js/pie-chart.js" type="text/javascript"></script>
 

	<!-- requried-jsfiles-for owl -->
	<link href="css/owl.carousel.css" rel="stylesheet">
	<script src="js/owl.carousel.js"></script>
</head> 
<body class="cbp-spmenu-push">
	<div class="main-content">
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<jsp:include page="admin-nav.jsp"></jsp:include>
			<div class="header-right">
				
				<div class="profile_details">		
					<ul>
						<li class="dropdown profile_details_drop">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<div class="profile_img">	
									<span class="prfil-img"><img src="images/2.jpg" alt=""> </span> 
									<div class="user-name">
										<p>Admin Name</p>
										<span>Administrator</span>
									</div>
									<i class="fa fa-angle-down lnr"></i>
									<i class="fa fa-angle-up lnr"></i>
									<div class="clearfix"></div>	
								</div>	
							</a>
							<ul class="dropdown-menu drp-mnu">
								<li> <a href="#"><i class="fa fa-sign-out"></i> Logout</a> </li>
							</ul>
						</li>
					</ul>
				</div>
			
			</div>
		</div>
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				<div class="container">
					<div class="row">
						<div class="col-sm-6">
							<h3>Chi tiết hóa đơn</h3><br/>
							<form action="" method="post" id="form-hoadon">
								<input type="hidden" class="form-control" id="idsanpham" name="idsanpham" value="${hoaDon.getIdhoadon() }"/>
							  <div class="form-group">
							    <label for="tenkhachhang">Tên khách hàng :</label>
							    <input type="text" class="form-control" id="tenkhachhang" name="tenkhachhang" value="${hoaDon.getTenkhachhang() }"/>
							  </div>
							  <div class="form-group">
							    <label for="dienthoai">Số điện thoại :</label>
							    <input type="number" class="form-control" id="dienthoai" name="dienthoai" value="${hoaDon.getSodienthoai() }">
							  </div>
							  <div class="form-group">
								  <label for="mota">Địa chỉ giao hàng :</label>
								  <textarea class="form-control" rows="5" id="mota" name="mota">${hoaDon.getDiachigiaohang() }</textarea>
							  </div>
							  <div class="radio">
							  	  <c:choose>
							  	  	<c:when test="${hoaDon.isTinhtrang() != false}">
								  		<label><input type="radio" name="tinhtrang" value="0">Chưa giao hàng</label>
								  		<label><input type="radio" name="tinhtrang" value="1" checked="checked">Đã giao hàng</label>
							  	  	</c:when>
							  	  	<c:otherwise>
							  	  		<label><input type="radio" name="tinhtrang" value="0"  checked="checked">Chưa giao hàng</label>
							  	  		<label><input type="radio" name="tinhtrang" value="1">Đã giao hàng</label>
							  	  	</c:otherwise>
							  	  </c:choose>
								  
								</div>
								
							</form>
		
							
						</div>
						<div class="col-sm-6">
							<h3>Danh sách sản phẩm</h3><br/>
							<table class="table table-bordered" style="width: 90%;">
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
							      	<tr>
								        <td>${sanpham.getTenSanPham()}</td>
								        <td>${sanpham.getSizeSanPham()}</td>
								        <td>${sanpham.getSoLuongSanPham()}</td>
								        <td class="giatien">${sanpham.getGiaSanPham() }</td>
								      </tr>
							      </c:forEach>
							    </tbody>
							  </table>
							  <h3>Tổng tiền : <span id="tongtien" style="color:red;"></span></h3>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	
	<!--footer-->
	<div class="footer">
	   <p>&copy; Viện Điện Tử Viễn Thông 2018 </p>		
	</div>
    <!--//footer-->
	</div>
		
	<!-- new added graphs chart js-->
	
    <script src='<c:url value="/resources/Admin/js/Chart.bundle.js" />'></script>
    <script src='<c:url value="/resources/Admin/js/utils.js" />'></script>
	
	<!-- Classie --><!-- for toggle left push menu script -->
		<script src="js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			

			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
	<!-- //Classie --><!-- //for toggle left push menu script -->
		
	<!--scrolling js-->
	<script src='<c:url value="/resources/Admin/js/jquery.nicescroll.js" />'></script>
	<script src='<c:url value="/resources/Admin/js/scripts.js" />'></script>
	<!--//scrolling js-->
	
	<!-- side nav js -->
	<script src='<c:url value="/resources/Admin/js/SidebarNav.min.js"/>' type='text/javascript'></script>
	<script>
      $('.sidebar-menu').SidebarNav()
    </script>
	<!-- //side nav js -->
	
	<!-- //for index page weekly sales java script -->
	
	
	<!-- Bootstrap Core JavaScript -->
   <script src='<c:url value="/resources/Admin/js/bootstrap.js" />'> </script>
	<!-- //Bootstrap Core JavaScript -->
	<script src='<c:url value="/resources/JS/trangsanpham.js"/>' type='text/javascript'></script>
</body>
</html>