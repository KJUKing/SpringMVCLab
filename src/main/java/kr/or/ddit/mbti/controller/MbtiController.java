package kr.or.ddit.mbti.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import kr.or.ddit.mbti.service.MbtiService;
import kr.or.ddit.vo.MbtiVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * /mbti Get
 * /mbti/estj GET
 * /mbti POST
 * /mbti/{mtType} PUT
 * /mbti/{mtType} DELETE
 */

@RequestMapping(value = "/mbti", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
public class MbtiController {

    @Autowired
    private MbtiService service;

    @GetMapping
    public void list(Model model) {
        model.addAttribute("list", service.readMbtiList());
    }

    @GetMapping("{mtType}")
    public void single(@PathVariable String mtType, Model model) {
        try{
            if (!model.containsAttribute("mbti")) {
                model.addAttribute("mbti", service.readMbti(mtType));
            }
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @PostMapping
    public String insert(@ModelAttribute("mbti") MbtiVO mbti, RedirectAttributes redirectAttributes) {
        service.createMbti(mbti);
        redirectAttributes.addFlashAttribute("mbti", mbti);
        return "redirect:/mbti"+mbti.getMtType();
    }

    @PutMapping("{mtType}")
    public void update(@ModelAttribute("mbti") MbtiVO mbti, Model model) {
        service.modifyMbti(mbti);
        model.addAttribute("success", true);
    }

    @DeleteMapping("{mtType}")
    public void delete(@PathVariable String mtType, Model model) {
        service.removeMbti(mtType);
        model.addAttribute("success", true);
    }
}
