package com.postgres.rls.config;





public class TenantContext {

  private static final InheritableThreadLocal<String> currentTenant = new InheritableThreadLocal<>();

  private TenantContext() {
  }

  public static String getTenantId() {
    return currentTenant.get();
  }

  public static void setTenantId(final String tenantId) {
    currentTenant.set(tenantId);
  }

  public static void clear() {
    currentTenant.remove();
  }

}
