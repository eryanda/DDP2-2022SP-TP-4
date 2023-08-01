import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    private Division division;

    @BeforeEach
    void setUp() {
        division = new Division(5000);
    }

    @Test
    void testAddEmployee() {
        Employee manager = new Manager("John Doe", 1, 7000);
        Employee employee = new Employee("Jane Smith", 1, 4000);

        division.addEmployee(manager);
        division.addEmployee(employee);

        assertTrue(division.getEmployeesList().contains(manager));
        assertTrue(division.getEmployeesList().contains(employee));
    }

    @Test
    void testSetBaseSalary() {
        division.setBaseSalary(5500);
        assertEquals(5500, division.getBaseSalary());
    }

    @Test
    void testGetEmployeesList() {
        assertTrue(division.getEmployeesList().isEmpty());
    }
}
