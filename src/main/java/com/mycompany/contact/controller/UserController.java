package com.mycompany.contact.controller;

import com.mycompany.contact.command.LoginCommand;
import com.mycompany.contact.command.UserCommand;
import com.mycompany.contact.domain.User;
import com.mycompany.contact.exception.UserBlockedException;
import com.mycompany.contact.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author 55ans
 */
@Controller
public class UserController {

    @Autowired
    private UserService userservice;

    @RequestMapping(value = {"/", "/index"}) //this is url of index page
    public String index(Model m) {
        m.addAttribute("command", new LoginCommand());
        return "index";//jsp - /WEB-INF/view/index.jsp 
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {

        try {
            User loggedInUser = userservice.login(cmd.getLoginName(), cmd.getPassword());
            if (loggedInUser == null) {

             //filed part
                //add error message and go back to login-form
                m.addAttribute("err", "LOGIN FAILED! ENTER VALID CREDENTIALS ");
                return "index";//JSP - LOGIN FORM
            } else {
               //success part
                //check the role and redirect to appropriate dashboard
                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    //TODO: add user detail in session (assign session to logged in user)
                    addUserInSession(loggedInUser, session);

                    return "redirect:admin/dashboard";
                } else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
                 //add user detail in session (assign session to logged in user)  

                    addUserInSession(loggedInUser, session);

                    return "redirect:user/dashboard";
                } else {

                    m.addAttribute("err", "Invalid User Role");
                    return "index";//JSP - LOGIN FORM

                }
            }

        } catch (UserBlockedException ex) {

            //add error message and go back to login-form
            m.addAttribute("err", ex.getMessage());
            return "index";//JSP - LOGIN FORM

        }
    }
    
    
     @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:index?act=lo";//Here act is called flag which we gonna use in index page to display message
    }

    @RequestMapping(value = "/user/dashboard")
    public String userDashboard() {
        return "dashboard_user";//jsp
    }

    @RequestMapping(value = "/admin/dashboard")
    public String admiDashboard() {
        return "dashboard_admin";//jsp
    }
    
    
    
    @RequestMapping(value = "/admin/users")
    public String getuserList(Model m) {     // Model m is model object
       m.addAttribute("userList",userservice.getUserList());
        return "users";//jsp
    }

    //below logic for sign up page or jsp page to register stars here
    
    @RequestMapping(value= "/reg_form")
    public String registerationForm(Model m){
        UserCommand cmd = new UserCommand();
       m.addAttribute("command", cmd);
        return "reg_form"; //JSP
    }
    
    
    //logic to take data from registration form and pass it to service method
    
    @RequestMapping(value= "/register")
    public String registerUser(@ModelAttribute("command") UserCommand cmd,Model m){
        try {
            User user = cmd.getUser(); //taking from user
            user.setRole(UserService.ROLE_USER);            
            user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
            userservice.register(user); //passing to service 
            return "redirect:index?act=reg"; //after registration redirect user to index page and act is flag 
            
        } catch (DuplicateKeyException e) {
            m.addAttribute("err","user name already exist try another");
            return "reg_form";
            
        }
}
    
     //below logic for sign up page or jsp page to register ends here
   
    private void addUserInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());

    }
    
    
    
     @RequestMapping(value= "/admin/change_status")
     @ResponseBody
    public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus) {
    
         try {
             userservice.changeLoginStatus(userId, loginStatus);   
             return "STATUS : Status Changed";
         } catch (Exception e) {
             e.printStackTrace();
             return "ERROR: Unable to Change Status";
         }
    }
    
     @RequestMapping(value= "/admin/check_avail")
     @ResponseBody
    public String checkAvailability(@RequestParam String username) {
        
    if(userservice.isUserNameExist(username)){
       
    return "This user name is already taken";
    
    } else {
        return "Yes! You can take this name";
    }   
     }      
        
    }
    
    
    


