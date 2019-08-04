
package com.mycompany.capp.dao;

import com.mycompany.contact.domain.Contact;
import java.util.List;

/**
 *
 * @author 55ans
 */
public interface ContactDAO {
    
    public void save (Contact c);
    
    public void update (Contact c);
    
    public void delete (Contact c);
    
    public void delete (Integer ContactId); 
    
    public Contact findById(Integer ContactId); 
    
    public List <Contact> findAll();
    
    public List <Contact> findByProperty(String propname, Object propValue );
    
    
}
