import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SalesItemTest {

    @Test
    public void testConstructorAndGetters() {
        SalesItem item = new SalesItem("Laptop", 99999);

        assertEquals("Laptop", item.getName());
        assertEquals(99999, item.getPrice());
        assertEquals(0, item.getNumberOfComments());
    }

    @Test
    public void testAddCommentValid() {
        SalesItem item = new SalesItem("Phone", 49999);

        assertTrue(item.addComment("Alice", "Great product!", 5));
        assertEquals(1, item.getNumberOfComments());
    }

    @Test
    public void testAddCommentDuplicateAuthor() {
        SalesItem item = new SalesItem("Tablet", 29999);

        assertTrue(item.addComment("Bob", "Nice screen!", 4));
        assertFalse(item.addComment("Bob", "Updated review", 3)); // Duplicate author not allowed
    }

    @Test
    public void testAddCommentInvalidRating() {
        SalesItem item = new SalesItem("Camera", 19999);

        assertFalse(item.addComment("Charlie", "Bad rating!", -1)); // Invalid rating
        assertFalse(item.addComment("Diana", "Too high rating!", 6)); // Invalid rating
    }

    @Test
    public void testRemoveComment() {
        SalesItem item = new SalesItem("Monitor", 15999);

        item.addComment("Alice", "Very clear!", 5);
        item.addComment("Bob", "Sleek design!", 4);

        assertEquals(2, item.getNumberOfComments());
        item.removeComment(0); // Remove the first comment
        assertEquals(1, item.getNumberOfComments());
    }

    @Test
    public void testUpvoteDownvoteComment() {
        SalesItem item = new SalesItem("Keyboard", 4999);

        item.addComment("Alice", "Great keys!", 5);
        item.addComment("Bob", "Sturdy build!", 4);

        item.upvoteComment(0);
        item.upvoteComment(0);
        item.downvoteComment(1);

        Comment comment1 = item.findMostHelpfulComment();
        assertEquals("Alice", comment1.getAuthor());
        assertEquals(2, comment1.getVoteCount());

        Comment comment2 = item.findCommentByAuthor("Bob");
        assertEquals(-1, comment2.getVoteCount());
    }

    @Test
    public void testFindMostHelpfulComment() {
        SalesItem item = new SalesItem("Mouse", 2999);

        item.addComment("Alice", "Good!", 4);
        item.addComment("Bob", "Better!", 5);
        item.upvoteComment(1);

        Comment mostHelpful = item.findMostHelpfulComment();
        assertEquals("Bob", mostHelpful.getAuthor());
    }

    @Test
    public void testShowInfo() {
        SalesItem item = new SalesItem("Headphones", 5999);

        item.addComment("Alice", "Excellent sound quality!", 5);
        item.addComment("Bob", "Comfortable to wear.", 4);

        // Check console output using a logging approach, or trust manual verification.
        item.showInfo();
    }
}
