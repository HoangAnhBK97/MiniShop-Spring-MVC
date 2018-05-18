package com.hoanganhbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoanganhbk.daoimpl.ChiTietSanPhamImpl;
import com.hoanganhbk.entity.ChiTietSanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ChiTietSanPhamDAO implements ChiTietSanPhamImpl {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public ChiTietSanPham LayChiTietSanPhamTheoId(int id) {
		Session session = sessionFactory.getCurrentSession();
		ChiTietSanPham chiTietSanPham = session.get(ChiTietSanPham.class, id);
		return chiTietSanPham;
	}
	
	
	
}
