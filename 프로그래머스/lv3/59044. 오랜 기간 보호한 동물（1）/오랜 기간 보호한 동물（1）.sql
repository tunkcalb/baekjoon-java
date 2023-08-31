-- 코드를 입력하세요
SELECT I.NAME, I.DATETIME 
from ANIMAL_INS I 
left outer join ANIMAL_OUTS O 
on I.ANIMAL_ID = O.ANIMAL_ID
where O.DATETIME is null
order by DATETIME asc
limit 3;
