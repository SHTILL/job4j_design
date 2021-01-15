select * from product
where current_date + interval '1 month' > product.expired_date
and current_date + interval '1 month' < product.expired_date + 2 * interval '1 month'