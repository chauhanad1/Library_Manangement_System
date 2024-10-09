package com.example.library_management_system.Repository;

import com.example.library_management_system.Entity.Library_Transactions;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class LibraryTransaction implements JpaRepository<Library_Transactions, Integer> {
    @Override
    public void flush() {
    }

    @Query("SLECT lt from Library_Transactions lt where user_id =:user_id and copy_id =:copy_id")
    public Library_Transactions getLibraryTransactions(@Param("user_id") int user_id, @Param("copy_id") int copy_id);

//    @Modifying
//    @Query("UPDATE Library_Transactions set ")
//    @Override
//    public <S extends Library_Transactions> S saveAndFlush(S entity) {
//        return null;
//    }

    @Override
    public <S extends Library_Transactions> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Library_Transactions> entities) {

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
    public Library_Transactions getOne(Integer integer) {
        return null;
    }

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Library_Transactions getById(Integer integer) {
        return null;
    }

    @Override
    public Library_Transactions getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Library_Transactions> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Library_Transactions> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Library_Transactions> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Library_Transactions> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Library_Transactions> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Library_Transactions> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Library_Transactions, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Library_Transactions> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Library_Transactions> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Library_Transactions> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Library_Transactions> findAll() {
        return null;
    }

    @Override
    public List<Library_Transactions> findAllById(Iterable<Integer> integers) {
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
    public void delete(Library_Transactions entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Library_Transactions> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Library_Transactions> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Library_Transactions> findAll(Pageable pageable) {
        return null;
    }
}
