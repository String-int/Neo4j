package com.ay.kg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基于知识图谱的自问自答的查询接口
 * @author 3089759971@qq.com
 * @blob
 * @date   updated by 2021年12月28日-上午10:58:32
 */
@Mapper
public interface QuestionMapper {

    /**
     * 0 对应问题模板0 == nm(人) 年代
     *
     * @param nodeName
     * @return
     */
    String getCulturalRelicAge(@Param("nodeName") String nodeName);


    String getCulturalRelicTexture(@Param("nodeName") String nodeName);


}

