package sample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.program.Program;

public class ProgramTest {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("factorial.xml")) {
			Program p = context.getBean(Program.class);
			Object result1 = p.evaluate(3);
			System.out.println("result : " + result1.toString());
			Object result2 = p.evaluate(10);
			System.out.println("result : " + result2.toString());
		}
	}
}
