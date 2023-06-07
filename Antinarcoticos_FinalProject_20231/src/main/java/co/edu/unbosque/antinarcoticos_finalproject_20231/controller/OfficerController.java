package co.edu.unbosque.antinarcoticos_finalproject_20231.controller;

import co.edu.unbosque.antinarcoticos_finalproject_20231.model.Officer;
import co.edu.unbosque.antinarcoticos_finalproject_20231.repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class OfficerController {
    @Autowired
    private OfficerRepository officerrepo;

    @GetMapping("/register_officer")
    public String showOfficerForm(Model model) {
        Officer officer = new Officer();
        model.addAttribute("officer", officer);
        List<String> rankList = Arrays.asList("General", "Mayor General", "Brigadier General", "Coronel", "Teniente Coronel", "Mayor", "Capitán", "Teniente", "Subteniente");
        model.addAttribute("rankList", rankList);
        return "officer_form";
    }

    @PostMapping("/register_officer")
    public String submitOfficerForm(@ModelAttribute("officer") Officer officer) {
        System.out.println(officer);
        officerrepo.save(officer);
        return "officer_success";
    }

    @RequestMapping("/list_officer")
    public String showOfficers(Model model) {
        List<Officer> list = officerrepo.findAll();
        model.addAttribute("listOfficers", list);
        return "list_officers";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name="id")Integer id) {
        ModelAndView mav = new ModelAndView("edit_officer");
        Optional<Officer> officeropt = officerrepo.findById(id);
        Officer officer = officeropt.get();
        mav.addObject("officer", officer);
        return mav;
    }

    @PostMapping("/update/{id}")
    public String updateOfficer(@PathVariable(name="id")Integer id, Officer officer, BindingResult result, Model model) {
        List<String> rankList = Arrays.asList("General", "Mayor General", "Brigadier General", "Coronel", "Teniente Coronel", "Mayor", "Capitán", "Teniente", "Subteniente");
        model.addAttribute("rankList", rankList);
        if(result.hasErrors()) {
            officer.setId(id);
            return "redirect:/index";
        }
        officerrepo.save(officer);
        return "officer_success";
    }

    @RequestMapping("/delete/{id}")
    public String deleteOfficer(@PathVariable("id")Integer id, Model model) {
        Officer officer = officerrepo.findById(id).get();
        officerrepo.delete(officer);
        return "officer_success";
    }

}
