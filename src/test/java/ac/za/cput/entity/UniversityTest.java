package ac.za.cput.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniversityTest {

    // Create cput
    University cput = new University.Builder().setUniversityId(1).setName("CPUT").setAddress("Hanover St, Zonnebloem, Cape Town, 7925").build();

    @Test
    public void getUniversityId() {
        assertEquals(1,cput.getUniversityId());
    }

    @Test
    public void getName() {
        assertEquals("CPUT",cput.getName());
    }

    @Test
    public void getLocation() {
        assertEquals("Hanover St, Zonnebloem, Cape Town, 7925",cput.getAddress());
    }
}