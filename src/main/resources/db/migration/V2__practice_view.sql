CREATE VIEW practice_student_view AS
SELECT
    p.id AS practice_id,
    p.semester,
    p.term,
    p.start_date,
    p.end_date,
    p.delivery_date,
    s.id AS student_id,
    s.first_name,
    s.last_name,
    s.nui,
    s.email,
    s.photo_url,
    c.description AS career_description,
    c.institution_name AS career_institution
FROM
    practice p
        JOIN
    student s ON p.student_id = s.id
        JOIN
    career c ON s.career_id = c.id;
