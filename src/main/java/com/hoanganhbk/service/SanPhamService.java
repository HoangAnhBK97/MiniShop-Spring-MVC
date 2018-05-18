package com.hoanganhbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganhbk.dao.SanPhamDAO;
import com.hoanganhbk.daoimpl.SanPhamImpl;
import com.hoanganhbk.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImpl{
	@Autowired
	SanPhamDAO sanPhamDao;
		
	public List<SanPham> LayDanhSachSanPham(int batdau) {
		return sanPhamDao.LayDanhSachSanPham(batdau);
	}

	public SanPham LaySanPhamTheoId(int id) {
		SanPham sanPham = sanPhamDao.LaySanPhamTheoId(id);
		return sanPham;
	}

	public List<SanPham> LayDanhSachSanPhamTheoDanhMuc(int idDanhMuc) {
		return sanPhamDao.LayDanhSachSanPhamTheoDanhMuc(idDanhMuc);
	}

	public boolean XoaSanPham(int idSanPham) {
		return sanPhamDao.XoaSanPham(idSanPham);
	}

	public boolean ThemSanPham(SanPham sanPham) {
		return sanPhamDao.ThemSanPham(sanPham);
	}

	public void UpdateSanPham(SanPham sanPham) {
		sanPhamDao.UpdateSanPham(sanPham);
	}

	public List<SanPham> SearchSanPhamTheoTen(String tenSanPham) {
		return sanPhamDao.SearchSanPhamTheoTen(tenSanPham);
	}

}
