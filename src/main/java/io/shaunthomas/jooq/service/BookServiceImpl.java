package io.shaunthomas.jooq.service;

import io.shaunthomas.jooq.model.tables.pojos.Book;
import io.shaunthomas.jooq.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service(value = "BookServiceDSL")
public class BookServiceImpl implements BookService {

  private final BookRepository repository;

  @Override
  public Book create(Book book) {
    return repository.save(book);
  }

  @Override
  public Book update(Book book) {
    return repository.update(book, book.getId());
  }

  @Override
  public List<Book> getAll(){
    return repository.findAll();
  }

  @Override
  public Book getOne(int id) {
    Optional<Book> book = repository.findById(id);
    if(book.isEmpty()){
      throw new RuntimeException(MessageFormat.format("Book id {0} not found", String.valueOf(id)));
    }
    return book.get();
  }

  @Override
  public void deleteById(int id) {
    boolean isDeleted = repository.deleteById(id);
    if(!isDeleted){
      throw new RuntimeException("Delete error, please check ID and try again");
    }
  }

}
