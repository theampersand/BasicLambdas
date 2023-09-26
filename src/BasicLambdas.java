import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BasicLambdas {
    public static void main(String[] args) {
        BasicLambdas lambdas = new BasicLambdas();
        lambdas.consumer();
        lambdas.supplier();
    }

    public void consumer(){
        Printable<String> sp = s -> System.out.println(s);
        sp.print("Printable lambda");
        Consumer<String> consumerLambda = s -> System.out.println(s);
        Consumer<String> consumerMethodReference = System.out::println;
        consumerLambda.accept("Consumer lambda");
        consumerLambda.accept("Consumer method reference");
    }

    public void supplier() {
        Retrievable<Integer> r = () -> 77;
        System.out.println(r.retrieve());
        Supplier<Integer> s = () -> 77;
        System.out.println(s.get());
    }

    public void predicate() {

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