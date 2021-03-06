package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseData;
import org.launchcode.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("types", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors, Model model) {
        if (errors.hasErrors()){
            model.addAttribute("types", CheeseType.values());
            model.addAttribute("title", "Add Cheese");
            model.addAttribute(newCheese);
            return "cheese/add";
        }
        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId){
        Cheese toEdit = CheeseData.getById(cheeseId);
        model.addAttribute("cheese", toEdit);
        model.addAttribute("types", CheeseType.values());
        model.addAttribute("title", "Edit Cheese " +
                toEdit.getName() + "(id=" + cheeseId + ")");
        return "cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese cheese,
                                  Errors errors, int cheeseId, Model model){
        Cheese toEdit = CheeseData.getById(cheeseId);
        if (errors.hasErrors()){
            model.addAttribute("cheese", cheese);
            model.addAttribute("types", CheeseType.values());
            model.addAttribute("title", "Edit Cheese " +
                    toEdit.getName() + "(id=" + cheeseId + ")");
            return "cheese/edit";
        }
        toEdit.setDescription(cheese.getDescription());
        toEdit.setName(cheese.getName());
        toEdit.setType(cheese.getType());
        return "redirect: ";
    }

}
