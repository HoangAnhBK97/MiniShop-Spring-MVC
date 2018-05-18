package com.hoanganhbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hoanganhbk.daoimpl.NhanVienImpl;
import com.hoanganhbk.entity.NhanVien;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAO implements NhanVienImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public int KiemTraDangNhap(String tenDangNhap, String matKhau) {
		Session session = sessionFactory.getCurrentSession();
		try {
			NhanVien nhanVien = (NhanVien) session.createQuery("from nhanvien where tendangnhap='"+tenDangNhap+"' and matkhau='"+matKhau+"'").getSingleResult();
			return nhanVien.getChucvu().getIdchucvu();
		} catch (Exception e) {
			return -1 ;
		}
	}
	@Transactional
	public boolean ThemTaiKhoan(NhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		int kt = (Integer) session.save(nhanVien);
		if(kt != 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
