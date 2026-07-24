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

    @Query("""
            
           SELECT new com.prueba.tecnica.empleados.dto.EmployeeDTO(
            E.firstName,
            E.lastName,
            E.email,
            TL.title,
            S.salary,
            S.commission,
            CONCAT(EM.firstName, " ", EM.lastName))
            FROM
            	TitleEntity T
            INNER JOIN DepartmentEmployeeManagerEntity DM
            ON
            	DM.employeeId = T.employeeId
            INNER JOIN DepartmentEmployeeEntity DE
            ON
            	DE.departmentId = DE.departmentId
            INNER JOIN EmployeeEntity E
            ON
            	E.id = DE.employeeId
            INNER JOIN EmployeeEntity EM
            ON
            	EM.id = T.employeeId
            INNER JOIN TitleEntity TL
            ON
            	TL.employeeId = E.id
            INNER JOIN SalaryEntity S
            ON
            	S.employeeId = E.id
            WHERE
            	T.title = :charge
            	AND T.employeeId = :idEmployeeManager
            """)
    List<EmployeeDTO> findByNameChargeAndIdEmployeeManager(@Param("charge") String charge, @Param("idEmployeeManager") Long idEmployeeManager);
}
