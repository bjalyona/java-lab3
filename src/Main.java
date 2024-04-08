import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите фамилию, имя и отчество. Пример: Иванов Иван Иванович");
        String sname = scan.nextLine();
        if (!sname.matches("[а-яА-Я-ё\\s]+")){
            System.out.println("ФИО введено некорректно.");
            System.exit(0);
        }
        String[] name = (sname.split(" "));
        if (name.length != 3){
            System.out.println("ФИО введено некорректно.");
            System.exit(0);
        }
        System.out.println("Введите дату рождения в формате ДД:ММ:ГГГГ");
        String dates = scan.nextLine();
        if(!dates.matches("^\\d{2}:\\d{2}:\\d{4}$")) {
            System.out.println("Дата рождения введена некорректно, введите дату в указанном формате.");
            System.exit(0);
        }
        DateFormat df = new SimpleDateFormat("dd:MM:yyyy");
        try {
            Date date = df.parse(dates);
            Person p = new Person(name, date);
            p.printInfo();
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}