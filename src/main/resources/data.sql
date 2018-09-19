--为HQL章节提供查询数据

INSERT INTO event_inf VALUES (1,'2004-10-03','很高兴的事情');
INSERT INTO event_inf VALUES (2,'2005-10-03','很普通的事情');
INSERT INTO event_inf VALUES (3,'2004-10-04','疯狂Java筹备中');
INSERT INTO event_inf VALUES (4,'2005-10-05','疯狂Java开始培训');

INSERT INTO person_inf VALUES (1, 30, 'crazyit.org');
INSERT INTO person_inf VALUES (2, 30, '老朱');

INSERT INTO person_email_inf VALUES (1,'crazyit@crazyit.org');
INSERT INTO person_email_inf VALUES (1,'crazyit@fkit.org');
INSERT INTO person_email_inf VALUES (2,'dddd@163.com');
INSERT INTO person_email_inf VALUES (2,'vvvvvv@163.com');

INSERT INTO person_event VALUES (1,1);
INSERT INTO person_event VALUES (1,2);
INSERT INTO person_event VALUES (2,2);
INSERT INTO person_event VALUES (2,3);
INSERT INTO person_event VALUES (1,4);
