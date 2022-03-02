# 工程简介

解析excel文件

### 功能组件：

easyexcel

### 注意：

在对象中，一定要加入@ExcelProperty，value值为sheet第一行名称，不要写错。

private String name 第一行必须小写

```java
@ExcelProperty(value = "Name")
private String name; // 第一个字母必须小写，否则get/set会出错，找不到相应的名称
```





### hotel的sql

```sql
CREATE TABLE hotel_user_t (
	id INT ( 11 ) NOT NULL auto_increment,
	NAME VARCHAR ( 240 ) COMMENT '用户姓名',
	CardNo VARCHAR ( 60 ) COMMENT '卡号',
	Descriot VARCHAR ( 60 ) COMMENT '描述',
	CtfTp VARCHAR ( 60 ) COMMENT '证件类型',
	CtfId VARCHAR ( 60 ) COMMENT '证件号',
	Gender VARCHAR ( 60 ) COMMENT '性别',
	Birthday VARCHAR ( 60 ) COMMENT '卡号',
	Address VARCHAR ( 240 ) COMMENT '地址',
	Zip VARCHAR ( 60 ) COMMENT '邮编',
	Dirty VARCHAR ( 60 ) COMMENT '是否弄脏房间',
	District1 VARCHAR ( 60 ),
	District2 VARCHAR ( 60 ),
	District3 VARCHAR ( 60 ),
	District4 VARCHAR ( 60 ),
	District5 VARCHAR ( 60 ),
	District6 VARCHAR ( 60 ),
	FirstNm VARCHAR ( 60 ),
	LastNm VARCHAR ( 60 ),
	Duty VARCHAR ( 240 ) COMMENT '职务',
	Mobile VARCHAR ( 60 ) COMMENT '手机号',
	Tel VARCHAR ( 60 ) COMMENT '手机号',
	Fax VARCHAR ( 60 ) COMMENT '传真',
	EMail VARCHAR ( 60 ),
	Nation VARCHAR ( 240 ) COMMENT '民族',
	Taste VARCHAR ( 60 ) COMMENT '体验',
	Education VARCHAR ( 240 ) COMMENT '教育',
	Company VARCHAR ( 240 ) COMMENT '公司',
	CTel VARCHAR ( 60 ) COMMENT '公司号码',
	CAddress VARCHAR ( 240 ) COMMENT '公司地址',
	CZip VARCHAR ( 60 ) COMMENT '公司邮编',
	Family VARCHAR ( 240 ) COMMENT '家庭住址',
	Version TIMESTAMP COMMENT '入会时间',
PRIMARY KEY ( `id` ) 
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COMMENT = '酒店用户信息表';
```

