import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EngineeringTest {

    @Test
    public void testAddEmployee() {
        Engineering engineering = new Engineering(5000000);

        // Membuat beberapa karyawan dan manajer baru
        Employee employee1 = new Employee("Employee 1", 3, 0.2);
        Manager manager1 = new Manager("Manager 1", 5, 0.3);

        // Menambahkan karyawan dan manajer ke divisi Engineering
        engineering.addEmployee(employee1);
        engineering.addEmployee(manager1);

        // Memastikan karyawan dan manajer telah ditambahkan ke divisi Engineering
        assertTrue(engineering.getEmployeesList().contains(employee1));
        assertTrue(engineering.getEmployeesList().contains(manager1));
    }

    @Test
    public void testToString() {
        Engineering engineering = new Engineering(5000000);

        // Membuat beberapa karyawan dan manajer baru
        Employee employee1 = new Employee("Employee 1", 3, 0.2);
        Manager manager1 = new Manager("Manager 1", 5, 0.3);

        // Menambahkan karyawan dan manajer ke divisi Engineering
        engineering.addEmployee(employee1);
        engineering.addEmployee(manager1);

        // Menghitung jumlah karyawan dan manajer di divisi Engineering
        int managerCount = 0;
        for (Employee employee : engineering.getEmployeesList()) {
            if (employee instanceof Manager) {
                managerCount++;
            }
        }
        int employeeCount = engineering.getEmployeesList().size() - managerCount;

        // Memastikan hasil representasi string sesuai dengan perhitungan jumlah karyawan dan manajer
        String expectedString = "Divisi Engineering memiliki " + employeeCount + " karyawan dengan " + managerCount + " manager.";
        assertEquals(expectedString, engineering.toString());
    }
}
