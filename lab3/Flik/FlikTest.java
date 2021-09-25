import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {

    @Test
    public void testHorrible() {
        for(int i = 0, j = 0; i < 500; i++, j++){
            System.out.print(i + " " + j + ";");
            assertTrue(Flik.isSameNumber(i, j));
        }
    }
}