-- https://school.programmers.co.kr/learn/courses/30/lessons/59046
-- 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물의 아이디와 이름, 성별 및 중성화 여부를 조회하는 SQL
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE from ANIMAL_INS
where name in ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty');