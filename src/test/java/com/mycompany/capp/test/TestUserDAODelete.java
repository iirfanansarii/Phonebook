
package com.mycompany.capp.test;

import com.mycompany.capp.dao.UserDAO;
import com.mycompany.contact.config.SpringRootConfig;
import com.mycompany.contact.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserDAODelete {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
    UserDAO userDAO = ctx.getBean(UserDAO.class);
    userDAO.delete(3);
    System.out.println("---------- Data Deleted Successfully! ------------");
    
    }
    
}
