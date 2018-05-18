package com.hoanganhbk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hoanganhbk.entity.DanhMucSanPham;
import com.hoanganhbk.entity.GioHang;
import com.hoanganhbk.entity.SanPham;
import com.hoanganhbk.service.DanhMucService;
import com.hoanganhbk.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes("giohang")
public class ChiTietController {
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	@GetMapping("/{id}")
	public String Default(@PathVariable int id, ModelMap modelMap, HttpSession httpSession){
		SanPham sanPham = sanPhamService.LaySanPhamTheoId(id);
		List<DanhMucSanPham> danhSachDanhMuc = danhMucService.LayDanhMuc();
		if(httpSession.getAttribute("giohang") != null) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanpham", listGioHang.size());
		}
		modelMap.addAttribute("sanPham", sanPham);
		modelMap.addAttribute("danhSachDanhMuc", danhSachDanhMuc);
		return "chitiet";
	}
}
