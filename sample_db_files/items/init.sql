CREATE TABLE IF NOT EXISTS public.items
(
    item_id text COLLATE pg_catalog."default" NOT NULL,
    owner_id text COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    category text COLLATE pg_catalog."default",
    CONSTRAINT items_pkey PRIMARY KEY (item_id)
)

TABLESPACE pg_default;

ALTER TABLE public.items
    OWNER to postgres;