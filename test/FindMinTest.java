import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMinTest {

    @Test
    void testFindMinComparable() {
        String[] names = {"Bob", "John", "Alice"};
        // Заменили ElementarySort на AdvancedSort
        assertEquals("Alice", AdvancedSort.findMin(names));
    }

    @Test
    void testFindMinComparator() {
        String[] names = {"Bob", "John", "Alice"};
        // Заменили ElementarySort на AdvancedSort
        assertEquals("Bob", AdvancedSort.findMin(names, new StringComparator()));
    }
}