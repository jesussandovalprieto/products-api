CREATE TABLE category (
  id int(11) NOT NULL AUTO_INCREMENT,
  created_at datetime(6) DEFAULT NULL,
  updated_at datetime(6) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE product (
  id int(11) NOT NULL AUTO_INCREMENT,
  created_at datetime(6) DEFAULT NULL,
  updated_at datetime(6) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  category_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_PRODUCT_CATEGORY_ID FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE product_detail (
  id int(11) NOT NULL AUTO_INCREMENT,
  created_at datetime(6) DEFAULT NULL,
  updated_at datetime(6) DEFAULT NULL,
  price double DEFAULT NULL,
  quantity double DEFAULT NULL,
  trademark varchar(255) DEFAULT NULL,
  product_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_PRODUCT_DETAIL_PRODUCT_ID FOREIGN KEY (product_id) REFERENCES product (id)
);