INSERT INTO USER (id,username) VALUES(1,'Banzhao');
INSERT INTO USER (id,username) VALUES(2,'Razor');

INSERT INTO LOCATION (id,name) VALUES(1,'上海近代公园');
INSERT INTO LOCATION (id,name) VALUES(2,'上海工业遗址');

INSERT INTO ITEM (id,name,location_id,latitude,longitude) VALUES(1,'1933老杨坊',1,103.11,301.12);
INSERT INTO ITEM (id,name,location_id,latitude,longitude) VALUES(2,'上海近代公园',1,104.11,302.12);
INSERT INTO ITEM (id,name,location_id,latitude,longitude) VALUES(3,'黄兴公园',1,105.11,303.12);

INSERT INTO ITEM (id,name,location_id,latitude,longitude) VALUES(4,'1933老遗址',2,201.11,102.11);
INSERT INTO ITEM (id,name,location_id,latitude,longitude) VALUES(5,'近代遗址',2,202.11,103.11);
INSERT INTO ITEM (id,name,location_id,latitude,longitude) VALUES(6,'黄兴遗址',2,203.11,104.11);

INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(1,5,1,1);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(2,4,1,2);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(3,3,1,3);

INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(4,4,2,1);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(5,3,2,2);
INSERT INTO RATING (id,ratingvalue,user_id,item_id) VALUES(6,2,2,3);