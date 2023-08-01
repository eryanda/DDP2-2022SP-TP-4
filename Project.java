import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Kelas Project merepresentasikan sebuah proyek dalam sistem SimProyek.
 * Setiap proyek memiliki nama, seorang manajer yang menjadi leader proyek, dan daftar karyawan sebagai anggota proyek.
 */
public class Project {
    // TODO: Tambahkan modifier untuk atribut
    private String name;
    Manager projectLeader;
    List<Employee> memberList;

    /**
     * Konstruktor untuk membuat objek Project dengan nama proyek yang ditentukan.
     *
     * @param name Nama proyek yang akan dibuat.
     */
    public Project(String name) {
        this.name = name;
        this.memberList = new ArrayList<>();
    }

    /**
     * Mengatur nama proyek.
     *
     * @param name Nama proyek yang akan diatur.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mendapatkan nama proyek.
     *
     * @return Nama proyek.
     */
    public String getName() {
        return name;
    }

    /**
     * Mengatur manajer sebagai leader proyek.
     *
     * @param projectLeader Objek Manager yang akan diatur sebagai leader proyek.
     */
    public void setProjectLeader(Manager projectLeader) {
        this.projectLeader = projectLeader;
    }

    /**
     * Mendapatkan manajer yang menjadi leader proyek.
     *
     * @return Objek Manager yang menjadi leader proyek.
     */
    public Manager getProjectLeader() {
        return projectLeader;
    }

    /**
     * Mendapatkan daftar karyawan yang merupakan anggota proyek.
     *
     * @return Daftar karyawan yang merupakan anggota proyek.
     */
    public List<Employee> getMemberList() {
        return memberList;
    }

    /**
     * Menambahkan karyawan ke dalam proyek sebagai anggota.
     * Jika karyawan merupakan manajer dan belum menjadi leader proyek, maka karyawan tersebut akan diatur sebagai leader proyek.
     * Jika karyawan merupakan anggota biasa, maka karyawan tersebut akan ditambahkan ke daftar anggota proyek.
     *
     * @param employee Objek Employee yang akan ditambahkan ke proyek sebagai anggota.
     */
    public void addMember(Employee employee) {
        if (employee instanceof Manager && ((Manager) employee).getProjects() == null) {
            /** Mengassign manajer menjadi project leader jika belum memiliki proyek */
            projectLeader = (Manager) employee;
        } else {
            /** Menambahkan anggota biasa ke dalam member list */
            memberList.add(employee);
        }
    }

    /**
     * Menghapus karyawan dari proyek sebagai anggota.
     * Jika karyawan merupakan leader proyek, maka leader proyek akan dihapus.
     * Jika karyawan merupakan anggota biasa, maka karyawan akan dihapus dari daftar anggota proyek.
     *
     * @param employee Objek Employee yang akan dihapus dari proyek sebagai anggota.
     */
    public void removeMember(Employee employee) {
        /** Mengecek apakah karyawan adalah leader proyek */
        if (employee.equals(projectLeader)) {
            /** Jika iya, menghapus leader proyek */
            projectLeader = null;
        } else {
            /** Menghapus anggota biasa dari member list */
            memberList.remove(employee);
        }
    }

    /**
     * Membandingkan dua objek Project untuk menentukan apakah mereka sama.
     * Dua objek Project dianggap sama jika memiliki nama, projectLeader, dan memberList yang sama.
     *
     * @param o Objek lain yang akan dibandingkan.
     * @return true jika objek Project sama dengan objek lain, false jika tidak.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) &&
                Objects.equals(projectLeader, project.projectLeader) &&
                Objects.equals(memberList, project.memberList);
    }

    /**
     * Menghasilkan nilai hash code untuk objek Project.
     *
     * @return Nilai hash code dari objek Project.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, projectLeader, memberList);
    }
}
