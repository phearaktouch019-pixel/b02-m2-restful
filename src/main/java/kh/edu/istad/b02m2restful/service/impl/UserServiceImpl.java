package kh.edu.istad.b02m2restful.service.impl;

import kh.edu.istad.b02m2restful.model.User;
import kh.edu.istad.b02m2restful.repository.UserRepository;
import kh.edu.istad.b02m2restful.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.selectAll();
    }

    @Override
    public User getById(UUID id) {
        return userRepository.selectById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public User create(User user) {
        user.setId(UUID.randomUUID());
        user.setName("Touch Phearak");
        if (user.getUsername() == null ) {
            user.setUsername("Rakk");
        }
        if (user.getPassword() == null) {
            user.setPassword("GenAi");
        }
        if (user.getIsActive() == null) {
            user.setIsActive(true);
        }
        userRepository.insert(user);
        return user;
    }

    @Override
    public User update(UUID id, User user) {
        User existingUser = getById(id);
        existingUser.setName(user.getName());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setIsActive(user.getIsActive());

        userRepository.update(existingUser);
        return existingUser;
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteById(UUID id) {
        User user = getById(id);
        userRepository.delete(user);
    }
}