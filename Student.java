import java.util.ArrayList;

public class Student{
        private String name;
        private final ArrayList<Project> projects;

        // constructorul initializeaza arrayList ul si seteaza numele
        public Student(String name){
            this.projects = new ArrayList<Project>();
            this.name = name;
        }

        public String getName()
        {
            return name;
        }
        public void setName(String newName)
        {
            this.name = newName;
        }

        public ArrayList getProjects()
        {
            return projects;
        }
        // adaugam proiecte noi studentilor
        public void setProject(Project newProject)
        {
            this.projects.add(newProject);
        }

        // Facem override la functia toString ca sa afisam date despre studenti
        @Override
        public String toString()
        {
            return "Student: " + name + " have the projects " + projects + " ";
        }
    }