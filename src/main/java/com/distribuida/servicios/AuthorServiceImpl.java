package com.distribuida.servicios;

import com.distribuida.entity.AuthorEntity;
import com.distribuida.db.Author;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class AuthorServiceImpl implements AuthorService {
	public List<Author> getAll() {
		List<AuthorEntity> listAll = AuthorEntity.findAll().list();
		List<Author> list = listAll.stream().map(entity -> {
			Author author = new Author();
			author.setId(entity.id);
			author.setFirst_name(entity.first_name);
			author.setLast_name(entity.last_name);
			return author;
		}).collect(Collectors.toList());
		System.out.println("trayendo autores");
		return list;
	}
	public AuthorEntity findById (Long id) {
		AuthorEntity entity = AuthorEntity.findById(id);
		return entity;
	}
	
	@Transactional
	public AuthorEntity pushAuthor(Author author) {
		AuthorEntity authorEntity = new AuthorEntity();
		authorEntity.first_name = author.getLast_name();
		authorEntity.last_name = author.getLast_name();
		authorEntity.persist();
		return authorEntity;
	}
	
	@Transactional
	public AuthorEntity editAuthor(Long id , Author author) {
		AuthorEntity entity = AuthorEntity.findById(id);
		entity.first_name = author.getFirst_name();
		entity.last_name = author.getLast_name();
		return entity;
	}
	
	@Transactional
	public void delete(Long id) {
		AuthorEntity.deleteById(id);
	}

}