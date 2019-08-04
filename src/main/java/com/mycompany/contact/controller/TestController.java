
package com.mycompany.contact.controller;

/**
 *
 * @author 55ans
 */
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/test/hello")
    public String helloWorld(){
        return "hello"; //-- this hello is a jsp file, location: /WEB-INF/view/hello.jsp
    }
    
    @RequestMapping("/test/ajax_test")
      public String testPage(){
          return "test" ;
      }
    
     @RequestMapping("/test/get_time")
     @ResponseBody
    public String getServerTime(){
         System.out.println("--------Get Server Time-------");
         Date d = new Date();
        return d.toString(); //
    }
    
}

