package org.example.dentalcompany.service;


import lombok.RequiredArgsConstructor;
import org.example.dentalcompany.dto.RegisterRequestDTO;
import org.example.dentalcompany.dto.UserDTO;
import org.example.dentalcompany.entity.Company;
import org.example.dentalcompany.repository.CompanyRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UserService userService;

    public Long registerCompanyAndUser(RegisterRequestDTO dto) {
        Company company = new Company();
        company.setName(dto.companyName());
        company = companyRepository.save(company);
        UserDTO userDTO = UserDTO.builder()
                .name(dto.name())
                .mail(dto.mail())
                .password(dto.password())
                .companyId(company.getId())
                .roleId(2L)
                .build();

        return userService.createUser(userDTO);
    }
}
