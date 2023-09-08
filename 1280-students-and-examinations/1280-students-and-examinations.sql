select s.student_id, s.student_name, sub.subject_name, coalesce(e.attended_exams,0) as 'attended_exams' from students as s cross join Subjects as sub left join (
    SELECT student_id, subject_name, COUNT(*) AS attended_exams
    FROM Examinations
    GROUP BY student_id, subject_name)
    as e on s.student_id=e.student_id and sub.subject_name=e.subject_name order by student_id, subject_name