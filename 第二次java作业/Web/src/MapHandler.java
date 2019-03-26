import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MapHandler extends DefaultHandler {
	private static Map<String, String> map = new HashMap<String, String>();
	static String clz_method = "";
	static String url = "";
	private String tag;// 标签名

	public static Map<String, String> getMap() {
		return map;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (null != qName) {
			tag = qName; // 储存操作标签
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if (null != tag) { // 处理了空
			if (tag.equals("url")) {
				url = contents;
			} else if (tag.equals("class-method")) {
				clz_method = contents;
			}

		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (clz_method != "" && url != "") {
			map.put(url, clz_method);
			clz_method = "";
			url = "";
		}
		tag = null; // 丢弃tag
	}

	public Map<String, String> Start() {
		// SAX解析
		// 1、获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2、从解析工厂获取解析器
		SAXParser parse = null;
		try {
			parse = factory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e2) {
			e2.printStackTrace();
		}
		// 3、编写处理器
		// 4、加载文档Document注册处理器
		MapHandler handler = new MapHandler();
		// 5、解析
		try {
			parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("map.xml"), handler);
		} catch (SAXException | IOException e2) {
			e2.printStackTrace();
		}
		// System.out.println("handler-->" + map);
		return map;
	}
}
