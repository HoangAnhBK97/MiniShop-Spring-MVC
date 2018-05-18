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
							<h3>Sửa sản phẩm</h3><br/>
							<form action="" method="post" id="form-sanpham">
								<input type="hidden" class="form-control" id="idsanpham" name="idsanpham" value="${sanPham.getIdsanpham() }"/>
							  <div class="form-group">
							    <label for="tensanpham">Tên sản phẩm :</label>
							    <input type="text" class="form-control" id="tensanpham" name="tensanpham" value="${sanPham.getTensanpham() }"/>
							  </div>
							  <div class="form-group">
							    <label for="giatien">Giá tiền :</label>
							    <input type="number" class="form-control" id="giatien" name="giatien" value="${sanPham.getGiatien() }">
							  </div>
							  <div class="form-group">
								  <label for="mota">Mô tả :</label>
								  <textarea class="form-control" rows="5" id="mota" name="mota">${sanPham.getMota() }</textarea>
							  </div>
							  <div class="form-group">
								  <label for="danhmuc">Danh mục :</label>
								  <select class="form-control" id="danhmuc" name="danhmuc">
								  	<c:forEach var="danhmuc" items="${listDanhMuc }">
								  		<c:choose>
								  			<c:when test="${sanPham.getDanhmucsanpham().getIddanhmucsanpham() == danhmuc.getIddanhmucsanpham() }">
								  				<option value="${danhmuc.getIddanhmucsanpham() }" selected="selected">${danhmuc.getTendanhmuc() }</option>
								  			</c:when>
								  			<c:otherwise>
								  				<option value="${danhmuc.getIddanhmucsanpham() }">${danhmuc.getTendanhmuc() }</option>
								  			</c:otherwise>
								  		</c:choose>
								  		 
								  	</c:forEach>
								  </select>
								</div>
								<div class="form-group">
								    <label for="image">Hình ảnh</label>
								    <input type="file" class="form-control-file" id="image" name="image"/>
								  </div>
								  <h3>Chi tiết sản phẩm</h3><br/>
								 <c:forEach var="chitiet" items="${listChiTietSanPham}">
								 	<div class="form-group">
									  <label for="size">Size sản phẩm :</label>
									  <select class="form-control" id="size" name="size" style="width:80%">
									  	<c:forEach var="size" items="${listSizeSanPham }">
									  		 <c:choose>
									  		 	<c:when test="${size.getSize() == chitiet.getSizesanpham().getSize() }">
									  		 		<option value="${size.getSize() }" selected="selected">${size.getSize() } </option>
									  		 	</c:when>
									  		 	<c:otherwise>
									  		 		<option value="${size.getSize() }">${size.getSize() }</option>
									  		 	</c:otherwise>
									  		 </c:choose>	
									  	</c:forEach>
									  </select>
									</div>
									<div class="form-group">
									    <label for="soluong">Số lượng :</label>
									    <input min="1" type="number" class="form-control" id="soluong" name="soluong" style="width:80%" value="${chitiet.getSoluong() }">
									  </div>
								 </c:forEach>
							</form>
							<button type="submit" class="btn btn-primary" id="btn-them">Update sản phẩm</button>
							
						</div>
						<div class="col-sm-6">
							<h3>Chi tiết sản phẩm</h3><br/>
							<div id="chitiet" class="chitiet">
								<div class="form-group">
								  <label for="size">Size sản phẩm :</label>
								  <select class="form-control" id="size" name="size" style="width:80%">
								  	<c:forEach var="size" items="${listSizeSanPham }">
								  		 <option value="${size.getSize() }">${size.getSize() }</option>
								  	</c:forEach>
								  </select>
								</div>
								<div class="form-group">
								    <label for="soluong">Số lượng :</label>
								    <input min="1" type="number" class="form-control" id="soluong" name="soluong" style="width:80%">
								  </div>
							</div>
							
							  <button id="btn-themchitiet" class="btn btn-primary">Thêm chi tiết</button>
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