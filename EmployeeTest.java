import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee;
    private Division division;
    private Project project1;
    private Project project2;

    @BeforeEach
    void setUp() {
        employee = new Employee("John Doe", 5, 0.1);
        division = new Division(5000);
        project1 = new Project("Project A");
        project2 = new Project("Project B");
    }

    @Test
    void testCalculateSalary() {
        employee.setDivision(division);
        int expectedSalary = (int) (5000 * (1 + 0.1 + 5 / 10));
        assertEquals(expectedSalary, employee.calculateSalary());
    }

    @Test
    void testGetDivisionName() {
        employee.setDivision(division);
        assertEquals("Division", employee.getDivisionName());
    }

    @Test
    void testGetProjectsStringEmpty() {
        assertEquals("Belum ada proyek", employee.getProjectsString());
    }

    @Test
    void testGetProjectsString() {
        employee.addProject(project1);
        employee.addProject(project2);
        assertEquals("Project A, Project B", employee.getProjectsString());
    }

    @Test
    void testAddProjectMaxLimit() {
        employee.addProject(project1);
        employee.addProject(project2);
        Project project3 = new Project("Project C");
        employee.addProject(project3);
        assertFalse(employee.getProjects().contains(project3));
    }

    @Test
    void testRemoveProject() {
        employee.addProject(project1);
        employee.addProject(project2);

        assertTrue(employee.getProjects().contains(project1));
        employee.removeProject(project1);
        assertFalse(employee.getProjects().contains(project1));
    }

    @Test
    void testToString() {
        employee.addProject(project1);
        String expected = "John Doe - " + employee.calculateSalary() + " - Project A";
        assertEquals(expected, employee.toString());
    }
}
