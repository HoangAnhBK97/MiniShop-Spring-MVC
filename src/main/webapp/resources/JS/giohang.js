$(document).ready(function(){
	var bag = [];
	$('tbody td:nth-child(4)').each(function(){
			  var a = $(this).text();
			  $(this).text(a.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") + " VNĐ")
	})
	var tinhTongTien = function() {
		var bag = [];
		$('tbody td:nth-child(4)').each(function(){
			  var a = $(this).text();
			  var b = a.split(" ")[0].split(",").join("");
			  bag.push(b);
			});
			var total = 0;
			 for(i = 0; i<bag.length; i ++){
			   total += parseInt(bag[i]);
			 }
			 return total;
	}
	var tongTien = tinhTongTien();
	$("#tongTien").text(tongTien.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") + " VNĐ");
	
	$(".soLuongSanPham").change(function(){
		var giaSanPham = $(this).closest("tr").find(".giaSanPham").attr("data-price");
		var soLuong = $(this).find(".count").val();
		giaSanPham = giaSanPham.split(" ")[0];
		giaSanPham = giaSanPham*soLuong;
		$(this).parent().find(".giaSanPham").text(giaSanPham.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") + " VNĐ");
		//alert(giaSanPham + "-" + soLuong);
		tongTien = tinhTongTien();
		tongTien = tongTien.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
		$("#tongTien").text(tongTien+ " VNĐ");
		var idSanPham =  $(this).closest("tr").find(".tenSanPham").attr("data-id");
		var sizeSanPham = $(this).closest("tr").find(".sizeSanPham").attr("data-size");
		idSanPham = parseInt(idSanPham);
		$.ajax({
			url: "http://localhost:8080/MiniShop/api/UpdateGioHang",
			type: "GET",
			data: {
				soLuong: soLuong,
				idSanPham: idSanPham,
				sizeSanPham: sizeSanPham,
				giaSanPham: giaSanPham
			},
			success: function(value){
				
			}
		});
	});
	$(".btn-delete").click(function(){
		$(this).closest("tr").remove();
		var idSanPham =  $(this).closest("tr").find(".tenSanPham").attr("data-id");
		var sizeSanPham = $(this).closest("tr").find(".sizeSanPham").attr("data-size");
		$.ajax({
			url: "http://localhost:8080/MiniShop/api/XoaSanPham",
			type: "GET",
			data: {
				idSanPham: idSanPham,
				sizeSanPham: sizeSanPham,
			},
			success: function(value){
				
			}
		});
		var tongTien = tinhTongTien();
		$("#tongTien").text(tongTien.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") + " VNĐ");
	});
});