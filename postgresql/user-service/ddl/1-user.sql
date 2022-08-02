CREATE DATABASE user_service;

GRANT ALL PRIVILEGES ON DATABASE postgres TO postgres;

\connect user_service;
CREATE SCHEMA IF NOT EXISTS final_project_user AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS final_project_user.users
(
    uuid uuid NOT NULL,
    date_of_create timestamp(3) without time zone,
    date_of_update timestamp(3) without time zone,
    mail character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nick character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default"
)
    TABLESPACE pg_default;



CREATE TABLE IF NOT EXISTS final_project_user.user_roles
(
    uuid uuid NOT NULL,
    role character varying(255) COLLATE pg_catalog."default"
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS final_project_user.users
    OWNER to postgres;

ALTER TABLE IF EXISTS final_project_user.user_roles
    OWNER to postgres;

ALTER TABLE IF EXISTS final_project_user.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (uuid),
    ADD CONSTRAINT uk_jhck7kjdogc7yia7qamc89ypv UNIQUE (mail);

ALTER TABLE IF EXISTS final_project_user.user_roles
    ADD CONSTRAINT fkt4lx3rpw6gxkb49bvohe3sq5m FOREIGN KEY (uuid)
        REFERENCES final_project_user.users (uuid) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE;


