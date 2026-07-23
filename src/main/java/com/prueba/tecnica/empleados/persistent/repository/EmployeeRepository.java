package com.prueba.tecnica.empleados.persistent.repository;

import com.prueba.tecnica.empleados.dto.EmployeeDTO;
import com.prueba.tecnica.empleados.persistent.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query(
            """
                   SELECT new com.prueba.tecnica.empleados.dto.EmployeeDTO(
                    	E.id,
                    	CONCAT(E.firstName, " ", E.lastName),
                    	E.hireDate,
                    	T.title,
                    	S.salary,
                    	D.departmentName)
                    FROM
                    	DepartmentEntity D
                    INNER JOIN DepartmentEmployeeEntity DE
                    ON
                    	D.id = DE.departmentId
                    INNER JOIN EmployeeEntity E
                    ON
                    	E.id = DE.employeeId
                    INNER JOIN TitleEntity T
                    ON
                    	T.employeeId = DE.employeeId
                    INNER JOIN SalaryEntity S
                    ON
                    	S.employeeId = DE.employeeId
                    WHERE
                    	D.id = :departmentId
                  
            """
    )
    List<EmployeeDTO> findByIdDepartment(@Param("departmentId") Long departmentId);
}
