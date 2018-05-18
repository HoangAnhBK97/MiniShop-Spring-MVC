package com.hoanganhbk.daoimpl;

import com.hoanganhbk.entity.NhanVien;

public interface NhanVienImpl {
	int KiemTraDangNhap(String tenDangNhap, String matKhau);
	boolean ThemTaiKhoan(NhanVien nhanVien);
}
