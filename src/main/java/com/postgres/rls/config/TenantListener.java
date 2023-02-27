package com.postgres.rls.config;

import com.postgres.rls.entity.TenantAware;

import jakarta.persistence.PrePersist;

public class TenantListener {

	@PrePersist
	public void setTenant(final TenantAware entity) {
		final String tenantId = TenantContext.getTenantId();
		entity.setTenantId(tenantId);
	}

}