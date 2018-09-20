
INSERT INTO category_inf (`category_id`,`name`,`eff_start_date`,`eff_end_date`) VALUES (1,'it产品', ADDDATE(now() , - 200) , ADDDATE(now() , 20));
INSERT INTO category_inf (`category_id`,`name`,`eff_start_date`,`eff_end_date`) VALUES (2,'工业产品', ADDDATE(now() , - 180) , ADDDATE(now() , 34));
INSERT INTO category_inf (`category_id`,`name`,`eff_start_date`,`eff_end_date`) VALUES (3,'输出设备', ADDDATE(now() , - 223) , ADDDATE(now() , 42));

INSERT INTO product_inf (`product_id`,`product_name`,`stock_number`,`eff_start_date`,`eff_end_date`) VALUES (1,'显示器',20040404 , ADDDATE(now() , - 90) , ADDDATE(now() , 20));
INSERT INTO product_inf (`product_id`,`product_name`,`stock_number`,`eff_start_date`,`eff_end_date`) VALUES (2,'键盘',20040219 ,  ADDDATE(now() , - 78) , ADDDATE(now() , 19));
INSERT INTO product_inf (`product_id`,`product_name`,`stock_number`,`eff_start_date`,`eff_end_date`) VALUES (3,'机箱',20040915 , ADDDATE(now() , - 56) , ADDDATE(now() , 15));

INSERT INTO product_category (`product_id`,`category_id`) VALUES (1,1);
INSERT INTO product_category (`product_id`,`category_id`) VALUES (1,3);
INSERT INTO product_category (`product_id`,`category_id`) VALUES (2,1);
INSERT INTO product_category (`product_id`,`category_id`) VALUES (2,2);
INSERT INTO product_category (`product_id`,`category_id`) VALUES (3,1);
INSERT INTO product_category (`product_id`,`category_id`) VALUES (3,2);
INSERT INTO product_category (`product_id`,`category_id`) VALUES (3,3);
