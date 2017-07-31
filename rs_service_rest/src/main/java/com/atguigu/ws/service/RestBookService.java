package com.atguigu.ws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.atguigu.ws.domain.Book;
import com.atguigu.ws.domain.BookMap;

@Path("/book")
public interface RestBookService {
	
	@POST@Path("/save")@Produces("text/plain")@Consumes(value={"application/json","application/xml"})
	boolean save(Book book);
	
	@DELETE@Path("/detete/{id}")@Produces("text/plain")
	boolean delete(int id);
	
	@PUT@Path("/update/{id}")@Produces("text/plain")@Consumes(value={"application/json","application/xml"})
	boolean update(Book book);
	
	@GET@Path("/getById/{id}")@Produces(value={"application/json","application/xml"})
	Book getById(int id);
	
	@GET@Path("/getList")@Produces(value={"application/json","application/xml"})
	List<Book> getAll();
	
	@GET@Path("/getMap")@Produces(value={"application/json","application/xml"})
	BookMap getMap();
}
