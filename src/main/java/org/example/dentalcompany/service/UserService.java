package org.example.dentalcompany.service;


import lombok.RequiredArgsConstructor;
import org.example.dentalcompany.dto.UserDTO;
import org.example.dentalcompany.entity.Company;
import org.example.dentalcompany.entity.Role;
import org.example.dentalcompany.entity.User;
import org.example.dentalcompany.repository.CompanyRepository;
import org.example.dentalcompany.repository.RoleRepository;
import org.example.dentalcompany.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final RoleRepository roleRepository;

    public Long createUser(UserDTO dto) {
        Company company = companyRepository.findById(dto.companyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        Role role = roleRepository.findById(dto.roleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = dto.toEntity(company, role);
        User saved = userRepository.save(user);

        return saved.getId();
    }
}
