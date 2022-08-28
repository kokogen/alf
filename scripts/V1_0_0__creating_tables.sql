CREATE TABLE company (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    url VARCHAR(255) NOT NULL,
    area VARCHAR(255) NOT NULL
);

CREATE TABLE location (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    counrty_name VARCHAR(255) NOT NULL
);

CREATE TABLE vacancy (
    id BIGINT PRIMARY KEY,
    company_id BIGINT not null,
    position_name VARCHAR(16) NOT NULL,
    job_mode VARCHAR(16) NOT NULL,
    description VARCHAR(1024) NOT NULL,
    requirements VARCHAR(512) NOT NULL,
    location_id VARCHAR(16) NOT NULL,
    is_active BIT NOT NULL,

    CONSTRAINT "FK_vacancy_to_company" FOREIGN KEY (company_id)
        REFERENCES public.company (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,

    CONSTRAINT "FK_vacancy_to_location" FOREIGN KEY (location_id)
        REFERENCES public.location (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE INDEX "fki_FK_vacancy_to_company"
    ON public.vacancy USING btree
    (company_id ASC NULLS LAST)
    TABLESPACE pg_default;

CREATE INDEX "fki_FK_vacancy_to_location"
    ON public.vacancy USING btree
    (location_id COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;