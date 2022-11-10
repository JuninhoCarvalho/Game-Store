package com.br.inatel.gamestore.repository;

import com.br.inatel.gamestore.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
