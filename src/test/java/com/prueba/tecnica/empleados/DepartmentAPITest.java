package com.prueba.tecnica.empleados;

import com.prueba.tecnica.empleados.dto.DepartmentRequestDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:test.properties")
public class DepartmentAPITest {

    @Value("${test.department.url}")
    String testUrl;

    @Test
    void createOkTest() {

        DepartmentRequestDTO departmentRequestDTO = getDepartmentRequestDTO();

        RestAssured
                .given()
                .log()
                .all()
                .when()
                .body(departmentRequestDTO)
                .contentType(ContentType.JSON)
                .post(testUrl)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.OK.value());
    }

    private DepartmentRequestDTO getDepartmentRequestDTO() {
        DepartmentRequestDTO departmentRequestDTO = new DepartmentRequestDTO();
        departmentRequestDTO.setName("Test Department");
        departmentRequestDTO.setIdEmployeeManager(1L);
        return departmentRequestDTO;
    }

}
