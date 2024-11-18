package kr.or.ddit.case07.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("case07/result")
public class FormBindResultController {


    @GetMapping
    public String result() {
        return "case07/result";
    }
}
