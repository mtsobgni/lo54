
CREATE TABLE client (
    id_client integer NOT NULL,
    id_session integer,
    lastname character varying(60),
    firstname character varying(60),
    address character varying(120),
    phone character varying(20),
    email character varying(50)
);

CREATE TABLE course (
    code character varying(20) NOT NULL,
    title character varying(50) NOT NULL
);

CREATE TABLE course_session (
    id_session integer NOT NULL,
    id integer NOT NULL,
    code character varying(40) NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL,
    max integer
);

CREATE TABLE location (
    id integer NOT NULL,
    city character varying(50) NOT NULL
);

ALTER TABLE course_session
    ADD CONSTRAINT "COURSE_SESSION_pkey" PRIMARY KEY (id_session);

ALTER TABLE course
    ADD CONSTRAINT "COURSE_pkey" PRIMARY KEY (code);

ALTER TABLE location
    ADD CONSTRAINT "LOCATION_pkey" PRIMARY KEY (id);

ALTER TABLE client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id_client);

ALTER TABLE course_session
    ADD CONSTRAINT "CODE_COURSE_SESSION" FOREIGN KEY (code) REFERENCES course(code);

ALTER TABLE course_session
    ADD CONSTRAINT "LOCATION_COURSE_SESSION" FOREIGN KEY (id) REFERENCES location(id);

ALTER TABLE client
    ADD CONSTRAINT client_course_session FOREIGN KEY (id_session) REFERENCES course_session(id_session);


