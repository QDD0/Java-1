//Создать класс Student, содержащий следующие характеристики: имя, группа, курс, оценки по предметам.
//
//Создать коллекцию, содержащую объекты класса Student.
//
//Написать метод, который удаляет студентов со средним баллом < 3.
//Если средний балл >= 3, студент переводится на следующий курс.
//
//Реализовать метод printStudents(List<Student> students, int course),
// который получает список студентов и номер курса и выводит в консоль имена тех студентов из списка, которые обучаются на данном курсе.

import java.util.List;

class Student {
    private String name = "";
    private String group = "";
    private int course = 0;
    private int[] number;
    private int sum = 0;
    private double result = 0;

    Student(String _name, String _group, int _course, int... _number) {
        this.name = _name;
        this.group = _group;
        this.course = _course;
        this.number = _number;
    }

    public void Delete() {
        for (int i = 0; i < number.length; i++) {
            sum += number[i];
        }

        result = (double) sum / number.length;

        if (result >= 3) {
            System.out.println("Студент " + name + " переведен на " + (course + 1) + " курс");
            System.out.println(result);
        } else {
            System.out.println("Студент " + name + " удален");
        }
    }

    public void printStudents(List<Student> students, int course) {
        System.out.print("\nСтуденты, обучающиеся на " + course + " курсе: ");

        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Student one = new Student("Alex", "ИВТ", 3, 5, 4, 4, 5);
        one.Delete();

        Student two = new Student("Rob", "ПРИ", 2, 5, 3, 4, 5);
        two.Delete();

        Student three = new Student("Bob", "МОА", 3, 2, 4, 2, 3);
        three.Delete();

        Student four = new Student("Kate", "ПРИ", 1, 5, 4, 4, 5);
        four.printStudents(List.of(one, two, three, four), 1);
    }
}