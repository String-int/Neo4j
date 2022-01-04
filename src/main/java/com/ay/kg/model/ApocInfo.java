package com.ay.kg.model;

import lombok.Data;

@Data
public class ApocInfo {
    /**
     * 导入的文件名
     */
    private String fileName;
    /**
     * 第一个标签名
     */
    private String leftLable;
    /**
     * 第二个标签名
     */
    private String rightLable;
    /**
     * 第一个便签Key
     */
    private String leftKey;
    /**
     * 第二个便签Key
     */
    private String rightKye;

}
