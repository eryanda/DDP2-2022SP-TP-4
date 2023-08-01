import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HRDTest {

    @Test
    public void testAddEmployee() {
        HRD hrd = new HRD(6000000);

        // Membuat beberapa karyawan dan manajer baru
        Employee employee1 = new Employee("Employee 1", 2, 0.1);
        Manager manager1 = new Manager("Manager 1", 4, 0.25);

        // Menambahkan karyawan dan manajer ke divisi HRD
        hrd.addEmployee(employee1);
        hrd.addEmployee(manager1);

        // Memastikan karyawan dan manajer telah ditambahkan ke divisi HRD
        assertTrue(hrd.getEmployeesList().contains(employee1));
        assertTrue(hrd.getEmployeesList().contains(manager1));
    }

    @Test
    public void testToString() {
        HRD hrd = new HRD(6000000);

        // Membuat beberapa karyawan dan manajer baru
        Employee employee1 = new Employee("Employee 1", 2, 0.1);
        Manager manager1 = new Manager("Manager 1", 4, 0.25);

        // Menambahkan karyawan dan manajer ke divisi HRD
        hrd.addEmployee(employee1);
        hrd.addEmployee(manager1);

        // Menghitung jumlah karyawan dan manajer di divisi HRD
        int managerCount = 0;
        for (Employee employee : hrd.getEmployeesList()) {
            if (employee instanceof Manager) {
                managerCount++;
            }
        }
        int employeeCount = hrd.getEmployeesList().size() - managerCount;

        // Memastikan hasil representasi string sesuai dengan perhitungan jumlah karyawan dan manajer
        String expectedString = "Divisi HRD memiliki " + employeeCount + " karyawan dengan " + managerCount + " manager.";
        assertEquals(expectedString, hrd.toString());
    }
}
