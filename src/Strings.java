import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Strings {
    public String getInitials(String[] fio){
        try{
            String ans = fio[0] + " " + fio[1].charAt(0) + "." + fio[2].charAt(0) + ".";
            return ans;
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка при формировании инициалов: " + e.getMessage());
        }
    }
    public String getGender(String m_name){
        try {
            int n = m_name.length();
            String gender;
            if (n>=6 && (m_name.substring(n - 4, n).equals("овна") || m_name.substring(n - 4, n).equals("евна") || m_name.substring(n - 4, n).equals("ична") || m_name.substring(n - 6, n).equals("инична"))) {
                gender = "Женский";
            }
            else if (n>=4 && (m_name.substring(n - 4, n).equals("ович") || m_name.substring(n - 4, n).equals("евич") || m_name.substring(n - 2, n).equals("ич"))) {
                gender = "Мужской";
            }
            else {
                gender = "Не удалось определить";
            }
            return gender;
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка при определении пола: " + e.getMessage());
        }
    }
    public String getAge(int[] bday){
        try {
            LocalDate t = LocalDate.now();
            int[] today = new int[3];
            today[0] = t.getDayOfMonth();
            today[1] = t.getMonthValue();
            today[2] = t.getYear();
            int age = today[2] - bday[2];
            if (today[1] < bday[1]) {
                age -= 1;
            } else if (today[1] == bday[1]) {
                if (today[0] < bday[0]) {
                    age -= 1;
                }

            }
            String ans = Integer.toString(age);
            String alf1 = "234";
            String alf2 = "567890";
            int n = ans.length();
            if (alf1.contains(ans.substring(n - 1, n)) && !ans.equals("11") && !ans.equals("12") && !ans.equals("13") && !ans.equals("14")) {
                ans = ans + " года";
            } else if (alf2.contains(ans.substring(n - 1, n)) || ans.equals("11") || ans.equals("12") || ans.equals("13") || ans.equals("14")) {
                ans = ans + " лет";
            } else {
                ans = ans + " год";
            }
            return ans;
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка при определении возраста: " + e.getMessage());
        }

    }
}
