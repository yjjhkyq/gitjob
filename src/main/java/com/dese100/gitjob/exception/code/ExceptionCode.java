package com.dese100.gitjob.exception.code;

public enum ExceptionCode implements BaseExceptionCode {
    //系统相关 start
    SYSTEM_BUSY(-1, "系统繁忙，请稍候再试"),
    SYSTEM_TIMEOUT(-2, "系统超时，请稍候再试"),
    VALIDATE_ERROR(-3, "校验错误"),
    NOT_FOUND_ENTITT_ERROR(-4, "校验错误"),
    //系统相关 end

    //DB相关 start
    DB_REMOVE_ERROR(10000, "无法软删除"),
    //DB相关 end
    
    //customer role
    DELETE_SYSTEM_ROLE_ERROR(20000, "System role could not be deleted"),
    EDIT_SYSTEM_ROLE_ERROR(20001, "can not edit system role "),
    //customer role
    
	 TOKEN_EXPIRED(40001, "token超时，请检查 token 的有效期");
	 
	 private  int code;
    private  String msg;

    ExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
