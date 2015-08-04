package sample.parser;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

import sample.program.VarStatement;

public class VarBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	protected Class<?> getBeanClass(Element element) {
		return VarStatement.class;
	}

	protected void doParse(Element element, BeanDefinitionBuilder bean) {
		String name = element.getAttribute("name");
		String expression = element.getAttribute("expression");

		bean.addConstructorArgValue(name).addConstructorArgValue(expression);
	}
}
