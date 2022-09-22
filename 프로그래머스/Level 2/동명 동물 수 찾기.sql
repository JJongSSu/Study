-- https://school.programmers.co.kr/learn/courses/30/lessons/59041
-- 두 번 이상 쓰인 이름과 해당 이름이 쓰인 횟수를 조회하는 SQL
-- 결과는 이름이 없는 동물은 집계에서 제외하며, 결과는 이름 순으로 조회

select name, A.count from (
    select name, count(name) as count from ANIMAL_INS
    where name is not null
    group by name
    ) A
where A.count > 1
order by name;