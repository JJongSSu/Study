-- https://school.programmers.co.kr/learn/courses/30/lessons/59040
-- 고양이와 개가 각각 몇 마리인지 조회하는 SQL문, 고양이를 개보다 먼저 조회
SELECT ANIMAL_TYPE, count(ANIMAL_TYPE) from ANIMAL_INS
group by ANIMAL_TYPE
order by ANIMAL_TYPE;