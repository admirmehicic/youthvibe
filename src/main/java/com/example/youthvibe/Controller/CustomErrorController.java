package com.example.youthvibe.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

   @RequestMapping("/error")
    public String handleError() {
        // Return the error view name
        return "error"; // Make sure error.html exists in src/main/resources/templates
    }


}
