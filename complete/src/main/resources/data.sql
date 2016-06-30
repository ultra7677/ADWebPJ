INSERT INTO USER (id,username,password,avatarid) VALUES(1,'Banzhao','Initial0',2);
INSERT INTO USER (id,username,password,avatarid) VALUES(2,'Razor','Initial0',0);

INSERT INTO LOCATION (id,name) VALUES(1,'公园');
INSERT INTO LOCATION (id,name) VALUES(2,'博物馆');

INSERT INTO ITEM (id,name,location_id,latitude,longitude,collect,footstep,wanted) VALUES(1,'上海迪斯尼',1,121.6747210000,31.1477010000,30,10000,50);
INSERT INTO ITEM (id,name,location_id,latitude,longitude,collect,footstep,wanted) VALUES(2,'和平公园',1,121.510012,31.276778,20,5000,20);
INSERT INTO ITEM (id,name,location_id,latitude,longitude,collect,footstep,wanted) VALUES(3,'上海黄兴公园',1,121.536202,31.29962,70,8000,60);

INSERT INTO ITEM (id,name,location_id,latitude,longitude,collect,footstep,wanted) VALUES(4,'上海博物馆',2,121.48204,31.234227,30,600,44);
INSERT INTO ITEM (id,name,location_id,latitude,longitude,collect,footstep,wanted) VALUES(5,'上海汽车博物馆',2,121.176653,31.284629,15,300,55);
INSERT INTO ITEM (id,name,location_id,latitude,longitude,collect,footstep,wanted) VALUES(6,'上海动画博物馆',2,121.618336,31.21812,50,450,77);

INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(1,5,1,1);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(2,4,1,2);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(3,3,1,3);

INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(4,4,2,1);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(5,3,2,2);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(6,2,2,3);

INSERT INTO FILES (id,filename,fileLocation,filetype) VALUES(1,'beforelogin.jpg','/Users/ultra/Documents/images/beforelogin.jpg','image');
INSERT INTO FILES (id,filename,fileLocation,filetype) VALUES(2,'heart.jpg','/Users/ultra/Documents/images/heart.jpg','image');

INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(7,4,1,4);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(8,3,2,5);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(9,2,2,6);