import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private Project project;
    private Manager manager;
    private Employee employee;

    @BeforeEach
    void setUp() {
        project = new Project("Project A");
        manager = new Manager("John Doe", 5, 0.2);
        employee = new Employee("Jane Smith", 3, 0.1);
    }

    @Test
    void testAddMemberManagerAsLeader() {
        project.addMember(manager);
        assertFalse(project.getMemberList().isEmpty());
    }

    @Test
    void testAddMemberEmployeeAsMember() {
        project.addMember(employee);
        assertNull(project.getProjectLeader());
        assertTrue(project.getMemberList().contains(employee));
    }

    @Test
    void testRemoveMemberManagerAsLeader() {
        project.addMember(manager);
        project.removeMember(manager);
        assertNull(project.getProjectLeader());
        assertTrue(project.getMemberList().isEmpty());
    }

    @Test
    void testRemoveMemberEmployeeAsMember() {
        project.addMember(employee);
        project.removeMember(employee);
        assertNull(project.getProjectLeader());
        assertTrue(project.getMemberList().isEmpty());
    }

    @Test
    void testEquals() {
        Project project2 = new Project("Project A");
        assertEquals(project, project2);
    }

    @Test
    void testHashCode() {
        Project project2 = new Project("Project A");
        assertEquals(project.hashCode(), project2.hashCode());
    }
}
