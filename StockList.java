import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
	private final Map<String, StockItem> list;

	public StockList() {
		this.list = new HashMap<>();
	}

	public boolean addToStock(StockItem item){
		if (item != null){
			StockItem inStock = list.getOrDefault(item.getItemName(),item);
			if(inStock != item){
				item.adjustInStock(inStock.availableQuantity()); 
			}
			list.put(item.getItemName(), item);
			return true;
		}
		return false;
	}
	
	public int sellStock(String item, int quantity){
		StockItem inStock = list.get(item);
		if((inStock != null) && quantity > 0){
			return inStock.finaliseStock(quantity);
		}
		return 0;
	}
	
	public int reserveStock (String item, int quantity){
		StockItem inStock = list.get(item);
		if((inStock != null) && (quantity >0)){
				return inStock.reserveStock(quantity);
		}
		return 0;
	}
	
	public int unreserveStock (String item, int quantity){
		StockItem inStock = list.get(item);
		if((inStock != null) && (quantity >0)){
				return inStock.unreserveStock(quantity);
		}
		return 0;
	}
	
	public StockItem get(String key){
		return list.get(key); 
	}
	
	public Map<String, StockItem> Item(){
		return Collections.unmodifiableMap(list);
	}

	@Override
	public String toString() {
		String s = "\nIn stock\n";
		double totalValue = 0;
		
		for (Map.Entry<String, StockItem> item : list.entrySet()){
			StockItem stockItem = item.getValue();
			
			double totalPrice = stockItem.getPrice() * stockItem.availableQuantity();
			
			s = s + stockItem + " " + "  :" + totalPrice+ "\n";
			totalValue += totalPrice;
		}
		return s + "Total value = " + totalValue;
	}
}