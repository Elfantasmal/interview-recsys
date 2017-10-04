CREATE TABLE `article` (
  `docid` varchar(45) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `source` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `insert_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`docid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
