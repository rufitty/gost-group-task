package task;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TextTest {
    public static Text text = new Text();

    @Test
    public void testWordCounting() {
        ByteArrayInputStream stream = new ByteArrayInputStream(("Ехал Грека через реку,\n" +
                "Видит Грека - в реке рак.\n" +
                "Сунул Грека руку в реку,\n" +
                "Рак за руку Греку - цап!").getBytes());
        List<Map.Entry<String, Integer>> entries = text.countWords(stream);
        assertEquals("Words count",
                "[грека=3, реку=2, в=2, руку=2, рак=2, ехал=1, видит=1, сунул=1, " +
                        "цап=1, реке=1, через=1, за=1, греку=1]",
                entries.toString());
    }
}
