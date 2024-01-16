package com.example.javamasterproject.repository;



import com.example.javamasterproject.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


    Page<User> findAll(Pageable pageable);

    User getUserByEmail(String email);

}
