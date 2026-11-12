package kh.edu.istad.b02m2restful.controller;

import kh.edu.istad.b02m2restful.model.User;
import kh.edu.istad.b02m2restful.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable UUID id) {
        return userService.getById(id);
    }
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable UUID id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping
    public void deleteAll() {
        userService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
    }

}
