
CREATE TABLE public.users (
    id character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    tenant_id character varying(255) NOT NULL,
    email character varying(255) NOT NULL
   
);

ALTER TABLE users
    OWNER to postgres;
