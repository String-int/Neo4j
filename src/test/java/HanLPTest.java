import com.ay.kg.core.CoreProcessor;
import com.ay.kg.util.CustomDictWordUtils;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import org.junit.Test;

import java.util.List;

public class HanLPTest {
    @Test
    public void Test(){
        String lineStr="刘邦的年代是多少";
        try{
            Segment segment= HanLP.newSegment();
            segment.enableCustomDictionary(true);
            /**
             * 自定义分词+词性
             */
//            CustomDictionary.add("好热","ng 0");
            List<Term> seg=segment.seg(lineStr);
            for (Term term:seg) {
                System.out.println(term.toString());
            }
        }catch (Exception e){
            System.out.println(e.getClass()+","+e.getMessage());
        }
    }


    @Test
    public void TestA(){
        String lineStr = "明天虽然会下雨，但是我还是会看周杰伦的演唱会。";
        customDict(lineStr,"虽然会","ng 0");
    }

    @Test
    public void TestB(){
        String lineStr = "刘邦是那个朝代的";
        customDict(lineStr,"朝代","ng 0");
    }

    private void customDict(String lineStr ,String word,String natureAndFrequency ) {
        try{
            Segment segment = HanLP.newSegment();
            segment.enableCustomDictionary(true);
            CustomDictWordUtils.setNatureAndFrequency(word,natureAndFrequency,true);
            List<Term> seg = segment.seg(lineStr);
            for (Term term : seg) {
                System.out.println(term.toString());
            }
        }catch(Exception ex){
            System.out.println(ex.getClass()+","+ex.getMessage());
        }
    }

    //---------------------------------------------------------------------------------------
    @Test
    public void TestC() throws Exception{
        CoreProcessor query = new CoreProcessor("D:/HanLP/data");
        String[] questionArr = new String[] {"卧虎藏龙的分数是多少"};
        for(String que: questionArr){
            List<String> question = query.analysis(que);
            System.err.println(question);
        }
    }
}
