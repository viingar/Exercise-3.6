import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, List<User>> map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Введите имя пользователя: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Ошибка: имя пользователя не может быть пустым");
                i--;
                continue;
            }

            System.out.print("Введите возраст пользователя: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: возраст должен быть целым числом");
                i--;
                scanner.nextLine();
                continue;
            }
            int age = scanner.nextInt();
            scanner.nextLine();
            User user = new User(name, age);

            List<User> userList = map.get(age);
            if (userList == null) {
                userList = new ArrayList<>();
                map.put(age, userList);
            }
            userList.add(user);
        }

        System.out.print("Введите возраст для поиска: ");
        int searchAge = scanner.nextInt();

        List<User> userList = map.get(searchAge);
        if (userList != null) {
            Collections.sort(userList, Comparator.comparing(User::getName));
            for (User user : userList) {
                System.out.println(user);
            }
        } else {
            System.out.println("Пользователи с таким возрастом не найдены");
        }
    }
}