package Collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created: 21.10.2022
 *
 * @author Maximilian Ertl (maxer)
 */
class PhonebookEntryTest {

    @Test
    void numberWrongFormatOne() {
        assertThrows(IllegalArgumentException.class, () -> new PhonebookEntry("no number", null));
    }

    @Test
    void numberWrongFormatTwo() {
        assertThrows(IllegalArgumentException.class, () -> new PhonebookEntry("+002149134"));
    }

    @Test
    void correctFormattingOne() {
        assertEquals("a : 001834729247", new PhonebookEntry("001834729247", "a").toString());
    }

    @Test
    void correctFormattingTwo() {
        assertEquals("a : 012345678", new PhonebookEntry("012345678", "a").toString());
    }

    @Test
    void correctFormattingThree() {
        assertEquals("a : 012345678", new PhonebookEntry("012345678", "a").toString());
    }

    @Test
    void testEquals() {
        assertEquals(true, "a".equals("a"));
        assertEquals(false, "b".equals("a"));
    }

    @Test
    void testHashCode() {
        PhonebookEntry phonebookEntry = new PhonebookEntry("0027361634", "test");
        PhonebookEntry phonebookEntry2 = new PhonebookEntry("0027361634", "test2");
        assertEquals(phonebookEntry.hashCode(), phonebookEntry2.hashCode());
    }

    @Test
    void testHashCodeTwo() {
        PhonebookEntry phonebookEntry = new PhonebookEntry("023758432695", "test");
        PhonebookEntry phonebookEntry2 = new PhonebookEntry("023758432695", "test2");
        assertEquals(phonebookEntry.hashCode(), phonebookEntry2.hashCode());
    }

}