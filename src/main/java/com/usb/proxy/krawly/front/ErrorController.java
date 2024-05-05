package com.usb.proxy.krawly.front;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice
public class ErrorController {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(ErrorController.class);

//    @RequestMapping(name = "/")
//    String hello() {
//        return "Hello World!";
//    }

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
        // Nothing to do
    }

    // Specify the name of a specific view that will be used to display the error:
    @ExceptionHandler({SQLException.class,DataAccessException.class})
    public String databaseError() {
        // Nothing to do.  Returns the logical view name of an error page, passed to
        // the view-resolver(s) in usual way.
        // Note that the exception is _not_ available to this view (it is not added to
        // the model) but see "Extending ExceptionHandlerExceptionResolver" below.
        return "databaseError";
    }

    // Total control - setup a model and return the view name yourself. Or consider
    // subclassing ExceptionHandlerExceptionResolver (see below).
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleError(HttpServletRequest req, Exception exception) {
        log.warn(exception.getMessage(), exception);
//        Locale locale = LocaleContextHolder.getLocale();
//        String errorURL = req.getRequestURL().toString() + " " + locale.getLanguage();
        System.out.println("requestHandlingNoHandlerFound #" + 2);
        return new ResponseEntity<String>(exception.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
