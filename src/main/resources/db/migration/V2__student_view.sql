CREATE VIEW student_view AS
SELECT
    s.id AS student_id,
    s.first_name,
    s.last_name,
    s.email AS student_email,
    s.career_id,
    c.id AS company_id,
    c.entity_name AS company_name,
    c.ceo AS company_ceo
FROM
    student s
    LEFT JOIN company c ON s.career_id = c.id;