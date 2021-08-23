package aplicattion;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.DAO.DaoFactory;
import model.DAO.SellerDao;
import model.entites.Department;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {
	  
		
		Scanner sc = new Scanner(System.in);
       
       SellerDao sellerdao = DaoFactory.createSellerDao();
       
       System.out.println("==========teste1 : SELLER  findById ========================================");
       Seller sle = sellerdao.findByid(3);
       
       System.out.println(sle);
       
       System.out.println("\n==========teste2 : SELLER  findByDepartment ==========================================");
       Department dep = new Department(1,null);
       List<Seller> lista = sellerdao.findByDepartment(dep);
       
       for(Seller e : lista) {
    	   
    	   System.out.println(e);
       }
       
       System.out.println("\n==========teste3 : SELLER  findAll() ==========================================");
       
        lista = sellerdao.findAll();
       
       for(Seller e : lista) {
    	   
    	   System.out.println(e);
       }
       
       
     //  System.out.println("\n==========teste4 : SELLER  insert() ==========================================");
       
       
      // Seller obj = new Seller(null, "cuca" ,"cuga@gmail.com" , new Date(), 4000.0 , dep);
      // sellerdao.insert(obj);
       
     //  System.out.println("INSERIR NOVO ID = " + obj.getId());
       
    //System.out.println("\n==========teste 5  : SELLER  Update() ==========================================");
       
       
      // Seller atua = new  Seller(11,"mastra cardoso" , "mastra@gmail.com" , new Date() , 5000.00 , dep);
       //sellerdao.update(atua);
       
       //System.out.println("UPDATE COMPLETADO !!!");
       
       
       System.out.println("\n==========teste 6  : SELLER  Delete() ==========================================");
       System.out.println(" entre o ID do vendedor que vai ser deletado : ");
       int deletar = sc.nextInt();
       sellerdao.deleteByid(deletar);
       System.out.println("o ID deletado foi : " + deletar);
       
       sc.close();
	}

}
