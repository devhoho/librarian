package org.holab.librarian.web.api.advice;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.holab.librarian.web.response.ApiException;
import org.holab.librarian.web.response.ApiResponseCode;
import org.holab.librarian.web.response.ApiResponseDto;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

import static org.holab.librarian.web.response.ApiResponseCode.BAD_PARAMETER;
import static org.holab.librarian.web.response.ApiResponseCode.NOT_FOUND;

@Slf4j
@Order(value = 1)
@RestControllerAdvice(basePackages = {"org.holab.librarian.controller"})
public class ApiCommonAdvice {
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler
    public ApiResponseDto<String> handleBaseException(ApiException e) {
        return ApiResponseDto.createException(e);
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({ConstraintViolationException.class})
    public ApiResponseDto<String> handleBaseException(ConstraintViolationException e) {
        return ApiResponseDto.createException(BAD_PARAMETER, BAD_PARAMETER.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NotFoundException.class})
    public ApiResponseDto<String> handleValidException(NotFoundException e) {
        ApiResponseDto<String> exception = ApiResponseDto.createException(new ApiException(NOT_FOUND, NOT_FOUND.getMessage()));
        return exception;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class})
    public ApiResponseDto<ErrorMessageCollection> handleValidException(BindException e) {
        ApiResponseDto<ErrorMessageCollection> exception = ApiResponseDto.createException(
                BAD_PARAMETER,
                new ErrorMessageCollection(e.getBindingResult().getFieldErrors(), e.getBindingResult().getGlobalErrors())
        );

        return exception;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ApiResponseDto<String> handleValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        String errorMessage = String.format(" %s 요청 파라미터를 확인해주세요.", Objects.requireNonNull(result.getFieldError()).getField());
        ApiResponseDto<String> exception = ApiResponseDto.createException(new ApiException(ApiResponseCode.BAD_PARAMETER, errorMessage));
        return exception;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NumberFormatException.class})
    public ApiResponseDto<String> handleValidException(NumberFormatException e) {
        return ApiResponseDto.createException(ApiResponseCode.BAD_PARAMETER, "파라미터가 잘못됐습니다.");
    }
}
