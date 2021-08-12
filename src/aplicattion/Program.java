package aplicattion;

import model.DAO.DaoFactory;
import model.DAO.SellerDao;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {
	
       
       SellerDao sellerdao = DaoFactory.createSellerDao();
       Seller sle = sellerdao.findByid(3);
       
       System.out.println(sle);
       
	}

}
