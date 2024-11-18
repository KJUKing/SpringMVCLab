package kr.or.ddit.props.controller;

import kr.or.ddit.props.exception.PersonNotFoundException;
import kr.or.ddit.props.service.PersonService;
import kr.or.ddit.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * 다건조회 : /props/personList.do(GET)
 * 단건조회 : /props/personDetail.do?who=a001(GET)
 * 등록 : /props/personInsert.do(GET, POST)
 * 수정 : /props/personUpdate.do?who=a001(GET, POST)
 * 삭제 : /props/personDelete.do?who=a001(GET)
 *
 * HCLC - High Cohesion Low Coupling
 */
@Controller
@RequestMapping("/props")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("personList.do")
    public String listHandler(Model model) {

        List<PersonVO> personList = service.readPersonList();
        model.addAttribute("personList", personList);
        return "props/personList";
    }

    @GetMapping("personDetail.do")
    public String detailHandler(@RequestParam(name = "who") String who, Model model) {
        try {
            if (!model.containsAttribute(PersonUpdateController.MODELNAME)) {
                PersonVO person = service.readPerson(who);
                model.addAttribute(PersonUpdateController.MODELNAME, person);
            }
            return "props/personDetail";
        }catch (PersonNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }

    }
}
