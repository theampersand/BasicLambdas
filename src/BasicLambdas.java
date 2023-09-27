import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicLambdas {
    public static void main(String[] args) {
        BasicLambdas lambdas = new BasicLambdas();
        lambdas.consumer();
        lambdas.supplier();
        lambdas.predicate();
        lambdas.check(lambdas);
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
        Person mike = new Person(33, "Mike", 1.8);
        lambdas.check(mike, isAdult);
        Person ann = new Person(13, "Ann", 1.4);
        lambdas.check(ann, isAdult);
    }
    public <T> Boolean check(T t, Predicate<T> p) {
        return p.test(t);
    }

    public void function() {

    }

    private void sortName(List<Person> personList){}
    private void sortAge(List<Person> personList){}
    private void sortHeight(List<Person> personList){}
    private List<Person> getPeople() {
        return null;
    };
}