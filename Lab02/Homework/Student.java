public class Student extends Person 
{
    private final String registration_number;

    public Student(String name, String date_of_birth, String registration_number) 
    {
        super(name, date_of_birth);
        this.registration_number = registration_number;
    }
    
    //getter
    public String getRegistrationNumber() { return this.registration_number; }

    @Override
    public boolean equals(Object object)
    {
        if(!super.equals(object)) return false;
        Student student = (Student) object;
        return registration_number.equals(student.registration_number);
    }
}