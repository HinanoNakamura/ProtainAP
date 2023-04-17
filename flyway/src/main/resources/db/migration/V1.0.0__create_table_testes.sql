-- CREATE TABLE testes (
-- 	id INT NOT NULL AUTO_INCREMENT    	COMMENT 'id',
-- 	name VARCHAR(64)					COMMENT '名前',
-- 	PRIMARY KEY (id)
-- );

CREATE TABLE protain (
	id INT NOT NULL AUTO_INCREMENT    	COMMENT '商品コード',
	name VARCHAR(64)					COMMENT '商品名',
	flavorcode INT NOT NULL            COMMENT '味コード',
	purposecode INT NOT NULL           COMMENT '目的コード',
	componentcode INT NOT NULL         COMMENT '成分コード',
	price INT NOT NULL                 COMMENT '価格',
	pricecode INT NOT NULL              COMMENT '価格コード',
	img VARCHAR(500) NOT NULL               COMMENT '画像パス',
	PRIMARY KEY (id)
);