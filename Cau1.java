import java.util.*;

public class Person {
    private String name;
    private Date birthDate;
    private String gender;
    private Person spouse;
    private List<Person> children;

    public Person(String name, Date birthDate, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public void marry(Person spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }

    public void addChild(Person child) {
        this.children.add(child);
        if (this.spouse != null) {
            this.spouse.children.add(child);
        }
    }

    public List<Person> getChildren() {
        return children;
    }

    public Person getSpouse() {
        return spouse;
    }

    public boolean isMarried() {
        return spouse != null;
    }

    public boolean hasTwoChildren() {
        return children.size() == 2;
    }
}

public class Main {
    public static void main(String[] args) {
        Person james = new Person("James", new Date(), "Male");
        Person hana = new Person("Hana", new Date(), "Female");
        james.marry(hana);
        Person ryan = new Person("Ryan", new Date(), "Male");
        Person kai = new Person("Kai", new Date(), "Male");
        james.addChild(ryan);
        james.addChild(kai);

        // Tìm tất cả các cá nhân không kết hôn trong danh sách phả hệ
        List<Person> unmarried = new ArrayList<>();
        if (!james.isMarried()) unmarried.add(james);
        if (!hana.isMarried()) unmarried.add(hana);
        if (!ryan.isMarried()) unmarried.add(ryan);
        if (!kai.isMarried()) unmarried.add(kai);
        System.out.println("Unmarried: " + unmarried);

        // Tìm tất cả các cặp vợ chồng có hai con trong danh sách phả hệ
        List<Person> twoChildren = new ArrayList<>();
        if (james.hasTwoChildren()) twoChildren.add(james);
        if (hana.hasTwoChildren()) twoChildren.add(hana);
        if (ryan.hasTwoChildren()) twoChildren.add(ryan);
        if (kai.hasTwoChildren()) twoChildren.add(kai);
        System.out.println("Two children: " + twoChildren);
    }
}
