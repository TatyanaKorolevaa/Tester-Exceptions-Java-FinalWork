import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DataRequest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String yearOfBirth;
    private long numberPhone;
    private char gender;
    private final Scanner scan = new Scanner(System.in);

    // Методы для присваивания значений полям
   
    private void EnterLastName() {
        System.out.println("Введите фамилию:");
        lastName = scan.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterFirstName() {
        System.out.println("Введите имя:");
        firstName = scan.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterMiddleName() {
        System.out.println("Введите отчество:");
        middleName = scan.nextLine();
        if (middleName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterYearOfBirth() {
        System.out.println("Введите дату рождения:");
        yearOfBirth = scan.nextLine();
        if (yearOfBirth.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterNumberPhone() {
        try {
            System.out.println("Введите номер телефона:");
            String number = scan.nextLine();
            if (number.equals("")) {
                throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
            }
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Не верный формат, попробуйте снова!");
        }
    }

    private void EnterGender() {
        System.out.println("Введите пол (f, m):");
        String gen;
        String f = "f";
        String m = "m";
        gen = scan.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("Вы ввели слишком много символов \noпопробуйте снова!");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("Вы ввели не тот символ!");
        }
    }

    // Метод для вывода в консоль получившихля значений
    private void OutPutData() {
        System.out.println("\nФамилия \t- \t" + lastName + "\n" + "Имя \t- \t" + firstName + "\n" + "Отчество \t- \t" + middleName + "\n" + "Дата рождения \t- \t" + yearOfBirth + "\n" + "Номер телефона \t- \t" + numberPhone + "\n" + "Пол   \t- \t" + gender);
    }

    // Метод для соединения всех методов в один
    private void DataEnter() {
        EnterLastName();
        EnterFirstName();
        EnterMiddleName();
        EnterYearOfBirth();
        EnterNumberPhone();
        EnterGender();
        OutPutData();
    }

    // Метод для сохранения данных в файл
    public void SaveDataEnter() {

        DataEnter();
        File file = new File(lastName + ".txt") ;
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("<" + lastName + "> " + "<" + firstName + "> " + "<" + middleName + "> " + "<" + yearOfBirth + "> " + "<" + numberPhone + "> " + "<" + gender + ">\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так!");
        }
    }

    // Геттеры для полей

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public char getGender() {
        return gender;
    }
}