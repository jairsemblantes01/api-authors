package com.distribuida.rest;

import com.distribuida.db.Author;
import com.distribuida.entity.AuthorEntity;
import com.distribuida.servicios.AuthorService;
import org.jboss.logging.annotations.Param;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/authors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
	public class AuthorsRest {
	@Inject
	AuthorService authorService;
	@GET
	public List<Author> get() { return authorService.getAll();}
	@POST
	public AuthorEntity create(Author author){
		try {
			AuthorEntity authorEntity = authorService.pushAuthor(author);
			return authorEntity;
		} catch (Exception err) {
			System.out.println(err);
		}
		return null;
	}
	
	@PUT
	@Path("{id}")
	public AuthorEntity update(@PathParam("id") Long id, Author author){
		try {
			AuthorEntity authorEntity = authorService.editAuthor(id, author);
			return authorEntity;
		} catch (Exception err) {
			System.out.println(err);
			return null;
		}
	}
	@GET
	@Path("{id}")
	public AuthorEntity getbyId(@PathParam("id") Long id){
		try {
			AuthorEntity authorEntity = authorService.findById(id);
			return authorEntity;
		} catch (Exception err) {
			System.out.println(err);
			return null;
		}
	}
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id){
		try {
			authorService.delete(id);
		} catch (Exception err){
				System.out.println(err);
			}
	}
	


}
