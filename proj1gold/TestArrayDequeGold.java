import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<Integer>();
        StringBuilder message = new StringBuilder();

        int times = StdRandom.uniform(0, 300);
        for (int i = 0; i < times; i++) {
            int choice = StdRandom.uniform(0,4);
            Integer data = StdRandom.uniform(0, 800);
            switch (choice) {
                case 0: {
                    sad1.addFirst(data);
                    ads1.addFirst(data);
                    message.append("addFirst(").append(data).append(")\n");
                    break;
                }
                case 1: {
                    sad1.addLast(data);
                    ads1.addLast(data);
                    message.append("addLast(").append(data).append(")\n");
                    break;
                }
                case 2: {
                    if (!sad1.isEmpty() && !ads1.isEmpty()) {
                        Integer actual = sad1.removeFirst();
                        Integer expected = ads1.removeFirst();
                        message.append("removeFirst()\n");
                        assertEquals(message.toString(), expected, actual);
                    }
                    break;
                }
                case 3: {
                    if (!sad1.isEmpty() && !ads1.isEmpty()) {
                        Integer actual = sad1.removeLast();
                        Integer expected = ads1.removeLast();
                        message.append("removeLast()\n");
                        assertEquals(message.toString(), expected, actual);
                    }
                    break;
                }
            }
        }

        /*
        if (!sad1.isEmpty() && !ads1.isEmpty()) {
            Integer actual = null;
            Integer expected = null;
            int size = sad1.size();
            for (int i = 0; i < size; i++) {
                actual = sad1.get(i);
                expected = ads1.get(i);
                assertEquals("Oh noooo!\\nThis is bad:\\n   Random number " + actual
                                + " not equal to " + expected + "!",
                                    expected, actual);
            }
        }
        */
    }


}