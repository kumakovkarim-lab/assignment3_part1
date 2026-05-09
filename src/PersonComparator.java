import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        // implement this according to your variant
        int res = o1.firstname.compareTo(o2.firstname);
        if (res == 0) {
            return o1.lastname.compareTo(o2.lastname);
        }
        return res;
    }
}