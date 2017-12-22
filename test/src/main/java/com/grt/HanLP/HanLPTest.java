package com.grt.HanLP;

import java.util.List;

import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Viterbi.ViterbiSegment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.TraditionalChineseTokenizer;

public class HanLPTest {
	//NLP分词: NLPTokenizer 会执行全部命名实体识别和词性标注
	public static void test1(String str){
		List<Term> termList = NLPTokenizer.segment(str);
		System.out.println(termList);
	}
	//索引分词:IndexTokenizer 是面向搜索引擎的分词器，能够对长词全切分，另外通过 term.offset 可以获取单词在文本中的偏移量
	public static void test2(String str){
		List<Term> termList = IndexTokenizer.segment(str);
		for (Term term : termList) {
		    System.out.println(term + " [" + term.offset + ":" + (term.offset + term.word.length()) + "]");
		}
	}
	//繁体分词 :TraditionalChineseTokenizer 可以直接对繁体进行分词，输出切分后的繁体词语
	public static void test3(String str){
		List<Term> termList = TraditionalChineseTokenizer.segment(str);
		System.out.println(termList);
	}
	//极速分词:是词典最长分词，速度极其快，精度一般
	public static void test4(String str){
		System.out.println(SpeedTokenizer.segment(str));
		long start = System.currentTimeMillis();
		int pressure = 1000000;
		for (int i = 0; i < pressure; ++i) {
		    SpeedTokenizer.segment(str);
		}
		double costTime = (System.currentTimeMillis() - start) / (double)1000;
		System.out.printf("分词速度：%.2f字每秒", str.length() * pressure / costTime);
	}
	//N最短路分词器 :NShortSegment 比最短路分词器( DijkstraSegment )慢，但是效果稍微好一些，对命名实体识别能力更强
	public static void test5(String str){
		Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
		Segment shortestSegment = new ViterbiSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
		String[] testCase = new String[]{str,};
		for (String sentence : testCase) {
		    System.out.println("N-最短分词：" + nShortSegment.seg(sentence) + "\n最短路分词：" + shortestSegment.seg(sentence));
		}
	}
	
	public static void main(String[] args) {
		
		String str = "中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程";
//		String str = "结合成分子";
//		String str = "大衛貝克漢不僅僅是名著名球員，球場以外，其妻為前辣妹合唱團成員維多利亞·碧咸，亦由於他擁有突出外表、百變髮型及正面的形象，以至自己品牌的男士香水等商品，及長期擔任運動品牌Adidas的代言人，因此對大眾傳播媒介和時尚界等方面都具很大的影響力，在足球圈外所獲得的認受程度可謂前所未見。";
//		String str = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
//		String str = "刘喜杰石国祥会见吴亚琴先进事迹报告团成员";
//		String str = "文本内容以词库中任选20词拼成的句子，每词大约3字，一句大约60字，总数据量为2000W条数据";
		
		test1(str);
		test2(str);
		test3(str);
		test4(str);
		test5(str);
	}
}
