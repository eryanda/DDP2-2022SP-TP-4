import java.util.ArrayList;
import java.util.List;

/**
 * Kelas Employee merepresentasikan seorang karyawan dalam perusahaan.
 * Karyawan memiliki nama, tahun pengalaman, faktor pengali gaji, divisi tempat bekerja, dan daftar proyek yang diikuti.
 */
public class Employee {
    String name;
    int yearsOfExperience;
    double salaryMultiplier;
    Division division;
    List<Project> projects;

    /**
     * Konstruktor untuk membuat objek Employee dengan parameter yang ditentukan.
     *
     * @param name              Nama karyawan.
     * @param yearsOfExperience Tahun pengalaman karyawan.
     * @param salaryMultiplier  Faktor pengali gaji karyawan.
     */
    public Employee(String name, int yearsOfExperience, double salaryMultiplier) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.salaryMultiplier = salaryMultiplier;
        this.division = null;
        projects = new ArrayList<>();
    }

    /**
     * Menghitung gaji karyawan berdasarkan faktor pengali, tahun pengalaman, dan gaji dasar dari divisi tempat karyawan bekerja.
     *
     * @return Gaji karyawan yang dihitung.
     */
    public int calculateSalary() {
        if (division != null) {
            int divisionBaseSalary = division.getBaseSalary();
            return (int) (divisionBaseSalary * (1 + salaryMultiplier + yearsOfExperience / 10));
        } else {
            return 0;
        }
    }

    /**
     * Mendapatkan nama divisi tempat karyawan bekerja.
     *
     * @return Nama divisi tempat karyawan bekerja, atau "Tidak ada" jika karyawan tidak tergabung dalam divisi manapun.
     */
    public String getDivisionName() {
        if (division != null) {
            return division.getClass().getSimpleName();
        } else {
            return "Tidak ada";
        }
    }

    /**
     * Mengembalikan representasi string dari daftar proyek yang diikuti oleh karyawan.
     *
     * @return String berisi nama-nama proyek yang diikuti oleh karyawan, dipisahkan oleh tanda koma,
     *         atau "Belum ada proyek" jika karyawan belum mengikuti proyek apapun.
     */
    public String getProjectsString() {
        if (projects == null || projects.isEmpty()) {
            return "Belum ada proyek";
        } else {
            StringBuilder projectsString = new StringBuilder();
            for (Project project : projects) {
                projectsString.append(project.getName()).append(", ");
            }
            return projectsString.substring(0, projectsString.length() - 2);
        }
    }

    /**
     * Mendapatkan nama karyawan.
     *
     * @return Nama karyawan.
     */
    public String getName() {
        return name;
    }

    /**
     * Mengatur divisi tempat karyawan bekerja.
     *
     * @param division Objek Division yang akan diatur sebagai divisi karyawan.
     */
    public void setDivision(Division division) {
        this.division = division;
    }

    /**
     * Mendapatkan daftar proyek yang diikuti oleh karyawan.
     *
     * @return List dari objek Project yang merupakan daftar proyek yang diikuti oleh karyawan.
     */
    public List<Project> getProjects() {
        return projects;
    }

    /**
     * Menambahkan proyek ke daftar proyek yang diikuti oleh karyawan.
     * Karyawan hanya dapat mengikuti maksimal dua proyek.
     *
     * @param project Objek Project yang akan ditambahkan ke daftar proyek karyawan.
     */
    public void addProject(Project project) {
        if (projects.size() >= 2) {
            System.out.println("Karyawan " + name + " hanya dapat mengikuti dua proyek.");
            return;
        }
        projects.add(project);
    }

    /**
     * Menghapus proyek dari daftar proyek yang diikuti oleh karyawan.
     *
     * @param project Objek Project yang akan dihapus dari daftar proyek karyawan.
     */
    public void removeProject(Project project) {
        projects.remove(project);
    }

    /**
     * Mengembalikan representasi string dari karyawan, termasuk nama, gaji, dan daftar proyek yang diikuti.
     *
     * @return String berisi nama, gaji, dan daftar proyek karyawan.
     */
    @Override
    public String toString() {
        return name + " - " + calculateSalary() + " - " + getProjectsString();
    }
}
