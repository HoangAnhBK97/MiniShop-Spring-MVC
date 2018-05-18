package com.hoanganhbk.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hoanganhbk.entity.ChiTietHoaDon;
import com.hoanganhbk.entity.ChiTietHoaDonId;
import com.hoanganhbk.entity.GioHang;
import com.hoanganhbk.entity.HoaDon;
import com.hoanganhbk.service.ChiTietHoaDonService;
import com.hoanganhbk.service.HoaDonService;

@Controller
@SessionAttributes("giohang")
public class GioHangController {
	@Autowired
	HoaDonService hoaDonService;
	
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;
	
	@GetMapping("giohang")
	public String Default(HttpSession httpSession, ModelMap modelMap) {
		if(httpSession.getAttribute("giohang") != null) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("listGioHang", listGioHang);
			modelMap.addAttribute("soluongsanpham", listGioHang.size());
		}
		
		return "giohang";
	}
	@PostMapping("giohang")
	public String ThemHoaDon(HttpSession httpSession, @RequestParam String tenKhachHang, @RequestParam String soDienThoai, @RequestParam String diaChiGiaoHang, 
			@RequestParam String hinhThucGiaoHang, @RequestParam String ghiChu) {
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("giohang");
			
			HoaDon hoaDon = new HoaDon();
			hoaDon.setTenkhachhang(tenKhachHang);
			hoaDon.setSodienthoai(soDienThoai);
			hoaDon.setDiachigiaohang(diaChiGiaoHang);
			hoaDon.setHinhthucgiaohang(hinhThucGiaoHang);
			hoaDon.setGhichu(ghiChu);
			int idHoaDon = hoaDonService.ThemHoaDon(hoaDon);
			if(idHoaDon > 0) {
				Set<ChiTietHoaDon> listChiTietHoaDon = new HashSet<ChiTietHoaDon>();
				for(GioHang gioHang : listGioHang) {
					ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
					chiTietHoaDonId.setIdchitietsanpham(gioHang.getIdChiTiet());
					chiTietHoaDonId.setIdhoadon(hoaDon.getIdhoadon());
					
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setChitiethoadonid(chiTietHoaDonId);
					chiTietHoaDon.setGiatien(gioHang.getGiaSanPham());
					chiTietHoaDon.setSoluong(gioHang.getSoLuongSanPham());
					chiTietHoaDonService.ThemChiTietHoaDon(chiTietHoaDon);
				}
			} else {
				System.out.println("Thêm Thất Bại");
			}
		}
		
		return null;
	}
}
