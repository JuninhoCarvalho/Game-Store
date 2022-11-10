package com.br.inatel.gamestore.mapper;

import com.br.inatel.gamestore.model.dto.CompanyDto;
import com.br.inatel.gamestore.model.dto.GameDto;
import com.br.inatel.gamestore.model.entity.Company;
import com.br.inatel.gamestore.model.entity.Game;

import java.util.List;
import java.util.stream.Collectors;

public class StoreMapper {

    public static List<Game> toGameList(List<GameDto> gameDtos){
        return gameDtos.stream().map(StoreMapper::toGame).collect(Collectors.toList());
    }

    public static List<GameDto> toGameDtoList(List<Game> games){
        return games.stream().map(StoreMapper::toGameDto).collect(Collectors.toList());
    }

    public static List<Company> toCompanyList(List<CompanyDto> companyDtos){
        return companyDtos.stream().map(StoreMapper::toCompany).collect(Collectors.toList());
    }

    public static List<CompanyDto> toCompanyDtoList(List<Company> companyList){
        return companyList.stream().map(StoreMapper::toCompanyDto).collect(Collectors.toList());
    }

    public static Game toGame(GameDto dto){
        return Game.builder()
                .name(dto.getName())
                .company(dto.getCompany())
                .releasedYear(dto.getReleasedYear())
                .price(dto.getPrice())
                .build();
    }

    public static GameDto toGameDto(Game game){
        return GameDto.builder()
                .name(game.getName())
                .company(game.getCompany())
                .releasedYear(game.getReleasedYear())
                .price(game.getPrice())
                .build();
    }

    public static Company toCompany(CompanyDto dto){
        return Company.builder()
                .name(dto.getName())
                .build();
    }

    public static CompanyDto toCompanyDto(Company company){
        return CompanyDto.builder()
                .name(company.getName())
                .build();
    }
}
