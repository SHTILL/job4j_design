select males.name as males_names, females.name as females_names
from
teens as males cross join teens as females
where males.gender = 'm' and females.gender = 'f'