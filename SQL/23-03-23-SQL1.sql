--Çalışanlarda tittle dr olanları getir.

Select first_name ad,last_name soyad from employees where title_of_courtesy = 'Dr.'

--toplam terrotories sayısını bulalım

Select Count(* ) as "Toplam Bölge" from territories

--toplam calısan sayısını kolon ismini Toplam Çalışan Sayısı olarak yazdıralım.

Select Count(* ) as "Toplam Çalışan Sayısı" from employees 

--title_of_coutrsey tekrarlanmayan verileri getir

SELECT DISTINCT title_of_courtesy FROM employees

SELECT title_of_courtesy, first_name FROM employees WHERE (title_of_courtesy, first_name)in(SELECT title_of_courtesy, MIN(first_name) FROM employees GROUP BY title_of_courtesy)

--calısan erkek sayısı 

Select count(*) as "Toplam Erkek Çalışan" from employees where title_of_courtesy = 'Mr.'

--calısan kadın sayısı
 
Select count(*) as "Toplam Kadın Çalışan" from employees where title_of_courtesy = 'Mrs.'

--hiç sipariş vermemiş müşteriler

Select * from customers where customer_id not in (select customer_id from orders)

--regoion u eastern olan territiroiesleri bul

Select region_id from region where region_description='Eastern'

Select * from territories Where region_id = (Select region_id from region where region_description='Eastern')

SELECT * FROM territories inner JOIN region ON region.region_id=territories.region_id where region_description='Eastern'

--Çalışanlar kaç farklı şehirde çalışıyor

Select count(DISTINCT city) from employees

--Dogum tarihi 5 mayis 1960 dan büyük olan 

Select * from employees Where birth_date >'1960-05-05'

--çalışanların yaş ortalamasını bulalım.

--postgre bugünün tarihini nasıl buluruz.


select avg(extract(year from age(current_date,birth_date))) as "Yaş Ort" from employees

SELECT AVG(AGE(birth_date)) FROM employees

select avg(now()::date - birth_date)/360 FROM employees

--soy isim uzunluğu 6 karakter den küçük olanları getirelim

Select * from employees where LENGTH(last_name) < 6

--product name ilk üç harf

Select SUBSTRING(product_name,1,3) from products

select product_name , left(product_name,4) from products

--satışta olmayan ve sipariş adedi stoktan fazla olan ürünlerim ismini stok adedini sipariş adedini getirelim.

select product_name,units_in_stock,units_on_order,discontinued from products where  discontinued = '1' or (units_on_order >= units_in_stock)

