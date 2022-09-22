-- https://school.programmers.co.kr/learn/courses/30/lessons/59408
-- 동물 보호소에 들어온 동물의 이름은 몇 개인지 조회하는 SQL
-- 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나
SELECT count(DISTINCT name) from ANIMAL_INS
where name is not null;