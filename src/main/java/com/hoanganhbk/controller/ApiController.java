package com.hoanganhbk.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hoanganhbk.entity.GioHang;
import com.hoanganhbk.entity.SanPham;
import com.hoanganhbk.service.HoaDonService;
import com.hoanganhbk.service.NhanVienService;
import com.hoanganhbk.service.SanPhamService;

@Controller
@RequestMapping("api/")
@SessionAttributes({"username", "giohang"})
public class ApiController {
	@Autowired
	NhanVienService nhanVienService;
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping("KiemTraDangNhap")
	@ResponseBody
	
	public String KiemTraDangNhap(@RequestParam String username,@RequestParam String password, ModelMap modelMap) {
		int kiemTra = nhanVienService.KiemTraDangNhap(username, password);
		if(kiemTra != -1) {
			modelMap.addAttribute("username", username);
		}
		return "" + kiemTra;
	}
	
	@GetMapping("XoaSanPham")
	@ResponseBody
	public void XoaSanPham(HttpSession httpSession, @RequestParam String idSanPham, 
			@RequestParam String sizeSanPham) {
		if(httpSession.getAttribute("giohang") != null) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("giohang");
			int viTri = KiemTraSanPhamTrongGioHang(listGioHang, sizeSanPham, idSanPham);
			GioHang gioHang = listGioHang.remove(viTri);
		}
	}
	
	@GetMapping("UpdateGioHang")
	@ResponseBody
	public String UpdateGioHang(HttpSession httpSession,@RequestParam int soLuong, @RequestParam String idSanPham, 
			@RequestParam String sizeSanPham) {
		if(httpSession.getAttribute("giohang") != null) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("giohang");
			int viTri = KiemTraSanPhamTrongGioHang(listGioHang, sizeSanPham, idSanPham);
			GioHang gioHang = listGioHang.get(viTri);
			gioHang.setSoLuongSanPham(soLuong);
		}
		return "";
	}
	
	@GetMapping("ThemGioHang")
	@ResponseBody
	public String KiemTraGioHang(@RequestParam String tenSanPham, @RequestParam String giaSanPham,
								@RequestParam String idSanPham, @RequestParam String sizeSanPham, @RequestParam int idChiTiet, 
								HttpSession httpSession) {
		if(null == httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHang = new ArrayList<GioHang>();
			GioHang gioHang = new GioHang();
			gioHang.setTenSanPham(tenSanPham);
			gioHang.setGiaSanPham(Integer.parseInt(giaSanPham.split(" ")[0]));
			gioHang.setIdSanPham(idSanPham);
			gioHang.setSizeSanPham(sizeSanPham);
			gioHang.setSoLuongSanPham(1);
			gioHang.setIdChiTiet(idChiTiet);
			listGioHang.add(gioHang);
			httpSession.setAttribute("giohang", listGioHang);
			return listGioHang.size()+"";
		} else {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("giohang");
			int i = KiemTraSanPhamTrongGioHang(listGioHang, sizeSanPham, idSanPham);
			if(i == -1) {
				GioHang gioHang = new GioHang();
				gioHang.setTenSanPham(tenSanPham);
				gioHang.setGiaSanPham(Integer.parseInt(giaSanPham.split(" ")[0]));
				gioHang.setIdSanPham(idSanPham);
				gioHang.setSizeSanPham(sizeSanPham);
				gioHang.setSoLuongSanPham(1);
				gioHang.setIdChiTiet(idChiTiet);
				listGioHang.add(gioHang);
			} else {
				GioHang gioHang = listGioHang.get(i);
				int soluongmoi = gioHang.getSoLuongSanPham()+1;
				gioHang.setSoLuongSanPham(soluongmoi);
			}
			return listGioHang.size()+"";
		}	
	}
	private int KiemTraSanPhamTrongGioHang(List<GioHang> listGioHang, String sizeSanPham, String idSanPham) {
		for(int i = 0; i < listGioHang.size(); i++) {
			if(listGioHang.get(i).getSizeSanPham().equals(sizeSanPham)&& listGioHang.get(i).getIdSanPham().equals(idSanPham)) {
				return i;
			}
		}
		return -1;
	}
	
	@GetMapping(path="LayDanhSachSanPham", produces="text/plain; charset=utf-8")
	@ResponseBody
	public String LayDanhSachSanPham(int spBatDau) {
		List<SanPham> listSanPham = sanPhamService.LayDanhSachSanPham(spBatDau);
		String html = "";
		for(SanPham sanPham : listSanPham) {
			html += "<tr>";
			html += "<th scope=\"row\" class=\"cbSanPham\"><label><input type=\"checkbox\" value=\"\"></label></th>";
			html += "<td>" + sanPham.getTensanpham()+ "</td> ";
			html += "<td>" + sanPham.getGiatien()+ "</td> ";
			html += "<td>" + sanPham.getMota()+ "</td> ";
			html += "<td><a href='"+sanPham.getIdsanpham()+"'><button class='btn btn-primary'>Sửa</button></a></td> ";
			html +="</tr>";
		}
		return html;
	}
	
	@GetMapping("XoaSanPhamTheoId")
	@ResponseBody
	public String XoaSanPham(int idSanPham) {
		boolean kt = sanPhamService.XoaSanPham(idSanPham);
		return ""+kt;
	}
	
	@Autowired
	ServletContext context;
	
	@PostMapping("UploadFile")
	@ResponseBody
	public String UploadFile(MultipartHttpServletRequest request) {
		String path = context.getRealPath("/resources/Image/SanPham/");
		Iterator<String> listNames = request.getFileNames();
		MultipartFile mf = request.getFile(listNames.next());
		
		File fileSave = new File(path + mf.getOriginalFilename());
		try {
			mf.transferTo(fileSave);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(path + "-" +mf.getOriginalFilename());
		return "true";
	}
	@Autowired
	HoaDonService hoaDonService;
	
	@GetMapping("XoaHoaDonTheoId")
	@ResponseBody
	public String XoaHoaDonTheoId(int idHoaDon) {
		boolean kt = hoaDonService.XoaHoaDonTheoId(idHoaDon);
		return ""+kt;
	}
	
	@GetMapping(path="SearchSanPham", produces="text/plain; charset=utf-8")
	@ResponseBody
	public String SearchSanPham(String search_data) {
		List<SanPham> listSanPham = sanPhamService.SearchSanPhamTheoTen(search_data);
		String html = "";
		if(listSanPham.size() > 0) {
			for(SanPham sanPham : listSanPham) {
				html += "<div class=\"col-sm-3\">";
				html += "<a href='chitiet/"+sanPham.getIdsanpham()+"'>";	
				html += "<div class=\"motsanpham\" style=\"width:259px; height:415px; margin-bottom:10px;\">";
				html += "<img class=\"img-responsive\" src='/MiniShop/resources/Image/SanPham/"+sanPham.getHinhsanpham()+"'alt=\"sản phẩm\"/>";
				html += "<span class=\"tensanpham\" style=\"font-size:26px;\">"+sanPham.getTensanpham()+"</span><br/>";
				html += "<span class=\"giasanpham\">"+sanPham.getGiatien()+" VNĐ</span><br/>";
				html += "<button type=\"button\" class=\"btn btn-primary\">Xem chi tiết</button>";
				html += "</div>";
				html += "</a></div>";
			}
		} else {
			html = "Không tìm thấy sản phầm nào";
		}
		
		return html;
	}
	
}
