import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertTrue;

public class PasswordVerifyTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private PasswordVerify passwordVerify = new PasswordVerify();

//    @Test
//    public void verifyShouldReturnExceptionIfPasswordLesserThan8Chars() {
//        expectedException.expect(IllegalArgumentException.class);
//        expectedException.expectMessage("Password should Be Atleast 8 characters long");
//        passwordVerify.verify("aA12");
//    }

    @Test
    public void verifyShouldNotThrowExceptionIfPasswordGreaterThan8Chars() {
        assertTrue(passwordVerify.verify("AbCd1R390"));
    }

    @Test
    public void verifyShouldThrowExceptionIfPasswordIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Password Should Not Be Null");
        passwordVerify.verify(null);
    }

    @Test
    public void verifyShouldThrowExceptionIfDoesNotHaveAtleast1UpperCaseLetter() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Password Should Have Atleast 1 uppercase letter");
        passwordVerify.verify("abcdersdfd");
    }

    @Test
    public void verifyShouldThrowExceptionIfDoesNotHaveAtleast1LowerCaseLetter() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Password Should Have Atleast 1 lowercase letter");
        passwordVerify.verify("ABCSDKFLER");
    }

    @Test
    public void verifyShouldThrowExceptionIfDoesNotHaveAtleast1Number() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Password Should Have Atleast 1 Numeric");
        passwordVerify.verify("ABCacf");
    }

    @Test
    public void verifyShouldReturnTrueIfPasswordUpperLowerAndNumeric() {
        assertTrue(passwordVerify.verify("Ab1R390"));
    }

    @Test
    public void verifyShouldThrowExceptionIfNoLowerCase() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Password Should Have Atleast 1 lowercase letter");
        passwordVerify.verify("ABCSDKFL234ER");
    }
}
