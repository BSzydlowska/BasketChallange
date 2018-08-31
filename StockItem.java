import java.lang.Comparable;

public class StockItem implements Comparable<StockItem>{

	private final String itemName;
	private int inStock;
	private int reserved;
	private double price;
	
	public StockItem(String itemName, double price) {
		super();
		this.itemName = itemName;
		this.inStock = 0;
		this.reserved = 0;
		this.price = price;
	}

	public StockItem(String itemName, int inStock, double price) {
		super();
		this.itemName = itemName;
		this.inStock = inStock;
		this.reserved = 0;
		this.price = price;
	}

	public int availableQuantity() {
		return inStock - reserved;
	}

	public int getquantityReserved() {
		return reserved;
	}
	
	public double getPrice() {
		return price;
	}

	public String getItemName() {
		return itemName;
	}

	public boolean adjustInStock(int quantity){
		if ((quantity + this.inStock) >= 0){
			this.inStock = this.inStock + quantity;
			return true;
		}
		return false;
	}
	
	public int  reserveStock(int quantity){
		if (quantity <= availableQuantity()){
			reserved += quantity;
			return quantity;
		}
		return 0;
	}
	
	public int unreserveStock(int quantity){
		 if(quantity <= reserved){
			 reserved -= quantity;
			 return quantity;
		 }
		 return 0;
	 }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockItem other = (StockItem) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return itemName + "\t - "+ inStock + " -inStock\t| "
				+ reserved + " -reserved \t "
				+ price + "zl";
	}

	@Override
	public int compareTo(StockItem item) {
		System.out.println("Into compareto()");
		if(this == item){
			return 0;
		}
		if (item != null){
			return this.itemName.compareTo(item.getItemName());
		}
		throw new NullPointerException();
	}

	public int finaliseStock(int quantity) {
		if(quantity <= reserved){
			inStock -= quantity;
			reserved -= quantity;
			return quantity;
		}
		return 0;
	}
}
