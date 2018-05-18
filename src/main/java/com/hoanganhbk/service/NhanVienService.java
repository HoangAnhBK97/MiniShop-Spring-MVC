package com.hoanganhbk.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hoanganhbk.dao.NhanVienDAO;
import com.hoanganhbk.daoimpl.NhanVienImpl;
import com.hoanganhbk.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienImpl {
	
	@Autowired
	NhanVienDAO nhanVienDAO;
	
	public int KiemTraDangNhap(String tenDangNhap, String matKhau) {
		return nhanVienDAO.KiemTraDangNhap(tenDangNhap, matKhau);
	}

	public boolean ThemTaiKhoan(NhanVien nhanVien) {
		boolean kiemTra = nhanVienDAO.ThemTaiKhoan(nhanVien);
		return kiemTra;
	}
}
