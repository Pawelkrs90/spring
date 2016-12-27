/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.packages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class mainController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        
        return "index";
    }
    
    @RequestMapping(value = "/dynamic_nav", method = RequestMethod.GET)
    public String dynamic_nav(Model model){
        
        return "dynamic_nav";
    }
    
}
