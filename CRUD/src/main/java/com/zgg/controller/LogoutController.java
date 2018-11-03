package com.zgg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * zgg
 * 2018/10/30 20:34
 */
@Controller
public class LogoutController {
@GetMapping("/logout")
public String logout(){
    return "redirect:/index";

}
}
