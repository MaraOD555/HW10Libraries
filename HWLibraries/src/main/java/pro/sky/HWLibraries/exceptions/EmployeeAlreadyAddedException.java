package pro.sky.HWLibraries.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Сотрудник уже добавлен")//помечает метод или класс исключений кодом состояния
// и сообщением о причине, которые должны быть возвращены, Код состояния
// применяется к ответу HTTP при вызове метода обработчика или всякий раз, к
// огда создается указанное исключение.
public class EmployeeAlreadyAddedException extends RuntimeException{
}
