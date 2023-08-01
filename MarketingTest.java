import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarketingTest {

    @Test
    public void testAddEmployee() {
        Marketing marketing = new Marketing(7000000);

        // Membuat beberapa karyawan dan manajer baru
        Employee employee1 = new Employee("Employee 1", 2, 0.1);
        Manager manager1 = new Manager("Manager 1", 4, 0.25);

        // Menambahkan karyawan dan manajer ke divisi Marketing
        marketing.addEmployee(employee1);
        marketing.addEmployee(manager1);

        // Memastikan karyawan dan manajer telah ditambahkan ke divisi Marketing
        assertTrue(marketing.getEmployeesList().contains(employee1));
        assertTrue(marketing.getEmployeesList().contains(manager1));
    }

    @Test
    public void testToString() {
        Marketing marketing = new Marketing(7000000);

        // Membuat beberapa karyawan dan manajer baru
        Employee employee1 = new Employee("Employee 1", 2, 0.1);
        Manager manager1 = new Manager("Manager 1", 4, 0.25);

        // Menambahkan karyawan dan manajer ke divisi Marketing
        marketing.addEmployee(employee1);
        marketing.addEmployee(manager1);

        // Menghitung jumlah karyawan dan manajer di divisi Marketing
        int managerCount = 0;
        for (Employee employee : marketing.getEmployeesList()) {
            if (employee instanceof Manager) {
                managerCount++;
            }
        }
        int employeeCount = marketing.getEmployeesList().size() - managerCount;

        // Memastikan hasil representasi string sesuai dengan perhitungan jumlah karyawan dan manajer
        String expectedString = "Divisi Marketing memiliki " + employeeCount + " karyawan dengan " + managerCount + " manager.";
        assertEquals(expectedString, marketing.toString());
    }
}
