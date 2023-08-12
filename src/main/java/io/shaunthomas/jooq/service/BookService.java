package io.shaunthomas.jooq.service;

import io.shaunthomas.jooq.model.tables.pojos.Book;

import java.util.List;

public interface BookService {
  Book create(Book book);

  Book update(Book book);

  List<Book> getAll();

  Book getOne(int id);

  void deleteById(int id);
}
