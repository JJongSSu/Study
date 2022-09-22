-- https://school.programmers.co.kr/learn/courses/30/lessons/59414
-- 각 동물의 아이디와 이름, 들어온 날짜1를 조회하는 SQL문, 아이디 순으로 조회
-- 시각(시-분-초)을 제외한 날짜(년-월-일)만 보여주세요.
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, "%Y-%m-%d") from ANIMAL_INS;