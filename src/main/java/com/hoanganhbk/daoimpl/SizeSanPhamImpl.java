package com.hoanganhbk.daoimpl;

import java.util.List;

import com.hoanganhbk.entity.SizeSanPham;

public interface SizeSanPhamImpl {
	List<SizeSanPham> LaySizeSanPham();
	SizeSanPham LaySizeSanPhamTheoTen(String ten);
}
