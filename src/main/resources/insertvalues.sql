INSERT INTO users values ('chessmaster8990','$2a$10$KHmah7.ow/lmcsPoXG5VTe1ApEWFSgtuFqGWuXL9bxoT.zhcvJMM.', true );
/*BOSS, bosspassword*/
INSERT INTO users values ('BOSS', '$2a$10$KHmah7.ow/lmcsPoXG5VTe1ApEWFSgtuFqGWuXL9bxoT.zhcvJMM.',true);
INSERT INTO authorities values ('BOSS', 'ADMIN');
/*Visitor, visitorpassword*/
INSERT INTO users values ('Visitor','$2a$10$ssXJmcSL3z6dUZxQQCLDhebmZABwINcsgT65kPDNunyijXre1WoFG', true );
INSERT INTO authorities values ('Visitor', 'USER');
/*1234, 1234*/
INSERT INTO users values ('1234','$2a$10$JRgEx/oSaiKPHb/urdOGXedsBNVfMrslZUQATEAsIGsZqaRzeuw9i', true);
INSERT INTO authorities values ('1234', 'ROLE_USER');

SELECT * FROM users;

INSERT INTO Products values ('1001','Пенал','Пенал с машинками, цвет серый','Школа','100',10 );
INSERT INTO Products values ('1002','Ручка','Ручка шариковая, цвет синий','Школа','15',100 );
INSERT INTO Products values ('2001','Книга Гарри Поттер и кубок огня','Автор Дж.Роулинг, жесткая обложка, перевод - М.Спивак','Зарубежная литература','900',2 );
INSERT INTO Products values ('3001','Книга Сон смешного человека','Автор Ф.М. Достоевский, мягкая обложка','Русская литература','400',5 );