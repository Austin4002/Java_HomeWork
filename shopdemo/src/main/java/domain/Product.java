package domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	// `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
	// COMMENT '商品id',
	// `product_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT
	// NULL COMMENT '商品名称',
	// `product_price` double(32,2) DEFAULT NULL COMMENT '商品价格',
	// `product_date` date DEFAULT NULL COMMENT '上架时间',
	// `product_image` blob COMMENT '商品图片',
	// `product_attribute` json DEFAULT NULL COMMENT '商品属性',
	// `product_description` varchar(255) DEFAULT NULL COMMENT '商品描述',
	// `cid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
	// COMMENT '分类id',
	private String product_id;
	private String product_name;
	private double product_price;
	private Date product_date;
	private String product_image;
	private String product_attribute;
	private String product_description;
	private String cid;

}
