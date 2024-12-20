CREATE VIEW evaluation_view AS
SELECT
    e.id AS evaluation_id,
    e.career_name,
    e.category,
    e.grade,
    e.practice_id,
    p.semester,
    p.term,
    p.start_date,
    p.end_date,
    p.delivery_date,
    p.student_id,
    p.company_tutor_id
FROM
    evaluation e
        JOIN
    practice p
    ON
        e.practice_id = p.id;
