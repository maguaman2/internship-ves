--Pimero las tablas que no tienen llave foranea
--Carlos Quituisaca  (CarlosQ18a)
CREATE TABLE IF NOT EXISTS career
(
    id               SERIAL PRIMARY KEY,
    description      VARCHAR(255) NOT NULL,
    institution_name VARCHAR(255) NOT NULL,
    cycle            INT          NOT NULL
);

--Micaela Barbecho (micaelabar)
CREATE TABLE IF NOT EXISTS  company
(
    id          SERIAL PRIMARY KEY,
    entity_name VARCHAR(255) NOT NULL,
    ceo         VARCHAR(255) NOT NULL,
    latitude    DECIMAL(10, 7),
    longitude   DECIMAL(10, 7)

);

--Ariel Samaniego  (ariel12m)
CREATE TABLE IF NOT EXISTS  student
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    nui        VARCHAR(10)  NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    photo_url  VARCHAR(100),
    email      VARCHAR(100) NOT NULL,
    career_id  INT          NOT NULL,
    CONSTRAINT fk_career FOREIGN KEY (career_id) REFERENCES career (id)
);

--Jose Calle (josecalle0711)
CREATE TABLE IF NOT EXISTS  academic_tutor
(
    id        SERIAL,
    full_name VARCHAR(100) NOT NULL,
    phone     VARCHAR(15),
    email     VARCHAR(50),
    career_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (career_id) REFERENCES career (id)
);

CREATE TABLE IF NOT EXISTS  company_tutor
(
    id         SERIAL,
    full_name  VARCHAR(100) NOT NULL,
    phone      VARCHAR(15),
    email      VARCHAR(50),
    company_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (company_id) REFERENCES company (id)
);

--Pablo Sari (Andrés10M)
CREATE TABLE IF NOT EXISTS practice
(
    id               SERIAL PRIMARY KEY,
    semester         VARCHAR(50) NOT NULL,
    term             VARCHAR(50) NOT NULL,
    start_date       DATE        NOT NULL,
    end_date         DATE        NOT NULL,
    delivery_date    DATE,
    student_id       INT         NOT NULL,
    company_tutor_id INT,
    FOREIGN KEY (student_id) REFERENCES STUDENT (id),
    FOREIGN KEY (company_tutor_id) REFERENCES company_tutor (id)

);


--Franks Gonzalez (Franks11m)
CREATE TABLE IF NOT EXISTS activity
(
    id          SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    created_at  DATE NOT NULL,
    start_time  DATE NOT NULL,
    end_time    DATE NOT NULL,
    hours       INT,
    resources   TEXT,
    observation TEXT,
    practice_id INT  NOT NULL,
    FOREIGN KEY (practice_id) REFERENCES practice (id)
);

CREATE TABLE IF NOT EXISTS evaluation
(
    id          SERIAL PRIMARY KEY,
    career_name VARCHAR(255),
    category    VARCHAR(255),
    grade       DECIMAL(5, 2),
    practice_id INT NOT NULL,
    FOREIGN KEY (practice_id) REFERENCES practice (id)
);

CREATE TABLE IF NOT EXISTS parameter
(
    id            SERIAL PRIMARY KEY,
    description   TEXT    NOT NULL,
    valor         NUMERIC NOT NULL,
    evaluation_id INTEGER NOT NULL,
    FOREIGN KEY (evaluation_id) REFERENCES evaluation (id)
);