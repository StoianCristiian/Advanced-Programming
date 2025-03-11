
public class EX1 {
    public static void main(String[] args){
        Project P1 = new Project("proiect1", enums.ProjectType.PRACTICAL);
        Project P2 = new Project("proiect2", enums.ProjectType.THEORETICAL);
        Project P3 = new Project("proiect3", enums.ProjectType.PRACTICAL);
        Project P4 = new Project("proiect4", enums.ProjectType.THEORETICAL);

        Student S1 = new Student("Andrei");
        S1.setProject(P4);
        S1.setProject(P2);
        Student S2 = new Student("Luiza");
        S2.setProject(P3);
        System.out.println(S1);
        System.out.println(S2);
    }
}