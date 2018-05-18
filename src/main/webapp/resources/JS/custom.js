$(document).ready(function(){
//	$("#btnDangNhap").click(function(){
//		var username = $("#username").val();
//		var password = $("#password").val();
//		$.ajax({
//			url:"http://localhost:8080/MiniShop/api/KiemTraDangNhap",
//			type:"GET",
//			data:{
//				username:username,
//				password:password
//			},
//			success: function(value) {
//				if(value == "true") {
//					$("#ketqua").text("Đăng nhập thành công.");
//					duongdan = window.location.href;
//					duongdan = duongdan.replace("/login", "")
//					window.location.href = duongdan
//				} else {
//					$("#ketqua").text("Đăng nhập thất bại.");
//				}
//			}
//		});
//	});
	$("#login").click(function(){
		$(".container-signup-form").hide();
		$(".container-login-form").show();
		$("#login").addClass("actived");
		$("#signup").removeClass("actived");
	});
	$("#signup").click(function(){
		$(".container-signup-form").show();
		$(".container-login-form").hide();
		$("#login").removeClass("actived");
		$("#signup").addClass("actived");
	});
	
	$(".btn-mua").click(function(){
		var idChiTiet = $(this).attr("data-idChiTiet");
		var tenSanPham = $(".tenSanPham").text();
		var giaSanPham = $(".giaSanPham").text();
		var idSanPham = $(this).closest("tr").find(".idSanPham").attr("data-id");
		var sizeSanPham = $(this).closest("tr").find(".sizeSanPham").attr("data-size");
		var soluong = $(this).closest("tr").find(".count").attr("data-count");
		$.ajax({
			url: "http://localhost:8080/MiniShop/api/ThemGioHang",
			type: "GET",
			data: {
				tenSanPham: tenSanPham,
				giaSanPham: giaSanPham,
				idSanPham: idSanPham,
				sizeSanPham: sizeSanPham,
				idChiTiet: idChiTiet
			},
			success: function(value){
				$("#soluong").html(value+"-SP");
			}
		});
	});
	
	$("#search").on("input", function(){
		$("#listsanpham").empty();
		var search_data = $("#search").val();
		$.ajax({
			url: "http://localhost:8080/MiniShop/api/SearchSanPham",
			type: "GET",
			data: {
				search_data: search_data
			},
			success: function(value){
				$("#listsanpham").html(value);
			}
		});
	});
});