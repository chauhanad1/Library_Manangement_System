package com.example.library_management_system.Repository;

import com.example.library_management_system.Entity.Books;
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
import org.springframework.stereotype.Repository;
//import org.springframework.security.core.parameters.P;


import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface BorrowedBookRepository extends JpaRepository<Borrowed_Books, Integer> {
    @Override
    public void flush() ;
    @Modifying
    @Query("Update Borrowed_Books b set b.returnDate =:return_date where b.bookcopy.copy_id =:copy_id and b.user.user_id =:user_id")
    public void updateBorrowTable(@Param("return_date") Timestamp return_date,
                                  @Param("copy_id") int copy_id,
                                  @Param("user_id") int user_id);

    @Query("select b from Borrowed_Books b where b.bookcopy.copy_id =:copy_id and b.user.user_id =:user_id")
    public Borrowed_Books getBorrowedBooks(@Param("copy_id") int copy_id
                                           ,@Param("user_id") int user_id);

    @Query("select bb.borrow_id, b.title,bb.borrowDate,bb.bookcopy.copy_id from Borrowed_Books bb " +
            "JOIN Book_Copies bc ON bb.bookcopy.copy_id = bc.copy_id JOIN Books b on bc.book.book_id " +
            "= b.book_id where bb.user.user_id =:userId and bb.returnDate IS NULL")
    List<Object[]> getBorrowedBookbyUserId(@Param("userId") int userId);

    @Override
    public <S extends Borrowed_Books> S saveAndFlush(S entity) ;

    @Override
    public <S extends Borrowed_Books> List<S> saveAllAndFlush(Iterable<S> entities) ;

    @Override
    public void deleteAllInBatch(Iterable<Borrowed_Books> entities) ;

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) ;

    @Override
    public void deleteAllInBatch() ;

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Borrowed_Books getOne(Integer integer) ;

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Borrowed_Books getById(Integer integer) ;

    @Override
    public Borrowed_Books getReferenceById(Integer integer) ;

    @Override
    public <S extends Borrowed_Books> Optional<S> findOne(Example<S> example);

    @Override
    public <S extends Borrowed_Books> List<S> findAll(Example<S> example) ;

    @Override
    public <S extends Borrowed_Books> List<S> findAll(Example<S> example, Sort sort) ;

    @Override
    public <S extends Borrowed_Books> Page<S> findAll(Example<S> example, Pageable pageable) ;

    @Override
    public <S extends Borrowed_Books> long count(Example<S> example) ;

    @Override
    public <S extends Borrowed_Books> boolean exists(Example<S> example);

    @Override
    public <S extends Borrowed_Books, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) ;

    @Override
    public <S extends Borrowed_Books> S save(S entity) ;

    @Override
    public <S extends Borrowed_Books> List<S> saveAll(Iterable<S> entities) ;

    @Override
    public Optional<Borrowed_Books> findById(Integer integer);

    @Override
    public boolean existsById(Integer integer);

    @Override
    public List<Borrowed_Books> findAll() ;

    @Override
    public List<Borrowed_Books> findAllById(Iterable<Integer> integers) ;

    @Override
    public long count() ;

    @Override
    public void deleteById(Integer integer) ;

    @Override
    public void delete(Borrowed_Books entity) ;

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) ;

    @Override
    public void deleteAll(Iterable<? extends Borrowed_Books> entities) ;

    @Override
    public void deleteAll() ;

    @Override
    public List<Borrowed_Books> findAll(Sort sort) ;

    @Override
    public Page<Borrowed_Books> findAll(Pageable pageable) ;
}
