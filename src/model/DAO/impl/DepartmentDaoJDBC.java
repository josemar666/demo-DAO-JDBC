package model.DAO.impl;

import java.sql.Connection;
import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
