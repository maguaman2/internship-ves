CREATE VIEW academic_tutor_view AS
SELECT
    at.id AS tutor_id,
    at.full_name AS tutor_name,
    at.phone AS tutor_phone,
    at.email AS tutor_email,
    c.description AS career_description
FROM academic_tutor at
JOIN career c ON at.career_id = c.id;
