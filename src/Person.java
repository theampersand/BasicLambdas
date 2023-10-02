public class Person {
    private Integer age;
    private String name;
    private Double height;

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }

    public Person(String name, Integer age, Double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
