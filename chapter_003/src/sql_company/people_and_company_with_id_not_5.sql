select person.name as person, company.name as copmany from person
join company on person.company_id = company.id
where company.id != 5