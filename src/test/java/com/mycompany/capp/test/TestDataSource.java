
package com.mycompany.capp.test;

import com.mycompany.contact.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author 55ans
 */
public class TestDataSource {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        DataSource ds = ctx.getBean(DataSource.class);
        
        String sql = "INSERT INTO user (name,phone,email,address,loginName,password)";
        
        Object[] param = new Object[]{"asgar","7015720216","asgar@gmail.com","Harinagar","ans","1456"};
        
//        jt.update(sql,param);
        
        System.out.println("----------SQL Executed---------");
    
    }
    
}
