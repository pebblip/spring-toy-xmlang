package sample.parser;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import sample.program.Program;

public class ProgramBeanDefinitionParser extends AbstractBeanDefinitionParser {

	@Override
	protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
		BeanDefinitionBuilder bean = BeanDefinitionBuilder.rootBeanDefinition(Program.class);

		bean.addConstructorArgValue(element.getAttribute("argument"));
		bean.addConstructorArgValue(BlockFactoryBean.createBlockBeanDefinition(parserContext, bean, element));

		return bean.getBeanDefinition();
	}

	@Override
	public boolean shouldGenerateId() {
		return true;
	}

}
