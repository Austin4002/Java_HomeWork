package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
	//商品
	private Product product;
	//购买数量
	private int buyNum;
	//小计
	private double subtotal;
}
