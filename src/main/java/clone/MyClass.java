/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package clone;


public class MyClass implements Cloneable {
	public Integer i = 10;

	//	@Override
	public MyClass clone() throws CloneNotSupportedException {
		MyClass obj = (MyClass) super.clone();
		obj.i = i;
		return obj;
	}

	public String toString() {
		return i.toString();
	}
}

class Temp {
	public static void main(String[] args) throws CloneNotSupportedException {
		MyClass a = new MyClass();
		a.i = 11;
		MyClass b = a.clone();
		MyClass c = a;
		System.out.println("a: " + a + " b: " + b + " c: " + c);
		a.i = 12;
		System.out.println("a: " + a + " b: " + b + " c: " + c);
	}
}
//  Вывод
// a: 11 b: 11 c: 11
//a: 12 b: 11 c: 12