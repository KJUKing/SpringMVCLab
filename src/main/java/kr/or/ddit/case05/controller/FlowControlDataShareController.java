package kr.or.ddit.case05.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/case05")
public class FlowControlDataShareController {


    @RequestMapping("start02")
    public String start02(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("info", "start02에서 만든모델");

        log.info("start02 에서 요청 접수");
        return "redirect:/case05/dest02";
    }

//    RedirectAttributes flash attribute -> Flash Map으로 이동 ->
//    redirect이후 새로운 요청이 발생하면 , flash map --> Model로 이동

    @RequestMapping("dest02")
    public String dest02(Model model) {

        log.info("dest02 으로 요청을 분기 {}", model.getAttribute("info"));
        return "case05/view1";
    }

    @RequestMapping("start01")
    public String start01(Model model) {
        model.addAttribute("info", "start01에서 만든모델");
        log.info("start01 에서 요청 접수");
        return "forward:/case05/dest01";
    }

    @RequestMapping("dest01")
    public String dest01(@RequestAttribute String info) {

        log.info("dest01 으로 요청을 분기, model : {}" , info);
        return "case05/view1";
    }
}
