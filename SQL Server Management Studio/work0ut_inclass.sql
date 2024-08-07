--1แสดง รหัส ชื่อ และสาขา ของนิสิตทุกคนที่ไม่มีชื่อ
select	sid, name, major
from	student
where name is null

--2แสดง รหัส ชื่อ และสาขา ของนิสิตทุกคนที่ทั้งชื่อ และสาขา ไม่เป็นค่าว่าง
select	sid,name,major
from	student
where   name is not null
and major is not null

--3แสดง รหัส ชื่อ และสาขา ของนิสิตทุกคนที่อยู่ สาขา CS
select	sid ,name,major
from	student
where	major = 'CS'

--4แสดง รหัส ชื่อ และสาขา ของนิสิตทุกคนที่อยู่ สาขา CS หรือ PY
select	sid,name,major
from	student
where	major in('CS','PY')

--5แสดง รหัส ชื่อ และสาขา ของนิสิตทุกคนที่ไม่ได้อยู่ สาขา CS, MA, PY
select	sid,name,major
from	student
where	major not in ('CS','PY')

--6แสดง รหัส ชื่อ และสาขา ของนิสิตทุกคนที่ชื่อขึ้นต้นด้วยตัว S
select	sid,name,major
from	student
where	name like 'S%'

--7แสดง รหัส ชื่อ และสาขา ของนิสิตทุกคนที่ชื่อขึ้นต้นด้วยตัว K และลงท้ายด้วย A
select	 sid,name,major
from	 student
where	 name like 'K%%A'

--8แสดง ชื่อนิสิต สาขา และ gpa ของนิสิตทุกคนที่ gpa อยู่ระหว่าง  2.00 ถึง 3.00
select	 name,major	,gpa
from	 student
where	 gpa between 2.00 and 3.00 

--9แสดง ชื่อนิสิต สาขา และ gpa ของนิสิตทุกคนที่ไม่ได้อยู่ CS หรือ PY เรียงลำดับตาม gpa จากมากไปน้อย
select	  name,major,gpa 
from	  student
where	  major not in('CS','PY')
order by  gpa desc

--10แสดง ชื่อนิสิต สาขา และ gpa ของนิสิตทุกคน เรียงลำดับตาม สาขา และ gpa จากน้อยไปมาก
select	 name,major,gpa
from	 student
order by major desc

--11แสดง gpa ที่สูงที่สุด และ ต่ำที่สุดของนิสิต โดยให้แสดงเป็น column ชื่อ max_gpa และ min_gpa
select	 max(gpa) as max_gpa,
		 min(gpa) as min_gpa
from	 student
		
--12แสดง gpa ที่สูงที่สุด และ gpa ต่ำสุด ของ สาขา CS โดยให้แสดงเป็น column ชื่อ max_cs และ min_cs
select	 max(gpa) as max_cs,
		 min(gpa) as min_cs
from	 student
where	major  = 'CS'
-- = ใช้กับเพียงตรวจสอบค่าเดียว 
-- in ใช้กับ ตรวจสอบค่ามากกว่า 1 ตัวขึ้นไป

--13แสดงรหัสวิชาที่เป็น prerequisite ของวิชา Graphics
select	prerequisite
from	subject
where	name = 'Graphics'

--14แสดงรหัสและชื่อวิชา ของวิชาที่ไม่มีวิชา prerequisite
select	prerequisite,name
from	subject
where	prerequisite is  null

--15วิชาใดบ้างที่มีหน่วยกิต 3 หน่วยกิตขึ้นไป
select  name,credit
from	subject
where	credit > 3

--16วิชาใดบ้างที่มีวิชา CS001 เป็นวิชา prerequisite
select	name
from	subject
where	prerequisite = 'CS001'

--17มีกี่วิชาที่วิชารหัส CS001 เป็นวิชา prerequisite
select	 count(name)
from	 subject
where	 prerequisite = 'CS001'

--18แสดงข้อมูลอาจารย์ที่ได้เงินเดือนระหว่าง 20000 – 40000
select	 *
from	 lecturer
where	salary between 20000 and 40000

--19เงินเดือนที่สูงที่สุดของอาจารย์สาขา CS คือเท่าไร
select  max(salary) as max_salaryTC_CS
from	lecturer

--20เงินเดือนเฉลี่ยของอาจารย์ในสาขา English คือเท่าไร
select	avg(salary) as Average_salary_TC_English
from	lecturer
where	major = 'English'

