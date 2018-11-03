package com.zgg.mapper;


import com.zgg.bean.Department;
import com.zgg.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

//或者@MapperScan将接口扫描装配到容器中
@Mapper
public interface EmployeeMapper {


    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Select("select * from employee")
    public Collection<Employee> getEmpAll();

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into employee(lastName,email,gender,birth) values(#{lastName},#{email},#{gender},#{birth}) ")
    public int insertEmp(Employee employee);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender} where id=#{id}")
    public int updateEmp(Employee employee);


    @Delete("delete from employee where id=#{id}")
    public int deleteEmpById(Integer id);
}
