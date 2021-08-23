
Create Table users (
    username varchar(255) not null primary key,
    password varchar(255) not null,
    enabled boolean not null);
Create Table Authorities(
    username varchar(255) not null,
    authority varchar(255) not null,
    foreign key (username) references users(username), unique (username, authority)
);

Create Table Products (
                          Code varchar(20) primary key,
                          Name varchar(255),
                          Description varchar(1023),
                          category varchar(255),
                          Price double precision,
                          Quantity int
);


CREATE TABLE Cart(
                     Cart_ID varchar(255) primary key,
                     Order_ID int
                         constraint Order_in_cart_FK
                             references Orders(ID),
                     Sum double precision
);
Create Table Orders(
                       ID serial primary key ,
                       PRODUCT_ID varchar(20) not null
                           constraint Ordered_Products_FK
                               references Products(code),
                       Quantity int,
                       Amount double precision,
                       Username varchar(255)
                           constraint Ordered_User_FK
                               references Users(username),
                       Cart_id varchar(255)

);
ALTER TABLE Orders add FOREIGN KEY (Cart_id) references Cart(Cart_ID);