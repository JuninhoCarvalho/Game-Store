package com.br.inatel.gamestore.service;

import com.br.inatel.gamestore.mapper.StoreMapper;
import com.br.inatel.gamestore.model.dto.GameDto;
import com.br.inatel.gamestore.repository.CompanyRepository;
import com.br.inatel.gamestore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StoreService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    GameRepository gameRepository;

    public List<GameDto> findAllGames(){
        return StoreMapper.toGameDtoList(gameRepository.findAll());
    }

    public List<GameDto> findByGamesByCompany(String company){
        return StoreMapper.toGameDtoList(gameRepository.findByCompany(company));
    }
}
