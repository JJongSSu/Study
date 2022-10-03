-- 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL, 시간대 순으로 정렬
# 왜 SET @HOUR = -1로만 해야 되는 거임??
SET @HOUR = -1;
SELECT (@HOUR := @HOUR +1) AS HOUR,  
(select count(hour(DATETIME)) from ANIMAL_OUTS where hour(DATETIME) = @HOUR) as count 
FROM ANIMAL_OUTS
WHERE @HOUR < 23
group by HOUR
;