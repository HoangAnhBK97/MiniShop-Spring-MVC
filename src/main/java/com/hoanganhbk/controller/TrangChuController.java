package com.hoanganhbk.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hoanganhbk.entity.DanhMucSanPham;
import com.hoanganhbk.entity.GioHang;
import com.hoanganhbk.entity.SanPham;
import com.hoanganhbk.service.DanhMucService;
import com.hoanganhbk.service.SanPhamService;

@Controller
@RequestMapping("/")
@SessionAttributes("giohang")
public class TrangChuController {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap, HttpSession httpSession) {
		List<SanPham> listSanPham = sanPhamService.LayDanhSachSanPham(0);
		List<DanhMucSanPham> danhSachDanhMuc = danhMucService.LayDanhMuc();
		if(httpSession.getAttribute("giohang") != null) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanpham", listGioHang.size());
		}
		
		modelMap.addAttribute("listSanPham", listSanPham);
		modelMap.addAttribute("danhSachDanhMuc", danhSachDanhMuc);
		return "trangchu";
	}
	
	
}
