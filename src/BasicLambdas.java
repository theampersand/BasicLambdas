import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicLambdas {

    private static List<Person> listPeople;

    public static void main(String[] args) {
        BasicLambdas lambdas = new BasicLambdas();
        lambdas.consumer();
        lambdas.supplier();
        lambdas.predicate();
        lambdas.check(lambdas);
        lambdas.function();
        System.out.println("Generating People list");
        listPeople = BasicLambdas.getPeople();
        listPeople.forEach(System.out::println);

        System.out.println("Sorting people list by Age");
        BasicLambdas.sortAge(listPeople);
        listPeople.forEach(System.out::println);

        System.out.println("Soring people list by Name");
        BasicLambdas.sortName(listPeople);
        listPeople.forEach(System.out::println);

        System.out.println("Sorting people list by Height");
        BasicLambdas.sortHeight(listPeople);
        listPeople.forEach(System.out::println);
    }

    public void consumer(){
        Printable<String> sp = s -> System.out.println(s);
        sp.print("Printable lambda");
        Consumer<String> consumerLambda = s -> System.out.println(s);
        Consumer<String> consumerMethodReference = System.out::println;
        consumerLambda.accept("Consumer lambda");
        consumerMethodReference.accept("Consumer method reference");
    }

    public void supplier() {
        Retrievable<Integer> r = () -> 77;
        System.out.println(r.retrieve());
        Supplier<Integer> s = () -> 77;
        System.out.println(s.get());
    }

    public void predicate() {
        Evaluate<Integer> e = integer -> integer < 0;
        System.out.println(e.isNegative(-1));
        System.out.println(e.isNegative(1));
        Predicate<Integer> p = integer -> integer < 0;
        System.out.println(p.test(-1));
        System.out.println(p.test(1));
    }

    public void check(BasicLambdas lambdas) {
        // part 4 - check()
        Predicate<Integer> isEven = integer -> integer % 2 == 0;
        if (lambdas.check(4, isEven)) System.out.println("4 is even");
        else System.out.println("4 is odd");
        if (lambdas.check(7, isEven)) System.out.println("7 is even");
        else System.out.println("7 is odd");
        Predicate<String> isMr = s -> s.startsWith("Mr.");
        if (lambdas.check("Mr. Joe Bloggs", isMr)) System.out.println("Mr. Joe Bloggs is a Mr.");
        else System.out.println("Mr. Joe Bloggs is not a Mr.");
        if (lambdas.check("Ms. Ann Bloggs", isMr)) System.out.println("Ms. Ann Bloggs is a Mr.");
        else System.out.println("Ms. Ann Bloggs is not a Mr.");
        Predicate<Person> isAdult = person -> person.getAge() >= 18;
        Person mike = new Person("Mike", 33, 1.8);
        lambdas.check(mike, isAdult);
        Person ann = new Person("Ann", 13, 1.4);
        lambdas.check(ann, isAdult);
    }
    public <T> Boolean check(T t, Predicate<T> p) {
        return p.test(t);
    }

    public void function() {
        Functionable<Integer, String> functionable = integer -> "Number is: " + integer;
        System.out.println(functionable.applyThis(25));
        Function<Integer, String> function = integer -> "Number is: " + integer;
        System.out.println(function.apply(25));
    }

    private static void sortName(List<Person> personList){
        personList.sort(Comparator.comparing(Person::getName));
    }
    private static void sortAge(List<Person> personList){
        personList.sort(Comparator.comparingInt(Person::getAge));
    }
    private static void sortHeight(List<Person> personList){
        personList.sort(Comparator.comparingDouble(Person::getHeight));
    }
    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike",33, 1.8));
        result.add(new Person("Mary",25, 1.4));
        result.add(new Person("Alan",34, 1.7));
        result.add(new Person("Zoe",30, 1.5));
        return result;
    };
}