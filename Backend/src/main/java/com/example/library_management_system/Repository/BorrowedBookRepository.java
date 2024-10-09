package com.example.library_management_system.Repository;

import com.example.library_management_system.Entity.Borrowed_Books;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;


import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class BorrowedBookRepository implements JpaRepository<Borrowed_Books, Integer> {
    @Override
    public void flush() {

    }
    @Modifying
    @Query("Update Borrowed_Books set borrow_date = :borrow_date where copy_id =:copy_id and user_id =:user_id and return_date =:return_date")
    public void updateBorrowTable(@Param("borrow_date") Timestamp borrow_date,
                                  @Param("return_date") Timestamp return_date,
                                  @Param("copy_id") int copy_id,
                                  @Param("book_id") int book_id);

    @Modifying
    @Query("select b from Borrowed_Books b where copy_id =:copy_id and user_id =:user_id")
    public Borrowed_Books getBorrowedBooks(@Param("copy_id") int copy_id
                                           ,@Param("user_id") int user_id);

    @Override
    public <S extends Borrowed_Books> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Borrowed_Books> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Borrowed_Books> entities) {

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
    public Borrowed_Books getOne(Integer integer) {
        return null;
    }

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Borrowed_Books getById(Integer integer) {
        return null;
    }

    @Override
    public Borrowed_Books getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Borrowed_Books> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Borrowed_Books> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Borrowed_Books> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Borrowed_Books> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Borrowed_Books> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Borrowed_Books> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Borrowed_Books, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Borrowed_Books> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Borrowed_Books> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Borrowed_Books> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Borrowed_Books> findAll() {
        return null;
    }

    @Override
    public List<Borrowed_Books> findAllById(Iterable<Integer> integers) {
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
    public void delete(Borrowed_Books entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Borrowed_Books> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Borrowed_Books> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Borrowed_Books> findAll(Pageable pageable) {
        return null;
    }
}
