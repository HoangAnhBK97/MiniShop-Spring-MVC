package com.hoanganhbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganhbk.dao.SizeSanPhamDAO;
import com.hoanganhbk.daoimpl.SizeSanPhamImpl;
import com.hoanganhbk.entity.SizeSanPham;

@Service
public class SizeSanPhamService implements SizeSanPhamImpl{
	@Autowired
	SizeSanPhamDAO sizeSanPhamDao;
	public List<SizeSanPham> LaySizeSanPham() {
		return sizeSanPhamDao.LaySizeSanPham();
	}

	public SizeSanPham LaySizeSanPhamTheoTen(String ten) {
		// TODO Auto-generated method stub
		return sizeSanPhamDao.LaySizeSanPhamTheoTen(ten);
	}

}
