-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회
select o.ANIMAL_ID, o.NAME from ANIMAL_INS i right outer join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID
# where i.ANIMAL_ID is null
order by o.ANIMAL_ID;