--21อาจารย์ในสาขา English ใครบ้างที่ได้เงินเดือนต่ำกว่า 40000 บาท
select	 name
from	 lecturer
where	 salary < 40000

--22แสดงข้อมูลอาจารย์ที่อยู่ภาควิชาอื่น ๆ ที่ไม่ใช่ CS หรือ MIS
select	 *
from	lecturer
where	 major not in('CS','MIS')

--23แสดงเงินเดือนรวมทั้งหมด, เงินเดือนสูงสุด, เงินเดือนต่ำสุด , ค่าเฉลี่ยเงินเดือน ของอาจารย์โดยให้แสดงเป็น column ชื่อ total_salary, max_salary, min_salary และ average_salary
select	 sum(salary) as total_salary,
		 max(salary) as max_salary,
		 min(salary) as min_salary,
		 avg(salary) as average_salary
from	 lecturer	
--24แสดงเงินเดือนรวมทั้งหมด, เงินเดือนสูงสุด, เงินเดือนต่ำสุด , ค่าเฉลี่ยเงินเดือน ของอาจารย์สาขา Englishโดยให้แสดงเป็น column ชื่อ total_sal, max_sal, min_sal และ average_sal
select	 sum(salary) as total_sal,
		 max(salary) as max_sal,
		 min(salary) as min_sal,
		 avg(salary) as average_sal
from	 lecturer
where	 major = 'English'
--25แสดงรหัสอาจารย์ที่สอนวิชา CS001 เทอม 1-2020
select  lecid
from	section
where	subid = 'CS001'
AND		term = '1-2020'

--26section รหัสใดบ้างที่เปิดสอนวิชารหัส CS001
select  secid
from	section
where	subid = 'CS001'

--27เทอม 1-2021 เปิดสอนทั้งหมดกี่วิชา
select	 count(distinct subid) as subject_Opene
from	section
where	term = '1-2021'

--28แสดงจำนวนวิชาที่เปิดสอนปี 2020
select	count(distinct subid) as subject_Opene
from	section
where	SUBSTRING(term,3,4) ='2020'

--29แสดง section id, subject id, lecturer id และ เทอม ของการสอนที่เปิดสอนทุกเทอมในปี 2020
select *
from	section
where term  like '%2020'

--30แสดง รหัสวิชา ที่เปิดสอนในปี 2020 ( ทั้ง  1-2020 และ 2-2020 ) โดยไม่แสดงรหัสซ้ำกัน
select  distinct subid
from	section
where	term like '%2020'
แสดงรหัสวิชาที่สอนโดยอาจารย์รหัส t01 โดยแสดงรหัสไม่ซ้ำกัน
อาจารย์รหัส t02 เคยสอนทั้งหมดกี่ครั้ง
วิชารหัส CS005 เคยเปิดสอนทั้งหมดกี่ครั้ง

แสดงรหัสนิสิตที่ได้เกรด A โดยแสดงรหัสไม่ซ้ำกัน
แสดงรหัสนิสิตที่ลงทะเบียนเรียนคอร์ส section id 5
แสดงรหัสนิสิตที่ลงทะเบียนเรียนคอร์ส section id 1 และเกรดไม่เป็น F
แสดงจำนวนนิสิตที่ลงทะเบียนเรียน section 2 และ เกรดไม่เป็น F
แสดงจำนวนครั้งที่นิสิตรหัส 60001 ลงทะเบียนเรียน
แสดงจำนวนครั้งที่นิสิตรหัส 60006 ได้เกรด F

แสดง รหัส ชื่อ และวันเกิด ของนิสิตทุกคนที่เกิดปี 2005
แสดง รหัส ชื่อ และวันเกิด ของนิสิตทุกคนที่มีอายุ 20 ปีขึ้นไป
แสดง รหัสนิสิต และชื่อ ของนิสิตทุกคนที่เกิดเดือน September
แสดง รหัสนิสิต ชื่อ และอายุ ของนิสิตทุกคนที่เกิดวันพฤหัสบดี
แสดง รหัสนิสิต ชื่อ ปีเกิด และ อายุ ของนิสิตทุกคน
แสดง รหัสนิสิต ชื่อ สาขา ปีเกิด, อายุ ของนิสิตที่อายุน้อยกว่า 20 ปี และไม่ได้อยู่ สาขา CS
