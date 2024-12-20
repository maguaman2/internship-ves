CREATE OR REPLACE VIEW practice_activity_view AS
SELECT
    p.id AS practice_id,
    p.semester,
    p.term,
    p.start_date AS practice_start_date,
    p.end_date AS practice_end_date,
    a.id AS activity_id,
    a.description AS activity_description,
    a.created_at AS activity_created_at,
    a.start_time AS activity_start_time,
    a.end_time AS activity_end_time,
    a.hours AS activity_hours,
    a.resources AS activity_resources,
    a.observation AS activity_observation
FROM
    practice p
        LEFT JOIN
    activity a
    ON
        p.id = a.practice_id;
