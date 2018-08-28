package com.dese100.gitjob.exception;

public interface BaseException {

	/**
	 * 返回异常信息
	 * @return
	 */
	String getMessage();

	/**
	 * 返回异常编码
	 * @return
	 */
	int getCode();

}
