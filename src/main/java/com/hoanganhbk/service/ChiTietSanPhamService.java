package com.hoanganhbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganhbk.dao.ChiTietSanPhamDAO;
import com.hoanganhbk.daoimpl.ChiTietSanPhamImpl;
import com.hoanganhbk.entity.ChiTietSanPham;

@Service
public class ChiTietSanPhamService implements ChiTietSanPhamImpl{
	@Autowired
	ChiTietSanPhamDAO chiTietSanPhamDao;
	public ChiTietSanPham LayChiTietSanPhamTheoId(int id) {
		return chiTietSanPhamDao.LayChiTietSanPhamTheoId(id);
	}

}
