select * from product
join product_type on product_type.id = product.type_id
where product_type.name = '{СЫР}'