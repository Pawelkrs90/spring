/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.packages.controllers;

import app.packages.domain.User;
import app.packages.service.UserDaoService;
import app.packages.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/Users")
public class UserController {
    
    //@Autowired
   // private UserService userService;
    private UserDaoService userDaoService;
	
    @Autowired(required=true)
    @Qualifier(value="userDaoService")
    public void setUserService(UserDaoService us){
	this.userDaoService = us;
    }
    
    
    @RequestMapping
    public String UsersList(Model model){
        
        model.addAttribute("userList", userDaoService.getUserList());

        return "users";
    }
    
    
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String initForm(Model model){
        
        model.addAttribute("newUser", new User());
        
        return "addUser";
    }
    
    
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String processAddProductForm(@ModelAttribute("newUser") @Valid User user,
                                        BindingResult result, HttpServletRequest httpRequest){
        
           
            if(result.hasErrors()){   //jesli Validacja zwroci problem
                return "addUser";
            }
            
            if(result.getSuppressedFields().length > 0){  //sprawdzenie czy dodano tylko pola zgodne z binderem
                throw new RuntimeException("Proba wiazania niedozwolonych pol: "
                                            + StringUtils.arrayToCommaDelimitedString(result.getSuppressedFields()));
            }
                  
            userDaoService.addUser(user);
            return "redirect:/Users";
        }
    
        @InitBinder
        public void initialiseBinder(WebDataBinder binder){
            
            binder.setAllowedFields("id", "firstName", "lastName");
        }
}
