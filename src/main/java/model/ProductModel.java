package model;

import java.io.File;

import javax.servlet.http.Part;

import util.StringUtils;

public class ProductModel {
	private int productId;
	private String productName;
	private String productImageUrl;
	private int productPrice;
	private String productDescription;
	private int productInventory;
	private String productCategory;
	

	public ProductModel(String productName, Part imagePart, int productPrice,
			String productDescription, int productInventory, String productCategory) {
		super();
//		this.productId = productId;
		this.productName = productName;
		this.productImageUrl = getImageUrl(imagePart);
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productInventory = productInventory;
		this.productCategory = productCategory;
	}
	
	public ProductModel() {
		// TODO Auto-generated constructor stub
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(int productInventory) {
		this.productInventory = productInventory;
	}
	
	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	private String getImageUrl(Part part) {
		String savePath = StringUtils.IMAGE_DIR_SAVE_PATH;
		File fileSaveDir = new File(savePath);
		String imageUrlFromPart = null;
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
			imageUrlFromPart = "download.jpg";
		}
		return imageUrlFromPart;
	}
	
}
	