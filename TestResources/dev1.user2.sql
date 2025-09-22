CREATE TABLE `user2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

insert into dev1.user2(id,name,email) values 
 (1,N'Zhangsan',N'Zhang@163.com')
,(2,N'lisi',N'li@163.com')
,(3,N'ee',N'www')
,(4,N'ee',N'www')
,(5,N'Wang',N'Wang@163.com')
,(6,N'Wang33',N'Wang@163.com')
;
