package com.spring.core.session02.beans;

public class WhiteA4 {
	private Integer id; // 編號
	private Color white; // 白顏色
	private Size a4; // A4尺寸
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Color getWhite() {
		return white;
	}
	public void setWhite(Color white) {
		this.white = white;
	}
	public Size getA4() {
		return a4;
	}
	public void setA4(Size a4) {
		this.a4 = a4;
	}
	@Override
	public String toString() {
		return "WhiteA4 [id=" + id + ", white=" + white + ", a4=" + a4 + "]";
	}
	
}
