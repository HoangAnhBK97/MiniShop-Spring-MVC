package com.hoanganhbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoanganhbk.daoimpl.DanhMucImpl;
import com.hoanganhbk.entity.DanhMucSanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAO implements DanhMucImpl {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<DanhMucSanPham> LayDanhMuc() {
		Session session = sessionFactory.getCurrentSession();
		List<DanhMucSanPham> danhSachDanhMuc = session.createQuery("from danhmucsanpham").getResultList();
		return danhSachDanhMuc;
	}
	@Transactional
	public DanhMucSanPham LayDanhMucTheoId(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (DanhMucSanPham) session.createQuery("from danhmucsanpham where iddanhmucsanpham="+id).getSingleResult();
	}

}
