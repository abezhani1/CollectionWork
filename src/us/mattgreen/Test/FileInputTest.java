package us.mattgreen.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.mattgreen.FileInput;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FileInputTest {
    FileInput input;
    @Before
    public void SetUp()
    {
        input = new FileInput("great");
    }

    @Test
    public void testFileReadLine()
    {
        assertNotNull("Read Returned null", input.fileReadLine());
        //assertTrue("read returned null", input.fileReadLine()==null);
    }

    @After
    public void testFileClose()
    {
        input.fileClose();
    }
}
