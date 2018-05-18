package com.hoanganhbk.daoimpl;

import java.util.List;

import com.hoanganhbk.entity.SanPham;

public interface SanPhamImpl {
	public List<SanPham> LayDanhSachSanPham(int batdau);
	public SanPham LaySanPhamTheoId(int id);
	public List<SanPham> LayDanhSachSanPhamTheoDanhMuc(int idDanhMuc);
	boolean XoaSanPham(int idSanPham);
	boolean ThemSanPham(SanPham sanPham);
	void UpdateSanPham(SanPham sanPham);
	List<SanPham> SearchSanPhamTheoTen(String tenSanPham);
}
