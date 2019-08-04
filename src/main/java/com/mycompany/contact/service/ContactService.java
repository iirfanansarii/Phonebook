
package com.mycompany.contact.service;

import com.mycompany.contact.domain.Contact;
import java.util.List;

/**
 *The interface specifies all business operation for contact Entity
 * @author 55ans
 */
public interface ContactService {
    
    
    public void save(Contact c);
    
    
    public void update(Contact c);
    
    
    public void delete(Integer contactId);
    
    
    public void delete(Integer[] contactIds);
    
    
    public Contact  findById(Integer contactId);
    
   
    public List<Contact>findUserContact(Integer userId);  //for logged in user
     
   /**
    * the method search contact for user based on given free-text-criteria (txt)
    * @param txt criteria used to search - free text criteria
    * @return 
    */
    
    public List<Contact>findUserContactList(String txt);
    
    
}
