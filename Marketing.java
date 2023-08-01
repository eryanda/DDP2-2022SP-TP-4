/**
 * Kelas Marketing merupakan subkelas dari kelas Division yang merepresentasikan
 * sebuah divisi di perusahaan yang khusus berfokus pada bidang pemasaran.
 * Kelas ini mengatur penambahan karyawan ke divisi Marketing dan menghitung jumlah
 * karyawan dan manajer di divisi tersebut.
 */
public class Marketing extends Division {

    /**
     * Konstruktor untuk kelas Marketing.
     *
     * @param baseSalary Gaji pokok untuk karyawan di divisi Marketing.
     */
    public Marketing(int baseSalary) {
        super(baseSalary);
    }

    /**
     * Metode override untuk menambahkan karyawan ke divisi Marketing. Metode ini akan
     * memanggil metode addEmployee dari kelas induk (Division) untuk menambahkan karyawan,
     * dan selanjutnya akan mencetak pesan ke layar mengenai tipe karyawan yang berhasil ditambahkan.
     *
     * @param employee Objek Employee yang akan ditambahkan ke divisi Marketing.
     */
    @Override
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);

        String employeeType = employee instanceof Manager ? "Manager" : "Karyawan";
        System.out.println(employeeType + " " + employee.getName() + " berhasil ditambahkan ke divisi Marketing");
    }

    /**
     * Metode override untuk mengambil representasi string dari objek Marketing.
     * Metode ini akan menghitung jumlah karyawan dan manajer di divisi Marketing dan
     * mengembalikan string yang berisi informasi tersebut.
     *
     * @return Representasi string dari objek Marketing.
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
        return "Divisi Marketing memiliki " + employeeCount + " karyawan dengan " + managerCount + " manager.";
    }
}
