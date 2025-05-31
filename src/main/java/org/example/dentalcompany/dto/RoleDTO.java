package org.example.dentalcompany.dto;


import lombok.Builder;
import org.example.dentalcompany.entity.Role;


@Builder
public record RoleDTO(
        Long id,
        String name
) {
    public static RoleDTO fromEntity(Role role) {
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public Role toEntity() {
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        return role;
    }
}
