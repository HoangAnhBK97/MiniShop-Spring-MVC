package com.hoanganhbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganhbk.dao.DanhMucDAO;
import com.hoanganhbk.daoimpl.DanhMucImpl;
import com.hoanganhbk.entity.DanhMucSanPham;

@Service
public class DanhMucService implements DanhMucImpl{
	@Autowired
	DanhMucDAO danhMucDao;
	public List<DanhMucSanPham> LayDanhMuc() {
		List<DanhMucSanPham> danhSachDanhMuc = danhMucDao.LayDanhMuc();
		return danhSachDanhMuc;
	}
	public DanhMucSanPham LayDanhMucTheoId(int id) {
		return danhMucDao.LayDanhMucTheoId(id);
	}

}
