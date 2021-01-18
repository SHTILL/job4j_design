CREATE TABLE body
(
    id integer NOT NULL,
    name character varying(255),
    CONSTRAINT body_pkey PRIMARY KEY (id)
);

CREATE TABLE engine
(
    id integer NOT NULL,
    name character varying(255),
    CONSTRAINT engine_pkey PRIMARY KEY (id)
);

CREATE TABLE transmission
(
    id integer NOT NULL,
    name character varying(255),
    CONSTRAINT transmission_pkey PRIMARY KEY (id)
);

CREATE TABLE auto
(
    id integer NOT NULL,
    name character varying(255),
    body_id integer NOT NULL,
    engine_id integer NOT NULL,
    transmission_id integer NOT NULL,
    CONSTRAINT auto_pkey PRIMARY KEY (id),
    CONSTRAINT body_fkey   FOREIGN KEY (body_id)         REFERENCES body         (id),
	CONSTRAINT engine_fkey FOREIGN KEY (engine_id)       REFERENCES engine       (id),
	CONSTRAINT trans_fkey  FOREIGN KEY (transmission_id) REFERENCES transmission (id)
)