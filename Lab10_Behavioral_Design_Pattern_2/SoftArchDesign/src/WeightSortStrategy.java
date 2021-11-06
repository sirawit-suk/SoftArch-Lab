import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Reference: https://www.techiedelight.com/sort-list-of-objects-using-comparator-java/
public class WeightSortStrategy implements SortStrategy {
    // YOU MAY ADD UP TO 5 LINES OF CODE BELOW THIS COMMENT !! A LINE OF CODE MAY CONTAIN UP TO ONE SEMI-COLON !!
    @Override
    public void customSort(List<Person> people) {
        Collections.sort(people, Comparator.comparingInt(Person::getWeight));
    }
}
