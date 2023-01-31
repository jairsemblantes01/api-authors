package com.distribuida.servicios;

import com.distribuida.db.Author;
import com.distribuida.entity.AuthorEntity;

import java.util.List;

public interface AuthorService {
	
	public List<Author> getAll();
		public AuthorEntity findById(Long id);
		public AuthorEntity pushAuthor(Author author);
		public AuthorEntity editAuthor(Long id, Author author);
		public void delete(Long id);
}
