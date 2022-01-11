package com.ay.kg.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 基于知识图谱的自问自答的查询接口
 * @author 3089759971@qq.com
 * @blob
 * @date   updated by 2021年12月28日-上午10:58:32
 */
@Mapper
public interface QuestionMapper {
        /**
         * 0:nm 的年代
         * 1:nm 的材质
         * 2:nm 的功能
         * 3:nm 的级别
         * 4:nm 出土日期  x
         * 5:nm 的分类
         * 6:nm 简介
         * 7:nnt 事件
         * 8:nnt 的出生日期 x
         * 9:nnt 的儿子
         * 10:nnt 的子孙
         * 11:nnt 的妻子
         * 12:nnt 的年代
         * 13:nnt 简介
         */
    /**
     * 0 对应问题模板0 == nm(人) 年代
     *
     * 文物的年代
     * @param nodeName
     * @return
     */
    String getCulturalRelicAge(@Param("nodeName") String nodeName);

    /**
     * 文物的材质
     * @param nodeName
     * @return
     */
    String getCulturalRelicTexture(@Param("nodeName") String nodeName);

    /**
     * 文物的功能
     * @param nodeName
     * @return
     */
    String getCulturalRelicFunctionCategory(@Param("nodeName") String nodeName);
    /**
     * 文物的级别
     * @param nodeName
     * @return
     */
    String getCulturalRelicGrade(@Param("nodeName") String nodeName);
    /**
     * 文物的分类
     * @param nodeName
     * @return
     */
    String getCulturalRelicCategory(@Param("nodeName") String nodeName);
    /**
     * 文物的简介
     * @param nodeName
     * @return
     */
    String getCulturalRelicIntro(@Param("nodeName") String nodeName);

//*******************************************************************************************

    /**
     * 7:nnt 事件
     * 8:nnt 的出生日期 *****************
     * 9:nnt 的儿子
     * 10:nnt 的子孙
     * 11:nnt 的妻子
     * 12:nnt 的年代
     * 13:nnt 简介
     */
    /**
     * 人物的年代
     * @param nodeName
     * @return
     */
    String getPeopleAge(@Param("nodeName") String nodeName);

    /**
     * 人物的事件
     * @param nodeName
     * @return
     */
    List<String> getPeopleEvent(@Param("nodeName") String nodeName);

    /**
     * 人物的儿子
     * @param nodeName
     * @return
     */
    List<String> getPeopleSon(@Param("nodeName") String nodeName);

    /**
     * 人物的子孙
     * @param nodeName
     * @return
     */
    List<String> getPeopleDescendants(@Param("nodeName") String nodeName);

    /**
     * 人物的妻子
     * @param nodeName
     * @return
     */
    List<String> getPeopleWife(@Param("nodeName") String nodeName);
    /**
     * 人物的简介
     * @param nodeName
     * @return
     */
    String getPeopleIntro(@Param("nodeName") String nodeName);







}

