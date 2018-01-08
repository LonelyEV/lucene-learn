package onem.quzhigang.lucene.analyzer;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 * 
 * @author 屈志刚
 * 2018年1月8日
 * TODO 测试标准分词器
 */
public class StdAnalyzer {
	
	private static String strCh = "lucene 分词器";
	
	private static String strEn = "lucene 分词器";
	
	
	public static void main(String[] args) {
		try {
			stdAnalyzer(strCh);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void stdAnalyzer(String str) throws IOException{
		
		Analyzer analyzer = null;
		analyzer = new StandardAnalyzer();
		
		StringReader reader = new StringReader(str);
		TokenStream toStram = analyzer.tokenStream(str, reader);
		
		toStram.reset();
		
		CharTermAttribute teAttribute = toStram.getAttribute(CharTermAttribute.class);
		
		System.out.println("分词结果：");
		
		while (toStram.incrementToken()) {
			System.out.print(teAttribute.toString()+"|");
		}
		
		System.out.println("\n");
		
		analyzer.close();
		
	}
	
	

}
