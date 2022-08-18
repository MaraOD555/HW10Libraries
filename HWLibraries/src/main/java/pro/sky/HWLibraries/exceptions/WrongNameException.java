package pro.sky.HWLibraries.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "имя или фамилия содержат недопустимые значения")
public class WrongNameException extends RuntimeException {
}
