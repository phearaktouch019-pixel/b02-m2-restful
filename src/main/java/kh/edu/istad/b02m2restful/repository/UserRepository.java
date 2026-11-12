package kh.edu.istad.b02m2restful.repository;

import kh.edu.istad.b02m2restful.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {

    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        User usrAdmin = new User(UUID.randomUUID(), "Administrator", "admin", "tank", true);
        User usrEditor = new User(UUID.randomUUID(), "Editor", "editor", "ganAi", false);
        User usrCustomer = new User(UUID.randomUUID(), "God", "Gord", "genAi", true);
        users.add(usrAdmin);
        users.add(usrEditor);
        users.add(usrCustomer);
    }

    public List<User> selectAll() {
        return users;
    }

    public Optional<User> selectById(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public void insert(User user) {
        users.add(user);
    }

    public void deleteAll() {
        users.clear();
    }

    public void delete(User user) {
        users.remove(user);
    }

    public void update(User existingUser) {
    }
}