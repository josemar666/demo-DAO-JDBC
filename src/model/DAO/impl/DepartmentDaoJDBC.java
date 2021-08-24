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
import model.DAO.DepartmentDao;
import model.entites.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection com;
	
public DepartmentDaoJDBC(Connection com) {
	this.com = com ;
}
	
	@Override
	public void insert(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByid(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findByid(Integer id) {
		  PreparedStatement st = null;
		   ResultSet rs = null;
		   try {
			   com = DB.getConnection();
			   st = com.prepareStatement("SELECT * from department  WHERE Id = ?");
			   
			   st.setInt(1,id);
			   rs = st.executeQuery();
			   if(rs.next()) {
				   Department dp = instantiateDepartment(rs);
			   return dp;
			   }
			   return null;
			   
			   
		   }catch(SQLException e) {
			   throw new DbException(e.getMessage());
		   }finally {
			   DB.closeStatement(st);
			   DB.closeResultSet(rs);
		   }
	
	}
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		
			Department dep = new Department();
			dep.setId(rs.getInt("Id"));
			dep.setName(rs.getString("Name"));
			return dep;
			
		
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		   ResultSet rs = null;
		   
		   
		   try {
			   com = DB.getConnection();
			   st = com.prepareStatement("SELECT * from Department " + 
			   		 			   		" ORDER BY Name");
			   			       
			        rs = st.executeQuery();
			        List<Department> lista = new ArrayList<>();
			        Map<Integer , Department> map = new HashMap<>();
			        while(rs.next()) {
			        	
			        	Department dep = map.get(rs.getInt("Id"));
			        	 if(dep == null) {
				        	    dep = instantiateDepartment(rs);
				        	   map.put(rs.getInt("Id"), dep);
				           }
			        	 lista.add(dep);
			        	
			        }
		return lista;
	}catch(SQLException e) {
		throw new DbException(e.getMessage());
	}finally{
	   DB.closeStatement(st);
       DB.closeResultSet(rs);
       
		
	}
	}

}
