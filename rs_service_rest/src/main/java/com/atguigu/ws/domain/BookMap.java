package com.atguigu.ws.domain;

import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
//json 格式原本就是hash结构,因此反馈set map类型数据时需要自定义包装类
@XmlRootElement 
public class BookMap {

	private Map<Integer,Book> map ;
	
	public Map<Integer,Book> getMap() {
		return map;
	}

	public void setMap(Map<Integer,Book> map) {
		this.map = map;
	}

	public BookMap(Map<Integer, Book> map) {
		super();
		this.map = map;
	}
	
	public BookMap() {
		super();
	}

	@Override
	public String toString() {
		return "MyMap [map=" + map + "]";
	}
	
}
