-- 보호소에 들어올 당시에는 중성화되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회
-- 아이디 순으로 조회
SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME from ANIMAL_INS i inner join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID
where (i.SEX_UPON_INTAKE like '%Intact%') and (o.SEX_UPON_OUTCOME like '%Neutered%' or o.SEX_UPON_OUTCOME like '%Spayed%')
order by i.ANIMAL_ID;