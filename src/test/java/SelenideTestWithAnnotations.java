import AnnotationMethods.AnnotationMethods;
import org.junit.jupiter.api.Test;

public class SelenideTestWithAnnotations {

    AnnotationMethods annoStep = new AnnotationMethods();

    @Test
    public void TestWithAnnotations () {
        annoStep.openPG()
                .searchRepository()
                .chooseRepository()
                .enterToRepository()
                .validationIssue();
    }
}
