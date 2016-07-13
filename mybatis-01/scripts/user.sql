DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
  id int(11) PRIMARY key AUTO_INCREMENT NOT NULL,
  username varchar(20) NOT NULL ,
  birthday date DEFAULT NULL,
  sex char(1) NOT NULL,
  address varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

insert into t_user(username,birthday,sex,address) values('longhuashen',now(),'1','深圳市梅林');