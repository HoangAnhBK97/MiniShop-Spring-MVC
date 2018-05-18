package com.hoanganhbk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="sizesanpham")
public class SizeSanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsizesanpham;
	private String Size;
	public int getIdsizesanpham() {
		return idsizesanpham;
	}
	public void setIdsizesanpham(int idsizesanpham) {
		this.idsizesanpham = idsizesanpham;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	
	
}
