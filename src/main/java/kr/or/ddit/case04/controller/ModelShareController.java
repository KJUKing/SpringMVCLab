package kr.or.ddit.case04.controller;

import kr.or.ddit.vo.MbtiVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/case04")
public class ModelShareController {

    @ModelAttribute("info")
    public String info() {
        return "주방에서 만든 모델";
    }

    @RequestMapping("model5")
    public String handler5(MbtiVO mbti) {
        return "case04/view1";
    }

    @RequestMapping("model4")
    public String handler4() {
        return "case04/view1";
    }

    @RequestMapping("model3")
    public ModelAndView handler3() {
        ModelAndView mav = new ModelAndView();
        String info = "주방에서 만든 모델";
        mav.addObject("info2", info);
        mav.setViewName("case04/view1");
        return mav;
    }

    @RequestMapping("model2")
    public String handler2(Model model) {
        String info = "주방에서 만든 모델";
        model.addAttribute("info", info);
        return "case04/view1";
    }

    @RequestMapping("model1")
    public String handler1(HttpServletRequest req) {
        String info = "주방에서 만든 모델";
        req.setAttribute("info", info);
        return "case04/view1";
    }
}
