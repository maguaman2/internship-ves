CREATE OR REPLACE VIEW practice_view AS
SELECT
    p.id AS practice_id,
    p.semester,
    p.term,
    p.start_date,
    p.end_date,
    p.delivery_date,
    s.id AS student_id,
    s.first_name AS student_first_name,
    s.last_name AS student_last_name,
    s.email AS student_email
FROM
    practice p
        INNER JOIN
    student s ON p.student_id = s.id;
