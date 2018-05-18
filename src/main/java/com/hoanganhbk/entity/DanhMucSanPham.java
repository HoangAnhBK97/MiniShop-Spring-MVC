package com.hoanganhbk.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="danhmucsanpham")
public class DanhMucSanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddanhmucsanpham;
	private String tendanhmuc;
	private String hinhdanhmuc;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="iddanhmuc")
	private Set<SanPham> danhsachsanpham;
	
	public int getIddanhmucsanpham() {
		return iddanhmucsanpham;
	}
	public void setIddanhmucsanpham(int iddanhmucsanpham) {
		this.iddanhmucsanpham = iddanhmucsanpham;
	}
	public String getTendanhmuc() {
		return tendanhmuc;
	}
	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}
	public String getHinhdanhmuc() {
		return hinhdanhmuc;
	}
	public void setHinhdanhmuc(String hinhdanhmuc) {
		this.hinhdanhmuc = hinhdanhmuc;
	}
	public Set<SanPham> getDanhsachsanpham() {
		return danhsachsanpham;
	}
	public void setDanhsachsanpham(Set<SanPham> danhsachsanpham) {
		this.danhsachsanpham = danhsachsanpham;
	}
	
}
