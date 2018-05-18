package com.hoanganhbk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hoanganhbk.entity.NhanVien;
import com.hoanganhbk.service.NhanVienService;

@Controller
@RequestMapping("/dangky")
public class DangKyController {
	@Autowired
	NhanVienService nhanVienService;
	
	@GetMapping
	public String Default(HttpSession httpSession) {
		if(httpSession.getAttribute("username") != null) {
			httpSession.removeAttribute("username");
		}
		return "redirect:/";
	}
	
	@PostMapping
	public String ThemTaiKhoan(@RequestParam String email, @RequestParam String username, @RequestParam String password,
								@RequestParam String repassword, ModelMap modelMap) {
		if(!password.equals(repassword)) {
			modelMap.addAttribute("thatbai", "Mật khẩu không giống nhau");
		} else {
			NhanVien nhanVien = new NhanVien();
			nhanVien.setEmail(email);
			nhanVien.setTendangnhap(username);
			nhanVien.setMatkhau(password);
			boolean kt = nhanVienService.ThemTaiKhoan(nhanVien);
			if(kt) {
				modelMap.addAttribute("thanhcong", "Đăng ký thành công");
			} else {
				modelMap.addAttribute("thatbai", "Đăng ký thất bại");
			}
		}
		return "dangnhap";
	}
}
