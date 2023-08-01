/**
 * Kelas Design merupakan subkelas dari kelas Division yang merepresentasikan sebuah divisi
 * dalam perusahaan dengan fokus pada desain.
 */
public class Design extends Division {

    /**
     * Konstruktor untuk membuat objek Design dengan baseSalary yang ditentukan.
     *
     * @param baseSalary Gaji dasar untuk karyawan dalam divisi Design.
     */
    public Design(int baseSalary) {
        super(baseSalary);
    }

    /**
     * Menambahkan seorang karyawan ke dalam divisi Design.
     * Setelah karyawan ditambahkan, akan dicetak pesan yang menunjukkan berhasilnya penambahan
     * berdasarkan jenis karyawan (Manager atau Karyawan) dan nama karyawan.
     *
     * @param employee Objek Employee yang akan ditambahkan ke divisi Design.
     */
    @Override
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        String employeeType = employee instanceof Manager ? "Manager" : "Karyawan";
        System.out.println(employeeType + " " + employee.getName() + " berhasil ditambahkan ke divisi Design");
    }

    /**
     * Menghasilkan representasi string dari informasi divisi Design.
     * String yang dihasilkan berisi jumlah karyawan dan manager dalam divisi Design.
     *
     * @return String yang berisi informasi jumlah karyawan dan manager dalam divisi Design.
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
        return "Divisi Design memiliki " + employeeCount + " karyawan dengan " + managerCount + " manager.";
    }
}
