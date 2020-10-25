package eci.ieti.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eci.ieti.data.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByName(String name);

    User findByEmail(String email);
    
}
