Purpose of this project compare two shop price of same product.

I have Develop two solution.

Solution 1   :  I have to create one Plain Old Java Object (POJO) Class. For saving a raw in a object form.
                So it’s easy to iterate and search it and calculate a price of particular product.
				So I create one function to “readFile” means Read .csv file and covert one raw as a one object of  BabyProducts Class.
				Baby_Products Class I have declared ShopID Integer , Price Float , Product Label List of String  
				So Product Label can be multiple in one column .

				One more method to search particular product from List of Products. Return only selected object.
				
				One more for make list of product based on his shop ID. so its easy to calculate one shop price and other shop price of given products.
				so easily add price and compare both shop and less one is our result.

Solution 2  :  I have to create one Plain Old Java Object (POJO) Class. For saving a raw in a object form. 
               So it’s easy to iterate and search it and calculate a price of particular product.
			   
			   So I create one function to “readFile” means Read .csv file and covert one raw as a one object of  
			   BabyProducts Class in this method I have to read from file  and save only user input product in form of Object .
		       
		       Baby_Products Class I have declared ShopID Integer , Price Float , Product Label List of String  
			   So Product Label can be multiple in one column .

			   One more for make list of product based on his shop ID. so its easy to calculate one shop price and other shop price of given products.
			   so easily add price and compare both shop and less one is our result.

How to Use it download and unzip import in eclipse as Maven project run from Solution1 Class right click Run as Java Application.
As input so please read console and give a proper input.

User Input   :   	
 
Example 1: 

Entre File Add
C:/Himansu/Preparation_Workspace/price_file_format/data.csv
Entre Product 1
baby_powder
Entre Product 2
teddy_bear
O/P => 2, 11.5

Example 2:

Entre File Add
C:/Himansu/Preparation_Workspace/price_file_format/data.csv
Entre Product 1
Pampers_diapers
Entre Product 2
Baby_soap
O/P => none

Example 3:

Entre File Add
C:/Himansu/Preparation_Workspace/price_file_format/data.csv
Entre Product 1
scissor
Entre Product 2
Bath_towel
O/P => 6, 11.0
