
package com.mycompany.capp.test;

import com.mycompany.contact.config.SpringRootConfig;
import com.mycompany.contact.domain.User;
import com.mycompany.contact.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author 55ans
 */
public class TestUserServiceRegister {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
    UserService userService = ctx.getBean(UserService.class);
    
    
    //the user details will be taken from user_reg_form
    
      User u = new User();
      u.setName("sameer");
      u.setPhone("454561548");
      u.setEmail("sara123@gmail.com");
      u.setAddress("madhavpur");
      u.setLoginName("bhakk");
      u.setPassword("bhakoli@420");
      u.setRole(UserService.ROLE_ADMIN);
      u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
      userService.register(u);
      System.out.println("---------User Registered successfully------");
      
  }
    
}
