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
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface LibraryTransaction extends JpaRepository<Library_Transactions, Integer> {
    @Override
    public void flush();

    @Override
    public <S extends Library_Transactions> S saveAndFlush(S entity) ;

    @Query("SELECT lt from Library_Transactions lt where lt.users.user_id =:user_id and lt.bookCopies.copy_id =:copy_id")
    public Library_Transactions getLibraryTransactions(@Param("user_id") int user_id, @Param("copy_id") int copy_id);

//    @Modifying
//    @Query("UPDATE Library_Transactions set ")
//    @Override
//    public <S extends Library_Transactions> S saveAndFlush(S entity) {
//        return null;
//    }

    @Override
    public <S extends Library_Transactions> List<S> saveAllAndFlush(Iterable<S> entities) ;

    @Override
    public void deleteAllInBatch(Iterable<Library_Transactions> entities) ;

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) ;

    @Override
    public void deleteAllInBatch() ;

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Library_Transactions getOne(Integer integer) ;

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Library_Transactions getById(Integer integer) ;

    @Override
    public Library_Transactions getReferenceById(Integer integer) ;

    @Override
    public <S extends Library_Transactions> Optional<S> findOne(Example<S> example);

    @Override
    public <S extends Library_Transactions> List<S> findAll(Example<S> example) ;

    @Override
    public <S extends Library_Transactions> List<S> findAll(Example<S> example, Sort sort) ;

    @Override
    public <S extends Library_Transactions> Page<S> findAll(Example<S> example, Pageable pageable) ;

    @Override
    public <S extends Library_Transactions> long count(Example<S> example) ;

    @Override
    public <S extends Library_Transactions> boolean exists(Example<S> example);

    @Override
    public <S extends Library_Transactions, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) ;

    @Override
    public <S extends Library_Transactions> S save(S entity) ;

    @Override
    public <S extends Library_Transactions> List<S> saveAll(Iterable<S> entities) ;

    @Override
    public Optional<Library_Transactions> findById(Integer integer);

    @Override
    public boolean existsById(Integer integer);

    @Override
    public List<Library_Transactions> findAll() ;

    @Override
    public List<Library_Transactions> findAllById(Iterable<Integer> integers) ;

    @Override
    public long count() ;

    @Override
    public void deleteById(Integer integer) ;

    @Override
    public void delete(Library_Transactions entity) ;

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) ;

    @Override
    public void deleteAll(Iterable<? extends Library_Transactions> entities) ;

    @Override
    public void deleteAll() ;

    @Override
    public List<Library_Transactions> findAll(Sort sort) ;

    @Override
    public Page<Library_Transactions> findAll(Pageable pageable) ;
}
