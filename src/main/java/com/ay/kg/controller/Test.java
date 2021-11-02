//package com.ay.kg.controller;
//
//import com.ay.kg.model.Node;
//
//import java.lang.reflect.Field;
//
//public class Test {
//    public static void main(String[] args) {
//
//        getFiledName(new Node());
//    }
//    /**
//     * 获取属性名数组
//     * */
//    private static String[] getFiledName(Object o){
//        Field[] fields=o.getClass().getDeclaredFields();
//        String[] fieldNames=new String[fields.length];
//        for(int i=0;i<fields.length;i++){
//            System.out.println("类型"+fields[i].getType());
//            System.out.println("名称="+fields[i].getName());
//            fieldNames[i]=fields[i].getName();
//        }
//        return fieldNames;
//    }
//
//}
