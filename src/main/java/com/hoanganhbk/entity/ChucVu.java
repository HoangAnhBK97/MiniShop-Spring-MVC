package com.hoanganhbk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="chucvu")
public class ChucVu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idchucvu;
	private String tenchucvu;

	public int getIdchucvu() {
		return idchucvu;
	}
	public void setIdchucvu(int idchucvu) {
		this.idchucvu = idchucvu;
	}
	public String getTenchucvu() {
		return tenchucvu;
	}
	public void setTenchucvu(String tenchucvu) {
		this.tenchucvu = tenchucvu;
	}
	
	
}
