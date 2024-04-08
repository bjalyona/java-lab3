import java.util.Date;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private Date birthdate;
    Person(String[] fio, Date date){
        surname = fio[0];
        name = fio[1];
        patronymic = fio[2];
        birthdate = date;
    }
    public String getSurname(){
        return surname;
    }
    public String getName(){
        return name;
    }
    public String getPatronymic(){
        return patronymic;
    }
    public Date getBirthDate(){
        return birthdate;
    }
    public int getAge(){
        Date curr = new Date();
        int age = curr.getYear() - birthdate.getYear();
        if (birthdate.getMonth() > curr.getMonth()){
            age--;
        }
        else if (birthdate.getMonth() == curr.getMonth()) {
            if (birthdate.getDay() > curr.getDay()) {
                age--;
            }
        }
        return age;
    }
    public String getInitials(){
        char nameinit = name.charAt(0);
        char patrinit = patronymic.charAt(0);
        return surname + " " + nameinit + "." + patrinit + ".";
    }
    public String getGender(){
        String gender;
        if (patronymic.matches(".*ич$")){
            gender = "мужской";
        }
        else{
            gender = "женский";
        }
        return gender;
    }
    public void printInfo(){
        System.out.println("Имя: " + getInitials());
        System.out.println("Пол: " + getGender());
        System.out.println("Возраст: " + getAge());
    }
}