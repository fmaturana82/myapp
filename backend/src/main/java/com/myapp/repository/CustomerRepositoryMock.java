//package com.myapp.repository;
//
//import com.myapp.domain.Customer;
//import jakarta.transaction.Transactional;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Conditional;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Repository
//@ConditionalOnProperty(name="mock.enable", havingValue = "true")
//public abstract class CustomerRepositoryMock implements CustomerRepository {
//
//    @Override
//    public <S extends Customer> S save(S entity) {
//        return null;
//    }
//
//}
