package kr.or.ddit.case07.controller;

import kr.or.ddit.case06.controller.DummyDTO;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.PersonVO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("case07/form1")
public class FormBindController1 {

    /**
     * form:form 커스텀 태그에서 modelAttribute라는 필수 속성으로 전달된 모델명을 설정해야함.
     *
     * @return
     */
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

    /**
     * submit된 form-data는 command object로 바인드되고,
     * @ModelAttribute를 이용해 request scope 속성명을 결정함.
     * 1. 검증 대상이 되는 command object 앞에 @Valid / @Validated(group hint) 사용
     * 2(*). 검증 대상이 되는 command object 다음에 Errors / BindingResult를 선언해 검증 결과를 수신함.
     * 3. hasErrors를통해 검증 통과 여부 확인 후 처리
     *
     * @param person
     * @param errors
     * @param redirectAttributes
     * @return
     */
    @PostMapping

    public String postHandler(
            @Validated(InsertGroup.class) @ModelAttribute("person") PersonVO person
            , Errors errors
            , @Validated(InsertGroup.class)@ModelAttribute("dummy")DummyDTO dummy
            , Errors errors1 //이런식으로 밸리데이트다음에 에러를붙혀야함 키값쌍같이
            , RedirectAttributes redirectAttributes
    ) {
        if (errors.hasErrors()) {

            return "case07/form1";
        } else {
            redirectAttributes.addFlashAttribute("person", person);
            return "redirect:/case07/result";
        }
    }
}
