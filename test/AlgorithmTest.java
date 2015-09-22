import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MacBookEr on 9/22/15.
 */
public class AlgorithmTest {

    @Test
    public void itShouldReturnTestsAreWorking() {
        Algorithm algo = new Algorithm();
        String result = algo.getTestsAReWorkingMessage();
        String correct = "Tests are working";
        assertEquals(correct, result);
    }


}