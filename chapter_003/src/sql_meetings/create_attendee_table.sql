CREATE TABLE attendee
(
    id integer NOT NULL,
    meeting_id integer NOT NULL,
    person_id integer NOT NULL,
    status text NOT NULL,
    CONSTRAINT attendee_pkey PRIMARY KEY (id)
);
