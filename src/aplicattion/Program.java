package aplicattion;

import java.util.List;

import model.DAO.DaoFactory;
import model.DAO.SellerDao;
import model.entites.Department;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {
	
       
       SellerDao sellerdao = DaoFactory.createSellerDao();
       
       System.out.println("==========teste1 : SELLER  findById ===================================");
       Seller sle = sellerdao.findByid(3);
       
       System.out.println(sle);
       
       System.out.println("\n==========teste2 : SELLER  findByDepartment ===============================");
       Department dep = new Department(2,null);
       List<Seller> lista = sellerdao.findByDepartment(dep);
       
       for(Seller e : lista) {
    	   
    	   System.out.println(e);
       }
       
	}

}
