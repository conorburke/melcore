CREATE TABLE IF NOT EXISTS public.owners
(
    owner_id text COLLATE pg_catalog."default" NOT NULL,
    first_name text COLLATE pg_catalog."default",
    last_name text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT owners_pkey PRIMARY KEY (owner_id)
)

TABLESPACE pg_default;

ALTER TABLE public.owners
    OWNER to postgres;