import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Basket {
	private final String name;
	private final Map<StockItem, Integer> shoppingList;
	
	public Basket(String name) {
		this.name = name;
		this.shoppingList = new HashMap<>();
	} 
	
	public int addToBasket(StockItem item, int quantity){
		if(quantity > 0 && item !=null){
			int inBasket = this.shoppingList.getOrDefault(item, 0);
			this.shoppingList.put(item,inBasket + quantity);
			return inBasket;
		}
		return 0;
	}
	
	public int removeFromBasket(StockItem item, int quantity){
		if ((item != null) && (quantity > 0)){
			int inBasket = shoppingList.getOrDefault(item, 0);
			int newQuantity = inBasket + quantity;
			
			if(newQuantity > 0){
				shoppingList.put(item, newQuantity);
				return quantity;}
			else if(newQuantity == 0){
				shoppingList.remove(item);
				return quantity;
			}	
		}
		return 0;
	}
	
	public void clearBasket(){
		shoppingList.clear();
	}

	public Map<StockItem, Integer> Items() {
		return Collections.unmodifiableMap(shoppingList); 
	}
	
	@Override
	public String toString() {
		String s = "Basket: "+ name + "\n";
			for (Map.Entry<StockItem, Integer> list : shoppingList.entrySet()){
				s += list.toString() + "\n";
			}
	return s;
	}

	public boolean proceed(StockList shop) {
		for (Map.Entry<StockItem, Integer> list: this.shoppingList.entrySet()){
			int reservedQuantity = list.getKey().getquantityReserved();
			StockItem name = list.getKey();
			System.out.println(shoppingList + "\n");
			if (name.adjustInStock(-reservedQuantity)) {
				list.getKey().reserveStock(-reservedQuantity);
				System.out.println(name.getItemName() + " potwierdzony.");
			} else{
				return false;
				}
			}
		return true;
	}
}
