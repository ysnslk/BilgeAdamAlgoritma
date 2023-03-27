--En az ödeme fiyatı olan sipariş 

select min(unit_price * quantity) as "En az ödeme fiyatı olan sipariş" from order_details 

-- Hangi üründen toplam kaç adet sipariş alınmıştır.

select product_id,sum(quantity) as "Satılan ürün sayısı" from order_details group by product_id order by "Satılan ürün sayısı"

SELECT products.product_name,order_details.quantity FROM products INNER JOIN order_details ON products.product_id=order_details.product_id

--fiyatı ortalamanın üstünde olan ürünlerin ismini ve fiyatını sorgulayalım

select product_name "Ürün", unit_price "Ürün Fiyat" from products where unit_price > (select avg(unit_price) from products)

--en pahalı ürünü bulalım

select product_name "Ürün" ,max(unit_price) "En Pahalı Ürün" from products group by product_name

--ülkelere göre müşt sayısı

select country , count(country) as "Müşt Sayısı" from customers group by country order by country

--hangi tedarikçi hangi ürünü sağlıyor

Select p.product_name , s.company_name from products p inner join suppliers s on p.supplier_id =  s.supplier_id

select products.product_name , suppliers.company_name from products , suppliers where products.supplier_id =  suppliers.supplier_id

--Beverages kategorisinde kaç tane ürün var ; join


