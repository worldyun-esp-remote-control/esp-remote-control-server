package xyz.worldyun.espcontrol.common.exception;



import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.worldyun.espcontrol.common.base.R;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public R handler(RuntimeException e) {
        log.error("运行时异常：----------------{}", e);
        return R.error().message(e.getMessage());
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public  R MyExceptionHandler(HttpServletRequest req, MyException e){
        log.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return new R().code(e.getErrorCode()).message(e.getErrorMsg());
    }

}
