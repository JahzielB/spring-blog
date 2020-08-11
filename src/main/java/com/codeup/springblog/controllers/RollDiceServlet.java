package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RollDiceServlet{
    @GetMapping("/roll-dice")
    public String showRollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{roll}")
    @ResponseBody
    public String sayHello(@PathVariable int roll) {
        int random = (int) (Math.random() * (6 - 1 + 1) + 1);
        if (roll == random) {
            return "You guessed: " + roll + "<br>" + "The dice landed on: " + random + "<br>" + "Congrats!";
        } else {
            return "You guessed: " + roll + "<br>" + "The dice landed on: " + random + "<br>" + "Sorry";
        }
    }
}
