import java.util.Scanner;

class Staff {
    String staffId;
    String name;
    String phone;
    double salary;

    public Staff(String staffId, String name, String phone, double salary) {
        this.staffId = staffId;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }

    public void display() {
        System.out.println("StaffId: " + staffId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Salary: $" + salary);
    }
}

class Teaching extends Staff {
    String domain;
    String publications;

    public Teaching(String staffId, String name, String phone, double salary, String domain, String publications) {
        super(staffId, name, phone, salary);
        this.domain = domain;
        this.publications = publications;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Domain: " + domain);
        System.out.println("Publications: " + publications);
    }
}

class Technical extends Staff {
    String skills;

    public Technical(String staffId, String name, String phone, double salary, String skills) {
        super(staffId, name, phone, salary);
        this.skills = skills;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Skills: " + skills);
    }
}

class Contract extends Staff {
    int period;

    public Contract(String staffId, String name, String phone, double salary, int period) {
        super(staffId, name, phone, salary);
        this.period = period;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Contract Period: " + period + " months");
    }
}

class StaffTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Teaching Staff objects
        Teaching[] teachingStaff = new Teaching[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for Teaching Staff " + (i + 1));
            System.out.print("Enter StaffId: ");
            String staffId = scanner.next();
            System.out.print("Enter Name: ");
            String name = scanner.next();
            System.out.print("Enter Phone: ");
            String phone = scanner.next();
            System.out.print("Enter Salary: $");
            double salary = scanner.nextDouble();
            System.out.print("Enter Domain: ");
            String domain = scanner.next();
            System.out.print("Enter Publications: ");
            String publications = scanner.next();

            teachingStaff[i] = new Teaching(staffId, name, phone, salary, domain, publications);
        }

        // Create Technical Staff objects
        Technical[] technicalStaff = new Technical[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for Technical Staff " + (i + 1));
            System.out.print("Enter StaffId: ");
            String staffId = scanner.next();
            System.out.print("Enter Name: ");
            String name = scanner.next();
            System.out.print("Enter Phone: ");
            String phone = scanner.next();
            System.out.print("Enter Salary: $");
            double salary = scanner.nextDouble();
            System.out.print("Enter Skills: ");
            String skills = scanner.next();

            technicalStaff[i] = new Technical(staffId, name, phone, salary, skills);
        }

        // Create Contract Staff objects
        Contract[] contractStaff = new Contract[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for Contract Staff " + (i + 1));
            System.out.print("Enter StaffId: ");
            String staffId = scanner.next();
            System.out.print("Enter Name: ");
            String name = scanner.next();
            System.out.print("Enter Phone: ");
            String phone = scanner.next();
            System.out.print("Enter Salary: $");
            double salary = scanner.nextDouble();
            System.out.print("Enter Contract Period (months): ");
            int period = scanner.nextInt();

            contractStaff[i] = new Contract(staffId, name, phone, salary, period);
        }

        // Display details for each category
        System.out.println("\nDetails of Teaching Staff:");
        for (Teaching staff : teachingStaff) {
            staff.display();
            System.out.println();
        }

        System.out.println("\nDetails of Technical Staff:");
        for (Technical staff : technicalStaff) {
            staff.display();
            System.out.println();
        }

        System.out.println("\nDetails of Contract Staff:");
        for (Contract staff : contractStaff) {
            staff.display();
            System.out.println();
        }

        scanner.close();
    }
}


