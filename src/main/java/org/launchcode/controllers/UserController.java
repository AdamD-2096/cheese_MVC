package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("enthusiast")
public class UserController {


    @RequestMapping(value="add", method = RequestMethod.GET)
    public String addUser(Model model){
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user,
                      String verify, Errors errors){

        model.addAttribute("user",user);
        if (errors.hasErrors() || !user.getPassword().equals(verify)){
            if (!user.getPassword().equals(verify)){model.addAttribute("noMatch", "passwords must match");}
            return "user/add";
        }
        return "user/index";
    }
}
