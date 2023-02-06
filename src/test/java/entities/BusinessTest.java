package entities;

import categories.ComponentTest;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Category(ComponentTest.class)
class BusinessTest {
    @Test
    void testConstructor() {
        assertEquals("Business{id=null, name='Name'}", (new Business("Name")).toString());
    }

    @Test
    void testConstructor2() {
        Business actualBusiness = new Business();
        actualBusiness.setId(1);
        actualBusiness.setName("Name");
        assertEquals(1, actualBusiness.getId().intValue());
        assertEquals("Name", actualBusiness.getName());
        assertEquals("Business{id=1, name='Name'}", actualBusiness.toString());
    }

    @Test
    void testConstructor3() {
        Business actualBusiness = new Business("Name");
        actualBusiness.setId(1);
        actualBusiness.setName("Name");
        assertEquals(1, actualBusiness.getId().intValue());
        assertEquals("Name", actualBusiness.getName());
        assertEquals("Business{id=1, name='Name'}", actualBusiness.toString());
    }
}

