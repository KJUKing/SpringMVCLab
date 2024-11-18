package kr.or.ddit.props.controller;

import kr.or.ddit.props.service.PersonService;
import kr.or.ddit.props.service.PersonServiceImpl;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.PersonVO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static sun.security.util.KeyUtil.validate;

//@WebServlet("/props/personUpdate.do")
@Controller
@RequestMapping("/props/personUpdate.do")
public class PersonUpdateController {

    public static final String MODELNAME = "person";
    @Autowired
    private PersonService service;

    @PostMapping
    public String doPost(@Validated(UpdateGroup.class) @ModelAttribute("person") PersonVO person
                         , Errors errors
                         , RedirectAttributes redirectAttributes

    ) {
        boolean valid = !errors.hasErrors();
        if (valid) {
            boolean result = service.modifyPerson(person);
            if (result) {
                return "redirect:/props/personDetail.do?who=" + person.getId();
            } else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류인듯");
            }
        } else {
            //기존 입력데이터 전달
            redirectAttributes.addFlashAttribute(MODELNAME, person);
            // 검증 결과 전달
            String errAttrName = BindingResult.MODEL_KEY_PREFIX + MODELNAME;
            redirectAttributes.addFlashAttribute(errAttrName, errors);
            return "redirect:/props/personDetail.do?who=" + person.getId();
        }
    }
}
