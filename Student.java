import java.util.Scanner;

class Student {
    String usn;
    String name;
    String programme;
    String phone;

    // Constructor to initialize Student object
    public Student(String usn, String name, String programme, String phone) {
        this.usn = usn;
        this.name = name;
        this.programme = programme;
        this.phone = phone;
    }

    // Display method to print Student details
    public void display() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Programme: " + programme);
        System.out.println("Phone: " + phone);
        System.out.println();
    }
}

class StudentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        // Create an array to store n Student objects
        Student[] students = new Student[n];

        // Input details for each student
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Enter USN: ");
            String usn = scanner.next();
            System.out.print("Enter Name: ");
            String name = scanner.next();
            System.out.print("Enter Programme: ");
            String programme = scanner.next();
            System.out.print("Enter Phone: ");
            String phone = scanner.next();

            // Create a new Student object and store it in the array
            students[i] = new Student(usn, name, programme, phone);
        }

        // Display details for each student
        System.out.println("\nDetails of Students:");
        for (Student student : students) {
            student.display();
        }

        scanner.close();
    }
}

