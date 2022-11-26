package br.com.inatel.gamestore.mapper;

import br.com.inatel.gamestore.model.dto.GameDto;
import br.com.inatel.gamestore.model.entity.Game;

import java.util.List;
import java.util.stream.Collectors;

public class StoreMapper {

    public static List<GameDto> toGameDtoList(List<Game> games) {
        return games.stream().map(StoreMapper::toGameDto).collect(Collectors.toList());
    }

    public static Game toGame(GameDto dto){
        return Game.builder()
                .name(dto.getName())
                .company(dto.getCompany())
                .releasedYear(dto.getReleasedYear())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .build();
    }

    public static GameDto toGameDto(Game game) {
        return GameDto.builder()
                .name(game.getName())
                .company(game.getCompany())
                .releasedYear(game.getReleasedYear())
                .price(game.getPrice())
                .imageUrl(game.getImageUrl())
                .build();
    }
}
