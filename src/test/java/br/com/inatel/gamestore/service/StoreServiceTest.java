package br.com.inatel.gamestore.service;

import br.com.inatel.gamestore.exception.GameNotFound;
import br.com.inatel.gamestore.model.entity.Game;
import br.com.inatel.gamestore.model.dto.GameDto;
import br.com.inatel.gamestore.repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StoreServiceTest {

    @Mock
    private GameRepository gameRepository;

    private Game game;
    private GameDto gameDto;
    private List<Game> games = new ArrayList<>();
    private List<GameDto> gameDtos = new ArrayList<>();

    @InjectMocks
    private StoreService storeService = new StoreService();

    @BeforeEach
    public void init(){
        game = Game.builder()
                .code(1)
                .name("Counter-Strike")
                .company("Valve")
                .releasedYear(2010)
                .price(60.0)
                .imageUrl("http://imagem.com.br")
                .build();

        gameDto = GameDto.builder()
                .name("Counter-Strike")
                .company("Valve")
                .releasedYear(2010)
                .price(60.0)
                .imageUrl("http://imagem.com.br")
                .build();
    }

    @Test
    public void givenAGetAllGames_whenANewGameHasNotBeenCreated_shouldReturnEmptyGameDtoList(){
        when(gameRepository.findAll()).thenReturn(games);

        gameDtos = storeService.findAllGames();

        assertEquals(0, gameDtos.size());
    }

    @Test
    public void givenAGetAllGames_whenAGameHasAlreadyBeenCreated_shouldReturnGameDtoList(){
        when(gameRepository.findAll()).thenReturn(games);

        games.add(game);

        gameDtos = storeService.findAllGames();

        assertEquals(1, gameDtos.size());
        assertEquals(gameDtos.get(0).getName(), game.getName());
        assertEquals(gameDtos.get(0).getCompany(), game.getCompany());
        assertEquals(gameDtos.get(0).getReleasedYear(), game.getReleasedYear());
        assertEquals(gameDtos.get(0).getPrice(), game.getPrice());
        assertEquals(gameDtos.get(0).getImageUrl(), game.getImageUrl());
    }

    @Test
    public void givenAGetGameByName_whenFindByNoGameCreated_shouldReturnGameNotFoundException(){
        when(gameRepository.findByName(any(String.class))).thenReturn(Optional.empty());

        Throwable throwable = catchThrowable(() -> storeService.findGamesByName("Invalid"));

        assertThat(throwable)
                .isInstanceOf(GameNotFound.class)
                .hasMessageContaining("Invalid Not Found!");
    }

    @Test
    public void givenAGetGameByName_whenFindByValidGame_shouldReturnGameDto(){
        when(gameRepository.findByName(any(String.class))).thenReturn(Optional.of(game));

        gameDto = storeService.findGamesByName(game.getName());

        assertEquals(gameDto.getName(), game.getName());
        assertEquals(gameDto.getCompany(), game.getCompany());
        assertEquals(gameDto.getReleasedYear(), game.getReleasedYear());
        assertEquals(gameDto.getPrice(), game.getPrice());
        assertEquals(gameDto.getImageUrl(), game.getImageUrl());
    }


    @Test
    public void givenAPostNewGame_shouldAStringMessage(){
        String message = storeService.createGame(gameDto);

        assertEquals("Game Created!", message);
    }

    @Test
    public void givenADeleteGame_whenDeleteAInvalidGame_shouldReturnGameNotFoundException(){
        when(gameRepository.findByName(any(String.class))).thenReturn(Optional.empty());

        Throwable throwable = catchThrowable(() -> storeService.deleteGame("Invalid"));

        assertThat(throwable)
                .isInstanceOf(GameNotFound.class)
                .hasMessageContaining("Invalid Not Found!");
    }

    @Test
    public void givenADeleteGame_shouldAStringMessage(){
        when(gameRepository.findByName(any(String.class))).thenReturn(Optional.of(game));

        String message = storeService.deleteGame(game.getName());

        assertEquals("Jogo Comprado!", message);
    }
}
