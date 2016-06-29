INSERT INTO USER (id,username) VALUES(1,'Banzhao');
INSERT INTO USER (id,username) VALUES(2,'Razor');

INSERT INTO LOCATION (id,name) VALUES(1,'公园');
INSERT INTO LOCATION (id,name) VALUES(2,'博物馆');

INSERT INTO ITEM (id,name,location_id,latitude,longitude,radius) VALUES(1,'上海迪斯尼',1,121.6747210000,31.1477010000,1200);
INSERT INTO ITEM (id,name,location_id,latitude,longitude,radius) VALUES(2,'和平公园 ',1,121.510012,31.276778,320);
INSERT INTO ITEM (id,name,location_id,latitude,longitude,radius) VALUES(3,'上海黄兴公园',1,121.536202,31.29962,400);

INSERT INTO ITEM (id,name,location_id,latitude,longitude,radius) VALUES(4,'上海博物馆',2,121.48204,31.234227,300);
INSERT INTO ITEM (id,name,location_id,latitude,longitude,radius) VALUES(5,'上海汽车博物馆',2,121.176653,31.284629,100);
INSERT INTO ITEM (id,name,location_id,latitude,longitude,radius) VALUES(6,'上海动画博物馆',2,121.618336,31.21812,70);

INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(1,5,1,1);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(2,4,1,2);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(3,3,1,3);

INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(4,4,2,1);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(5,3,2,2);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(6,2,2,3);

INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(7,4,1,4);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(8,3,2,5);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(9,2,2,6);