package org.example.dentalcompany.dto;


import lombok.Builder;


@Builder
public record RegisterRequestDTO(
        String name,
        String mail,
        String password,
        String companyName
) {}
