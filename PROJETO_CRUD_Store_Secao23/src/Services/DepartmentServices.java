package Services;

import entities.Department;
import entities.dao.DaoFactory;
import entities.dao.DepartmentDao;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServices {
    private DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
    
    public List<Department> findAll(){
        List<Department> listDepartment = departmentDao.findAll();
        return listDepartment;
    }
}
