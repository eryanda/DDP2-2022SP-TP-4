import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InternTest {

    @Test
    public void testAddProject() {
        Intern intern = new Intern("Intern 1", 1, 0.05);

        // Membuat proyek baru
        Project project1 = new Project("Proyek 1");

        // Menambahkan proyek ke intern
        intern.addProject(project1);

        // Memastikan intern hanya dapat mengikuti satu proyek
        assertEquals(1, intern.getProjects().size());
    }

    @Test
    public void testToString() {
        Intern intern = new Intern("Intern 1", 1, 0.05);

        // Memastikan hasil representasi string sesuai dengan jabatan "Intern"
        String expectedString = intern.getName() + " - " + intern.calculateSalary() + " - " + intern.getProjectsString() + " - Intern";
        assertEquals(expectedString, intern.toString());
    }
}
