package kr.or.ddit.case06.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/case06")
@Slf4j
@Controller
public class ReceiveRequestParameterController {

    @RequestMapping("parameter5")
    public void handler5(
            @ModelAttribute("dummy") DummyDTO dummy
    ){
    }

    @RequestMapping("parameter4")
    public void handler4(
            @RequestParam MultiValueMap<String, String> params
            ,Model model
    ){
        params.forEach((n, vs)-> log.info("{} : {}", n, vs));
        model.addAllAttributes(params);
    }


    @RequestMapping("parameter3")
    public void handler3(
            @RequestParam(required = false, defaultValue = "DEFAULT") String who,
            @RequestParam(required = false, defaultValue = "-1") int number,
            Optional<Double> dbNumber,
            Model model) {

        log.info("who : {}", who);
        log.info("number : {}", number);
        model.addAttribute("who-prop", who);
    }


    @RequestMapping("parameter2")
    public void handler2(@RequestParam(required = true) String who, Model model){
        log.info("who : {}", who);
        model.addAttribute("who-prop", who);
    }

    // who필수파라미터를 받고싶음. 누락시 400에러발생
    @RequestMapping("parameter1")
    public void handler1(HttpServletRequest req, HttpServletResponse resp, Model model) throws IOException {

        String who = req.getParameter("who");
        if (StringUtils.isBlank(who)) {
            resp.sendError(400);
            return;
        }
        log.info("who : {}", who);
        model.addAttribute("who-prop", who);
    }
}
