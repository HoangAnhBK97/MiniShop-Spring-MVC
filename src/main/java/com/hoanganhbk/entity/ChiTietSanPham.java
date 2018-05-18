package com.hoanganhbk.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="chitietsanpham")
public class ChiTietSanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idchitietsanpham;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idsanpham")
	private SanPham sanpham;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idsizesanpham")
	private SizeSanPham sizesanpham;
	
	private int soluong;
	private String ngaynhap;
	public int getIdchitietsanpham() {
		return idchitietsanpham;
	}
	public void setIdchitietsanpham(int idchitietsanpham) {
		this.idchitietsanpham = idchitietsanpham;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public SizeSanPham getSizesanpham() {
		return sizesanpham;
	}
	public void setSizesanpham(SizeSanPham sizesanpham) {
		this.sizesanpham = sizesanpham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	
	
}
