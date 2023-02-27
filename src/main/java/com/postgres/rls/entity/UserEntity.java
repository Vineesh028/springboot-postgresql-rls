package com.postgres.rls.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends TenantAwareEntity{

	@Id
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

}
