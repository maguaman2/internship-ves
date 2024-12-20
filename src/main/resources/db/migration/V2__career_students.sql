CREATE VIEW career_students AS
SELECT
    s.id AS studentId,
    s.career_id AS careerId,
    c.description AS careerDescription,
    c.institution_name AS institutionName,
    c.cycle,
    s.first_name AS firstName,
    s.last_name AS lastName,
    s.nui,
    s.email,
    s.photo_url AS photoUrl
FROM student s
         JOIN career c ON s.career_id = c.id;
