-- https://school.programmers.co.kr/learn/courses/30/lessons/59407
-- 동물 보호소에 들어온 동물 중, 이름이 있는 동물의 ID를 조회하는 SQL
SELECT ANIMAL_ID from ANIMAL_INS
where name is not null
order by ANIMAL_ID;