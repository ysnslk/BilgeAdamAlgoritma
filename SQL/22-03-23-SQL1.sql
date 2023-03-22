-- iteam tablosunda unit price 5.15 olanları getirelim.

Select * from items where unitprice = 5.15

--items tablosunda unitprice 5ten büyük ve kategorisi ev

Select * from items where unitprice  > 5 and category1 = 'EV'

--items tablosunda unitprice 5ten büyük ve kategorisi ev veya manav

Select * from items where unitprice  > 5 and (category1 = 'EV' or category2='MANAV')

--items tablosunda category1 ev olmayanları getir

Select * from items where  category1 <> 'EV'

Select * from items where not category1 = 'EV'

Select * from items where  category1 != 'EV'


--invoices tablosundan total price 500 ile 650 arasındaki order idsini getir

Select orderid,totalprice from invoices where (totalprice >=500 and totalprice <=650)

Select orderid,totalprice from invoices where totalprice between 500 and 650

--orders tablosunda total price 500den büyük olan ilk 5 deger

Select * from orders where totalprice >500 limit 5

--orders tablosunda total price 500den büyük olan ilk 5 deger büyükten kücüe

Select * from orders where totalprice >500  ORDER BY totalprice DESC limit 5

--cities tablosunda ankara ve bursayı getiren tablo

Select * from cities where city = 'ANKARA' or city = 'BURSA'

Select * from cities where city in ('ANKARA','BURSA')

--Anakra şehrinin idsini cities tablosunda bulup adres rablosunda city id eşit olan degelerni döndor
Select id from cities where city like 'A%'

select * from address where cityid in (Select id from cities where city = 'ANKARA') 

select * from address where cityid in (Select id from cities where city ilike 'A%') 

select * from address where cityid = (Select id from cities where city = 'ANKARA') 

select * from users where namesurname ilike'%az%'

--namesurname a ile başlayanların siparişini getiren sorgu

select * from users where namesurname ilike'a%'

select * from orders where userid in (select id from users where namesurname like'A%')

Select * from cities where lower (city) = lower ('ANKARA')

update cities set city='ankara' where city = 'ANKARA' returning *

update cities set city='ANKARA' where city = 'ankara' returning *

update cities set 'ANKARA' = lower('ANKARA')

delete from users where id = 4

Select * from users

--orders tablosunda totalprice değeri en yüksek değerini id ve addressid sini getir

select userid,addressid from orders where totalprice = (SELECT MAX(totalprice) AS LargestPrice FROM orders)

