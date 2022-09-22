-- https://school.programmers.co.kr/learn/courses/30/lessons/59410
-- 동물의 생물 종, 이름, 성별 및 중성화 여부를 아이디 순으로 조회
-- 이름이 없는 동물의 이름은 "No name"으로 표시
SELECT ANIMAL_TYPE, (case when NAME is NULL then 'No name' else name end) as Name, SEX_UPON_INTAKE from ANIMAL_INS
order by ANIMAL_ID
;