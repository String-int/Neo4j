package com.ay.kg.service.impl;


import com.ay.kg.core.CoreProcessor;
import com.ay.kg.mapper.QuestionMapper;
import com.ay.kg.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;


/**
 * <p>核心问答业务实现类</p>
 *
 * @author Appleyk
 * @version V.0.1.2
 * @blob https://blog.csdn.net/Appleyk
 * @date updated on 21:21 2020/3/31
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired(required = false)
    private CoreProcessor queryProcess;

    @Override
    public String answer(String question) throws Exception {

        List<String> reStrings = queryProcess.analysis(question);
        int modelIndex = Integer.valueOf(reStrings.get(0));
        String answer =null;
        String title;
        String name;

        /**匹配问题模板*/
        switch (modelIndex) {
            case 0:
                title = reStrings.get(1);
                answer = questionMapper.getCulturalRelicAge(title);
                break;
            case 1:
                title = reStrings.get(1);
                answer = questionMapper.getCulturalRelicTexture(title);
                break;
            default:
                break;
        }
        System.out.println(answer);
        if (answer != null && !"".equals(answer) && !("\\N").equals(answer)) {
            return answer;
        } else {
            return "sorry,小主,我没有找到你要的答案";
        }
    }


}
