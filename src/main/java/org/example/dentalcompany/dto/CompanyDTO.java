package org.example.dentalcompany.dto;


import lombok.Builder;
import org.example.dentalcompany.entity.Company;


@Builder
public record CompanyDTO(
        Long id,
        String name
) {
    public static CompanyDTO fromEntity(Company company) {
        return CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }

    public Company toEntity() {
        Company company = new Company();
        company.setId(id);
        company.setName(name);
        return company;
    }
}
