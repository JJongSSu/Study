-- https://school.programmers.co.kr/learn/courses/30/lessons/59409
-- 동물의 아이디와 이름, 중성화 여부를 아이디 순으로 조회하는 SQL
-- 중성화된 동물은 SEX_UPON_INTAKE 컬럼에 'Neutered' 또는 'Spayed'라는 단어
-- 중성화가 되어있다면 'O', 아니라면 'X'라고 표시
SELECT ANIMAL_ID, name, (
  CASE WHEN SEX_UPON_INTAKE like '%Neutered%' or SEX_UPON_INTAKE like  '%Spayed%' 
    THEN 'O'
    else 'X'
  END) AS SEX_UPON_INTAKE from ANIMAL_INS
order by ANIMAL_ID
;