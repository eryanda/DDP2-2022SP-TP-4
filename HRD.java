/**
 * Kelas HRD merupakan subkelas dari kelas Division yang merepresentasikan
 * sebuah divisi di perusahaan yang bertanggung jawab atas sumber daya manusia (SDM).
 * Kelas ini mengatur penambahan karyawan ke divisi HRD dan menghitung jumlah karyawan
 * dan manajer di divisi tersebut.
 */
public class HRD extends Division {

    /**
     * Konstruktor untuk kelas HRD.
     *
     * @param baseSalary Gaji pokok untuk karyawan di divisi HRD.
     */
    public HRD(int baseSalary) {
        super(baseSalary);
    }

    /**
     * Metode override untuk menambahkan karyawan ke divisi HRD. Metode ini akan
     * memanggil metode addEmployee dari kelas induk (Division) untuk menambahkan karyawan,
     * dan selanjutnya akan mencetak pesan ke layar mengenai tipe karyawan yang berhasil ditambahkan.
     *
     * @param employee Objek Employee yang akan ditambahkan ke divisi HRD.
     */
    @Override
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        String employeeType = employee instanceof Manager ? "Manager" : "Karyawan";
        System.out.println(employeeType + " " + employee.getName() + " berhasil ditambahkan ke divisi HRD");
    }

    /**
     * Metode override untuk mengambil representasi string dari objek HRD.
     * Metode ini akan menghitung jumlah karyawan dan manajer di divisi HRD dan
     * mengembalikan string yang berisi informasi tersebut.
     *
     * @return Representasi string dari objek HRD.
     */
    @Override
    public String toString() {
        int managerCount = 0;
        for (Employee employee : employeeList) {
            if (employee instanceof Manager) {
                managerCount++;
            }
        }
        int employeeCount = employeeList.size() - managerCount;
        return "Divisi HRD memiliki " + employeeCount + " karyawan dengan " + managerCount + " manager.";
    }
}
