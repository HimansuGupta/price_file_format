package challenge.price_file_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Himansu Gupta
 * 
 * Solution 1
 *
 */
public class Solution1 
{
	//Entry Point
	public static void main( String[] args ) throws IOException
	{
		ArrayList<String> products = new ArrayList<>();
		String fileAdd;
		String firstProduct;
		String secondProduct;
		
	   //String fileAdd = "C:/Himansu/Preparation_Workspace/price_file_format/data.csv";

		// Example 1: Input
		//products.add("baby_powder");
		//products.add("teddy_bear");

		// Example 2: Input
		//products.add("pampers_diapers");
		//products.add("baby_soap");

		// Example 3: Input
		//products.add("scissor");
		//products.add("bath_towel");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entre File Add");
		fileAdd = scanner.nextLine();
		System.out.println("Entre Product 1");
		firstProduct = scanner.nextLine();
		System.out.println("Entre Product 2");
		secondProduct = scanner.nextLine();
		products.add(firstProduct);
		products.add(secondProduct);
		
		List<BabyProducts> listOfBabyProducts = readFile(fileAdd);
		List<BabyProducts>  filtreList = serach(listOfBabyProducts , products);

		if(filtreList != null)
		{
			BabyProducts result = calculate(filtreList);   								// Call Calculate(filtreList)in this method I pass FiltreList that contain only four Object of BabyProduts Class
			System.out.print(" => "+result.getShop_ID()+", "+result.getPrice());
		}
		else
		{
			System.out.println("NONE......");
		}
	}

	/*
	 * 
	 * Calculate Price of User input Products from  filter Product list
	 * 
	 * Return object of BabyProducts final Result
	 * 
	 */
	public static BabyProducts calculate(List<BabyProducts> filtreList)
	{
		List<BabyProducts> temp1 = new ArrayList<>();
		List<BabyProducts> temp2 = new ArrayList<>();

		float val1 ;
		float val2;

		for (int i = 0; i < filtreList.size(); i++)
		{
			if(i == 0)
			{	
				temp1.add(filtreList.get(0));
			}
			else
				if(temp1.get(0).getShop_ID() == filtreList.get(i).getShop_ID())
				{
					temp1.add(filtreList.get(i));
				}
				else
				{
					temp2.add(filtreList.get(i));
				}
		}

		val1 = addPrice(temp1);
		val2 = addPrice(temp2);
		BabyProducts baby = new BabyProducts();

		if(val1 < val2)
		{	 
			baby.setShop_ID(temp1.get(0).getShop_ID());
			baby.setPrice(val1);
			return baby;
		}
		else
		{
			baby.setShop_ID(temp2.get(0).getShop_ID());
			baby.setPrice(val2);
			return baby;

		}
	}

	/*
	 * This addPrice of same ShopID and return Sum of both product but for one SHOPID
	 * 
	 * Return Sum of one shop Price
	 */
	public static float addPrice(List<BabyProducts> temp)
	{
		float val1 = 0;

		for (int i = 0; i < temp.size(); i++) {
			val1 = val1 + temp.get(i).getPrice();
		}
		return val1;
	}

	/*
	 * 
	 * Search Product that input we got from User from List of BabyProducts 
	 * 
	 * Return Filter / user Input  product,  list of BabyProduct Objects
	 * 
	 */
	public static List<BabyProducts> serach(List<BabyProducts> listOfBabyProducts, ArrayList<String> products )
	{
		List<BabyProducts> listOfbabyProduct = new ArrayList<>();
		for (int i = 0; i < listOfBabyProducts.size(); i++) 
		{
			BabyProducts tempbabyProduct = new BabyProducts();
			List<String> tempList = new ArrayList<>();
			tempbabyProduct.setShop_ID(listOfBabyProducts.get(i).getShop_ID());
			tempbabyProduct.setPrice(listOfBabyProducts.get(i).getPrice());
			for (int j = 0; j < listOfBabyProducts.get(i).getProduct_label().size(); j++)
			{
				for (int k = 0; k < products.size(); k++) 
				{
					if (products.get(k).equals(listOfBabyProducts.get(i).getProduct_label().get(j)))
					{	
						tempList.add(products.get(k));
						tempbabyProduct.setProduct_label(tempList);
						listOfbabyProduct.add(tempbabyProduct);
					}
				}
			}
		}
		if(listOfbabyProduct.size() < 3)
		{	
			listOfbabyProduct=null;
			return listOfbabyProduct;
		}
		return listOfbabyProduct;

	}

	/*
	 * 
	 * Read File and Save into List of BabyProducts in Object form.
	 * 
	 * Retrun List of BabyProducts Objects
	 * 
	 */
	public static List<BabyProducts> readFile(String fileAdd) throws NumberFormatException, IOException
	{
		List<BabyProducts> listOfBabyProducts = new ArrayList<BabyProducts>();
		BufferedReader br = new BufferedReader(new FileReader(new File(fileAdd)));
		String line;
		while((line = br.readLine()) != null )
		{
			String [] entries = line.split(",");
			BabyProducts babyProducts = new BabyProducts();
			List<String> product_label = new ArrayList<String>();
			for (int i = 0; i < entries.length; i++) {
				if (i==0)
					babyProducts.setShop_ID(Integer.parseInt(entries[0]));
				else if(i==1)
					babyProducts.setPrice(Float.parseFloat(entries[1]));
				else 
					product_label.add(entries[i]);

			}
			babyProducts.setProduct_label(product_label);
			listOfBabyProducts.add(babyProducts);
		}
		return listOfBabyProducts;
	}
}
