package com.hp.springbootmvc.springbootmvcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@Controller
public class home_controller
{

    @Autowired
    alienrepo repo;

    @ModelAttribute
    public void assign_modeldata(Model m, String name)
    {
        m.addAttribute("name",name);
    }

    @RequestMapping("/")
    public String home()
    {
        System.out.println("Home Page Requested");
        return "index";
    }

    @RequestMapping("add_two_numbers")
    public ModelAndView add_two_numbers(@RequestParam("num1") int a, @RequestParam("num2") int b)
    {
        //int a= Integer.parseInt(request.getParameter("num1"));
        //int b= Integer.parseInt(request.getParameter("num2"));

        ModelAndView mv= new ModelAndView();
        mv.setViewName("result");
        int c= a+b;
        mv.addObject("result",c);
        //session.setAttribute("result",c);

        return mv;
    }

    @RequestMapping("add_new_alien")
    public String add_new_alien(@ModelAttribute alien al, Model m)
    {
       // alien al= new alien();
        //al.setAlien_id(aid);
        //al.setAlien_name(name);
        assign_modeldata(m,al.getAlien_name());
        m.addAttribute("alien",al);
        return "result";
    }

    @GetMapping("allAliens")
    public String get_all_aliens(Model m)
    {
        List<alien> all_aliens= new ArrayList<>();
        all_aliens.add(new alien(2,"omm"));
        all_aliens.add(new alien(3,"tom"));
        all_aliens.add(new alien(4,"som"));

        m.addAttribute("result",repo.findAll());

        return "show_aliens";
    }

    @RequestMapping("getParticularAlien")
    public String get_the_alien(@RequestParam("alien_id") int aid,Model m)
    {
        m.addAttribute("result",repo.findById(aid));
        return "show_aliens";
    }

    @PostMapping("addAlien")
    public String add_alien(@ModelAttribute("result") alien al)
    {
        repo.save(al);
        return "result";
    }

    @GetMapping("getParticularAlienByName")
    public String get_alien_by_name(@RequestParam("alien_name") String alien_name, Model m)
    {
        m.addAttribute("result",repo.findByalien_name(alien_name));

        return "show_aliens";
    }
}
