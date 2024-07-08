package com.jsp.Thymeleaf_E_.Commerce_Application.response;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ApplicationResponse<T> {

	private String message;
	private HttpStatus httpStatus;
	private LocalDateTime dateTime;
	private T data;
	private List<T> list;

	public ApplicationResponse(String message, HttpStatus httpStatus, LocalDateTime dateTime, T data) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.dateTime = dateTime;
		this.data = data;
	}

	public ApplicationResponse(String message, HttpStatus httpStatus, LocalDateTime dateTime, List<T> list) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.dateTime = dateTime;
		this.list = list;
	}

	public ApplicationResponse(String message, HttpStatus httpStatus, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.dateTime = dateTime;
	}

}
