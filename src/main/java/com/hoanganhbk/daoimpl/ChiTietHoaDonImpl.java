package com.hoanganhbk.daoimpl;

import java.util.List;

import com.hoanganhbk.entity.ChiTietHoaDon;
import com.hoanganhbk.entity.ChiTietHoaDonId;

public interface ChiTietHoaDonImpl {
	boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
	List<ChiTietHoaDon> LayChiTietHoaDonTheoId(int idHoaDon);
}
