package memento;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ScmTest {

    @Test
    public void commitAndRevert() {
        Scm scm = new Scm();
        Repository repository = new Repository("TEST");

        repository.add(new File("test.java"));
        scm.commit(repository);
        repository.add(new File("forRevert.java"));
        scm.revert();

        assertEquals(1, repository.getFiles().size());
        assertEquals("test.java", repository.getFiles().get(0).getName());
        assertEquals("TEST", repository.getName());
    }


}