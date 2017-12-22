package com.grt.AnsjSeg;

import java.util.HashMap;
import java.util.Map;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

public class AnsjSegTest {
	public static Map<String, String> segMore(String text) {
		Map<String, String> map = new HashMap<>();
		StringBuilder result = new StringBuilder();
		for (Term term : BaseAnalysis.parse(text)) {
			result.append(term.getName()).append(" ");
		}
		map.put("BaseAnalysis", result.toString());
		result.setLength(0);
		for (Term term : ToAnalysis.parse(text)) {
			result.append(term.getName()).append(" ");
		}
		map.put("ToAnalysis", result.toString());
		result.setLength(0);
		for (Term term : NlpAnalysis.parse(text)) {
			result.append(term.getName()).append(" ");
		}
		map.put("NlpAnalysis", result.toString());
		result.setLength(0);
		for (Term term : IndexAnalysis.parse(text)) {
			result.append(term.getName()).append(" ");
		}
		map.put("IndexAnalysis", result.toString());
		return map;
	}

	// BaseAnalysis
	public static void test1(String text) {
		for (Term term : BaseAnalysis.parse(text)) {
			System.out.print(term.getName() + "-");
		}
		System.out.println();
	}

	// ToAnalysis
	public static void test2(String text) {
		for (Term term : ToAnalysis.parse(text)) {
			System.out.print(term.getName() + "-");
		}
		System.out.println();
	}

	// NlpAnalysis
	public static void test3(String text) {
		for (Term term : NlpAnalysis.parse(text)) {
			System.out.print(term.getName() + "-");
		}
		System.out.println();
	}

	// IndexAnalysis
	public static void test4(String text) {
		for (Term term : IndexAnalysis.parse(text)) {
			System.out.print(term.getName() + "-");
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		String text = "杨尚川是apdplat应用级产品开发平台的作者";
//		String text = "文本内容以词库中任选20词拼成的句子，每词大约3字，一句大约60字，总数据量为2000W条数据";
		String text = "中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程";
		test1(text);
		test2(text);
		test3(text);
		test4(text);
	}

}
