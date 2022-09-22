-- https://school.programmers.co.kr/learn/courses/30/lessons/59405
-- 동물 보호소에 가장 먼저 들어온 동물의 이름을 조회하는 SQL
SELECT NAME from ANIMAL_INS
WHERE DATETIME IN (SELECT min(DATETIME) FROM ANIMAL_INS);