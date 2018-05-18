package com.hoanganhbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoanganhbk.entity.DanhMucSanPham;
import com.hoanganhbk.entity.SanPham;
import com.hoanganhbk.service.DanhMucService;
import com.hoanganhbk.service.SanPhamService;

@Controller
@RequestMapping("/sanpham")
public class DanhMucController {
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	@GetMapping("/{id}")
	public String Default(@PathVariable int id, ModelMap modelMap) {
		List<DanhMucSanPham> danhSachDanhMuc = danhMucService.LayDanhMuc();
		for(DanhMucSanPham danhMuc : danhSachDanhMuc) {
			if(danhMuc.getIddanhmucsanpham() == id) {
				modelMap.addAttribute("tenDanhMuc", danhMuc.getTendanhmuc());
			}
		}
		modelMap.addAttribute("danhSachDanhMuc", danhSachDanhMuc);
		List<SanPham> sanPhamTheoDanhMuc = sanPhamService.LayDanhSachSanPhamTheoDanhMuc(id);
		modelMap.addAttribute("sanPhamTheoDanhMuc", sanPhamTheoDanhMuc);
		return "sanpham";
	}
}
