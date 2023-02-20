package com.codeup.codeupspringblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.Path;

@Controller
public class MathController {

//    ******** Add two nums *********
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        return  "<h1>" + "The numbers you added equal: " + (num1 + num2) + "</h1>";
    }

//    ******** Subtract two nums *********
    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2){
        return "<h1>" + "The difference between the two numbers is: " + (num1 - num2) + "</h1>";
    }

//    ******** Multiply two nums *********
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2){
        return "<h1>" + "The product of the two numbers is: " + (num1 * num2) + "</h1>";
    }

    //    ******** Divide two nums *********
    @GetMapping("/divide/{num1}/and/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2){
        return "<h1>" + "The division of the two numbers is: " + (num1 / num2) + "</h1>";
    }

}
