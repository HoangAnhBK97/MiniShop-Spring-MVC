package com.hoanganhbk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hoanganhbk.service.NhanVienService;


@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping
	public String Default() {
		return "dangnhap";
	}
	
	@Autowired
	NhanVienService nhanVienService;
	
	@PostMapping
	public String ProcessLogin(@RequestParam String username, @RequestParam String password, ModelMap modelMap, HttpSession httpSession) {
		int kt = nhanVienService.KiemTraDangNhap(username, password);
		if(kt != -1) {
			httpSession.setAttribute("username", username);
			if(httpSession.getAttribute("username") != null) {
				modelMap.addAttribute("username", username);
			}
			if(kt == 1 || kt == 2) {
				return "redirect:/admin/sanpham";
			} else {
				return "redirect:/";
			}
			
		} else {
			httpSession.removeAttribute("username");
			modelMap.addAttribute("thatbai", "Đăng nhập thất bại");
		}
		return "dangnhap";
	}
}
