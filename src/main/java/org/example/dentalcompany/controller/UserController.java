package org.example.dentalcompany.controller;


import lombok.RequiredArgsConstructor;
import org.example.dentalcompany.dto.UserDTO;
import org.example.dentalcompany.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDTO dto) {
        Long id = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("id", id));
    }
}
