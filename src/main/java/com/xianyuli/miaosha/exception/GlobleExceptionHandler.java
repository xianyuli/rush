package com.xianyuli.miaosha.exception;

import com.xianyuli.miaosha.result.CodeMsg;
import com.xianyuli.miaosha.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: rush
 * @Package: com.xianyuli.miaosha.exception
 * @ClassName: GlobleExceptionHandler
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2019/7/14 0014 23:37
 * @UpdateUser: LW
 * @UpdateDate: 2019/7/14 0014 23:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {

    @ExceptionHandler(value = BindException.class)
    public Result exceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            ObjectError objectError = bindException.getAllErrors().get(0);

            return Result.error(CodeMsg.BIND_ERROR.fillArgs(objectError.getDefaultMessage()));
        }else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }

}
