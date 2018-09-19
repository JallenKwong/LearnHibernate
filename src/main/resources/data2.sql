--为Criteria添加数据

INSERT INTO course_inf VALUES ('001','疯狂Java讲义');
INSERT INTO course_inf VALUES ('002','轻量级Java EE企业应用实战');
INSERT INTO course_inf VALUES ('003','疯狂Android讲义');

INSERT INTO student_inf VALUES (20050231,'孙悟空');
INSERT INTO student_inf VALUES (20050232,'猪八戒');
INSERT INTO student_inf VALUES (20050233,'牛魔王');

INSERT INTO enrolment_inf(`enrolment_id`,`semester`,`year`,`student_id`,`course_code`) VALUES (1,3,2005,20050232,'001');
INSERT INTO enrolment_inf(`enrolment_id`,`semester`,`year`,`student_id`,`course_code`) VALUES (2,2,2005,20050232,'003');
INSERT INTO enrolment_inf(`enrolment_id`,`semester`,`year`,`student_id`,`course_code`) VALUES (3,2,2005,20050233,'002');
INSERT INTO enrolment_inf(`enrolment_id`,`semester`,`year`,`student_id`,`course_code`) VALUES (4,3,2005,20050233,'003');
INSERT INTO enrolment_inf(`enrolment_id`,`semester`,`year`,`student_id`,`course_code`) VALUES (5,1,2005,20050231,'002');

