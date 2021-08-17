/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package clone.cat;

import java.io.*;

public class BasketCats {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Cat vaska = new Cat("Vaska", "Gray", 4);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream ous = new ObjectOutputStream(baos);
		//сохраняем состояние кота Васьки в поток и закрываем его(поток)
		ous.writeObject(vaska);
		ous.close();
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		//создаём кота для опытов и инициализируем его состояние Васькиным
		Cat cloneVaska = (Cat) ois.readObject();
		System.out.println(vaska);
		System.out.println(cloneVaska);
		System.out.println("*********************************************");
		cloneVaska.setColor("Black");
		//Убеждаемся что у кота Васьки теперь есть клон, над которым можно ставить опыты без ущерба Василию
		System.out.println(vaska);
		System.out.println(cloneVaska);

	}
}
//	Вывод:
//		Cat{name='Vaska', color='Gray', age=4}
//		Cat{name='Vaska', color='Gray', age=4}
//		*********************************************
//		Cat{name='Vaska', color='Gray', age=4}
//		Cat{name='Vaska', color='Black', age=4}