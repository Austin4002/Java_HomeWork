package domain;

import lombok.Getter;
import lombok.Setter;

/*
 * `itemid` varchar(32) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pid` varchar(32) DEFAULT NULL,
  `oid` varchar(32) DEFAULT NULL,*/
@Setter
@Getter
public class OrderItem {
	private String itemid; //订单项的id
	private int count;    //订单项内商品的数量
	private double subtotal;  //订单项的小计
	private Product  product;   //订单项内部的商品
	private Order oid;   //该订单项属于哪一个订单
}
