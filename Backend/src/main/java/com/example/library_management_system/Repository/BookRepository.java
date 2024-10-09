package com.example.library_management_system.Repository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library_management_system.Entity.Books;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class BookRepository implements JpaRepository<Books, Integer> {
    @Override
    public void flush() {

    }

    @Modifying
    @Query("UPDATE Books set available_copies =:available_copies where book_id =:book_id")
    public void changeAvailableCopies(@Param("available_copies") int available_copies, @Param("book_id") int book_id);
    @Override
    public <S extends Books> S saveAndFlush(S entity) {
        return null;
    }
    @Query("SELECT b from books b join b.BookCopies bc where bc.copy_id =:copy_id")
    public Books getBookbyCopyId(@Param("copy_id") int copy_id);


    @Override
    public <S extends Books> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Books> entities) {

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
    public Books getOne(Integer integer) {
        return null;
    }

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Books getById(Integer integer) {
        return null;
    }

    @Override
    public Books getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Books> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Books> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Books> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Books> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Books> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Books> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Books, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Books> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Books> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Books> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Books> findAll() {
        return null;
    }

    @Override
    public List<Books> findAllById(Iterable<Integer> integers) {
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
    public void delete(Books entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Books> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Books> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Books> findAll(Pageable pageable) {
        return null;
    }
}
