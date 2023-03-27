-- Hangi tedarikçi hangi ürünü sağlıyor.

select company_name , product_name from suppliers , products where suppliers.supplier_id = products.supplier_id

--Beverage kategorisinde kaç tane ürün var ?

select count(*) from products p inner join categories c on p.category_id = c.category_id where p.category_id = '1'

-- bevarages kategorisinin stok miktarı 

select c.category_name , sum(p.units_in_stock) from categories c inner join products p on p.category_id = c.category_id and c.category_name = 'Beverages' group by c.category_name 
	
--kategori isimlerine göre kaç tane ürün olduğunu gösteren bir tablo
--kategori ismini yazdıralım , 10

select c.category_name ,count(c.category_id) from categories c inner join products p on p.category_id = c.category_id group by c.category_name

--bir siparişte kaç adet ürün satılmış ve hangi id'li müşteri almış

select orders.employee_id , count(order_details.quantity) from orders inner join order_details on orders.order_id = order_details.order_id group by orders.employee_id order by orders.employee_id asc

--hangi çalışan hangi bölümden sorumlu 

select first_name,last_name,territory_description from employee_territories as et inner join territories as t on et.territory_id = t.territory_id inner join employees as e on e.employee_id = et.employee_id

--hangi çalışan kaç bölümden sorumlu 

select first_name,last_name,count(territory_description) from employee_territories as et inner join territories as t on et.territory_id = t.territory_id inner join employees as e on e.employee_id = et.employee_id group by first_name , last_name

--5ten büyük sorumlu olduğu bölgeye sahip kişileri getirelim 

select first_name,last_name,count(territory_description) from employee_territories as et inner join territories as t on et.territory_id = t.territory_id inner join employees as e on e.employee_id = et.employee_id group by first_name , last_name having count(territory_description) > 5

--Hangi çalışan şimdiye kadar toplam kaç sipariş almış 

select e.first_name , e.last_name, sum(ord.quantity) from orders o inner join order_details ord on o.order_id = ord.order_id inner join employees e on e.employee_id = o.employee_id group by e.first_name , e.last_name

--hangi ürün hangi kategoride bulunmakta ? Bu ürün kim tedarik ediyor

select s.company_name as Supplier , p.product_name ,ca.category_name from products p inner join suppliers s on s.supplier_id = p.supplier_id inner join categories ca on ca.category_id = p.category_id 

--hangi siparişi hangi müşteri vermiş ,hangi  çalışan almış ahnagi tarihte hangi kargo şirketi tarafından gönderilmiş  hangi üründen kaç adate alınmış , hangi fiyattan alınmış ürün hangi kategordeymiş 

