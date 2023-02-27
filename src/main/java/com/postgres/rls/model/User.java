package com.postgres.rls.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class User {

	@NotBlank
	private String id;

	@NotBlank
	private String name;

	@NotBlank
	private String email;

}
