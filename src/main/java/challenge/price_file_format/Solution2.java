package challenge.price_file_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Himansu Gupta
 *
 * Solution 2
 */

public class Solution2
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
		
		List<BabyProducts> listOfBabyProducts = readFileIntoObject(fileAdd,products);

		if(listOfBabyProducts.size() > 3)
		{
			BabyProducts result = calculate(listOfBabyProducts);
			System.out.print(" => "+result.getShop_ID()+", "+result.getPrice());
		}	
		else
		{
			System.out.println(" => none");
		}
	}

	public static BabyProducts calculate(List<BabyProducts> filtreList)
	{
		BabyProducts result = new BabyProducts();
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
	 * Read File and Search Product that input we got from User I save into  List of BabyProducts Objects
	 * 
	 * Return Filter / user Input  product,  list of BabyProduct Objects
	 * 
	 * 
	 */
	public static List<BabyProducts> readFileIntoObject(String fileAdd, ArrayList<String> products) throws NumberFormatException, IOException
	{
		List<BabyProducts> listOfBabyProducts = new ArrayList<BabyProducts>();
		BufferedReader br = new BufferedReader(new FileReader(new File(fileAdd)));
		String line;
		float price = 0;
		int shop_ID = 0;

		while((line = br.readLine()) != null )
		{
			String [] entries = line.split(",");
			BabyProducts babyProducts = null;
			List<String> product_label = new ArrayList<String>();
			for (int i = 0; i < entries.length; i++) 
			{
				if (i==0)
					shop_ID=Integer.parseInt(entries[0]);
				else if(i==1)
					price = Float.parseFloat(entries[1]);
				else 
				{	for (int j = 0; j < products.size(); j++)
				{

					if (products.get(j).equals(entries[i]))
					{	
						babyProducts = new BabyProducts();
						babyProducts.setShop_ID(shop_ID);
						babyProducts.setPrice(price);
						product_label.add(entries[i]);
						babyProducts.setProduct_label(product_label);
						listOfBabyProducts.add(babyProducts);
					}
				}
				}
			}
		}
		return listOfBabyProducts;
	}
}
