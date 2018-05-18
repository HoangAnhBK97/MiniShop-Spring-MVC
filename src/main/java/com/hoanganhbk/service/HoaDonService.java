package com.hoanganhbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganhbk.dao.HoaDonDAO;
import com.hoanganhbk.daoimpl.HoaDonImpl;
import com.hoanganhbk.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImpl{
	@Autowired 
	HoaDonDAO hoaDonDao;

	public int ThemHoaDon(HoaDon hoaDon) {
		return hoaDonDao.ThemHoaDon(hoaDon);
	}

	public List<HoaDon> LayDanhSachHoaDon() {
		return hoaDonDao.LayDanhSachHoaDon();
	}

	public HoaDon LayHoaDonTheoId(int id) {
		return hoaDonDao.LayHoaDonTheoId(id);
	}

	public boolean XoaHoaDonTheoId(int id) {
		return hoaDonDao.XoaHoaDonTheoId(id);
	}
}
