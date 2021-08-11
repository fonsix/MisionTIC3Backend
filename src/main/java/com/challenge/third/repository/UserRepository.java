package com.challenge.third.repository;

import com.challenge.third.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.nickname = :nickname")
    User findByNickname(@Param("nickname") String nickname);
    
}
