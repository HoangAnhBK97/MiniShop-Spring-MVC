package com.hoanganhbk.daoimpl;

import java.util.List;

import com.hoanganhbk.entity.DanhMucSanPham;

public interface DanhMucImpl {
	public List<DanhMucSanPham> LayDanhMuc();
	public DanhMucSanPham LayDanhMucTheoId(int id);
}
