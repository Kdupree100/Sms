package JPA.entitymod;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jpa.entitymodels.Student;

public class StudentTest {

    @Test
    public void testgetmail() {
    Student student = new Student();
    student.setsEmail("sbowdenl@yellowbook.com");

    assertEquals("sbowdenl@yellowbook.com", student.getsEmail());
  // assertEquals("fhdjgr@yellowbook.com", student.getsEmail());


}
}