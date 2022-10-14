public class Main {
    public static void main(String[] args) {
        Person mother = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setCity("Сидней")
                .build();
        Person son = mother.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mother + " есть сын, " + son);

        try {
            Person dad = new PersonBuilder()
                    .setSurname("Вольф")
                    .build();
            System.out.println("У " + mother + " есть муж, " + dad);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            Person granddad = new PersonBuilder()
                    .setName("Владимир")
                    .setSurname("Азин")
                    .setAge(-100)
                    .build();
            System.out.println("У " + mother + " есть дедушка, " + granddad);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
