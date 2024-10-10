package com.example.library_management_system.Repository;

import com.example.library_management_system.Entity.Book_Copies;
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
public interface BookCopyRepository extends JpaRepository<Book_Copies, Integer> {

    @Query(value = "SELECT bc.copy_id from Book_Copies bc where bc.book_id = :book_id and bc.is_borrowed = false limit 1", nativeQuery = true)
    public Integer getAvailableCopyID(@Param("book_id") int book_id);

    @Modifying
    @Query("UPDATE Book_Copies SET is_borrowed =:borrowed_status where copy_id = :copy_id")
    public void updateBorrowStatus(@Param("borrowed_status") boolean borrowed_status,@Param("copy_id") int copy_id);



    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Book_Copies getById(Integer integer);




    @Override
    public <S extends Book_Copies> Optional<S> findOne(Example<S> example);

    @Override
    public <S extends Book_Copies> List<S> findAll(Example<S> example);
    @Override
    public <S extends Book_Copies> List<S> findAll(Example<S> example, Sort sort) ;

    @Override
    public <S extends Book_Copies> Page<S> findAll(Example<S> example, Pageable pageable) ;
    public <S extends Book_Copies> long count(Example<S> example) ;

    @Override
    public <S extends Book_Copies> boolean exists(Example<S> example) ;

    @Override
    public <S extends Book_Copies, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) ;
    public <S extends Book_Copies> S save(S entity) ;

    @Override
    public <S extends Book_Copies> List<S> saveAll(Iterable<S> entities) ;

    @Override
    public Optional<Book_Copies> findById(Integer integer) ;

    @Override
    public boolean existsById(Integer integer) ;

    @Override
    public List<Book_Copies> findAll() ;

    @Override
    public List<Book_Copies> findAllById(Iterable<Integer> integers) ;

    @Override
    public void deleteById(Integer integer) ;

    @Override
    public long count() ;

    @Override
    public void delete(Book_Copies entity) ;

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) ;

    @Override
    public void deleteAll(Iterable<? extends Book_Copies> entities) ;

    @Override
    public void deleteAll() ;

    @Override
    public List<Book_Copies> findAll(Sort sort) ;

    @Override
    public Page<Book_Copies> findAll(Pageable pageable) ;
}
