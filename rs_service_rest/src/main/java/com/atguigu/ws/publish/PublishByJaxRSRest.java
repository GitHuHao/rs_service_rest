package com.atguigu.ws.publish;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.atguigu.ws.service.RestBookService;

public class PublishByJaxRSRest {

	protected static Logger logger = Logger.getLogger(PublishByJaxRSRest.class);
	// 注Endpoint只能发布WS 不能发布RS,且不能使用Endpoint发布,发布Map类型时,需要自定义包装类
	public static void main(String[] args) {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext4HandlyPublish.xml");
		
		RestBookService bookService = (RestBookService)ioc.getBean("restBookService");
		System.out.println(bookService);
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		String address ="http://pc201608140721:8080/ws_service/BookService_WS" ;
		factory.setAddress(address);
		factory.setServiceBean(bookService);
		
		Server server = factory.create();
		server.start();
		
		logger.info(address+"  发布成功!");
	}
	
}
