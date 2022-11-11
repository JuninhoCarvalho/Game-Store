package br.com.inatel.gamestore.repository;

import br.com.inatel.gamestore.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, String> {
    List<Game> findByCompany(String company);

    Optional<Game> findByName(String name);
}
