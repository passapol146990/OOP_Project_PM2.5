5.2 ISNULL, TOP, Group by - having
46. แสดงข้อมูลของนิสิต ที่ได้GPA สูงที่สุดใน major CS
select	TOP 1*
from	student
where	major = 'CS'
order by  gpa desc
47. แสดงข้อมูลของอาจารย์ที่เงินเดือนน้อยที่สุด 2 คน
select  TOP 2*
from	LECTURER
order by salary
48. แสดงรหัสอาจารย์และจำนวนครั้งที่เคยสอน
select	lecid,count(*) as count_of_teach
from	SECTION
group by  lecid 
49. แสดงรหัสอาจารย์และจำนวนครั้งที่เคยสอน โดยแสดงเฉพาะอาจารยที่สอนมากที่ 3 ครั้ง
select	 lecid, count(*) as ount_of_teach
from	 section
group by lecid
having   count(*) > 3
50. แสดงรหัสวิชา ชื่อวิชา และ รหัสวิชาเงื่อนไข ถ้าวิชาใดไม่มวีิชาเงื่อนไข ให้แสดงข้อความ ไม่มีวิชาเงื่อนไข

select	sid, 
		name, 
		isnull(prerequisite,'ไม่มีวิชาเงื่อนไข')as prerequisite
from	subject

select	*
from	section



--6.1 Join and Nested Statement
--1. แสดงรหัสนิสิต และชื่อนิสิตทีเคยเรียนวิชา CS001
select	 student.sid, student.name
from	 student, enroll, SECTION
where	 student.sid		= enroll.stdid
and		 enroll.secid		= section.secid
and		 section.subid		= 'CS001'
--2. แสดงรหัสนิสิต และชื่อนิสิตที่เคยเรียนวิชา Programming
select	 student.sid, student.name
from	 student, enroll, SECTION ,SUBJECT
where	 student.sid		= enroll.stdid
and		 enroll.secid		= section.secid
and		 section.subid		= subject.sid
and		 subject.name		= 'Programming'
--3. แสดงรหัสนิสิต และชื่อนิสิตที่เคยเรียนกับอาจารย์ชื่อ Peter Parker
select	 student.sid, student.name
from	 student, enroll, section, LECTURER
where	 student.sid		= enroll.stdid
and		 enroll.secid		= section.secid
and		 section.lecid		= lecturer.lid
and		 lecturer.name		= 'Peter Parker'
--4. แสดง รหัสนิสิต ที่ได้เกรด A วิชา Programming
select	 distinct enroll.stdid
from	  enroll, section, subject
where	 enroll.secid		= section.secid
and		 section.subid		= subject.sid
and		 enroll.grade		= 'A'
and		 subject.name		= 'Programming'


--5. แสดง รหัสนิสิต และชื่อนิสิต ที่ได้เกรด A วิชา Programming
select	distinct student.sid, student.name
from	student, enroll, section, subject
where	student.sid			= enroll.stdid
and		enroll.secid		= section.secid
and		section.subid		= subject.sid
and		enroll.grade		= 'A'
and		subject.name		= 'Programming'
--6. แสดงรหัสนิสิต ชื่อนิสิต และเกรดที่ได้ของนิสิตที่เรียน section id 6
select	student.sid, student.name , ENROLL.grade
from	student, enroll
where	student.sid			= enroll.stdid
and		secid		= 6
--7. แสดงรหัสนิสิต ชื่อนิสิต และเกรดที่ได้ของนิสิตที่เรียนวิชา Database ในเทอม 1-2020
select	student.sid, student.name, enroll.grade
from	student, enroll, section, subject
where	student.sid			= enroll.stdid
and		enroll.secid		= section.secid
and		section.subid		= subject.sid
and		subject.name		= 'Database'
and		section.term		= '1-2020'
--8. แสดงรหัสนิสิต และชื่อนิสิตของนิสิตที่เคยเรียนวิชา cs001 หรือ cs002
select distinct student.sid, student.name, section.subid
from	student, enroll,section
where	student.sid			= enroll.stdid
and		enroll.secid		= section.secid
and		section.subid		 in('cs001','cs002')
		

9. แสดงชื่อวิชาและเทอมทเ
ี่ ปิดสอน เรียงลำดับตามเทอม
10. แสดงวิชา , เทอมท
ี่
เรียน , อาจารย์ผู้สอน และเกรดทไี่
ด้ของนิสิตชื่อ Rukawa
11. แสดงชื่อวิชา, เทอมท
ี่
สอน, ชื่อผู้สอน ของทุกวิชาท
ี่
สอนโดยอาจารย์ใน major CS
12. แสดง รหัสนิสิต, ชื่อนิสิต, ชื่อวิชา, ชื่อผู้สอน, เทอมท
ี่
เรียน ของการเรียนท
ี่ไดเ้กรด F
13. แสดงรหัสวิชา และชื่อวิชาท
ี่
เป็น pre-requisite ของวิชารหัส cs002
14. แสดงรหัสวิชา และชื่อวิชาท
ี่
เป็น pre-requisite ของวิชา AI
15. แสดงรหัสวิชา และชื่อวิชาของทุกวิชาท
ี่
มีวิชา programming เป็น pre-requisite