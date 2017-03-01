package ldsbc.springboot.controller;

import javax.validation.Valid;

import ldsbc.springboot.form.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Home {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Post post) {
        return "index"; // index is the page name
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addNewPost(@Valid Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        // do work here ie. sort
        model.addAttribute("post", post);
        return "result";
    }
}
