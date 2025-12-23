package org.example.dabacolis.repository;

import org.example.dabacolis.entity.User;
import org.example.dabacolis.enums.Speciality;
import org.example.dabacolis.enums.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByLogin(String login);

    boolean existsByLogin(String login);


    Page<User> findByRole(UserRole role, Pageable pageable);


    Page<User> findByRoleAndSpeciality(UserRole role, Speciality speciality, Pageable pageable);

}
