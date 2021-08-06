package aplicattion;

import java.util.Date;

import model.entites.Department;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {
		Department cu = new Department(1,"experts");
		System.out.println(cu);
		
		Seller pica = new Seller(21,"bob" ,"bobo@gmail.com",new Date(),3000.00 , cu);
       System.out.println(pica);
	}

}
