package com.example.library_management_system.Repository;

import com.example.library_management_system.Entity.Book_Copies;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class BookCopyRepository implements JpaRepository<Book_Copies, Integer> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Book_Copies> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Book_Copies> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Book_Copies> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Book_Copies getOne(Integer integer) {
        return null;
    }

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Book_Copies getById(Integer integer) {
        return null;
    }

    @Override
    public Book_Copies getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Book_Copies> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Book_Copies> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Book_Copies> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Book_Copies> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Book_Copies> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Book_Copies> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Book_Copies, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Book_Copies> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Book_Copies> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Book_Copies> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Book_Copies> findAll() {
        return null;
    }

    @Override
    public List<Book_Copies> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Book_Copies entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Book_Copies> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Book_Copies> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Book_Copies> findAll(Pageable pageable) {
        return null;
    }
}
