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

    public Person(Integer age, String name, Double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }
}
