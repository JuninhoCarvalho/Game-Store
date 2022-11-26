package br.com.inatel.gamestore.handler;

import br.com.inatel.gamestore.exception.GameNotFound;
import org.springframework.http.HttpStatus;
import br.com.inatel.gamestore.model.rest.Error;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@ControllerAdvice
@ResponseBody
public class StoreHandler {

    @ExceptionHandler(GameNotFound.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Error continentNotFoundException(GameNotFound gameNotFound){
        return Error.builder()
                .httpStatusCode(HttpStatus.NOT_FOUND)
                .message(gameNotFound.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Error fieldNullException(MethodArgumentNotValidException fieldNullException){
        return Error.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(Objects.requireNonNull(fieldNullException.getFieldError()).getField() +  " field is missing!")
                .build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Error jsonErrorException(HttpMessageNotReadableException jsonError){
        return Error.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(jsonError.getMessage())
                .build();
    }
}
