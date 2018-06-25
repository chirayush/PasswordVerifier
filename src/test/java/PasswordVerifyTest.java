import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PasswordVerifyTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void verifyShouldReturnExceptionIfPasswordLesserThan8Chars() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Password should Be Atleast 8 characters long");
        PasswordVerify passwordVerify = new PasswordVerify();
        passwordVerify.verify("a");

    }
}
