package com.example.library_management_system.Repository;

import com.example.library_management_system.Entity.Users;
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
public interface UserRepository extends JpaRepository<Users,Integer> {
    @Override
    public void flush() ;

    @Modifying
    @Query("UPDATE Users set borrowed_book_count = :borrowed_book_count where user_id =:user_id")
    public void changeBorrowCount(@Param("borrowed_book_count") int borrowed_book_count, @Param("user_id") int user_id);

    @Override
    public <S extends Users> S saveAndFlush(S entity) ;

    @Override
    public <S extends Users> List<S> saveAllAndFlush(Iterable<S> entities) ;

    @Override
    public void deleteAllInBatch(Iterable<Users> entities) ;

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) ;

    @Override
    public void deleteAllInBatch() ;

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Users getOne(Integer integer) ;

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Users getById(Integer integer) ;

    @Override
    public Users getReferenceById(Integer integer) ;

    @Override
    public <S extends Users> Optional<S> findOne(Example<S> example);

    @Override
    public <S extends Users> List<S> findAll(Example<S> example) ;

    @Override
    public <S extends Users> List<S> findAll(Example<S> example, Sort sort) ;

    @Override
    public <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable) ;

    @Override
    public <S extends Users> long count(Example<S> example) ;

    @Override
    public <S extends Users> boolean exists(Example<S> example);

    @Override
    public <S extends Users, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) ;

    @Override
    public <S extends Users> S save(S entity) ;

    @Override
    public <S extends Users> List<S> saveAll(Iterable<S> entities) ;

    @Override
    public Optional<Users> findById(Integer integer);

    @Override
    public boolean existsById(Integer integer);

    @Override
    public List<Users> findAll() ;

    @Override
    public List<Users> findAllById(Iterable<Integer> integers) ;

    @Override
    public long count() ;

    @Override
    public void deleteById(Integer integer) ;

    @Override
    public void delete(Users entity) ;

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) ;

    @Override
    public void deleteAll(Iterable<? extends Users> entities) ;

    @Override
    public void deleteAll() ;

    @Override
    public List<Users> findAll(Sort sort) ;

    @Override
    public Page<Users> findAll(Pageable pageable) ;
}
