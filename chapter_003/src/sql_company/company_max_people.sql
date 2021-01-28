select company.name as company, count(company.name) as number_of_people from person
join company on person.company_id=company.id
group by company
order by number_of_people desc
limit 1