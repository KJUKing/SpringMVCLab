package kr.or.ddit.case08_09.controller;

import kr.or.ddit.case06.controller.DummyDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(value = "/case08_09"
        , produces = MediaType.APPLICATION_JSON_VALUE // accept에 json요청아니면 안받겠다
        , consumes = MediaType.APPLICATION_JSON_VALUE) // content body에 json요청없으면 안받겠다

public class JsonConverterController {

    @PostMapping("json5")
    @ResponseBody
    public DummyDTO handler5( @RequestBody DummyDTO dummy) {
        log.info("dummy insert : {}", dummy);

        dummy.setPk("insert로 생성한 primary Key");
        dummy.setNow(LocalDateTime.now());
        return dummy;
    }

    @PostMapping("json4")
    @ResponseBody
    public Map<String, Object> handler4( @RequestBody DummyDTO dummy) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("success", true);
        json.put("message", "요청 처리 성공");
        return json;
    }

    // RequestBody를 쓸때는 json Payload를 리퀘스트로 받을때 사용함
    @PostMapping("json3") // ModelAttribute란 뒤에 들어갈 모델명을 미리 명명하는것
    public void handler3(@RequestBody DummyDTO dummy, Model model) {

        log.info("dummyDTO : {} ", dummy);

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("success", true);
        json.put("message", "요청 처리 성공");
        model.addAllAttributes(json);
        model.addAttribute("dummy", dummy);
    }

    // ModelAttribute를 쓸때는 폼데이터나 멀티파티를 리퀘스트로 받을때
@PostMapping("json2") // ModelAttribute란 뒤에 들어갈 모델명을 미리 명명하는것
    public void handler2(@ModelAttribute("dummy") DummyDTO dummy, Model model) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("success", true);
        json.put("message", "요청 처리 성공");
        model.addAllAttributes(json);
    }

   @PostMapping("json1") // ModelAttribute란 뒤에 들어갈 모델명을 미리 명명하는것
    @ResponseBody
    public Map<String, Object> handler1(@ModelAttribute("dummy") DummyDTO dummy) {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("success", true);
        json.put("message", "요청 처리 성공");
        return json;
    }


}
