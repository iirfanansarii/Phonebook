package com.mycompany.contact.controller;

import com.mycompany.contact.domain.Contact;
import com.mycompany.contact.service.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author 55ans
 */
@Controller
public class ContactController {
    
    @Autowired
    private ContactService contactService;
    private Object contactServices;
    
    @RequestMapping(value = "/user/contact_form")  // when you will requesting from "/user/contact_form" you will get "contact_form" 
    public String contactForm(Model m) {        
        Contact contact = new Contact();  //reusing conatact domain class
        m.addAttribute("command", contact); // comand is a keyword to bind the class
        return "contact_form"; // you will return contact_form which is jsp page
    }
    
    @RequestMapping(value = "/user/save_contact")
    public String saveContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
        System.out.println("--------- contact obj : " + c);
             Integer contactId  = (Integer) session.getAttribute("aContactId");
        System.out.println("--------- contactId : " + contactId);

        if(contactId == null)
     { 
         //save task
         System.out.println("------------ save");  
         try {
            Integer userId = (Integer) session.getAttribute("userId");
            c.setUserId(userId);
            contactService.save(c);
            return "redirect:clist?act=sv"; //redirect user to contact list
            
        } catch (Exception e) {
            e.printStackTrace();  // for internal preference 
            m.addAttribute("err", "Filed to save contact");
            return "contact_form";//jsp form view
        }
     }
    else 
     {
//update task
         System.out.println("------------ update");  
         try {
            c.setContactId(contactId); //PK
            contactService.update(c);
            return "redirect:clist?act=ed"; //redirect user to contact list
            
        } catch (Exception e) {
            e.printStackTrace();  // for internal preference 
            m.addAttribute("err", "Filed to Edit contact");
            return "contact_form";//jsp form view
        }    
    
      }
        
    }    
    
    @RequestMapping(value = "/user/clist")    
    public String contactList(Model m, HttpSession session) {        
        Integer userId = (Integer) session.getAttribute("userId");
        
        m.addAttribute("contactList", contactService.findUserContact(userId));
        return "clist"; //TODO JSP  
    }
    
    @RequestMapping(value = "/user/contact_search")    
    public String contactSearch(Model m, HttpSession session,@RequestParam("freeText") String freeText) {        
    Integer userId = (Integer) session.getAttribute("userId");
    m.addAttribute("contactList", contactService.findUserContactList(freeText));
    return "clist"; //TODO JSP  
    }
    
    
    @RequestMapping(value = "/user/del_contact")    
      public String deletecontact (@RequestParam ("cid") Integer contactId) {        
       contactService.delete(contactId);
        return "redirect:clist?act=del";
    }
    
      
       
    @RequestMapping(value = "/user/bulk_cdelete")    
      public String deleteBulkContact (@RequestParam("cid") Integer[] contactIds) {        
       contactService.delete(contactIds);
        return "redirect:clist?act=del";
    }
    
    
      @RequestMapping(value = "/user/edit_contact")    
    public String preparedEditForm( Model m, HttpSession session, @RequestParam ("cid") Integer contactId) {        
      session.setAttribute("aContactId" , contactId);
      Contact c = contactService.findById(contactId);
      m.addAttribute("command",c);
        return "contact_form"; //jsp form view
    }
    
}
