DROP TABLE IF EXISTS TBL_COMPANY_MGMT;

-- 업체관리
CREATE TABLE TBL_COMPANY_MGMT
(
    `id`      BIGINT          NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(100)    NOT NULL,
    `code`    VARCHAR(20)     NOT NULL,
    `address` VARCHAR(255)    NOT NULL,
    `phone`   VARCHAR(255)    NOT NULL,
    `email`   VARCHAR(100)    NOT NULL,
    `created_date` TIMESTAMP,
    CONSTRAINT TBL_COMPANY_MGMT_PK PRIMARY KEY (id)
);

-- 테스트 데이터
INSERT INTO TBL_COMPANY_MGMT (`name`, `code`, `address`, phone, email, created_date) 
    VALUES ('test company', 'TEST0001', '서울', '010-1234-5678', 'test@test.com', now());
