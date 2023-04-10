--kategorilere göre film sayısını listeleyelim ve en fazla filme sahip olan ilk 5 kategoriyi getir
select category.name , count(film_category.category_id) from film_category
join category on film_category.category_id = category.category_id
group by category.name
order by count(film_category.category_id) desc limit 5

--Elvis marx in oynadığı filmlerin kategorilerini ve dillerini listeleyelim

select f.title , c.name , l.name, a.first_name, a.last_name   from actor as a 
join film_actor as fa on a.actor_id = fa.actor_id
join film as f on f.film_id = fa.film_id
join language l on f.language_id = l.language_id
join film_category fc on f.film_id = fc.film_id
join category as c on c.category_id = fc.category_id
group by f.title , c.name , l.name, a.first_name, a.last_name
having a.first_name = 'Elvis'  and a.last_name ='Marx'