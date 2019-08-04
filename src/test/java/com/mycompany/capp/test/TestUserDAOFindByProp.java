
package com.mycompany.capp.test;

import com.mycompany.capp.dao.UserDAO;
import com.mycompany.contact.config.SpringRootConfig;
import com.mycompany.contact.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserDAOFindByProp {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
    UserDAO userDAO = ctx.getBean(UserDAO.class);
    
      //List<User> users = userDAO.findByProperty("userId", 1);
    
       // List<User> users = userDAO.findByProperty("name", "irfan");
        
        List<User> users = userDAO.findByProperty("role", 1);
      
      for(User u:users){
           System.out.println(u.getUserId()+" "+u.getName()+" "+u.getRole());
      //TODO: access other colums   
      
      }
    
   
    
    }
    
}
