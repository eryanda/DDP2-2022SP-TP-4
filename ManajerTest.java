import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Manager manager;
    private Project project1;
    private Project project2;
    private Project project3;
    private Project project4;

    @BeforeEach
    void setUp() {
        manager = new Manager("John Doe", 5, 0.2);
        project1 = new Project("Project A");
        project2 = new Project("Project B");
        project3 = new Project("Project C");
        project4 = new Project("Project D");
    }

    @Test
    void testAddProject() {
        manager.addProject(project1);
        manager.addProject(project2);
        manager.addProject(project3);

        assertEquals(3, manager.getProjects().size());
    }

    @Test
    void testAddProjectLimit() {
        manager.addProject(project1);
        manager.addProject(project2);
        manager.addProject(project3);
        manager.addProject(project4);

        assertEquals(3, manager.getProjects().size());
    }

    @Test
    void testToString() {
        String expected = "John Doe - " + manager.calculateSalary() + " - Belum ada proyek - Manager";
        assertEquals(expected, manager.toString());
    }
}
