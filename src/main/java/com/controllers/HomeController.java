package com.controllers;

import com.entities.Todo;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ServletContext context;

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("inside controller!!");

        String str = "home";
        model.addAttribute("curpage", str);

        List<Todo> list = (List<Todo>) context.getAttribute("list");
        model.addAttribute("todos", list);

        System.out.println(model);
        return "home";
    }

    @RequestMapping("/add")
    public String add(Model m) {

        Todo t = new Todo();
        //t.setTodoTitle("First todo here");
        String str = "add";
        m.addAttribute("curpage", str);
        m.addAttribute("todo", t);
        return "home";
    }

    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("todo") Todo todo, BindingResult result, Model m) {
        System.out.println(todo);

        if (result.hasErrors()) {
            System.out.println("Error page display!!");
            m.addAttribute("todo", todo);
            m.addAttribute("curpage", "add");
            System.out.println("printing model before passing to error page ");
            System.out.println(m);
            return "home";
        }

        todo.setTodoDate(new Date());
        System.out.println("here todo: "+ todo);
        System.out.println("here model is: "+ m);
        List<Todo> list = (List<Todo>) context.getAttribute("list");
        list.add(todo);
        m.addAttribute("msg", "To do added successfully");
        System.out.println("here updated model is: "+ m);
        return "home";
    }
}
