package br.com.inatel.gamestore.controller;

import br.com.inatel.gamestore.model.dto.GameDto;
import br.com.inatel.gamestore.service.StoreService;
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

    @GetMapping("/games/company")
    @ResponseStatus(HttpStatus.OK)
    public List<GameDto> getGamesByCompany(@RequestParam String company){
        return storeService.findByGamesByCompany(company);
    }

    @GetMapping("/games/game/{name}")
    @ResponseStatus(HttpStatus.OK)
    public GameDto getGamesByGameName(@PathVariable String name){
        return storeService.findByGamesByName(name);
    }

    @PostMapping("/games/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String postNewGame(@RequestBody GameDto gameDto){
        return storeService.createGame(gameDto);
    }
}
