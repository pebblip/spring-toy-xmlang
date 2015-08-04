package sample.parser;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import sample.program.IfStatement;

public class IfBeanDefinitionParser extends AbstractBeanDefinitionParser {

	protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
		BeanDefinitionBuilder bean = BeanDefinitionBuilder.rootBeanDefinition(IfStatement.class);

		String expression = element.getAttribute("expression");

		BeanDefinition blockBean = BlockFactoryBean.createBlockBeanDefinition(parserContext, bean, element);
		bean.addConstructorArgValue(expression).addConstructorArgValue(blockBean);
		return bean.getBeanDefinition();
	}
}
