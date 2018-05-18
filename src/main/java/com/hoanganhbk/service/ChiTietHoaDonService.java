package com.hoanganhbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoanganhbk.dao.ChiTietHoaDonDAO;
import com.hoanganhbk.daoimpl.ChiTietHoaDonImpl;
import com.hoanganhbk.entity.ChiTietHoaDon;
import com.hoanganhbk.entity.ChiTietHoaDonId;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImpl{
	@Autowired
	ChiTietHoaDonDAO chiTietHoaDonDao;
	
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		return chiTietHoaDonDao.ThemChiTietHoaDon(chiTietHoaDon);
	}

	public List<ChiTietHoaDon> LayChiTietHoaDonTheoId(int id) {
		return chiTietHoaDonDao.LayChiTietHoaDonTheoId(id);
	}

	
}
