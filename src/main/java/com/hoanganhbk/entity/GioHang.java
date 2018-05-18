package com.hoanganhbk.entity;

public class GioHang {
	private int idChiTiet;
	private String tenSanPham;
	private int giaSanPham;
	private String idSanPham;
	private String sizeSanPham;
	private int soLuongSanPham;
	
	public int getIdChiTiet() {
		return idChiTiet;
	}
	public void setIdChiTiet(int idChiTiet) {
		this.idChiTiet = idChiTiet;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public int getGiaSanPham() {	
		return giaSanPham*soLuongSanPham;
	}
	public void setGiaSanPham(int giaSanPham) {
		this.giaSanPham = giaSanPham;
	}
	public String getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}
	public String getSizeSanPham() {
		return sizeSanPham;
	}
	public void setSizeSanPham(String sizeSanPham) {
		this.sizeSanPham = sizeSanPham;
	}
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}
	
	
}
