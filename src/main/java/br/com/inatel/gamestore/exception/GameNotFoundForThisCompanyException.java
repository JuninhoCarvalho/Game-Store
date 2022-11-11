package br.com.inatel.gamestore.exception;

public class GameNotFoundForThisCompanyException extends RuntimeException{

    public GameNotFoundForThisCompanyException(String company){
        super("Games Not Found for this Company: " + company);
    }
}
