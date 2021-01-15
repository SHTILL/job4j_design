select product_type.name, count(product_type.name) as product_count from product
join product_type on product.type_id = product_type.id
group by product_type.name
having count(product_type.name) < 10