CREATE DATABASE Books

select b.title, m.value from book b join mark m on b.book_id=m.book_id;
select b.title, AVG(m.value) as srednia from book b join mark m on b.book_id=m.book_id group by b.title;

select t.name, a.last_name, b.title from book b join type t on b.type_id=t.id 
join author a on b.author_id=a.id;