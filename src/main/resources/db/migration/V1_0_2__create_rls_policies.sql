DROP policy if exists users_isolation_policy ON public.users;

CREATE POLICY users_isolation_policy ON public.users
	USING (tenant_id = current_setting('app.current_tenant', true)::text);

ALTER TABLE public.users ENABLE ROW LEVEL SECURITY;
