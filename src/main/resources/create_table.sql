CREATE TABLE `article` (
  `id`          INT(11) NOT NULL AUTO_INCREMENT,
  `docid`       VARCHAR(45)      DEFAULT NULL,
  `title`       varchar(45)      DEFAULT NULL,
  `content`     VARCHAR(5000)    DEFAULT NULL,
  `author`      varchar(45)      DEFAULT NULL,
  `source`      varchar(45)      DEFAULT NULL,
  `url`         VARCHAR(1024)    DEFAULT NULL,
  `update_time` datetime(6)      DEFAULT NULL,
  `insert_time` datetime(6)      DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
