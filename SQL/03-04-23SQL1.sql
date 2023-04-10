Select orders.order_id,customers.company_name as "Satın Alan Şirket",employees.first_name as "Çalışan",products.product_name as "Sipariş Edilen Ürün",categories.category_name as "Ürün Kategorisi" , 
sum(order_details.quantity) as "İşlem Miktarı" , 
sum(order_details.unit_price * order_details.quantity) as "Sipariş Tutarı",orders.order_date as "Sipariş Tarihi" , shippers.company_name as "Kargo Firması" , suppliers.company_name as "Tedarikçi Firma" 
from orders 
join customers on orders.customer_id = customers.customer_id
join employees on employees.employee_id = orders.employee_id
join shippers on orders.ship_via = shippers.shipper_id
join order_details on orders.order_id = order_details.order_id
join products on order_details.product_id = products.product_id
join categories on products.category_id = categories.category_id
join suppliers on suppliers.supplier_id = products.product_id
group by customers.company_name,employees.first_name,order_details.order_id,products.product_name,categories.category_name,orders.order_date,shippers.company_name,suppliers.company_name,orders.order_id
having orders.order_id = 10248