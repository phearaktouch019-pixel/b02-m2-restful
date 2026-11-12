package kh.edu.istad.b02m2restful.service;

import kh.edu.istad.b02m2restful.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    
    List<User> getAll();

    User getById(UUID id);

    User create(User user);

    User update(UUID id, User user);

    void deleteAll();

    void deleteById(UUID id);
}
