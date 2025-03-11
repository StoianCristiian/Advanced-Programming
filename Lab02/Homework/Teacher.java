public class Teacher extends Person
{   
    private final Projects[] projects;
    private int projectCnt;

    public Teacher(String name, String date_of_birth, int MaxProjects)
    {
        super(name,date_of_birth);
        this.projects = new Projects[MaxProjects];
        this.projectCnt = 0;
    }

    public void addProject(Projects project)
    {
        if(projectCnt < projects.length)
        {
            projects[projectCnt++] = project;
        }
    }

    //getters
    public Projects[] getPorjects() { return this.projects; }
    public int getProjectCnt() { return this.projectCnt; }

    @Override
    public boolean equals(Object object)
    {
        return super.equals(object);
    }
}