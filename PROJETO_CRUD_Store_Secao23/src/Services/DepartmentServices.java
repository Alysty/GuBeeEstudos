package Services;

import entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServices {
    public List<Department> findAll(){
        List<Department> list = new ArrayList<>();
        list.add(new Department(1, "test"));
        list.add(new Department(2, "test2"));
        return list;
    }
}
