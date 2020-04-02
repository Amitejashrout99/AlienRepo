package com.hp.springbootmvc.springbootmvcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class alienController
{

    @Autowired
    alienrepo repo;


    @GetMapping(path="Aliens",produces = {"application/json"})
    @ResponseBody
    public List<alien> get_all_aliens()
    {
        /*List<alien> all_aliens= new ArrayList<>();
        all_aliens.add(new alien(2,"omm"));
        all_aliens.add(new alien(3,"tom"));
        all_aliens.add(new alien(4,"som"));*/

        //m.addAttribute("result",repo.findAll());
        List<alien> all_aliens= repo.findAll();

        return all_aliens;

        //return "show_aliens";
    }

    @GetMapping("Aliens/{aid}")
    @ResponseBody
    public alien get_alien(@PathVariable("aid") int aid)
    {
        alien al= repo.findById(aid).orElse(new alien(0,""));
        return al;
    }

    @PostMapping(path="Aliens",consumes = {"application/json"})
    @ResponseBody
    public alien add_alien( @RequestBody alien al)
    {
        repo.save(al);
        return al;
    }
}
