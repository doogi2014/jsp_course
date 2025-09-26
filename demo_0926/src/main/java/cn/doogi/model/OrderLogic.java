package cn.doogi.model;

import java.util.ArrayList;
import java.util.List;

public class OrderLogic {
	
	public List<String> getResult(List<String> list){
		List<String> res = new ArrayList<String>();
		//List<Order> orders = new ArrayList<Order>();
		String str1 = "";
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < list.size(); i++) {
			Order order =new Order();
			order.setCount(Integer.valueOf(list.get(i)));
			//orders.add(order);
			switch (i) {
			case 0:
				order.setName("まぐる");
				order.setPrice(100);
				break;
			case 1:
				order.setName("サ一モン");
				order.setPrice(125);
				break;
			case 2:
				order.setName("エビ");
				order.setPrice(150);
				break;
			case 3:
				order.setName("タコ");
				order.setPrice(175);
				break;
			case 4:
				order.setName("イ力");
				order.setPrice(200);
				break;
			case 5:
				order.setName("いくら");
				order.setPrice(300);
				break;
			default:
				break;
			}
			
			if(order.getCount()>0) {
				str1+= order.getName()+"が"+order.getCount()+"皿、";
				count1 += order.getCount();
				count2 += order.getCount()*order.getPrice();
			}
		}
		res.add(str1);
		res.add(String.valueOf(count1));
		res.add(String.valueOf(count2));
		return res;
	}
}
