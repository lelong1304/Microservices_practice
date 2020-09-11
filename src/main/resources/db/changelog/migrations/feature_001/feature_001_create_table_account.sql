--liquibase formatted sql
--changeset long.le:feature_001

CREATE SEQUENCE account_id_seq;

CREATE TABLE account
(
    id integer not NULL DEFAULT NEXTVAL('account_id_seq') PRIMARY KEY,
    first_name CHARACTER VARYING (100),
    last_name CHARACTER VARYING (100),
    email CHARACTER VARYING (200),
    account_name CHARACTER VARYING (100),
    password CHARACTER VARYING (100),
    status CHARACTER VARYING (10)
)
WITH (
    OIDS = false
);

--rollback DROP TABLE account;
--rollback DROP SEQUENCE account_id_seq;