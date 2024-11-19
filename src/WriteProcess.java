import java.util.Scanner;
public class WriteProcess {
    public static void writing(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String[] fio = new String[3];
        int[] bday = new int[3];
        while (true) {
            try {
                System.out.println("Введите ФИО: ");
                String fio_in = sc1.nextLine().trim();
                if (fio_in.isEmpty()) {
                    throw new IllegalArgumentException("ФИО не может быть пустым.");
                }
                fio = fio_in.split(" ");
                if (fio.length != 3) {
                    throw new IllegalArgumentException("ФИО введено некорректно.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
                return;
            }
        }
        while (true){
            try {
                System.out.println("Введите дату рождения в формате день.месяц.год: ");
                String bd = sc2.nextLine().trim();
                if (bd.isEmpty()) {
                    throw new IllegalArgumentException("Дата рождения не может быть пустой.");
                }
                String[] b = bd.split("\\.");
                if (b.length != 3) {
                    throw new IllegalArgumentException("Дата рождения должна быть в формате день.месяц.год.");
                }
                int day = Integer.parseInt(b[0]);
                int month = Integer.parseInt(b[1]);
                int year = Integer.parseInt(b[2]);
                int currentYear = java.time.LocalDate.now().getYear();
                int currentMonth = java.time.LocalDate.now().getMonthValue();
                int currentDay = java.time.LocalDate.now().getDayOfMonth();
                bday[0]=day;
                bday[1]=month;
                bday[2]=year;
                if (day < 1 || day > 31) {
                    throw new IllegalArgumentException("Некорректный день.");
                }
                if (month < 1 || month > 12) {
                    throw new IllegalArgumentException("Некорректный месяц.");
                }
                if (year > currentYear) {
                    throw new IllegalArgumentException("Некорректный год.");
                }
                if ((year == currentYear && month > currentMonth) || (year == currentYear && month == currentMonth && day > currentDay)) {
                    throw new IllegalArgumentException("Некорректная дата.");
                }
                break;

            } catch (IllegalArgumentException e){
                System.out.println("Ошибка: " + e.getMessage());
                return;
            }
        }
        try {
            Strings ans1 = new Strings();
            System.out.println("Инициалы: " + ans1.getInitials(fio));
            Strings ans2 = new Strings();
            System.out.println("Пол: " + ans2.getGender(fio[2]));
            Strings ans3 = new Strings();
            System.out.println("Возраст: " + ans3.getAge(bday));
        }  catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}
