package com.spring.core.session02.beans;

public class Paper {
	private Integer id; // 紙張編號
	private Color color;
	private Size size;

	public Paper() {

	}

	public Paper(Color color, Size size) {

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
		return "Paper [id=" + id + ", color=" + color + ", size=" + size + "]";
	}

}
