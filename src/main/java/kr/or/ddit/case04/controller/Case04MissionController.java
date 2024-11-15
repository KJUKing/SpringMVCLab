package kr.or.ddit.case04.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.http.MediaType.*;


/**
 * uri : /case04/mission
 * method : GET / PUT
 * response type
 * GET - (JSON, HTML)
 * PUT - (JSON)
 * - 모든 요청에 대해 공통 모델추가(now - 현재 시간)
 */
@RequestMapping("/case04/mission")
@Slf4j
@Controller
public class Case04MissionController {


    @ModelAttribute("now")
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

//    @ModelAttribute("nowDate")
//    public Date nowDate() {
//        return new Date();
//    }

    @GetMapping
    public String missionGet() {
        return "case04/mission";
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void missionPut() {
    }

}
