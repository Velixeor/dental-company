package org.example.dentalcompany.dto;


import lombok.Builder;
import org.example.dentalcompany.entity.Company;
import org.example.dentalcompany.entity.Role;
import org.example.dentalcompany.entity.User;

import java.time.LocalDateTime;


@Builder
public record UserDTO(
        Long id,
        String name,
        String password,
        String mail,
        LocalDateTime dateCreate,
        Long companyId,
        Long roleId
) {
    public static UserDTO fromEntity(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .mail(user.getMail())
                .dateCreate(user.getDateCreate())
                .companyId(user.getCompany() != null ? user.getCompany().getId() : null)
                .roleId(user.getRole() != null ? user.getRole().getId() : null)
                .build();
    }

    public User toEntity(Company company, Role role) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        user.setMail(mail);
        user.setDateCreate(dateCreate != null ? dateCreate : LocalDateTime.now());
        user.setCompany(company);
        user.setRole(role);
        return user;
    }
}
