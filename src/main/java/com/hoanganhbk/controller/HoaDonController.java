package com.hoanganhbk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoanganhbk.entity.ChiTietHoaDon;
import com.hoanganhbk.entity.ChiTietHoaDonId;
import com.hoanganhbk.entity.ChiTietSanPham;
import com.hoanganhbk.entity.GioHang;
import com.hoanganhbk.entity.HoaDon;
import com.hoanganhbk.entity.SanPham;
import com.hoanganhbk.service.ChiTietHoaDonService;
import com.hoanganhbk.service.ChiTietSanPhamService;
import com.hoanganhbk.service.HoaDonService;

@Controller
@RequestMapping("/admin/hoadon")
public class HoaDonController {
	@Autowired
	HoaDonService hoaDonService;
	
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;
	
	@Autowired
	ChiTietSanPhamService chiTietSanPhamService; 
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<HoaDon> listHoaDon = hoaDonService.LayDanhSachHoaDon();
		modelMap.addAttribute("listHoaDon", listHoaDon);
		modelMap.addAttribute("tongSoPage", listHoaDon.size());
		return "quanlyhoadon";
	}
	
	@GetMapping("/{id}")
	public String SuaHoaDon(@PathVariable("id") int id, ModelMap modelMap) {
		HoaDon hoaDon = hoaDonService.LayHoaDonTheoId(id);
		List<ChiTietHoaDon> setChiTietHoaDon = chiTietHoaDonService.LayChiTietHoaDonTheoId(hoaDon.getIdhoadon());
		List<GioHang> listGioHang = new ArrayList<GioHang>();
		for(ChiTietHoaDon chiTietHoaDon : setChiTietHoaDon) {
			ChiTietHoaDonId chiTietHoaDonId = chiTietHoaDon.getChitiethoadonid();
			int idChiTietSanPham = chiTietHoaDonId.getIdchitietsanpham();
			ChiTietSanPham chiTietSanPham = chiTietSanPhamService.LayChiTietSanPhamTheoId(idChiTietSanPham);
			SanPham sanPham = chiTietSanPham.getSanpham();
			GioHang gioHang = new GioHang();
			gioHang.setTenSanPham(sanPham.getTensanpham());
			gioHang.setGiaSanPham(Integer.parseInt(sanPham.getGiatien()));
			gioHang.setSizeSanPham(chiTietSanPham.getSizesanpham().getSize());
			gioHang.setSoLuongSanPham(chiTietHoaDon.getSoluong());
			listGioHang.add(gioHang);
		}
		modelMap.addAttribute("hoaDon", hoaDon);
		modelMap.addAttribute("listGioHang", listGioHang);
		return "edithoadon";
	}
}
