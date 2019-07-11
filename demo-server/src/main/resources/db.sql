CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_roles_role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table post
(
  id                int unsigned auto_increment comment '自增ID' primary key,
  title             varchar(255) default ''                not null comment '标题',
  intro             varchar(500) default ''                not null comment '简介',
  post_url          varchar(100) default ''                not null comment 'url链接',
  post_from         tinyint      default 0                 not null comment '来源,枚举值',
  author            varchar(100) default ''                not null comment '作者',
  author_avatar     varchar(100) default ''                not null comment '作者头像',
  post_created_time datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
  created_time      datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
  modified_time     datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '修改时间',
  is_deleted        tinyint      default 0                 not null comment '逻辑删除 0：正常 1：已删除'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '文章';

