/**
 * Kelas Engineering merupakan subkelas dari kelas Division yang merepresentasikan
 * sebuah divisi di perusahaan yang berfokus pada bidang teknik dan rekayasa.
 * Kelas ini mengatur penambahan karyawan ke divisi Engineering dan menghitung jumlah karyawan
 * dan manajer di divisi tersebut.
 */
public class Engineering extends Division {

    /**
     * Konstruktor untuk kelas Engineering.
     *
     * @param baseSalary Gaji pokok untuk karyawan di divisi Engineering.
     */
    public Engineering(int baseSalary) {
        super(baseSalary);
    }

    /**
     * Metode override untuk menambahkan karyawan ke divisi Engineering. Metode ini akan
     * memanggil metode addEmployee dari kelas induk (Division) untuk menambahkan karyawan,
     * dan selanjutnya akan mencetak pesan ke layar mengenai tipe karyawan yang berhasil ditambahkan.
     *
     * @param employee Objek Employee yang akan ditambahkan ke divisi Engineering.
     */
    @Override
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        String employeeType = employee instanceof Manager ? "Manager" : "Karyawan";
        System.out.println(employeeType + " " + employee.getName() + " berhasil ditambahkan ke divisi Engineering");
    }

    /**
     * Metode override untuk mengambil representasi string dari objek Engineering.
     * Metode ini akan menghitung jumlah karyawan dan manajer di divisi Engineering dan
     * mengembalikan string yang berisi informasi tersebut.
     *
     * @return Representasi string dari objek Engineering.
     */
    @Override
    public String toString() {
        int managerCount = 0;
        for (Employee employee : getEmployeesList()) {
            if (employee instanceof Manager) {
                managerCount++;
            }
        }
        int employeeCount = employeeList.size() - managerCount;
        return "Divisi Engineering memiliki " + employeeCount + " karyawan dengan " + managerCount + " manager.";
    }
}
