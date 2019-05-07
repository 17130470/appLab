package com.calculator;
/*Подключение библиотеки. JUnit - это библиотека, позволяющая
 * проводить модульное тестирование Java приложений. Класс Assert 
 * содержит набор утверждений, которые облегачют процесс тестирования. */
import static org.junit.Assert.*;
/*Аннтоация @Test указывает JUnit, что метод является тестовым методом*/
import org.junit.Test;
/*Импортирует из пакета NalogC класс tax*/
import com.calculator.Calculator;
/*Объявляем новый класс test1*/
public class test1 {
	/*Обозначает новую переменную из класса tax*/
	Calculator calc = new Calculator();
	/*InterruptedException это проверяемое исключение, генерируемый многими методами стандартной библиотеки, которые блокируют поток исполнения*/
	@Test
	public void testCalc() throws InterruptedException
	 {
		/*Подставляет значения в метод calcTax1,
		 * где высчитывают процент налога с дохода*/
	 double res= tax.calcTax(1000, 13);
		/*Заданное полученное значение*/
	 double toch=130.0;
		/*Сравнивают высчитанное методом calcTax и заранее заданное значение */
	 assertEquals(Double.toString(res),Double.toString(toch));
	 }
}
