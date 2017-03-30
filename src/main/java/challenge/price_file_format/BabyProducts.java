package challenge.price_file_format;

import java.util.List;
import java.util.ArrayList;


/**
 * 
 * Himansu Gupta
 * 
 * POJO Class of BABYPRODUCTS
 *
 */
public class BabyProducts 
{
	int shop_ID;
	Float price;
	List<String> product_label = new ArrayList<String>();
	
	public int getShop_ID() {
		return shop_ID;
	}
	
	public void setShop_ID(int shop_ID) {
		this.shop_ID = shop_ID;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}

	public List<String> getProduct_label() {
		return product_label;
	}

	public void setProduct_label(List<String> product_label) {
		this.product_label = product_label;
	}
	
	public void addProduct_label(List<String> product_label , String product_label_1) {
		this.product_label.add(product_label_1);
	}
	
	/*public int compareTo(BabyProducts babyProduct)
	{
		if(babyProduct.shop_ID == )
		
		return;
	}*/
}
