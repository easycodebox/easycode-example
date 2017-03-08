
-- ----------------------------
-- Table structure for sys_id_generator
-- ----------------------------
DROP TABLE IF EXISTS `sys_id_generator`;
CREATE TABLE `sys_id_generator` (
  `id` varchar(32) NOT NULL COMMENT '类型 - 主键生成器类型',
  `initialVal` varchar(32) NOT NULL COMMENT '初始值',
  `currentVal` varchar(32) NOT NULL COMMENT '当前值',
  `maxVal` varchar(32) DEFAULT NULL COMMENT '最大值',
  `fetchSize` int(9) NOT NULL COMMENT '批次容量 - 每批获取的数目大小',
  `increment` int(9) NOT NULL COMMENT '增长值 - 每次增加多少',
  `isCycle` int(1) NOT NULL COMMENT '是否循环 - 值是否循环累加',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主键生成器 - 主键生成器';

-- ----------------------------
-- Table structure for sys_partner
-- ----------------------------
DROP TABLE IF EXISTS `sys_partner`;
CREATE TABLE `sys_partner` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '合作商名',
  `partnerKey` varchar(32) NOT NULL COMMENT '密钥 - 加密解密数据的密钥值',
  `website` varchar(512) DEFAULT NULL COMMENT '网址',
  `status` int(1) NOT NULL COMMENT '状态',
  `deleted` int(1) NOT NULL COMMENT '是否删除',
  `sort` int(9) NOT NULL COMMENT '排序值',
  `contract` varchar(512) DEFAULT NULL COMMENT '合同',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合作商 - 合作商调用接口配置';

-- ----------------------------
-- Table structure for user_ext
-- ----------------------------
DROP TABLE IF EXISTS `user_ext`;
CREATE TABLE `user_ext` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `level` int(9) NOT NULL COMMENT '等级',
  `balance` decimal(20,5) NOT NULL COMMENT '余额',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `modifyTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户扩展信息 - 基于权限系统u_user表的扩展信息';
