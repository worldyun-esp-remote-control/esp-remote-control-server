package xyz.worldyun.espcontrol.common.exception;



import lombok.extern.slf4j.Slf4j;


import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.worldyun.espcontrol.common.base.R;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public R handler(MethodArgumentNotValidException e) {
//        log.error("实体校验异常：----------------{}", e);
//        BindingResult bindingResult = e.getBindingResult();
//        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
//
//        return R.error().message(objectError.getDefaultMessage());
//    }
//
//
//    @ExceptionHandler(value = IllegalArgumentException.class)
//    public R handler(IllegalArgumentException e) {
//        log.error("Assert异常：----------------{}", e);
//        return R.error().message(e.getMessage());
//    }


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
