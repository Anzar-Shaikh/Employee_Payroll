package com.spring.respository;

import com.spring.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**  the repository where interaction with the database is carried out   */
@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

    /** custom query */
    public Employee findById(int id);

    /** All the queries given by JPA */


    @Override
    <S extends Employee> S save(S entity);

    @Override
    <S extends Employee> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Employee> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<Employee> findAll();

    @Override
    Iterable<Employee> findAllById(Iterable<Integer> integers);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Employee entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends Employee> entities);

    @Override
    void deleteAll();
}
