package com.grt.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class IKAnalyzerTest {

	public static void test(String text, boolean useSmart) {
		IKSegmenter ik = new IKSegmenter(new StringReader(text), useSmart);
		try {
			Lexeme word = null;
			while ((word = ik.next()) != null) {
				System.out.print(word.getLexemeText() + "-");
			}
			System.out.println();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public static void main(String[] args) {
		String text = "中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程";
		test(text,true);//智能切分
		test(text,false);//细粒度切分
	}
	
}
