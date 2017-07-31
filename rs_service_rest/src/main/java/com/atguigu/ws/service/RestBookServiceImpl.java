package com.atguigu.ws.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atguigu.ws.domain.Book;
import com.atguigu.ws.domain.BookMap;
import com.atguigu.ws.mapper.BookMapper;

/**
 * Restful 风格WebService 编码,要求Entity上必须标记@XmlRootEmelent
 * @author Administrator
 *
 */
@Service("restBookService")@Transactional
public class RestBookServiceImpl implements RestBookService {
	
	@Autowired
	private BookMapper bookMapper;
	
	@POST@Path("/save")@Produces("text/plain")@Consumes(value={"application/json","application/xml"})
	public boolean save(@PathParam("book")Book book) {
		try{
			bookMapper.save(book);
			System.out.println("ws-server: save()");
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@DELETE@Path("/detete/{id}")@Produces("text/plain")
	public boolean delete(@PathParam("id")int id) {
		try{
			bookMapper.delete(id);
			System.out.println("ws-server: delete()");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	@PUT@Path("/update/{id}")@Produces("text/plain")@Consumes(value={"application/json","application/xml"})
	public boolean update(@PathParam("book") Book book) {
		try{
			bookMapper.update(book);
			System.out.println("ws-server: update()");
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@GET@Path("/getById/{id}")@Produces(value={"application/json","application/xml"})
	public Book getById(@PathParam("id")int id) {
		System.out.println("ws-server: getById()");
		return bookMapper.getById(id);
	}

	@GET@Path("/getList")@Produces(value={"application/json","application/xml"})
	public List<Book> getAll() {
		return bookMapper.getAll();
	}

	@GET@Path("/getMap")@Produces(value={"application/json","application/xml"})
	public BookMap getMap() {
		Map<Integer,Book> map = new HashMap<>();
		List<Book> books = bookMapper.getAll();
		Map<Integer,Book> tempMap = new HashMap<>();
		for(Book book:books){
			tempMap.put(book.getId(), book);
		}
		BookMap myMap = new BookMap(tempMap);
		System.out.println("ws-server: getMap()");
	    return myMap;
	}
//	@WebMethod(exclude=true) //如果使用setter注入,必须使用前面的注解,即,将次方法排除在发布之外
//	public void setBookMapper(BookMapper bookMapper) {
//		this.bookMapper = bookMapper;
//	}
}
