package com.br.inatel.gamestore.controller;

import com.br.inatel.gamestore.model.dto.GameDto;
import com.br.inatel.gamestore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDto> getAllGames(){
        return storeService.findAllGames();
    }

    @GetMapping("/games/company={company}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDto> getGamesByCompany(@PathVariable @Valid String company){
        return storeService.findByGamesByCompany(company);
    }
}
