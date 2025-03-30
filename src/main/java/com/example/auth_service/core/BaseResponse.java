package com.example.auth_service.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponse<T> {
	private int status;
	private String message;
	private T data;
	public BaseResponse(int status, String message, T data) {
	    this.status = status;
	    this.message = message;
	    this.data = data;
	}
	
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<T>(200, "Thành công", data);
    }

    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse<T>(500, message, null);
    }
}
