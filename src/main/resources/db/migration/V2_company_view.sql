CREATE OR REPLACE VIEW company_view AS
SELECT
    c.id AS company_id,
    c.entity_name AS company_name,
    c.ceo AS company_ceo,
    c.latitude AS company_latitude,
    c.longitude AS company_longitude
FROM
    company c;