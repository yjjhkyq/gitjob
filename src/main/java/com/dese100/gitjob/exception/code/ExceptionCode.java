package com.dese100.gitjob.exception.code;

public enum ExceptionCode implements BaseExceptionCode {
    //系统相关 start
    SYSTEM_BUSY(-1, "系统繁忙，请稍候再试"),
    SYSTEM_TIMEOUT(-2, "系统超时，请稍候再试"),
    //系统相关 end

    //DB相关 start
    DB_REMOVE_ERROR(10000, "无法软删除"),
    //DB相关 end
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
