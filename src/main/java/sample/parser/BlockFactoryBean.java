package sample.parser;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import sample.program.Block;
import sample.program.Statement;

import java.util.List;

public class BlockFactoryBean implements FactoryBean<Block> {	
    
    private List<Statement> statements;    

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public Block getObject() throws Exception {
    	Block block = new Block();
        if (this.statements != null && this.statements.size() > 0) {
            for (Statement s : statements) {
            	block.addStatement(s);
            }
        }
        return block;
    }

    public Class<Block> getObjectType() {
        return Block.class;
    }

    public boolean isSingleton() {
        return true;
    }

	public static BeanDefinition createBlockBeanDefinition(ParserContext parserContext, BeanDefinitionBuilder bean,	Element parent) {
		ManagedList<BeanDefinition> childDefinitions = new ManagedList<>();
	
		for (Element child : DomUtils.getChildElements(parent)) {
			BeanDefinition childBeanDefinition = parserContext.getDelegate().parseCustomElement(child, bean.getRawBeanDefinition());
			childDefinitions.add(childBeanDefinition);
		}
	
		BeanDefinitionBuilder blockBean = BeanDefinitionBuilder.rootBeanDefinition(BlockFactoryBean.class);
		blockBean.addPropertyValue("statements", childDefinitions);
		return blockBean.getBeanDefinition();
	}

}