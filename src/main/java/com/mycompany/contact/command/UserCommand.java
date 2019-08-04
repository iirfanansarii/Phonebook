
package com.mycompany.contact.command;

import com.mycompany.contact.domain.User;

/**
 *command for register page which is sign up form
 * @author 55ans
 */
public class UserCommand {
    User user;
    
    //TODO:add  more fields if it requires

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
