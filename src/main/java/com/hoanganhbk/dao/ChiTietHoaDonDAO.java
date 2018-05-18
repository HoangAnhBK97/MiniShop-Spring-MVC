package com.hoanganhbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoanganhbk.daoimpl.ChiTietHoaDonImpl;
import com.hoanganhbk.entity.ChiTietHoaDon;
import com.hoanganhbk.entity.ChiTietHoaDonId;
import com.hoanganhbk.entity.HoaDon;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDAO implements ChiTietHoaDonImpl{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Session session = sessionFactory.getCurrentSession();
		Object id = (Object) session.save(chiTietHoaDon);
		if(id != null) {
			return true;
		} else {
			return false;
		}
	}
	@Transactional
	public List<ChiTietHoaDon> LayChiTietHoaDonTheoId(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<ChiTietHoaDon> chiTietHoaDon = session.createQuery("from chitiethoadon where idhoadon="+id).getResultList();
		return chiTietHoaDon;
	}

}
