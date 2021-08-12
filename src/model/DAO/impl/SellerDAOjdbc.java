package model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
		          Department dp = new Department();
		          dp.setId(rs.getInt("DepartmentId"));
		          dp.setName(rs.getString("DepName"));
		          Seller ob = new Seller();
		          ob.setId(rs.getInt("Id"));
		          ob.setName(rs.getString("Name"));
		          ob.setEmail(rs.getString("Email"));
		          ob.setBithDate(rs.getDate("BirthDate"));
		          ob.setBaseSalary(rs.getDouble("BaseSalary"));
		          ob.setDepartment(dp);
		          
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

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
