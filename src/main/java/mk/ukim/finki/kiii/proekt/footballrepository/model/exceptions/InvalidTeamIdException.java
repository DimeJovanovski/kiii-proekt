package mk.ukim.finki.kiii.proekt.footballrepository.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidTeamIdException extends RuntimeException {
    public InvalidTeamIdException(Long id) {
        super(String.format("Team with id: %d was not found", id));
    }
}
