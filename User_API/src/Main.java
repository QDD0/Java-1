//Создать класс User, описывающий пользователя (необходимые поля: id, firstName, lastName, age, country).
//Создать список из некоторого количества пользователей.
//        Реализовать методы, принимающие список пользователей и позволяющие выполнить следующее:
//        1) вывести всех пользователей, отсортированных по lastName; +
//        2) вывести всех пользователей, отсортированных по age; +
//        3) проверить, что для всех пользователей age > 7; +
//        4) вычислить средний возраст всех пользователей; +
//        5) вывести количество разных стран проживания (country) среди заданных пользователей +

import java.util.Comparator;
import java.util.List;

class User {
    private int id;
    public String first_name;
    public String last_name;
    public int age = 0;
    public String country;

    User(int id, String first_name, String last_name, int age, String country) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.country = country;
    }
}

class Main {
    public static void main(String[] args) {
        // Сохраняем пользователей в список
        List<User> users = List.of(
                new User(1, "Ivan", "Ivanov", 20, "Russia"),
                new User(2, "Jon", "Jonov", 25, "Poland"),
                new User(3, "Aya", "Jalouli", 30, "Morocco"),
                new User(4, "Key", "Khan", 35, "Iran"),
                new User(5, "John", "Doe", 40, "USA"),
                new User(6, "Shia", "Jalouli", 21, "Russia"),
                new User(7, "Roman", "Khan", 4, "Truky")
        );

        System.out.println("Сортировка по фамилиям:");
        users.stream().sorted(Comparator.comparing(user -> user.last_name))
                .forEach(user -> System.out.println(user.last_name));

        System.out.println("\nСортировка по возрасту:");
        users.stream().sorted(Comparator.comparing(user -> user.age))
                .forEach(user -> System.out.println(user.age));

        System.out.println("\nКол-во уникальных стран:");
        long count = users.stream().map(user -> user.country).distinct().count();
        System.out.println(count);

        System.out.println("\nБольше 7 лет: ");
        users.stream().filter(user -> user.age > 7).forEach(user -> System.out.println(user.first_name));

        System.out.println("\nСредний возраст: ");
        int sum = users.stream().map(user -> user.age).reduce(0, Integer::sum);
        System.out.println(sum / users.size());
    }
}