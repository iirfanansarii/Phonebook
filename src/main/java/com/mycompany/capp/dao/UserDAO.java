
package com.mycompany.capp.dao;

import com.mycompany.contact.domain.User;
import java.util.List;

/**
 *
 * @author 55ans
 */
public interface UserDAO {
    
    public void save (User u);
    
    public void update (User u);
    
    public void delete (User u);
    
    public void delete (Integer userId);
    
    public User findById(Integer userId);
    
    public List <User> findAll();
    
    public List <User> findByProperty(String propname, Object propValue );
    
}
