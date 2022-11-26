package br.com.inatel.gamestore.service;

import br.com.inatel.gamestore.exception.GameNotFound;
import br.com.inatel.gamestore.exception.GameNotFoundForThisCompanyException;
import br.com.inatel.gamestore.model.dto.GameDto;
import br.com.inatel.gamestore.model.entity.Game;
import br.com.inatel.gamestore.repository.GameRepository;
import br.com.inatel.gamestore.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StoreService {

    @Autowired
    GameRepository gameRepository;

    public List<GameDto> findAllGames(){
        return StoreMapper.toGameDtoList(gameRepository.findAll());
    }

    public List<GameDto> findByGamesByCompany(String company){
        List<Game> games = gameRepository.findByCompany(company);

        if(games.size() == 0){
            throw new GameNotFoundForThisCompanyException(company);
        }

        return StoreMapper.toGameDtoList(games);
    }

    public GameDto findByGamesByName(String name) {
        Optional<Game> optGame = gameRepository.findByName(name);

        if(optGame.isEmpty()){
            throw new GameNotFound(name);
        }

        return StoreMapper.toGameDto(optGame.get());
    }

    public String createGame(GameDto gameDto) {
        gameRepository.save(StoreMapper.toGame(gameDto));

        return "Game Created!";
    }

    public String deleteGame(String name) {
        Optional<Game> optionalGame = gameRepository.findByName(name);

        if(optionalGame.isEmpty()){
            throw new GameNotFound(name);
        }

        gameRepository.delete(optionalGame.get());
        return "Jogo Comprado!";
    }
}
