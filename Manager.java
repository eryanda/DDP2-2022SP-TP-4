/**
 * Kelas Manager merupakan subkelas dari Employee yang merepresentasikan seorang manajer dalam perusahaan.
 * Manajer memiliki nama, tahun pengalaman, faktor pengali gaji, divisi tempat bekerja, dan daftar proyek yang diikuti.
 * Seorang manajer memiliki batasan maksimal hanya dapat mengikuti tiga proyek.
 */
public class Manager extends Employee {

    /**
     * Konstruktor untuk membuat objek Manager dengan parameter yang ditentukan.
     *
     * @param name              Nama manajer.
     * @param yearsOfExperience Tahun pengalaman manajer.
     * @param salaryMultiplier  Faktor pengali gaji manajer.
     */
    public Manager(String name, int yearsOfExperience, double salaryMultiplier) {
        super(name, yearsOfExperience, salaryMultiplier);
    }

    /**
     * Mengembalikan representasi string dari objek Manager, termasuk nama, gaji, dan daftar proyek yang diikuti,
     * serta informasi tambahan "Manager" yang menunjukkan bahwa objek ini merupakan seorang manajer.
     *
     * @return String berisi nama, gaji, daftar proyek, dan informasi "Manager".
     */
    @Override
    public String toString() {
        return super.toString() + " - Manager";
    }

    /**
     * Menambahkan proyek ke daftar proyek yang diikuti oleh manajer.
     * Seorang manajer hanya dapat mengikuti maksimal tiga proyek.
     *
     * @param project Objek Project yang akan ditambahkan ke daftar proyek manajer.
     */
    @Override
    public void addProject(Project project) {
        if (getProjects().size() > 3) {
            System.out.println("Manager " + getName() + " hanya dapat mengikuti tiga proyek.");
            return;
        }
        super.addProject(project);
    }
}
