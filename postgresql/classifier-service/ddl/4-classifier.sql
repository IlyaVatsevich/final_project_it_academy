CREATE DATABASE  classifier_service;

GRANT ALL PRIVILEGES ON DATABASE postgres TO postgres;

\connect classifier_service;
CREATE SCHEMA IF NOT EXISTS final_project_classifier
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS final_project_classifier.concert_categories
(
    uuid uuid NOT NULL,
    date_of_create timestamp(3) without time zone,
    date_of_update timestamp(3) without time zone,
    title character varying(255) COLLATE pg_catalog."default"
)
    TABLESPACE pg_default;


CREATE TABLE IF NOT EXISTS final_project_classifier.countries
(
    uuid uuid NOT NULL,
    date_of_create timestamp(3) without time zone,
    date_of_update timestamp(3) without time zone,
    description character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default"
)
    TABLESPACE pg_default;


ALTER TABLE IF EXISTS final_project_classifier.countries
    OWNER to postgres;

ALTER TABLE IF EXISTS final_project_classifier.concert_categories
    OWNER to postgres;

ALTER TABLE IF EXISTS final_project_classifier.concert_categories
    ADD CONSTRAINT concert_categories_pkey PRIMARY KEY (uuid);

ALTER TABLE IF EXISTS final_project_classifier.countries
    ADD CONSTRAINT countries_pkey PRIMARY KEY (uuid);


