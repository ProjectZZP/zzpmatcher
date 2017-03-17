package com.thefuturegroup.zzpmatch;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ErrorResponse handleIllegalArgument(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("ILLEGAL_ARGUMENT");
        errorResponse.setMessage(exception.getMessage());
        return errorResponse;
    }
}