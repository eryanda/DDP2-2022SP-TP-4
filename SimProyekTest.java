import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimProyekTest {

    private SimProyek app;

    @BeforeEach
    public void setUp() {
        app = new SimProyek();
        app.mockDivisionData();
        app.mockData();
    }

    @Test
    public void testCreateProject() {
        int projectCount = app.projectList.size();
        String projectName = "Proyek Baru";
        app.createProject(projectName);
        assertEquals(projectCount + 1, app.projectList.size());
        assertEquals(projectName, app.projectList.get(projectCount).getName());
    }

    @Test
    public void testAddProjectMember() {
        Project project = app.projectList.get(0);
        int initialMemberCount = project.getMemberList().size();

        // Tambahkan karyawan baru ke dalam proyek
        Employee employee = new Employee("Karyawan Baru", 2, 0.1);
        app.employeeList.add(employee);
        app.addProjectMember(1, "Karyawan Baru");

        assertEquals(initialMemberCount + 1, project.getMemberList().size());
        assertTrue(project.getMemberList().contains(employee));
    }

    @Test
    public void testDeleteProjectMember() {
        Project project = app.projectList.get(0);
        int initialMemberCount = project.getMemberList().size();

        // Hapus anggota proyek yang sudah ada
        app.deleteProjectMember(1, 1);

        assertEquals(initialMemberCount - 1, project.getMemberList().size());
    }

    @Test
    public void testAddEmployee() {
        int employeeCount = app.employeeList.size();
        String namaKaryawan = "Karyawan Baru";
        String jabatan = "Karyawan";
        int lamaBekerja = 3;
        double bonusGaji = 0.15;
        int nomorDivisi = 1;

        app.addEmployee(namaKaryawan, jabatan, lamaBekerja, bonusGaji, nomorDivisi);

        assertEquals(employeeCount + 1, app.employeeList.size());
        assertEquals(namaKaryawan, app.employeeList.get(employeeCount).getName());
    }
}
