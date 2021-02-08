select meeting.name from meeting
left join attendee on attendee.meeting_id = meeting.id
where meeting_id is null or attendee.status = 'rejected'