package com.hoanganhbk.daoimpl;

import java.util.List;

import com.hoanganhbk.entity.HoaDon;

public interface HoaDonImpl {
	int ThemHoaDon(HoaDon hoaDon);
	List<HoaDon> LayDanhSachHoaDon();
	HoaDon LayHoaDonTheoId(int id);
	boolean XoaHoaDonTheoId(int id);
}
