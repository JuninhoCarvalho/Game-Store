package br.com.inatel.gamestore.exception;

public class GameNotFound extends RuntimeException {
    public GameNotFound(String name) {
        super(name + " Not Found!");
    }
}
