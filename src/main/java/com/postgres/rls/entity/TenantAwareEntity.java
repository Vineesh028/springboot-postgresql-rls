package com.postgres.rls.entity;

import com.postgres.rls.config.TenantListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(TenantListener.class)
public abstract class TenantAwareEntity implements TenantAware {

  @Column(name = "tenant_id", nullable = false)
  private String tenantId;

  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }
}
