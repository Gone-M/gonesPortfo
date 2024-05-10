import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static ArrayList<Project> projects = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        populateProjects(); // Adding some sample projects

        System.out.println("Welcome to Civan's Portfolio!");
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View Projects");
            System.out.println("2. Search Projects");
            System.out.println("3. Add New Project");
            System.out.println("4. Contact Me");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewProjects();
                    break;
                case 2:
                    searchProjects();
                    break;
                case 3:
                    addProject();
                    break;
                case 4:
                    contactMe();
                    break;
                case 5:
                    System.out.println("Thank you for visiting my portfolio. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void populateProjects() {
        projects.add(new Project("Java Calculator", "A simple calculator implemented in Java."));
        projects.add(new Project("Student Management System", "A system to manage student records and grades."));
        projects.add(new Project("Library Management System", "A software to manage library operations such as book borrowing and returning."));
    }

    public static void viewProjects() {
        System.out.println("\nProjects:");
        for (int i = 0; i < projects.size(); i++) {
            System.out.println((i + 1) + ". " + projects.get(i).getName());
        }
        System.out.println("0. Go Back");
        int choice = scanner.nextInt();
        if (choice == 0) return;
        Project project = projects.get(choice - 1);
        System.out.println("Project Name: " + project.getName());
        System.out.println("Description: " + project.getDescription());
    }

    public static void searchProjects() {
        scanner.nextLine(); // Consume newline character
        System.out.print("\nEnter search keyword: ");
        String keyword = scanner.nextLine().toLowerCase();
        System.out.println("\nSearch Results:");
        for (Project project : projects) {
            if (project.getName().toLowerCase().contains(keyword) || project.getDescription().toLowerCase().contains(keyword)) {
                System.out.println("Project Name: " + project.getName());
                System.out.println("Description: " + project.getDescription() + "\n");
            }
        }
    }

    public static void addProject() {
        scanner.nextLine(); // Consume newline character
        System.out.print("\nEnter project name: ");
        String name = scanner.nextLine();
        System.out.print("Enter project description: ");
        String description = scanner.nextLine();
        projects.add(new Project(name, description));
        System.out.println("Project added successfully!");
    }

    public static void contactMe() {
        System.out.println("\nContact Information:");
        System.out.println("Name: Civan Metin");
        System.out.println("Email: metcivan@gmail.com");
        System.out.println("Phone: +16479960773");
    }
}

class Project {
    private String name;
    private String description;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
