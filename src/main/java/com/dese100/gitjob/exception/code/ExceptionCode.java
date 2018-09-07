package com.dese100.gitjob.exception.code;

public enum ExceptionCode implements BaseExceptionCode {
    //系统相关 start
    SYSTEM_BUSY(-1, "system busy"),
    SYSTEM_TIMEOUT(-2, "time out"),
    VALIDATE_ERROR(-3, "validate error"),
    NOT_FOUND_ENTITT_ERROR(-4, "object not founded"),
    //系统相关 end

    //DB相关 start
    DB_REMOVE_ERROR(10000, "无法软删除"),
    //DB相关 end
    
    //customer role
    DELETE_SYSTEM_ROLE_ERROR(20000, "System role could not be deleted"),
    EDIT_SYSTEM_ROLE_ERROR(20001, "can not edit system role "),
    //customer role
    //Customer
    DELETE_SYSTEM_ACCOUNT_ERROR(20001, "can not delete system system "),
    //Customer
	 TOKEN_EXPIRED(40001, "token expired");
	 
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
