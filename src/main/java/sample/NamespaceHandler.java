package sample;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import sample.parser.IfBeanDefinitionParser;
import sample.parser.ProgramBeanDefinitionParser;
import sample.parser.ReturnBeanDefinitionParser;
import sample.parser.VarBeanDefinitionParser;
import sample.parser.WhileBeanDefinitionParser;

public class NamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("program", new ProgramBeanDefinitionParser());
		registerBeanDefinitionParser("var", new VarBeanDefinitionParser());
		registerBeanDefinitionParser("if", new IfBeanDefinitionParser());
		registerBeanDefinitionParser("while", new WhileBeanDefinitionParser());
		registerBeanDefinitionParser("return", new ReturnBeanDefinitionParser());
	}
}
