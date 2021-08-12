package aplicattion;

import model.DAO.DaoFactory;
import model.DAO.SellerDao;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {
	
       
       SellerDao sellerdao = DaoFactory.createSellerDao();
       
       System.out.println("==========teste1 : SELLER  findById ==================");
       Seller sle = sellerdao.findByid(3);
       
       System.out.println(sle);
       
	}

}
