package model;

public class CartModel extends ProductModel{
	
	private int cartId;
	private int quantity;
	

	public CartModel() {
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	
	
}