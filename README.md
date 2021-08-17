# Java_Themes_Object

В данном проекте приведены примеры использования методов основного класса Java Object.
Методы класса Object:
1)	public final native Class getClass() 
2)	public native int hashCode() 
3)	public boolean equals(Object obj)
4)	protected native Object clone() throws CloneNotSupportedException
5)	public String toString()
6)	public final native void notify()
7)	public final native void notifyAll()
8)	public final native void wait(long timeout) throws InterruptedException
9)	public final void wait(long timeout, int nanos) throws InterruptedException
10)	public final void wait() throws Inter-ruptedException
11)	protected void finalize() throws Throwa-ble

_ _ _ _ _ 

 - clone() </p>
 Метод clone() в Java используется для клонирования объектов. Т.к. Java работает с объектами с помощью ссылок, то простым присва-иванием тут не обойдешься, ибо в таком случае копируется лишь адрес, и мы получим две ссылки на один и тот же объект, а это не то, что нам нужно. Механизм копирования обеспечивает метод clone() класса Object.</p>
 clone() действует как конструктор копирования. Обычно он вызывает метод clone() суперкласса и т.д. пока не дойдет до Object.</p>
Метод clone() класса Object создает и возвращает копию объекта с такими же значениями полей. Object.clone() кидает исключение <em>CloneNotSupportedException</em> если вы пытаетесь клонировать объект не реализующий интерфейс Cloneable. Реализация по умолчанию метода Object.clone() выполняет неполное/поверхностное (shallow) копирование. Если вам нужно полное/глубокое (deep) копирование класса то в методе clone() этого класса, после получения клона суперкласса, необходимо скопировать нужные поля.</p>
Синтаксис вызова clone() следующий:</p>
 ![image](https://user-images.githubusercontent.com/61631173/129766932-66e4ae42-e8b3-4312-a404-72647b24990e.png)</p>
или чаще:</p>
 ![image](https://user-images.githubusercontent.com/61631173/129767022-bcc72664-4680-4c4d-8af0-243f7fe315e2.png)</p>
Один из недостатков метода clone(), это тот факт, что возвращается тип Object, поэтому требуется нисходящее преобразование типа. Однако, начиная, с версии Java 1.5 при переопределении метода вы можете сузить возвращаемый тип.</p>
Пару слов о clone() и final полях.</p>
Метод clone() несовместим с final полями. Если вы попробуете клонировать final поле, компилятор остановит вас. Единственное решение - отказаться от final.</p>
пример клонирования по ссылке: https://github.com/Krassilnikov-AV/Java_Themes_Object/blob/master/src/main/java/clone/MyClass.java</p>

 
 Рассмотрение клонирования объекта разными способами:</p>
1. Переопределение метода clone() и реализация интерфейса Cloneable();</p>
2. Использование конструктора копирования;</p>
3. Использовать для клонирования механизм сериализации</p>

 Первый способ подразумевает, что вы будете использовать механизм так называемого «поверхностного клонирования» и сами позаботитесь о клонировании полей-объектов. Метод <em>clone()</em> в родительском классе <em>Object</em> является <em>protected</em>, поэтому требуется переопределение его с объявлением как public. Он возвращает экземпляр объекта с cкопированными полями-примитивами и ссылками. И получается что у оригинала и его клона поля-ссылки указывают на одни и те же объекты. Пример по ссылке https://github.com/Krassilnikov-AV/Java_Themes_Object/blob/master/src/main/java/clone/CloneTest.java  показывает, как одновременно меняется поле у оригинального объекта и клона. </p>
Из примера выше видно, что у клона и оригинала состояние одного из полей изменяется одновременно. </p>
Следующий способ заключается в использовании конструктора копирования: </p>
https://github.com/Krassilnikov-AV/Java_Themes_Object/blob/master/src/main/java/clone/Person.java </p>
В классе описывается конструктор, который принимает объект этого же класса и инициализирует значениями его полей поля нового объекта. О реализации инициализации полей полностью должен позаботиться разработчик класса.</p>
Клониование так же можно осуществить механизмом сериализации. Он заключается в сохранении объекта в поток байтов с последующей эксгумацией его от туда. Для примера пригласим кота Ваську, его ждёт пара опытов:</p>
https://github.com/Krassilnikov-AV/Java_Themes_Object/tree/master/src/main/java/clone/cat </p>
мы видим что Васька был сохранён в поток, из которого затем восстановили независимый клон.</p>

