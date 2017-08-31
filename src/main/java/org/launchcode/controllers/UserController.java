package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("enthusiast")
public class UserController {


    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model){
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User newUser, Errors errors,
                      String verify, Model model){

        model.addAttribute(newUser);
        if (errors.hasErrors() || !newUser.getPassword().equals(verify)){
            if (!newUser.getPassword().equals(verify)){model.addAttribute("noMatch", "passwords must match");}
            return "user/add";
        }
        return "user/index";
    }
}
