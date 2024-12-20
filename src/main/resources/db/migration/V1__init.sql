-- Crear la tabla career
CREATE TABLE IF NOT EXISTS career
(
    id               SERIAL PRIMARY KEY,
    description      VARCHAR(255) NOT NULL,
    institution_name VARCHAR(255) NOT NULL,
    cycle            INT          NOT NULL
    );

-- Inserts para career
INSERT INTO career (description, institution_name, cycle)
VALUES
    ('Ingeniería de Software', 'Universidad Ejemplo', 1),
    ('Ingeniería Electrónica', 'Instituto Técnico', 2);

-- Crear la tabla company
CREATE TABLE IF NOT EXISTS company
(
    id          SERIAL PRIMARY KEY,
    entity_name VARCHAR(255) NOT NULL,
    ceo         VARCHAR(255) NOT NULL,
    latitude    DECIMAL(10, 7),
    longitude   DECIMAL(10, 7)
    );

-- Inserts para company
INSERT INTO company (entity_name, ceo, latitude, longitude)
VALUES
    ('Compañía ABC', 'Carlos Pérez', 40.712776, -74.005974),
    ('Tecnología XYZ', 'Ana López', 34.052235, -118.243683);

-- Crear la tabla student
CREATE TABLE IF NOT EXISTS student
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

-- Inserts para student
INSERT INTO student (first_name, last_name, nui, email, career_id)
VALUES
    ('Juan', 'Pérez', '1234567890', 'juan.perez@example.com', 1),
    ('Ana', 'González', '0987654321', 'ana.gonzalez@example.com', 2);

-- Crear la tabla academic_tutor
CREATE TABLE IF NOT EXISTS academic_tutor
(
    id        SERIAL,
    full_name VARCHAR(100) NOT NULL,
    phone     VARCHAR(15),
    email     VARCHAR(50),
    career_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (career_id) REFERENCES career (id)
    );

-- Inserts para academic_tutor
INSERT INTO academic_tutor (full_name, phone, email, career_id)
VALUES
    ('Dr. Luis Martínez', '555-123456', 'luis.martinez@example.com', 1),
    ('Prof. María Rodríguez', '555-654321', 'maria.rodriguez@example.com', 2);

-- Crear la tabla company_tutor
CREATE TABLE IF NOT EXISTS company_tutor
(
    id         SERIAL,
    full_name  VARCHAR(100) NOT NULL,
    phone      VARCHAR(15),
    email      VARCHAR(50),
    company_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (company_id) REFERENCES company (id)
    );

-- Inserts para company_tutor
INSERT INTO company_tutor (full_name, phone, email, company_id)
VALUES
    ('Pedro Gómez', '555-112233', 'pedro.gomez@abc.com', 1),
    ('Laura Díaz', '555-445566', 'laura.diaz@xyz.com', 2);

-- Crear la tabla practice
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
    FOREIGN KEY (student_id) REFERENCES student (id),
    FOREIGN KEY (company_tutor_id) REFERENCES company_tutor (id)
    );

-- Inserts para practice
INSERT INTO practice (semester, term, start_date, end_date, delivery_date, student_id, company_tutor_id)
VALUES
    ('2024-A', 'Primer término', '2024-01-01', '2024-06-30', '2024-07-15', 1, 1),
    ('2024-A', 'Primer término', '2024-01-01', '2024-06-30', '2024-07-15', 2, 2);

-- Crear la tabla activity
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

-- Inserts para activity
INSERT INTO activity (description, created_at, start_time, end_time, hours, resources, observation, practice_id)
VALUES
    ('Revisión de código', '2024-01-15', '2024-01-15 10:00:00', '2024-01-15 12:00:00', 2, 'Computadora, IDE', 'Revisión de las primeras líneas de código', 1),
    ('Desarrollo de funcionalidades', '2024-02-20', '2024-02-20 14:00:00', '2024-02-20 18:00:00', 4, 'Computadora, IDE', 'Desarrollo de nuevas funcionalidades del sistema', 2);

-- Crear la tabla evaluation
CREATE TABLE IF NOT EXISTS evaluation
(
    id          SERIAL PRIMARY KEY,
    career_name VARCHAR(255),
    category    VARCHAR(255),
    grade       DECIMAL(5, 2),
    practice_id INT NOT NULL,
    FOREIGN KEY (practice_id) REFERENCES practice (id)
    );

-- Inserts para evaluation
INSERT INTO evaluation (career_name, category, grade, practice_id)
VALUES
    ('Ingeniería de Software', 'Desarrollo', 90.5, 1),
    ('Ingeniería Electrónica', 'Práctica Profesional', 85.0, 2);

-- Crear la tabla parameter
CREATE TABLE IF NOT EXISTS parameter
(
    id            SERIAL PRIMARY KEY,
    description   TEXT    NOT NULL,
    valor         NUMERIC NOT NULL,
    evaluation_id INTEGER NOT NULL,
    FOREIGN KEY (evaluation_id) REFERENCES evaluation (id)
    );

-- Inserts para parameter
INSERT INTO parameter (description, valor, evaluation_id)
VALUES
    ('Calificación del código', 9.5, 1),
    ('Calificación de la presentación', 8.0, 2);