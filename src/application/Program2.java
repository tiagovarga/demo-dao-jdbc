package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: department findById =====" );
		Department department = departmentDao.findById(1);		
		System.out.println(department);
		
		System.out.println("\n=== Test 2: department findAll =====" );
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		System.out.println("\n=== Test 3: department insert =====" );
		Department newDepartment = new Department(null , "Sports");
		departmentDao.insert(newDepartment);
		System.out.println("Tnserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== Test 5: department update =====" );
		newDepartment = departmentDao.findById(1);
		newDepartment.setName("Foods");
		departmentDao.update(newDepartment);
		System.out.println("Update completed");
		
		System.out.println("\n=== Test 6: department delete =====" );
		System.out.println("Enter id for delected test");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();

	}
}
