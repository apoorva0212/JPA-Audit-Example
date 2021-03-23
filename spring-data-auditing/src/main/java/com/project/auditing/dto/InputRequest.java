package com.project.auditing.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
//To ignore any unknown properties in JSON input without exception, we can set ignoreUnknown=true of @JsonIgnoreProperties annotation.
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputRequest<T> {
	@JsonProperty(value="userId", required=true)
	private String loggedInUser;
	private String timeZone;
	private T employee;

}
