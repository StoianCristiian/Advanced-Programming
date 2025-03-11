public class Project{
        private String title;
        private enums.ProjectType type;

        public Project(String title, enums.ProjectType type){
            this.title = title;
            this.type = type;
        }

        // setters
        public void setTitle(String newTitle)
        {
            this.title = newTitle;
        }
        public void setType(enums.ProjectType newType)
        {
            this.type = newType;
        }

        // getters
        public String getTitle()
        {
            return title;
        }
        public enums.ProjectType getType()
        {
            return type;
        }
        
        // override la toString() ca sa afisez datele despre proiect
        @Override
        public String toString() {
            return "{" + "title='" + title + '\'' + ", type=" + type + '}';
        }
    }