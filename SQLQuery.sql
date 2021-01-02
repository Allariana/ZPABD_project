CREATE DATABASE Books

select b.title, m.value from book b join mark m on b.book_id=m.book_id;