package com.hoanganhbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoanganhbk.daoimpl.HoaDonImpl;
import com.hoanganhbk.entity.HoaDon;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoaDonImpl{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public int ThemHoaDon(HoaDon hoaDon) {
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(hoaDon);
		if(id > 0) {
			return id;
		} else {
			return 0;
		}
	}
	
	@Transactional
	public List<HoaDon> LayDanhSachHoaDon() {
		Session session = sessionFactory.getCurrentSession();
		List<HoaDon> listHoaDon = session.createQuery("from hoadon").getResultList();
		return listHoaDon;
	}
	
	@Transactional
	public HoaDon LayHoaDonTheoId(int id) {
		Session session = sessionFactory.getCurrentSession();
		HoaDon hoaDon = session.get(HoaDon.class, id);
		return hoaDon;
	}
	
	@Transactional
	public boolean XoaHoaDonTheoId(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from chitiethoadon where idhoadon="+id).executeUpdate();
		int kt = session.createQuery("delete from hoadon where idhoadon="+id).executeUpdate();
		return true;
	}
	
}
