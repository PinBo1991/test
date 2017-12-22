package com.grt.WordSegment;

import java.util.HashMap;
import java.util.Map;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;

//使用word分词器,需要修改jvm的内存栈大小,不然很容易内存溢出
public class WordSegmentTest {

	public Map<String, String> segMore(String text) {
		Map<String, String> map = new HashMap<>();
		for (SegmentationAlgorithm segmentationAlgorithm : SegmentationAlgorithm.values()) {
			map.put(segmentationAlgorithm.getDes(), seg(text, segmentationAlgorithm));
		}
		return map;
	}

	private static String seg(String text, SegmentationAlgorithm segmentationAlgorithm) {
		StringBuilder result = new StringBuilder();
		for (Word word : WordSegmenter.segWithStopWords(text, segmentationAlgorithm)) {
			result.append(word.getText()).append(" ");
		}
		return result.toString();
	}
	
	/**
	 * 默认配置文件为类路径下的word.conf，打包在word-x.x.jar中
	 * 自定义配置文件为类路径下的word.local.conf，需要用户自己提供 如果自定义配置和默认配置相同，自定义配置会覆盖默认配置
	 * 配置文件编码为UTF-8
	 */
	public static void test1(String text){
		for (SegmentationAlgorithm segmentationAlgorithm : SegmentationAlgorithm.values()){
			System.out.println(segmentationAlgorithm.getDes());
//			for (Word word : WordSegmenter.seg(text, segmentationAlgorithm)) { //移除停用词
			for (Word word : WordSegmenter.segWithStopWords(text, segmentationAlgorithm)) { //保留停用词
				System.out.print(word.getText()+"-");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
//		String text = "杨尚川是apdplat应用级产品开发平台的作者";
		String text = "中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程";
		test1(text);
	}
}
