package com.ay.kg.controller;

import com.ay.kg.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/appleyk/question")
public class QuestionController {

    @Autowired
    QuestionService questService;

    //http://localhost:8080/rest/appleyk/question/query?question=刘邦的年代是多少
    @RequestMapping("/query")
    public String query(@RequestParam(value = "question") String question) throws Exception {
        return questService.answer(question);
    }

}
