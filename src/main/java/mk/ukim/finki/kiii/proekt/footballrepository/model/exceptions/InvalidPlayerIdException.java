package mk.ukim.finki.kiii.proekt.footballrepository.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidPlayerIdException extends RuntimeException {
    public InvalidPlayerIdException(Long id) {
        super(String.format("Player with id: %d was not found", id));
    }
}
