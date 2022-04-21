import java.util.*;
///  import java.util.Arrays;
//  import java.util.List;
import java.util.stream.Collectors;


class Main {
    public static void main(String[] args) {


        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John", "Mike", "Alex", "Olga", "Mary", "Katrin", "Jane");
        //  List<String> namesWOMEN = Arrays.asList("Olga", "Mary", "Katrin", "Jane");

        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown", "Richards");

        List<Person> people = new ArrayList<>();


        Random random = new Random();
        //Collection<Person> persons = new ArrayList<>();
        //List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {


            int age = random.nextInt(100);
            Sex sex = Sex.values()[new Random().nextInt(Sex.values().length)];
            //  Sex sex = processingSex(names);
            Education education = processingAge(age, sex);

            people.add(new Person(names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    age, sex, education));
        }

        long count = people.stream()
                .filter(v -> v.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + count);

        List<String> militaryPeople = people.stream()
                .filter(v -> v.getAge() >= 18 && v.getAge() < 27)
                .map(v -> v.getSurname())
                .collect(Collectors.toList());
        System.out.println("Список фамилий призывников:");
        for (String militaryPerson : militaryPeople) {
            System.out.println(militaryPerson);
        }

        List<Person> workablePeople = people.stream()
                .filter(v -> v.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        System.out.println("Список потенциально работоспособных людей с высшим образованием: ");
        for (int i = 0; i < workablePeople.size(); i++) {
            System.out.println(workablePeople.get(i).toString());
        }
    }

    public static Education processingAge(int age, Sex sex) {
        if (age <= 14) {
            return Education.ELEMENTARY;
        } else if (age <= 18) {
            return Education.SECONDARY;
        } else if (age <= 22) {
            return Education.FURTHER;
        } else if (age <= 65 && sex.equals(Sex.MAN)) {
            return Education.HIGHER;
        } else if (age <= 60 && sex.equals(Sex.WOMEN)) {
            return Education.HIGHER;
        } else {
            return Education.RETIREE;
        }
    }


}

