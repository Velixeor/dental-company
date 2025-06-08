package org.example.dentalcompany.controller;


import lombok.RequiredArgsConstructor;
import org.example.dentalcompany.dto.RegisterRequestDTO;
import org.example.dentalcompany.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/company/auth")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequestDTO dto) {
        companyService.registerCompanyAndUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
