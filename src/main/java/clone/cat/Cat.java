/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package clone.cat;

import java.io.*;

class Cat implements Serializable {
	private String name;
	private String color;
	private int age;

	public Cat(String name, String color, int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cat{" +
			"name='" + name + '\'' +
			", color='" + color + '\'' +
			", age=" + age +
			'}';
	}
}
