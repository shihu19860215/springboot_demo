package com.shihu.demo.springboot.redis.service.impl;

import com.shihu.demo.springboot.redis.model.Book;
import com.shihu.demo.springboot.redis.repository.BookRepository;
import com.shihu.demo.springboot.redis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Book 业务层实现
 *
 * Created by bysocket on 30/09/2017.
 */
@Service
@CacheConfig(cacheNames = "books")
public class BookServiceImpl implements BookService {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book insertByBook(Book book) {
        return bookRepository.save(book);
    }

    @CachePut(key = "#p0.id")//@CachePut(key = "#book.id")
    @Override
    public Book update(Book book) {
        System.out.println(" call update method ");
        return bookRepository.save(book);
    }

    @CacheEvict(key = "#p0")//@CachePut(key = "#id")
    @Override
    public Book delete(Long id) {
        System.out.println(" call delete method ");
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }

    @Cacheable(key = "#p0")
    @Override
    public Book findById(Long id) {
        System.out.println(" call findById method ");
        String key="book"+id;
        ValueOperations<String,Book> valueOperations=redisTemplate.opsForValue();
        Book book;
        if(redisTemplate.hasKey(key)){
            book=valueOperations.get(key);
        }else {
            book=bookRepository.findById(id).get();
            valueOperations.set(key,book);
        }
        return book;
    }
}
