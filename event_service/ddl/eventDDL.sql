CREATE DATABASE event_service;

GRANT ALL PRIVILEGES ON DATABASE postgres TO postgres;

\connect event_service;
CREATE SCHEMA IF NOT EXISTS final_project
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS final_project.events_films
(
    uuid uuid NOT NULL,
    date_of_create timestamp(3) without time zone,
    date_of_update timestamp(3) without time zone,
    status character varying(255) COLLATE pg_catalog."default",
    type character varying(255) COLLATE pg_catalog."default",
    country uuid,
    description character varying(255) COLLATE pg_catalog."default",
    dt_end_of_sale bigint,
    dt_event bigint,
    duration integer,
    release_date date,
    release_year integer,
    title character varying(255) COLLATE pg_catalog."default"
)
    TABLESPACE pg_default;



CREATE TABLE IF NOT EXISTS final_project.events_concerts
(
    uuid uuid NOT NULL,
    date_of_create timestamp(3) without time zone,
    date_of_update timestamp(3) without time zone,
    status character varying(255) COLLATE pg_catalog."default",
    type character varying(255) COLLATE pg_catalog."default",
    category uuid,
    description character varying(255) COLLATE pg_catalog."default",
    dt_end_of_sale integer,
    dt_event integer,
    title character varying(255) COLLATE pg_catalog."default"
)
    TABLESPACE pg_default;


CREATE TABLE IF NOT EXISTS final_project.user_holder
(
    uuid uuid NOT NULL,
    username character varying(255) COLLATE pg_catalog."default",
    role character varying(255) COLLATE pg_catalog."default" NOT NULL
)
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS final_project.user_holder
    OWNER to postgres;

ALTER TABLE IF EXISTS final_project.events_films
    OWNER to postgres;

ALTER TABLE IF EXISTS final_project.events_concerts
    OWNER to postgres;


ALTER TABLE IF EXISTS final_project.events_films
    ADD CONSTRAINT events_films_pkey PRIMARY KEY (uuid);

ALTER TABLE IF EXISTS final_project.events_concerts
    ADD CONSTRAINT events_concerts_pkey PRIMARY KEY (uuid);

ALTER TABLE IF EXISTS final_project.user_holder
    ADD CONSTRAINT user_holder_pkey PRIMARY KEY (uuid, role);