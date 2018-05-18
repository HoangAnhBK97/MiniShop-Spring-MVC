package com.hoanganhbk.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoanganhbk.daoimpl.SanPhamImpl;
import com.hoanganhbk.entity.ChiTietHoaDon;
import com.hoanganhbk.entity.ChiTietSanPham;
import com.hoanganhbk.entity.SanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImpl{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SanPham> LayDanhSachSanPham(int batdau) {
		List<SanPham> listSanPham = new ArrayList<SanPham>();
		if(batdau >0) {
			Session session = sessionFactory.getCurrentSession();
			listSanPham = session.createQuery("from sanpham").setFirstResult(batdau).setMaxResults(8).getResultList();
		} else {
			Session session = sessionFactory.getCurrentSession();
			listSanPham = session.createQuery("from sanpham").getResultList();
		}
		
		return listSanPham;
	}
	
	@Transactional
	public SanPham LaySanPhamTheoId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from sanpham where id=" + id;
		SanPham sanPham = (SanPham) session.createQuery(query).getSingleResult();
		return sanPham;
	}
	
	@Transactional
	public List<SanPham> LayDanhSachSanPhamTheoDanhMuc(int idDanhMuc) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPham = session.createQuery("from sanpham where iddanhmucsanpham=" + idDanhMuc + "").getResultList();
		return listSanPham;
	}
	
	@Transactional
	public boolean XoaSanPham(int idSanPham) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.get(SanPham.class, idSanPham);
		Set<ChiTietSanPham> setChiTietSanPham = sanPham.getChitietsanpham();
		for(ChiTietSanPham chiTietSanPham : setChiTietSanPham) {
			String query = "delete from chitiethoadon where idchitietsanpham="+chiTietSanPham.getIdchitietsanpham();
			session.createQuery(query).executeUpdate();
		}
		
		session.createQuery("delete from chitietsanpham where idsanpham=" + idSanPham).executeUpdate();
		session.createQuery("delete from sanpham where idsanpham="+idSanPham).executeUpdate();
		return true;
	}
	@Transactional
	public boolean ThemSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(sanPham);
		if(id > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public void UpdateSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		session.update(sanPham);
	}
	
	@Transactional
	public List<SanPham> SearchSanPhamTheoTen(String tenSanPham) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPham = session.createQuery("from sanpham where tensanpham like '%"+tenSanPham+"%'").getResultList();
		return listSanPham;
	}
	
}
