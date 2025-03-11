public class Projects
{
    private final String title;
    private final enums.ProjectType type;

    public Projects(String title, enums.ProjectType type)
    {
        this.title = title;
        this.type = type;
    }
    
    //getters
    public String getTitle() { return this.title; }
    public enums.ProjectType getType() { return this.type; }

    @Override
    public boolean equals(Object object)
    {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Projects project = (Projects) object;
        return title.equals(project.title) && type == project.type; 
    }
}