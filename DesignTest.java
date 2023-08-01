import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesignTest {

    private Design design;

    @BeforeEach
    void setUp() {
        design = new Design(5000);
    }

    @Test
    void testAddEmployee() {
        Employee manager = new Manager("John Doe", 1, 7000);
        Employee employee = new Employee("Jane Smith", 2, 4000);

        design.addEmployee(manager);
        design.addEmployee(employee);

        assertTrue(design.getEmployeesList().contains(manager));
        assertTrue(design.getEmployeesList().contains(employee));
    }

    @Test
    void testToStringEmpty() {
        String expected = "Divisi Design memiliki 0 karyawan dengan 0 manager.";
        assertEquals(expected, design.toString());
    }

    @Test
    void testToStringWithEmployees() {
        Employee manager1 = new Manager("John Doe", 1, 7000);
        Employee manager2 = new Manager("Jane Smith", 1, 7500);
        Employee employee1 = new Employee("Alice Johnson", 1, 4500);
        Employee employee2 = new Employee("Bob Williams", 1, 4800);

        design.addEmployee(manager1);
        design.addEmployee(manager2);
        design.addEmployee(employee1);
        design.addEmployee(employee2);

        String expected = "Divisi Design memiliki 2 karyawan dengan 2 manager.";
        assertEquals(expected, design.toString());
    }
}
