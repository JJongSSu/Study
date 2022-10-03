-- 헤비 유저가 등록한 공간의 정보를 아이디 순으로 조회
-- 공간을 둘 이상 등록한 사람을 "헤비 유저"
select p.ID, p.NAME, p.HOST_ID 
from (SELECT HOST_ID, count(HOST_ID) as count from PLACES
group by HOST_ID) a inner join PLACES p on p.HOST_ID = a.HOST_ID
where a.count > 1
order by p.ID;