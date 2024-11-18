package kr.or.ddit.case07.controller;

import kr.or.ddit.case06.controller.DummyDTO;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.PersonVO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("case07/form2")
public class FormBindController2 {

    @ModelAttribute("person")
    public PersonVO person() {
        return new PersonVO();
    }

    @GetMapping
    //public String getHandler() { @ModelAttribute("person") PersonVO person 원래 이게붙어야하는데
    //위에 선언 때매 생략해도됨
    public String getHandler() {
        return "case07/form1";
    }

    @PostMapping
    public String postHandler(
            @Validated(InsertGroup.class) @ModelAttribute("person") PersonVO person
            , Errors errors
            , RedirectAttributes redirectAttributes
    ) {
        String errAttrName = BindingResult.MODEL_KEY_PREFIX + "person";
        redirectAttributes.addFlashAttribute("person", person);
        redirectAttributes.addFlashAttribute(errAttrName, errors);
        if (errors.hasErrors()) {
            return "redirect:/case07/form2";
        } else {
            return "redirect:/case07/result";
        }
    }
}
