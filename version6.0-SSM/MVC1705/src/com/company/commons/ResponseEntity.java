package com.company.commons;

import java.io.Serializable;

public class ResponseEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private int code;
	private String msg;
	private T data;

	public ResponseEntity() {
		// TODO Auto-generated constructor stub
	}

	public ResponseEntity(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ResponseEntity(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ResponseEntity(int code, T data) {
		super();
		this.code = code;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponeEntity [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
