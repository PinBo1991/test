package com.grt.MMSeg4j;

import java.io.IOException;
import java.io.StringReader;

import com.chenlb.mmseg4j.ComplexSeg;
import com.chenlb.mmseg4j.Dictionary;
import com.chenlb.mmseg4j.MMSeg;
import com.chenlb.mmseg4j.MaxWordSeg;
import com.chenlb.mmseg4j.Seg;
import com.chenlb.mmseg4j.SimpleSeg;
import com.chenlb.mmseg4j.Word;

public class MMSeg4jTest {
	private static final Dictionary DIC = Dictionary.getInstance();
	private static final SimpleSeg SIMPLE_SEG = new SimpleSeg(DIC);
	private static final ComplexSeg COMPLEX_SEG = new ComplexSeg(DIC);
	private static final MaxWordSeg MAX_WORD_SEG = new MaxWordSeg(DIC);

	public static void test(String text, Seg seg) {
		System.out.println(seg.getClass().getName());
		MMSeg mmSeg = new MMSeg(new StringReader(text), seg);
		try {
			Word word = null;
			while ((word = mmSeg.next()) != null) {
				System.out.print(word.getString() + "-");
			}
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		String text = "中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程";
		test(text,SIMPLE_SEG);
		test(text,COMPLEX_SEG);
		test(text,MAX_WORD_SEG);
	}
	
	
}
