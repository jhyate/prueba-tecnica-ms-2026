package com.prueba.tecnica.empleados;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:test.properties")
class EmployeeAPITest {

	@Value("${test.employee.url}")
	String testUrl;

	@Test
	void findByIdDepartmentOkTest() {

		RestAssured
				.given()
				.log()
				.all()
				.when()
				.pathParam("departmentId", "1")
				.get(testUrl.concat("/{departmentId}"))
				.then()
				.log()
				.all()
				.statusCode(HttpStatus.OK.value())
				.body("$", not(empty()))
				.body("$", hasSize(2))
				// Primer empleado
				.body("[0].id", equalTo(2))
				.body("[0].name", equalTo("Carlos Ruiz"))
				.body("[0].hireDate", equalTo("2013-04-22T00:00:00"))
				.body("[0].nameCharge", equalTo("Tester"))
				.body("[0].salary", equalTo(1000000))
				.body("[0].nameDepartment", equalTo("Tecnologia"))
				// Segundo empleado
				.body("[1].id", equalTo(3))
				.body("[1].name", equalTo("Diana Cepeda"))
				.body("[1].hireDate", equalTo("2010-01-01T00:00:00"))
				.body("[1].nameCharge", equalTo("Jefe de proyecto"))
				.body("[1].salary", equalTo(4500000))
				.body("[1].nameDepartment", equalTo("Tecnologia"));
	}

	@Test
	void findByIdDepartmentNotContentTest() {

		RestAssured
				.given()
				.log()
				.all()
				.when()
				.pathParam("departmentId", "100")
				.get(testUrl.concat("/{departmentId}"))
				.then()
				.log()
				.all()
				.statusCode(HttpStatus.NO_CONTENT.value());
	}

	@Test
	void findByNameChargeAndIdEmployeeManagerOkTest() {

		RestAssured
				.given()
				.log()
				.all()
				.when()
				.queryParam("nameCharge", "INGENIERO DE DESARROLLO")
				.queryParam("idManager", 1)
				.get(testUrl)
				.then()
				.log()
				.all()
				.statusCode(HttpStatus.OK.value())
				.body("$", not(empty()))
				.body("$", hasSize(2))
				// Primer empleado
				.body("[0].name", equalTo("Carlos"))
				.body("[0].lastname", equalTo("Ruiz"))
				.body("[0].nameCharge", equalTo("Tester"))
				.body("[0].salary", equalTo(1000000))
				.body("[0].nameManager", equalTo("Jose Yate"))
				// Segundo empleado
				.body("[1].name", equalTo("Diana"))
				.body("[1].lastname", equalTo("Cepeda"))
				.body("[1].nameCharge", equalTo("Jefe de proyecto"))
				.body("[1].salary", equalTo(4500000))
				.body("[1].commission", equalTo(1))
				.body("[1].nameManager", equalTo("Jose Yate"));
	}

	@Test
	void findByNameChargeAndIdEmployeeManagerNotContentTest() {

		RestAssured
				.given()
				.log()
				.all()
				.when()
				.queryParam("nameCharge", "INGENIERO DE DESARROLLO")
				.queryParam("idManager", 8)
				.get(testUrl)
				.then()
				.log()
				.all()
				.statusCode(HttpStatus.NO_CONTENT.value());
	}

}
