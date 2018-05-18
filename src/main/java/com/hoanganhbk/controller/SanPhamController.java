package com.hoanganhbk.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoanganhbk.entity.ChiTietSanPham;
import com.hoanganhbk.entity.DanhMucSanPham;
import com.hoanganhbk.entity.SanPham;
import com.hoanganhbk.entity.SizeSanPham;
import com.hoanganhbk.service.DanhMucService;
import com.hoanganhbk.service.SanPhamService;
import com.hoanganhbk.service.SizeSanPhamService;

@Controller
@RequestMapping("/admin/sanpham")
public class SanPhamController {
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<SanPham> listSanPham = sanPhamService.LayDanhSachSanPham(-1);
		int tongSoSanPham = listSanPham.size();
		int tongSoPage = (int) Math.ceil((double)tongSoSanPham/7);
		modelMap.addAttribute("listSanPham", listSanPham);
		modelMap.addAttribute("tongSoPage", tongSoPage);
		return "quanlysanpham";
	}
	
	@Autowired
	SizeSanPhamService sizeSanPhamService;
	
	@GetMapping("/them")
	public String ThemSanPham(ModelMap modelMap) {
		List<DanhMucSanPham> listDanhMuc = danhMucService.LayDanhMuc();
		List<SizeSanPham> listSizeSanPham = sizeSanPhamService.LaySizeSanPham();
		modelMap.addAttribute("listDanhMuc", listDanhMuc);
		modelMap.addAttribute("listSizeSanPham", listSizeSanPham);
		return "themsanpham";
	}
	
	@PostMapping("/them")
	@ResponseBody
	public String ThemSanPham(@RequestParam String tensanpham, @RequestParam String giatien, @RequestParam String mota, @RequestParam String danhmuc, 
			@RequestParam String image, @RequestParam String size, @RequestParam String soluong) {
		DanhMucSanPham danhMucSanPham = danhMucService.LayDanhMucTheoId(Integer.parseInt(danhmuc));
		Set<ChiTietSanPham> setChiTietSanPham = new HashSet();
		String[] listSize = size.split(",");
		String[] listSoLuong = soluong.split(",");
		for(int i=0; i<listSize.length; i++ ) {
			ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
			SizeSanPham sizeSanPham = sizeSanPhamService.LaySizeSanPhamTheoTen(listSize[i]);
			chiTietSanPham.setSizesanpham(sizeSanPham);
			chiTietSanPham.setSoluong(Integer.parseInt(listSoLuong[i]));
			setChiTietSanPham.add(chiTietSanPham);
		}
		SanPham sanPham = new SanPham();
		sanPham.setTensanpham(tensanpham);
		sanPham.setGiatien(giatien);
		sanPham.setMota(mota);
		sanPham.setDanhmucsanpham(danhMucSanPham);
		sanPham.setHinhsanpham(image);
		sanPham.setChitietsanpham(setChiTietSanPham);
		boolean kt = sanPhamService.ThemSanPham(sanPham);
		if(kt) {
			return "quanlysanpham";
		} else {
			return "themsanpham";
		}
		
	}
	
	@Autowired
	ServletContext context;
	
	@GetMapping("/edit/{id}")
	public String SuaSanPham(ModelMap modelMap, @PathVariable("id") int id) {
		String path = context.getRealPath("/resources/Image/SanPham/");
		SanPham sanPham = sanPhamService.LaySanPhamTheoId(id);
		List<DanhMucSanPham> listDanhMuc = danhMucService.LayDanhMuc();
		List<SizeSanPham> listSizeSanPham = sizeSanPhamService.LaySizeSanPham();
		Set<ChiTietSanPham> setChiTietSanPham = sanPham.getChitietsanpham();
		List<ChiTietSanPham> listChiTietSanPham = new ArrayList<ChiTietSanPham>();
		listChiTietSanPham.addAll(setChiTietSanPham);
		path += sanPham.getHinhsanpham();
		modelMap.addAttribute("sanPham", sanPham);
		modelMap.addAttribute("listDanhMuc", listDanhMuc);
		modelMap.addAttribute("listSizeSanPham", listSizeSanPham);
		modelMap.addAttribute("listChiTietSanPham", listChiTietSanPham);
		modelMap.addAttribute("path", path);
		return "editsanpham";
	}
	
	@PostMapping("/edit/{id}")
	public String SuaSanPham(@RequestParam int idsanpham, @RequestParam String tensanpham, @RequestParam String giatien, @RequestParam String mota, @RequestParam String danhmuc, 
			@RequestParam String image, @RequestParam String size, @RequestParam String soluong) {
		DanhMucSanPham danhMucSanPham = danhMucService.LayDanhMucTheoId(Integer.parseInt(danhmuc));
		Set<ChiTietSanPham> setChiTietSanPham = new HashSet();
		String[] listSize = size.split(",");
		String[] listSoLuong = soluong.split(",");
		for(int i=0; i<listSize.length; i++ ) {
			ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
			SizeSanPham sizeSanPham = sizeSanPhamService.LaySizeSanPhamTheoTen(listSize[i]);
			chiTietSanPham.setSizesanpham(sizeSanPham);
			chiTietSanPham.setSoluong(Integer.parseInt(listSoLuong[i]));
			setChiTietSanPham.add(chiTietSanPham);
		}
		SanPham sanPham = new SanPham();
		sanPham.setIdsanpham(idsanpham);
		sanPham.setTensanpham(tensanpham);
		sanPham.setGiatien(giatien);
		sanPham.setMota(mota);
		sanPham.setDanhmucsanpham(danhMucSanPham);
		SanPham sp = sanPhamService.LaySanPhamTheoId(idsanpham);
		if(image != "" && image != null) {
			System.out.println("Khac nulllllllllllllllllllllllllllll");
			sanPham.setHinhsanpham(image);
		} else {
			System.out.println("Nulllllllllllllllllllllllllllll");
			sanPham.setHinhsanpham(sp.getHinhsanpham());
		}
		sanPham.setChitietsanpham(setChiTietSanPham);
		sanPhamService.UpdateSanPham(sanPham);
		return "redirect:/admin/sanpham";
	}
	
}
