package com.spring.core.session02.beans;

public class Parper {
	private Integer id; // 紙張編號
	private Color color;
	private Size size;

	public Parper() {

	}

	public Parper(Integer id, Color color, Size size) {

		this.id = id;
		this.color = color;
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Parper [id=" + id + ", color=" + color + ", size=" + size + "]";
	}

}
