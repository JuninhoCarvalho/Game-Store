package br.com.inatel.gamestore.controller;

import br.com.inatel.gamestore.model.dto.GameDto;
import br.com.inatel.gamestore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/store/games")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<GameDto> getAllGames(){
        return storeService.findAllGames();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public GameDto getGamesByGameName(@PathVariable String name){
        return storeService.findGamesByName(name);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String postNewGame(@RequestBody GameDto gameDto){
        return storeService.createGame(gameDto);
    }

    @DeleteMapping("/buy/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String buyAGame(@PathVariable String name){
        return storeService.deleteGame(name);
    }

}
