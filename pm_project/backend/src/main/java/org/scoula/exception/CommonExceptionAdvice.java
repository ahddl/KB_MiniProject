package org.scoula.exception;


import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
// 404 에러 처리
@ControllerAdvice
@Log4j2
@Order(1)  // 우선순위 설정
public class CommonExceptionAdvice {

//    @ExceptionHandler(Exception.class)
//    public String except(Exception ex, Model model) {
//
//        log.error("Exception ......." + ex.getMessage());
//        model.addAttribute("exception", ex);
//        log.error(model);
//        return "error_page";
//    }


//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String handle404(HttpServletRequest request, Model model, NoHandlerFoundException ex) {
//        log.error(ex);
//        model.addAttribute("uri", request.getRequestURI());
//        return "custom404";
//    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(NoHandlerFoundException ex) {
        // 404 에러 시 index.html로 포워딩 (SPA 라우팅 지원)
        return "/resources/index.html";
    }

}