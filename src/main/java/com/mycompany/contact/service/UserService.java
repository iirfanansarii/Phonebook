
package com.mycompany.contact.service;

import com.mycompany.contact.domain.User;
import com.mycompany.contact.exception.UserBlockedException;
import java.util.List;

/**
 *
 * @author 55ans
 */
public interface UserService {
    
  public static final Integer LOGIN_STATUS_ACTIVE=1;  
  public static final Integer LOGIN_STATUS_BLOCKED=2;
  
  public static final Integer ROLE_ADMIN=1;
  public static final Integer ROLE_USER=2;
   
    
    /**
     * the method handle the user registration task
     * @param u the new user details as user object
     */
    public void register(User u);
    /**
     * the method handle login operation(authentication) using given credentials
     * it returns user object when success and null got failed
     * when failed when user account is blocked and an
     * @param loginName
     * @param Password
     * @return 
     * @throws com.mycompany.contact.exception.UserBlockedException when user account is blocked
     */
    public User login (String loginName,String Password) throws UserBlockedException;
    
    /**
     * call this method to get the list of registered users
     * @return 
     */
    
    public List<User> getUserList();
    
    /**
     * this method change the user login status for details passed as argument
     * @param userId
     * @param status 
     */
    public void changeLoginStatus(Integer userId,Integer status);
    /**
     * check username availability 
     * @param username
     * @return 
     */
    public Boolean isUserNameExist(String username);
    
    
   }
