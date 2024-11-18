package kr.or.ddit.mbti.controller;

import kr.or.ddit.mbti.service.MbtiService;
import kr.or.ddit.vo.MbtiVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * /mbti Get
 * /mbti/estj GET
 * /mbti POST
 * /mbti/{mtType} PUT
 * /mbti/{mtType} DELETE
 */

@RequestMapping(value = "/mbti"
        , produces = MediaType.APPLICATION_JSON_VALUE
        , consumes = MediaType.APPLICATION_JSON_VALUE
)
@Controller
public class MbtiController {

    @Autowired
    private MbtiService service;

    @GetMapping
    @ResponseBody
    public List<MbtiVO> list() {
        return service.readMbtiList();
    }

    @GetMapping("{mtType}")
    @ResponseBody
    public MbtiVO single(@PathVariable String mtType, Model model) {
        try{
//            model.addAttribute("message", "요청처리성공");
            if (!model.containsAttribute("mbti")) {
                return service.readMbti(mtType);
            } else {
                return (MbtiVO) model.getAttribute("mbti");
            }
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insert(@RequestBody MbtiVO mbti, RedirectAttributes redirectAttributes) {
        service.createMbti(mbti);
        redirectAttributes.addFlashAttribute("mbti", mbti);
        return "redirect:/mbti"+mbti.getMtType();
    }

    @PutMapping(value = "{mtType}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody MbtiVO mbti, Model model) {
        service.modifyMbti(mbti);
        model.addAttribute("success", true);
        model.addAttribute("mbti", mbti);
    }

    @DeleteMapping("{mtType}")
    public void delete(@PathVariable String mtType, Model model) {
        service.removeMbti(mtType);
        model.addAttribute("success", true);
    }
}
