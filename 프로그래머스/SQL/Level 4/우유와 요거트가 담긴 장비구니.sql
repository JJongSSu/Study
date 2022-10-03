-- 우유와 요거트를 동시에 구입한 장바구니의 아이디를 조회하는 SQL 문
-- 장바구니의 아이디 순
select a.CART_ID from (SELECT CART_ID, NAME from CART_PRODUCTS
    where NAME likae '%Yogurt%') a, 
    (SELECT CART_ID, NAME from CART_PRODUCTS 
     where NAME like '%Milk%') b
where a.CART_ID = b.CART_ID
order by a.CART_ID;