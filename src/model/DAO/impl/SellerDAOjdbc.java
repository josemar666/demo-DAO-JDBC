package model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.DAO.SellerDao;
import model.entites.Department;
import model.entites.Seller;

public class SellerDAOjdbc implements SellerDao {

	private Connection com ;
	
	
	public SellerDAOjdbc(Connection com) {
		
		this.com = com;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByid(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findByid(Integer id) {
	   PreparedStatement st = null;
	   ResultSet rs = null;
	   
	   
	   try {
		   com = DB.getConnection();
		   st = com.prepareStatement("SELECT seller.*,department.Name as DepName "
		   		+ "FROM seller INNER JOIN department "
		   		+ "ON seller.DepartmentId = department.Id "
		   		+ "WHERE seller.Id = ? ");
		   
		        st.setInt(1, id);
		        rs = st.executeQuery();
		        if(rs.next()) {
		          Department dp = instantiateDepartment(rs);
		         
		          Seller ob = instatiateSeller(rs, dp);
		          
		          return ob;
		        }
		      return null;
	   }catch(SQLException e) {
		   
		   throw new DbException(e.getMessage());
	   }
	   finally {
		   DB.closeResultSet(rs);
		   DB.closeStatement(st);
		  
		   
	   }
	
	}

	private Seller instatiateSeller(ResultSet rs, Department dp) throws SQLException {
		 Seller ob =  new Seller();
         ob.setId(rs.getInt("Id"));
         ob.setName(rs.getString("Name"));
         ob.setEmail(rs.getString("Email"));
         ob.setBithDate(rs.getDate("BirthDate"));
         ob.setBaseSalary(rs.getDouble("BaseSalary"));
         ob.setDepartment(dp);
         return ob;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
		
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department dp) {
		 PreparedStatement st = null;
		   ResultSet rs = null;
		   
		   
		   try {
			   com = DB.getConnection();
			   st = com.prepareStatement("SELECT seller.*,department.Name as DepName " + 
			   		"FROM seller INNER JOIN department " + 
			   		" ON seller.DepartmentId = department.Id " + 
			   		" WHERE DepartmentId = ? " + 
			   		" ORDER BY Name");
			   
			        st.setInt(1, dp.getId());
			        rs = st.executeQuery();
			       
			        List<Seller> lista = new ArrayList<>();
			        Map<Integer , Department> map = new HashMap<>();
			        
			        
			        while(rs.next()) {
			        	
			        Department dep = map.get(rs.getInt("DepartmentId"));
			        
			           if(dep == null) {
			        	    dep = instantiateDepartment(rs);
			        	   map.put(rs.getInt("DepartmentId"), dep);
			           }
			        		        
			         
			          Seller ob = instatiateSeller(rs, dep);
			          
			          lista.add(ob);
			        }
			      return lista;
		   }catch(SQLException e) {
			   
			   throw new DbException(e.getMessage());
		   }
		   finally {
			   DB.closeResultSet(rs);
			   DB.closeStatement(st);
			  
			   
		   }
		
	}

}
