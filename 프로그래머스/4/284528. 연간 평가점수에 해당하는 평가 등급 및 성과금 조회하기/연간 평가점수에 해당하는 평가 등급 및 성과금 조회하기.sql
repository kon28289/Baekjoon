-- 코드를 작성해주세요
SELECT
    g.EMP_NO,
    e.EMP_NAME,
    CASE
        WHEN SUM(g.SCORE) >= 192 THEN 'S'
        WHEN SUM(g.SCORE) >= 180 THEN 'A'
        WHEN SUM(g.SCORE) >= 160 THEN 'B'
        ELSE 'C'
    END as GRADE,
    CASE
        WHEN SUM(g.SCORE) >= 192 THEN (e.SAL / 100) * 20
        WHEN SUM(g.SCORE) >= 180 THEN (e.SAL / 100) * 15
        WHEN SUM(g.SCORE) >= 160 THEN (e.SAL / 100) * 10
        ELSE 0
    END as BONUS
FROM HR_EMPLOYEES e
JOIN HR_GRADE g ON e.EMP_NO = g.EMP_NO
GROUP BY g.EMP_NO
ORDER BY g.EMP_NO
