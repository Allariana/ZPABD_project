CREATE DATABASE Books

select b.title, m.value from book b join mark m on b.book_id=m.book_id;
select b.title, AVG(m.value) as srednia from book b join mark m on b.book_id=m.book_id 
group by b.title order by AVG(m.value) DESC;
select AVG(m.value) as srednia from book b join mark m on b.book_id=m.book_id where b.book_id=6
group by b.book_id 

select t.name, a.last_name, b.title from book b join type t on b.type_id=t.id 
join author a on b.author_id=a.id;

USE Books
GO
CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (username)
);
  
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username
  on authorities (username,authority);

INSERT INTO users (username, password, enabled)
  values ('Allariana','$2a$10$ELK/W1pmlxOPqezdHN/zxeNqPYD62.VfN8.2Ox/yuYNTt41GpE3Ji', 1); --userPass
INSERT INTO users (username, password, enabled)
  values ('IzabelaPieczek','$2a$10$Fr8BYkni9V5WK5Gxs7a6GOy8VwEl1U8/uRUxIOsum/pTdXF9NAvJu', 1); --uPassword
INSERT INTO users (username, password, enabled)
  values ('wjurek','$2a$10$ELK/W1pmlxOPqezdHN/zxeNqPYD62.VfN8.2Ox/yuYNTt41GpE3Ji', 1); --userPass
INSERT INTO users (username, password, enabled)
  values ('admin','$2a$10$7bsgPDdxJeMMu764jAgPHebxLznEPOUk8bkUeeGtxG/zphwwZMbsu', 1); --password
  
INSERT INTO authorities (username, authority) values ('Allariana', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('IzabelaPieczek', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('wjurek', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('admin', 'ROLE_ADMIN');

select * from dbo.users
select * from dbo.authorities


