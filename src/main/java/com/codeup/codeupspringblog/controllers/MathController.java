package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Random;

@Controller
public class MathController {

    //    ******** Add two nums *********
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        return "<h1>" + "The numbers you added equal: " + (num1 + num2) + "</h1>";
    }

    //    ******** Subtract two nums *********
    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2) {
        return "<h1>" + "The difference between the two numbers is: " + (num1 - num2) + "</h1>";
    }

    //    ******** Multiply two nums *********
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        return "<h1>" + "The product of the two numbers is: " + (num1 * num2) + "</h1>";
    }

    //    ******** Divide two nums *********
    @GetMapping("/divide/{num1}/and/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2) {
        return "<h1>" + "The division of the two numbers is: " + (num1 / num2) + "</h1>";
    }

    //    ****** Roll Dice Method *******
    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{numGuessed}")
    public String joinCohort(@PathVariable int numGuessed, Model model) {
        model.addAttribute("numGuessed", numGuessed);
        int answer = new Random().nextInt(6) + 1;
        model.addAttribute("answer", answer);
        if (numGuessed == answer) {
            model.addAttribute("correctGuess", true);
        } else {
            model.addAttribute("incorrectGuess", true);
        }
        return "roll-dice";
    }

}
