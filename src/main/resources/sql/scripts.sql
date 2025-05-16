<!-- Spring recommended DB Schema for DB Authentication -->
create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

<!-- Custom Schema for DB Authentication -->
CREATE TABLE `customer` (
    `id` int NOT NULL AUTO_INCREMENT,
    `email` varchar(45) NOT NULL,
    `pwd` varchar(200) NOT NULL,
    `role` varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `customer` (`email`,`pwd`,`role`) VALUES ('bharath@example.com','{noop}Bharath@1508','read');
INSERT INTO `customer` (`email`,`pwd`,`role`) VALUES ('admin@example.com','{bcrypt}$2a$12$WUTdRJjovtRMJ0.3nZKqMuhbWKyOuw5CtrfRvimxBW16cxnMnOSky','admin');