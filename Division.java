import java.util.ArrayList;
import java.util.List;

/**
 * Kelas Division merupakan kelas yang merepresentasikan sebuah divisi dalam perusahaan.
 * Divisi ini memiliki daftar karyawan yang dapat ditambahkan, diubah, atau diakses.
 */
public class Division {
    // TODO: Tambahkan modifier untuk atribut
    int baseSalary;
    List<Employee> employeeList;

    /**
     * Konstruktor untuk membuat objek Division dengan baseSalary yang ditentukan.
     * Daftar karyawan awal diinisialisasi sebagai ArrayList kosong.
     *
     * @param baseSalary Gaji dasar untuk karyawan dalam divisi.
     */
    // TODO: Lengkapi constructor
    public Division(int baseSalary) {
        this.baseSalary = baseSalary;
        this.employeeList = new ArrayList<>();
    }

    /**
     * Mengatur gaji dasar untuk karyawan dalam divisi.
     *
     * @param baseSalary Gaji dasar yang akan diatur.
     */
    public void setBaseSalary(int baseSalary){
        this.baseSalary = baseSalary;
    }

    /**
     * Mendapatkan gaji dasar untuk karyawan dalam divisi.
     *
     * @return Gaji dasar karyawan dalam divisi.
     */
    public int getBaseSalary(){
        return baseSalary;
    }

    /**
     * Menambahkan seorang karyawan ke dalam divisi.
     * Jika karyawan adalah seorang manajer, maka akan diletakkan di posisi paling depan
     * dalam daftar karyawan.
     *
     * @param employee Objek Employee yang akan ditambahkan ke divisi.
     */
    // TODO: Lengkapi logika untuk menambahkan karyawan
    public void addEmployee(Employee employee) {
        if (employee instanceof Manager) {
            // Jika employee manajer, maka diletakkan di list paling depan
            employeeList.add(0, employee);
        } else {
            employeeList.add(employee);
        }
    }

    /**
     * Mendapatkan daftar karyawan dalam divisi.
     *
     * @return List dari objek Employee yang merupakan daftar karyawan dalam divisi.
     */
    public List<Employee> getEmployeesList() {
        return employeeList;
    }

    // Tambahkan getter & setter lainnya sesuai kebutuhan
}
