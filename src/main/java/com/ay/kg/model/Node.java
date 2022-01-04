package com.ay.kg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    //节点的系统ID
    private Long nodeId;
    // label节点标签
    private String leftLabel;
    // 节点的关系
    private String leftType;
    //node_number 节点的UUID
    private String leftNodeNumber;
    //node_name 节点的名字
    private String leftNodeName;
    //gender 节点性别
    private String leftGender;
    //age 年代
    private String leftAge;
    //cover 图片
    private String leftCover;
    //intro 简介
    private String leftIntro;
    //opus_content 背景
    private String leftOpusContent;
    //category 类别
    private String leftCategory;
    //author作者
    private String leftAuthor;

    //function_category 功能
    private String leftFunctionCategory;
    //texture 质地
    private String leftTexture;
    //parent_age 上一级年代
    private String leftParentAge;
    //子节点
    private List<Node> nodes;

    public String[] str;

    private int num;

    public String[] getStr() {
        return str;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    public Node(String leftLabel) {
        this.leftLabel = leftLabel;
    }


    public Node(String leftLabel, String leftNodeName, String leftGender, String leftAge, String leftCategory, String leftAuthor) {
        this.leftLabel = leftLabel;
        this.leftNodeName = leftNodeName;
        this.leftGender = leftGender;
        this.leftAge = leftAge;
        this.leftCategory = leftCategory;
        this.leftAuthor = leftAuthor;
    }

    public Node(String leftLabel, String leftNodeName, String leftGender, String leftAge, String leftCover, String leftIntro, String leftOpusContent, String leftCategory, String leftAuthor) {
        this.leftLabel = leftLabel;
        this.leftNodeName = leftNodeName;
        this.leftGender = leftGender;
        this.leftAge = leftAge;
        this.leftCover = leftCover;
        this.leftIntro = leftIntro;
        this.leftOpusContent = leftOpusContent;
        this.leftCategory = leftCategory;
        this.leftAuthor = leftAuthor;
    }

    public Node(String leftLabel, String leftNodeNumber, String leftNodeName, String leftGender, String leftAge, String leftCover, String leftIntro, String leftOpusContent, String leftCategory, String leftAuthor, String leftFunctionCategory, String leftTexture, String leftParentAge, String rightLabel, String rightNodeName, String rightNodeNumber, String rightGender, String rightAge, String rightCover, String rightIntro, String rightOpusContent, String rightCategory, String rightAuthor, String rightFunctionCategory, String rightTexture, String rightParentAge) {
        this.leftLabel = leftLabel;
        this.leftNodeNumber = leftNodeNumber;
        this.leftNodeName = leftNodeName;
        this.leftGender = leftGender;
        this.leftAge = leftAge;
        this.leftCover = leftCover;
        this.leftIntro = leftIntro;
        this.leftOpusContent = leftOpusContent;
        this.leftCategory = leftCategory;
        this.leftAuthor = leftAuthor;
        this.leftFunctionCategory = leftFunctionCategory;
        this.leftTexture = leftTexture;
        this.leftParentAge = leftParentAge;
        this.rightLabel = rightLabel;
        this.rightNodeName = rightNodeName;
        this.rightNodeNumber = rightNodeNumber;
        this.rightGender = rightGender;
        this.rightAge = rightAge;
        this.rightCover = rightCover;
        this.rightIntro = rightIntro;
        this.rightOpusContent = rightOpusContent;
        this.rightCategory = rightCategory;
        this.rightAuthor = rightAuthor;
        this.rightFunctionCategory = rightFunctionCategory;
        this.rightTexture = rightTexture;
        this.rightParentAge = rightParentAge;
    }

    // label节点标签
    private String rightLabel;
    // 节点的关系
    private String righType;
    //node_name 节点的名字
    private String rightNodeName;
    //node_number 节点的UUID
    private String rightNodeNumber;
    //gender 节点性别
    private String rightGender;
    //age 年代
    private String rightAge;
    //cover 图片
    private String rightCover;
    //intro 简介
    private String rightIntro;
    //opus_content 背景
    private String rightOpusContent;
    //category 类别
    private String rightCategory;
    //author作者
    private String rightAuthor;

    //function_category 功能
    private String rightFunctionCategory;
    //texture 质地
    private String rightTexture;
    //parent_age 上一级年代
    private String rightParentAge;

}
