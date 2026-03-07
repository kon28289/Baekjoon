-- 코드를 작성해주세요
SELECT
    CASE
        WHEN (fe.CODE & d.SKILL_CODE) > 0 && (py.CODE & d.SKILL_CODE) > 0 THEN 'A'
        WHEN (cs.CODE & d.SKILL_CODE) > 0 THEN 'B'
        WHEN (fe.CODE & d.SKILL_CODE) > 0 THEN 'C'
    END as GRADE,
    d.ID,
    d.EMAIL
FROM DEVELOPERS d
CROSS JOIN (
    SELECT SUM(CODE) as CODE
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
) fe
CROSS JOIN (
    SELECT CODE
    FROM SKILLCODES
    WHERE NAME = 'C#'
) cs
CROSS JOIN (
    SELECT CODE
    FROM SKILLCODES
    WHERE NAME = 'Python'
) py
WHERE (fe.CODE & d.SKILL_CODE) > 0 && (py.CODE & d.SKILL_CODE) > 0 
    OR (cs.CODE & d.SKILL_CODE) > 0
    OR (fe.CODE & d.SKILL_CODE) > 0
ORDER BY GRADE, ID
