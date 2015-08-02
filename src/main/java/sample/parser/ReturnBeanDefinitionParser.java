package sample.parser;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

import sample.program.ReturnStatement;

public class ReturnBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	
	protected Class<?> getBeanClass(Element element) {
        return ReturnStatement.class;
    }

    protected void doParse(Element element, BeanDefinitionBuilder bean) {						
		bean.addConstructorArgValue(element.getAttribute("expression"));
	}

}
