
DROP TABLE IF EXISTS TBL_ADDRESS;

-- 주소
CREATE TABLE TBL_ADDRESS
(
    `id`      BIGINT          NOT NULL AUTO_INCREMENT,
    `zipcode` VARCHAR(10)     NOT NULL,
    `road_address`    VARCHAR(200)    NOT NULL ,
    `jibun_address`   VARCHAR(200)    NOT NULL ,
    `detail_address`  VARCHAR(100)    NOT NULL ,
    `extra_address`   VARCHAR(255)    NOT NULL ,
    `created_date` TIMESTAMP DEFAULT NOW(),
    `updated_date` TIMESTAMP DEFAULT NOW(),
    CONSTRAINT TBL_ADDRESS_PK PRIMARY KEY (id)
);

INSERT INTO TBL_ADDRESS (`zipcode`, `road_address`, `jibun_address`, `detail_address`, `extra_address`) 
    VALUES ('13529', '경기 성남시 분당구 판교역로 166', '경기 성남시 분당구 백현동 532', 'A동 1101호', '비산동, 관악아파트');


-- 업체관리
DROP TABLE IF EXISTS TBL_COMPANY_MGMT;

CREATE TABLE TBL_COMPANY_MGMT
(
    `id`      BIGINT          NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(100)    NOT NULL,
    `code`    VARCHAR(20)     NOT NULL UNIQUE,
    `address_id` BIGINT       NOT NULL,
    `phone`   VARCHAR(255)    NOT NULL,
    `email`   VARCHAR(100)    NOT NULL,
    `created_date` TIMESTAMP,
    `updated_date` TIMESTAMP DEFAULT NOW(),
    CONSTRAINT TBL_COMPANY_MGMT_PK PRIMARY KEY (id),
    CONSTRAINT TBL_COMPANY_MGMT_FK FOREIGN KEY (address_id) 
        REFERENCES TBL_ADDRESS(id)
);

-- -- 테스트 데이터
INSERT INTO TBL_COMPANY_MGMT (`name`, `code`, `address_id`, phone, email, created_date) 
    VALUES ('test company', 'TEST0001', '1', '010-1234-5678', 'test@test.com', now());


-- 재고관리
DROP TABLE IF EXISTS TBL_PRODUCT_MGMT;

CREATE TABLE TBL_PRODUCT_MGMT
(
    `id`      BIGINT          NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(100)    NOT NULL,
    `code`    VARCHAR(20)     NOT NULL UNIQUE,
    `amount`  BIGINT          NOT NULL,
    `price`   BIGINT          NOT NULL,
    `created_date` TIMESTAMP DEFAULT NOW(),
    `updated_date` TIMESTAMP DEFAULT NOW(),
    CONSTRAINT TBL_PRODUCT_MGMT_PK PRIMARY KEY (id)
);

-- 테스트 데이터
INSERT INTO TBL_PRODUCT_MGMT (`name`, `code`, `amount`, price) 
    VALUES ('test product', 'PTEST0001', '5', '30000');

-- 주문
CREATE TABLE TBL_ORDER_MGMT
(
    `id`      BIGINT          NOT NULL AUTO_INCREMENT,
    `product_id`    BIGINT    NOT NULL,
    `company_id`    BIGINT    NOT NULL,
    `amount`  BIGINT          NOT NULL,
    `total_price`   BIGINT          NOT NULL,
    `created_date` TIMESTAMP DEFAULT NOW(),
    `updated_date` TIMESTAMP DEFAULT NOW(),
    CONSTRAINT TBL_ORDER_MGMT_PK PRIMARY KEY (id),
    CONSTRAINT TBL_ORDER_MGMT_FK1 FOREIGN KEY (product_id) REFERENCES TBL_PRODUCT_MGMT(id),
    CONSTRAINT TBL_ORDER_MGMT_FK2 FOREIGN KEY (company_id) REFERENCES TBL_COMPANY_MGMT(id)
);

-- 테스트 데이터
INSERT INTO TBL_ORDER_MGMT (`product_id`, `company_id`, `amount`, total_price) 
    VALUES (1, 1, 3, 30000);