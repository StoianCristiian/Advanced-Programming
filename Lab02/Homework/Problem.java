public class Problem
{
    private final Student[] students;
    private final Teacher[] teachers;
    private int studentCnt, teacherCnt;

    public Problem(int maxStudents, int maxTeachers) 
    {
        students = new Student[maxStudents];
        teachers = new Teacher[maxTeachers];
        studentCnt = teacherCnt = 0;
    }

    public void addStudent(Student student) 
    {
        for (int i = 0; i < studentCnt; i++) 
        {
            if (students[i].equals(student)) return; //verificam mai intai daca exista deja acest student
        }
        students[studentCnt++] = student;
    }

    public void addTeacher(Teacher teacher) 
    {
        for (int i = 0; i < teacherCnt; i++) 
        {
            if (teachers[i].equals(teacher)) return; //verificam mai intai daca exista deja acest prof
        }
        teachers[teacherCnt++] = teacher;
    }

    // implementarea greedy pentru a aloca proiecte
    public void allocateProjects() 
    {
        for (int i = 0; i < studentCnt; i++) 
        {
            System.out.print("Student " + students[i].getName() + " assigned to projects: ");
            Projects[] proiecte = teachers[i].getPorjects();
            int projectsCnt = teachers[i].getProjectCnt();
            for(int j=0 ; j<projectsCnt ; j++)
            {
                System.out.print(proiecte[j].getTitle() + " ");
            }
            System.out.println("\n");
        }
    }


    // metoda de returnare a tuturor persoanelor
    public Person[] getAllPersons() 
    {
        int index = 0;
        Person[] persons = new Person[studentCnt + teacherCnt];

        for (int i = 0; i < studentCnt; i++) 
        {
            persons[index++] = students[i];
        }

        for (int i = 0; i < teacherCnt; i++) 
        {
            persons[index++] = teachers[i];
        }

        return persons;
    }

    public static void main(String[] args) 
    {
        // Cream profesori
        Teacher teacher1 = new Teacher("Prof. Alex", "1975-06-12", 2);
        Teacher teacher2 = new Teacher("Prof. Adrian", "1980-02-20", 3);

        // Cream studenti
        Student student1 = new Student("Andrei", "2002-05-10", "12345");
        Student student2 = new Student("Maria", "2001-11-15", "67890");

        // Cream proiecte
        Projects p1 = new Projects("Machine Learning", enums.ProjectType.THEORETICAL);
        Projects p2 = new Projects("Robotics", enums.ProjectType.PRACTICAL);
        Projects p3 = new Projects("Cyber Security", enums.ProjectType.THEORETICAL);
        Projects p4 = new Projects("Advanced Programming", enums.ProjectType.THEORETICAL);
        Projects p5 = new Projects("Software Engineering", enums.ProjectType.THEORETICAL);
        teacher1.addProject(p1);
        teacher1.addProject(p2);
        teacher2.addProject(p3);
        teacher2.addProject(p4);
        teacher2.addProject(p5);

        Problem problem = new Problem(2,2);
        problem.addStudent(student2);
        problem.addTeacher(teacher1);
        problem.addTeacher(teacher2);
        problem.addStudent(student1);

        problem.allocateProjects();

        Person[] allPersons = problem.getAllPersons();
        for (Person person : allPersons) {
            System.out.println(person.getName());
        }
    }
}