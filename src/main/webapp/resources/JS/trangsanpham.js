$(document).ready(function(){
	$(".item-paging").click(function(){
		$(".item-paging").removeClass("active");
		$(this).addClass("active");
		var soTrang = $(this).text()
		var spBatDau = (soTrang-1) * 7;
		$.ajax({
			url: "http://localhost:8080/MiniShop/api/LayDanhSachSanPham",
			type: "GET",
			data: {
				spBatDau: spBatDau
			},
			success: function(value){
				var tbody = $("#table-sanpham").children("tbody");
				tbody.empty();
				tbody.append(value);
			}
		});
	});
	$('#checkAll').on('click',function(){
	    if( $('#checkAll').is(':checked') == true ){
	       $('tbody tr th input').prop('checked', true);
	   }else{  
	       $('tbody tr th input').prop('checked', false);
	   }
	});
	
	$("#btn-delete").click(function(){
		$(".cbSanPham:checked").each(function(){
			$(this).closest("tr").remove();
			var idSanPham = $(this).val();
			alert(idSanPha)
			$.ajax({
				url: "http://localhost:8080/MiniShop/api/XoaSanPhamTheoId",
				type: "GET",
				data: {
					idSanPham: idSanPham
				},
				success: function(value){
					
				}
			});
		})
	});
	var files = []
	$("#image").change(function(event){
		files = event.target.files;
		forms = new FormData();
		forms.append("file", files[0]);
		$.ajax({
			url: "http://localhost:8080/MiniShop/api/UploadFile",
			type: "POST",
			data: forms,
			contentType: false,
			processData: false,
			enctype: "multipart/form-data",
			success: function(value){
				
			}
		});
	});
	
	$("#btn-themchitiet").click(function(){
		var soluong =$("#soluong").val();
		var size = $("#size").val()
//		$("#chitietsanpham").show();
//		$("<tr><td>"+size+"</td><td>"+soluong+"</td><td><a href='#'>Xóa</a></td></tr>").appendTo("#table-chitiet tbody")
//        $("#table-chitiet tbody tr td:nth-child(3) a").addClass("delete");
		$("#chitiet").clone().appendTo($("form"))
		
	});
	$("#table-chitiet tbody").on("click",".delete",function(){
	    $(this).closest("tr").remove();
	  })
	$("#btn-them").click(function(){
		$("#form-sanpham").submit();
	});
	var tongtien = 0;
	$(".giatien").each(function(){
		tongtien += parseInt($(this).text())
	})
	$("#tongtien").text(tongtien.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") + " VNĐ");
	
	$("#btn-delete-2").click(function(){
		$(".cbHoaDon:checked").each(function(){
			$(this).closest("tr").remove();
			var idHoaDon = $(this).val();
			$.ajax({
				url: "http://localhost:8080/MiniShop/api/XoaHoaDonTheoId",
				type: "GET",
				data: {
					idHoaDon: idHoaDon
				},
				success: function(value){
					
				}
			});
		})
	});
	
	
});