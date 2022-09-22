-- https://school.programmers.co.kr/learn/courses/30/lessons/59412
-- 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL, 시간대 순으로 정렬
select A.hour, A.count from(
SELECT hour(DATETIME) as hour, count(hour(DATETIME)) as count from ANIMAL_OUTS
group by hour(DATETIME)
) A
where A.hour >= 9 and A.hour<20
order by A.hour
;