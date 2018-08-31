
public class Main {

	public static StockList shop = new StockList();	
		
	public static void main(String[] args) {
		shop.addToStock(new StockItem("Kubek", 10, 22)); 
		shop.addToStock(new StockItem("Talerz", 10, 30));
		shop.addToStock(new StockItem("Miska", 10, 35));
		shop.addToStock(new StockItem("Lyzka", 10, 12));
		shop.addToStock(new StockItem("Widelec", 10, 13));
		shop.addToStock(new StockItem("Noz", 10, 14));
	
	//================ZAKUPY===============	
		Basket myBasket1 = new Basket("KoszOne");
		sellItem(myBasket1, "Talerz", 1);
		
//		Basket myBasket2 = new Basket("KoszTwo");
		//reserveItem(myBasket2, "Noz", 1);
		//reserveItem(myBasket2, "Talerz", 2);
//		System.out.println(myBasket2);
//		
//		System.out.println("\n Wyswietl koszyk.");
//		System.out.println(myBasket1.toString());
//		System.out.println(myBasket2.toString());
		
		System.out.println(shop.toString());

		System.out.println("\nZatwierdz zakupy");
		if (myBasket1.proceed(shop)){
			System.out.println("Zakupy zatwierdzone \n");
			System.out.println(shop.toString());
		} else{
			System.out.println("B³¹d zamowienia.");
		}
		
	}
	
	public static int sellItem(Basket basket, String itemName, int quantity){
		StockItem stockItem = shop.get(itemName);
		if(stockItem == null){
			System.out.println("We don't sell it");
			return 0;
		}
		if(shop.reserveStock(itemName, quantity) != 0){
			return basket.addToBasket(stockItem, quantity);
		}
		return 0;
	}
	
	public static int removeItem(Basket basket, String itemName, int quantity){
		StockItem stockItem = shop.get(itemName);
		if(stockItem == null){
			System.out.println("We don't sell it");
			return 0;
		}
		//if(basket.removeFromBasket(stockItem, quantity) == quantity){
		//	return shop.unreserveStock(itemName, quantity);
		//}
		return 0;
	}
}
