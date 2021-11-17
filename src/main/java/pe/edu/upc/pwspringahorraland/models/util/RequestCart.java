package pe.edu.upc.pwspringahorraland.models.util;

public class RequestCart {
	private String ProductID;
	
	private String SaleID;
	
	private String quantity;
	
	private String partialPrice;

		
	public RequestCart() {
		super();
	}
	
	

	public RequestCart(String productID, String saleID, String quantity, String partialPrice) {
		super();
		ProductID = productID;
		SaleID = saleID;
		this.quantity = quantity;
		this.partialPrice = partialPrice;
	}



	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public String getSaleID() {
		return SaleID;
	}

	public void setSaleID(String saleID) {
		SaleID = saleID;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPartialPrice() {
		return partialPrice;
	}

	public void setPartialPrice(String partialPrice) {
		this.partialPrice = partialPrice;
	}
	
	
}
