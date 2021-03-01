CREATE TABLE "appointment"
(
    id bigserial  NOT NULL,
    description character varying(255),
    CONSTRAINT appointment_pkey PRIMARY KEY (id)
);

ALTER TABLE "appointment" OWNER to postgres;

CREATE TABLE "merchandise_user"
(
    id bigserial  NOT NULL,
    name character varying(255)  NOT NULL,
    age bigint,
    id_appointment bigint NOT NULL,
    cia_admission_date date,
    CONSTRAINT merchandise_user_pkey PRIMARY KEY (id)
);

ALTER TABLE "merchandise_user"  OWNER to postgres;

CREATE TABLE "merchandise"
(
    id bigserial  NOT NULL ,
    product_name character varying(255) NOT NULL ,
    amount bigint NOT NULL,
    admission_date date NOT NULL,
    id_user bigint NOT NULL,
    CONSTRAINT merchandise_pkey PRIMARY KEY (id),
    CONSTRAINT merchandise_product_name_key UNIQUE (product_name)
);

ALTER TABLE "merchandise"  OWNER to postgres;

-- ----------------------------
-- Foreign Keys
-- ----------------------------
ALTER TABLE "merchandise_user" ADD CONSTRAINT fk_appointment FOREIGN KEY (id_appointment) REFERENCES "appointment" (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "merchandise"      ADD CONSTRAINT fk_user FOREIGN KEY (id_user) REFERENCES "merchandise_user" (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
