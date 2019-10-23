-- 문제M
CREATE TABLE `problemm` (
	`no`        VARCHAR(50) NOT NULL COMMENT '일련번호', -- 일련번호
	`grade`     VARCHAR(50) NULL     COMMENT '학년', -- 학년
	`subject`   VARCHAR(50) NULL     COMMENT '과목명', -- 과목명
	`professor` VARCHAR(50) NULL     COMMENT '출제자명', -- 출제자명
	`year`      VARCHAR(50) NULL     COMMENT '년도', -- 년도
	`semester`  VARCHAR(50) NULL     COMMENT '학기', -- 학기
	`count`     VARCHAR(50) NULL     COMMENT '문항수' -- 문항수
)
COMMENT '문제M';

-- 문제M
ALTER TABLE `problemm`
	ADD CONSTRAINT `PK_problemm` -- 문제M 기본키
		PRIMARY KEY (
			`no` -- 일련번호
		);

-- 문제D
CREATE TABLE `problemd` (
	`no`         VARCHAR(50) NOT NULL COMMENT '일련번호', -- 일련번호
	`number`     VARCHAR(50) NULL     COMMENT '문제번호', -- 문제번호
	`contents`   VARCHAR(50) NULL     COMMENT '문제내용', -- 문제내용
	`exno`       VARCHAR(50) NULL     COMMENT '보기번호', -- 보기번호
	`excontents` VARCHAR(50) NULL     COMMENT '보기내용' -- 보기내용
)
COMMENT '문제D';

-- 문제D
ALTER TABLE `problemd`
	ADD CONSTRAINT `PK_problemd` -- 문제D 기본키
		PRIMARY KEY (
			`no` -- 일련번호
		);

-- 문제D
ALTER TABLE `problemd`
	ADD CONSTRAINT `FK_problemm_TO_problemd` -- 문제M -> 문제D
		FOREIGN KEY (
			`no` -- 일련번호
		)
		REFERENCES `problemm` ( -- 문제M
			`no` -- 일련번호
		);