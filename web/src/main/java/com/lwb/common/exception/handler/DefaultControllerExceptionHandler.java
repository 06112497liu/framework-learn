package com.lwb.common.exception.handler;

import com.lwb.common.exception.BizException;
import com.lwb.common.exception.CommonErrorCode;
import com.lwb.common.result.RestResult;
import com.lwb.constant.StrConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author liuweibo
 * @date 2018/5/3
 */
@RestControllerAdvice
public class DefaultControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultControllerExceptionHandler.class);

    private static final String ERROR_MSG = "内部错误，请联系管理员。";

    /**
     * 业务异常处理器
     * @param e           抛出的业务异常
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    public RestResult bizException(BizException e) {
        int status = e.getErrorCode().getStatus();
        LOGGER.error("BizException，status=" + status, e);
        return RestResult.fail(status, e.getMessage());
    }

    /**
     * Valid 抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({ BindException.class })
    public RestResult bindException(BindException e) {
        LOGGER.warn(e.getMessage(), e);
        List<ObjectError> errors = e.getAllErrors();
        String msg = getValidationErrorMessage(errors);
        return RestResult.fail(CommonErrorCode.PARAM_ERROR.getStatus(), msg);
    }

    private String getValidationErrorMessage(List<ObjectError> errors) {
        StringBuffer sb = new StringBuffer();
        for (ObjectError error : errors) {
            sb.append(error.getDefaultMessage()).append(StrConstant.VERTICAL);
        }
        int len = sb.length();
        String msg = sb.substring(0, len - 1);
        return msg;
    }

    /**
     * 剩下的所有异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({ Exception.class })
    public RestResult allException(Exception e) {
        LOGGER.error(CommonErrorCode.SYS_ERROR.getMessage(), e);
        return RestResult.fail(CommonErrorCode.SYS_ERROR.getStatus(), ERROR_MSG);
    }
}
