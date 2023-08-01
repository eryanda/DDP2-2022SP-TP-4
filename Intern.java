/**
 * Kelas Intern merupakan subkelas dari kelas Employee yang merepresentasikan
 * seorang karyawan magang di perusahaan. Kelas ini mengatur pembuatan objek karyawan
 * magang serta pembatasan jumlah proyek yang dapat diikuti oleh seorang intern.
 */
public class Intern extends Employee {

    /**
     * Konstruktor untuk kelas Intern.
     *
     * @param name              Nama karyawan magang.
     * @param yearsOfExperience Jumlah tahun pengalaman karyawan magang.
     * @param salaryMultiplier  Faktor pengali gaji karyawan magang.
     */
    public Intern(String name, int yearsOfExperience, double salaryMultiplier) {
        super(name, yearsOfExperience, salaryMultiplier);
    }

    /**
     * Metode override untuk mengambil representasi string dari objek Intern.
     * Metode ini akan mengembalikan string yang berisi informasi mengenai objek Intern
     * serta memanggil metode toString dari kelas induk (Employee) untuk mendapatkan
     * informasi lainnya.
     *
     * @return Representasi string dari objek Intern.
     */
    @Override
    public String toString() {
        // TODO
        return super.toString() + " - Intern";
    }

    /**
     * Metode override untuk menambahkan proyek yang akan diikuti oleh seorang intern.
     * Metode ini akan membatasi jumlah proyek yang dapat diikuti oleh intern menjadi
     * maksimal satu proyek.
     *
     * @param project Objek Project yang akan diikuti oleh intern.
     */
    @Override
    public void addProject(Project project) {
        if (getProjects().size() > 1) {
            System.out.println("Intern " + getName() + " hanya dapat mengikuti satu proyek.");
            return;
        }
        super.addProject(project);
    }
}
