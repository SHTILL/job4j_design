select meeting.name as meeting, count(meeting.name) as attendees_count from attendee
join meeting on attendee.meeting_id = meeting.id
join person on attendee.person_id = person.id
where attendee.status = 'confirmed'
group by meeting.name