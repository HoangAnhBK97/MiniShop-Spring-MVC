package com.hoanganhbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoanganhbk.daoimpl.SizeSanPhamImpl;
import com.hoanganhbk.entity.SizeSanPham;
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SizeSanPhamDAO implements SizeSanPhamImpl {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SizeSanPham> LaySizeSanPham() {
		Session session = sessionFactory.getCurrentSession();
		List<SizeSanPham> listSizeSanPham = session.createQuery("from sizesanpham").getResultList();
		return listSizeSanPham;
	}
	@Transactional
	public SizeSanPham LaySizeSanPhamTheoTen(String ten) {
		Session session = sessionFactory.getCurrentSession();
		String q = "from sizesanpham where size='"+ten+"'";
		SizeSanPham size = (SizeSanPham) session.createQuery(q).getSingleResult();
		return size;
	}

}
