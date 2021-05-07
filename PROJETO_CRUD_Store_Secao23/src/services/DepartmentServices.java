package services;

import exceptions.DbException;
import entities.Department;
import entities.dao.DaoFactory;
import entities.dao.DepartmentDao;

import java.util.List;

public class DepartmentServices {
    private DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

    public List<Department> findAll(){
        List<Department> listDepartment = departmentDao.findAll();
        return listDepartment;
    }
    public void saveOrUpdate(Department department){
        if (department.getName() == "" || department.getName() == null){
            throw new DbException("Error, in saveOoUpdate, not able to save to database");
        }else if(department.getId() == null){
            departmentDao.insert(department);
        }else{
            departmentDao.update(department);
        }
    }
    public void delete(Department department){
        departmentDao.deleteById(department.getId());
    }
}
