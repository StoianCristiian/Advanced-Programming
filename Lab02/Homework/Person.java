public class Person
{
    private String name;
    private String date_of_birth;

    public Person(String name, String date_of_birth)
    {
        this.name = name;
        this.date_of_birth = date_of_birth;
    }

    //getters
    public String getName() { return this.name; }
    public String getDateOfBirth() { return this.date_of_birth; }

    @Override
    public boolean equals(Object object)
    {
        if(this == object) return true;
        if(object == null || getClass() !=object.getClass()) return false;
        Person person = (Person) object;
        return name.equals(person.name) && date_of_birth.equals(person.date_of_birth);
    }
}