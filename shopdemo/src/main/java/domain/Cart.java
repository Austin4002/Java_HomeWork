package domain;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
	// 购物车里的每一项
	private Map<String, CartItem> cartItems = new HashMap<String, CartItem>();
	// 总计
	private double total;
}
