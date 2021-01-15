select product.name, product_type.name from product
join product_type on product.type_id = product_type.id