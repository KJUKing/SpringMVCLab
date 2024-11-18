package kr.or.ddit.props.controller;

import kr.or.ddit.props.service.PersonService;
import kr.or.ddit.props.service.PersonServiceImpl;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.PersonVO;
import org.apache.commons.collections.functors.PredicateDecorator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 새로운 person을 등록하고 나면,
 * 갱신된 list를 조회함.
 * 직전에 새로 등록된 person의 tr태그에 배경색을 입힐것.
 */
@Controller
@RequestMapping("/props/personInsert.do")
public class PersonInsertController {

    @Autowired
    private PersonService service;
    public static final String MODELNAME = "person";
    @ModelAttribute(MODELNAME)
    public PersonVO person() {
        return new PersonVO();
    }


    @GetMapping
    public String personInsertForm() {
        return "props/personForm";
    }

    @PostMapping
    public String insertHandler(
            @Validated(InsertGroup.class) @ModelAttribute(MODELNAME) PersonVO person,
            Errors errors,
            RedirectAttributes redirectAttributes) {

        boolean valid = !errors.hasErrors();
        if (valid) {
            boolean result = service.createPerson(person);
            if (result) {
                redirectAttributes.addFlashAttribute("newPerson", person);
                return "redirect:/props/personList.do";
            } else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류인듯");
            }

        } else{
            //기존 입력데이터 전달

            redirectAttributes.addFlashAttribute(MODELNAME, person);
            // 검증 결과 전달
            String errAttrName = BindingResult.MODEL_KEY_PREFIX + MODELNAME;
            redirectAttributes.addFlashAttribute(errAttrName, errors);
            return "redirect:/props/personInsert.do";
        }
    }

}





