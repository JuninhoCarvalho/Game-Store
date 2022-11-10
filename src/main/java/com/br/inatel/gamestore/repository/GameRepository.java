package com.br.inatel.gamestore.repository;

import com.br.inatel.gamestore.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, String> {
    List<Game> findByCompany(String company);
}
