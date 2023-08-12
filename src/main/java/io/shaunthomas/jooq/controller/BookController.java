package io.shaunthomas.jooq.controller;

import io.shaunthomas.jooq.model.tables.pojos.Book;
import io.shaunthomas.jooq.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {

  private final BookService bookService;

  @PostMapping()
  public ResponseEntity<Book> create(@RequestBody @Valid Book book) {
    if (!ObjectUtils.isEmpty(book.getId())) {
      throw new RuntimeException("A new data cannot already have an ID");
    }

    return ResponseEntity.ok(bookService.create(book));
  }

  @GetMapping
  public ResponseEntity<List<Book>> getAll() {
    List<Book> books = bookService.getAll();

    return ResponseEntity.ok(books);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> getOne(@PathVariable("id") int id) {
    Book book = bookService.getOne(id);
    return ResponseEntity.ok(book);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") int id) {
    bookService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
