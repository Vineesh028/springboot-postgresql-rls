package com.postgres.rls.entity;

public interface TenantAware {

	String getTenantId();

	void setTenantId(String tenant);

}
