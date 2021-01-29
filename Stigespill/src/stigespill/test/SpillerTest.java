import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stigespill.Brett;
import stigespill.Spiller;
import stigespill.Terning;



import java.util.Random;

class SpillerTest {
    Brett testBrett = new Brett(99);
    Spiller spiller = new Spiller("Chen", "White");
    Terning terning = new Terning();
    Random random = new Random();
    @BeforeEach
    void setUp() {


    }

    @Test
    void startTur() {
        int position = 0;
        for(int i = 0 ; i < 1000 ; i++) {
            ;
            int after_position = spiller.startTur(terning, testBrett);
            System.out.println(after_position);
        }






    }

    @Test
    void getNavn() {
    }

    @Test
    void setNavn() {
    }

    @Test
    void getBrikke() {
    }

    @Test
    void setBrikke() {
    }
}