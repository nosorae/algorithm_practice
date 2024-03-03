package godofjava.a;

// GodOfJava Vol1. 8장
// GodOfJava Vol1. 12장
public class Student {
    String name;
    String address;
    String phone;
    String email;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " " + address + " " + phone + " " + email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Student other = (Student) obj;

        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) {
            return false;
        }

        if (address == null) {
            if (other.address != null) return false;
        } else if (!address.equals(other.address)) {
            return false;
        }

        if (phone == null) {
            if (other.phone != null) return false;
        } else if (!phone.equals(other.phone)) {
            return false;
        }

        if (email == null) {
            if (other.email != null) return false;
        } else if (!email.equals(other.email)) {
            return false;
        }

        return true;
    }
}

class ManageStudent {
    public static void main(String[] args) {
        ManageStudent manageStudent = new ManageStudent();

//        Student[] students = null;
//        students = manageStudent.addStudent();
//
//        manageStudent.printStudents(students);

        manageStudent.checkEquals();
    }

    public Student[] addStudent() {
        Student[] students = new Student[3];
        students[0] = new Student("Lim");
        students[1] = new Student("Min");
        students[2] = new Student("Sook", "Seoul", "010XXXXXXXX", "ask@godofjava.com");
        return students;
    }

    public void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void checkEquals() {
        Student a = new Student("Min", "Seoul", "010XXXXXXXX", "ask@godofjava.com");
        Student b = new Student("Min", "Seoul", "010XXXXXXXX", "ask@godofjava.com");
        if (a.equals(b)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
