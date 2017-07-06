CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL DEFAULT '',
  `contact_num` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


CREATE TABLE `subject` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `subject_category` varchar(256) NOT NULL DEFAULT '',
  `subject_name` varchar(256) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


Postman Request
1) For User
  POST    http://localhost:8080/main/user
            
            {
              "name":"Demo",
              "contactNum":"9999999999"
            }
           
2) For Subject
  POST    http://localhost:8080/main/subject
            
            {
              "subjectCategory":"History",
              "subjectName":"India and its history"
            }  
