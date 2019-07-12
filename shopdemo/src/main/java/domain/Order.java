package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/*
 * `oid` varchar(32) NOT NULL,
  `ordertime` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `uid` varchar(32) DEFAULT NULL,*/
@Setter
@Getter
public class Order {
	private String oid;  //该订单的订单号
	private Date  ordertime; //下单日期
	private double total;  //该订单的总金额
	private int state;  //订单的支付状态：0-未付款 1-已付款
	private String addr; //收货地址
	private String name; //收货人
	private String tel; //收货人的电话
	private User user; //该订单属于哪一个用户
	
	List<OrderItem> orderItems=new ArrayList<OrderItem>();  //该订单中有多少订单项
}
