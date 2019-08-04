
package com.mycompany.capp.test;

import com.mycompany.capp.dao.UserDAO;
import com.mycompany.contact.config.SpringRootConfig;
import com.mycompany.contact.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author 55ans
 */
public class TestUserDAOUpdate {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
    UserDAO userDAO = ctx.getBean(UserDAO.class);
    
    //the user details will be taken from user_reg_form
    
    User u = new User();
      u.setUserId(4);
      u.setName("anwar");
      u.setPhone("454561548");
      u.setEmail("bhakk@gmail.com");
      u.setAddress("ramnagar");
      u.setRole(5);
      u.setLoginStatus(5);
      userDAO.update(u);
      System.out.println("---------DATA Updated------");
      
  }
  
    
}
