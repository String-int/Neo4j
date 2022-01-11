package com.ay.kg.config;


import com.ay.kg.util.CustomDictWordUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * <p>全局配启动 -- 初始化项目时，执行命令，将相关额外的自定义词典加载下</p>
 *
 * @author Appleyk
 * @version V.0.1.2
 * @blob https://blog.csdn.net/Appleyk
 * @date created on 21:25 2020/3/31
 */
@Component
public class ConfigRunner implements CommandLineRunner {

    @Value("${HanLP.CustomDictionary.path.culturalRelicDict}")
    private String culturalRelicDictPath;

    @Value("${HanLP.CustomDictionary.path.categoryDict}")
    private String categoryDictPath;

    @Value("${HanLP.CustomDictionary.path.peopleDict}")
    private String peopleDictPath;

    @Value("${HanLP.CustomDictionary.cache.path}")
    private String cacheDictPath;

    @Override
    public void run(String... args){

        //先删除缓存
        File file = new File(cacheDictPath);
        if(file.exists()){
            file.delete();
            System.out.println("CustomDictionary.txt.bin delete success .");
        }

        /**加载自定义的【文物】字典 == 设置词性 nm 0*/
        loadDict(culturalRelicDictPath,0);
        /**加载自定义的【类型】字典 == 设置词性 ng 0*/
        loadDict(categoryDictPath,1);
        /**加载自定义的【人物】字典 == 设置词性 x 0*/
        loadDict(peopleDictPath,2);

    }

    /**
     * 加载自定义词性字典
     * @param path 字典路径
     * @param type 类型
     */
    public void loadDict(String path,Integer type) {
        File file = new File(path);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            addCustomDictionary(br, type);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }


    /**
     * 添加自定义分词及其词性，注意数字0表示频率，不能没有
     *
     * @param br 字节流（读）
     * @param type 字典类型
     */
    public void addCustomDictionary(BufferedReader br, int type) {

        String word;
        try {
            while ((word = br.readLine()) != null) {
                switch (type) {
                    /**设置文物名词词性 == nm 0*/
                    case 0:
                        CustomDictWordUtils.setNatureAndFrequency(word,"nm 0",true);
                        break;
                    /**设置人物类型名词 词性 == nnt 0*/
                    case 1:
                        CustomDictWordUtils.setNatureAndFrequency(word,"nnt 0",true);
                        break;
                    /**设置人物名词 词性 == nnt 0*/
//                    case 2:
//                        CustomDictWordUtils.setNatureAndFrequency(word,"x 0",true);
//                        break;
                    default:
                        break;
                }
            }
            br.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
