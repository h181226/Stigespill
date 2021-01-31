import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import stigespill.Brett;
import stigespill.Spiller;
import stigespill.Terning;



import java.util.Random;

class SpillerTest {
    Brett testBrett = new Brett(100);
    Spiller spiller = new Spiller("Chen", "White");
    Terning terning = new Terning();
    Random random = new Random();
    @BeforeEach
    void setUp() {


    }

    @Test
    void startTur() {
        // Skjekk at en spiller aldri kommer utenfor brettet
        int maxPos =0;
        int minPos =0;
        for (int testStartPosisjon = 0 ; testStartPosisjon < 100; testStartPosisjon++) {
            for(int testIterasjon = 0 ; testIterasjon <15 ; testIterasjon++){
            spiller.getBrikke().setPosisjon(testStartPosisjon);
                for (int i = 0; i < 20; i++) {
                    int positionAfter = spiller.startTur(terning, testBrett);
                    if (maxPos < positionAfter)
                        maxPos = positionAfter;
                    if (minPos > positionAfter)
                        minPos = positionAfter;
            }

                Assertions.assertTrue(maxPos <=99);
                Assertions.assertTrue(minPos >= 0);

        }}

        //  Skjekk 3 kast med 6'ere sender spiller til posisjon 0
        for (int testStartPosisjon = 0 ; testStartPosisjon < 100; testStartPosisjon++) {
            spiller.getBrikke().setPosisjon(testStartPosisjon);
            int terningVerdi = 6;
            this.terning = new TerningTest(terningVerdi);
            int positionAfter = spiller.startTur(terning, testBrett);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == 0);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == positionAfter);
        }


    }

    @Test
    void flyttOgSkjekk() {
        // Skjekk at stigene og slangene fungerer

        spiller.getBrikke().setPosisjon(0); // stige rute# 4
        int terningVerdi = 3;
        this.terning = new TerningTest(terningVerdi);
        int positionAfter = spiller.startTur(terning,testBrett);
        Assertions.assertTrue(spiller.getBrikke().getPosisjon() == 13);
        Assertions.assertTrue(spiller.getBrikke().getPosisjon() == positionAfter);

        for(terningVerdi = 1 ; terningVerdi > 6 ; terningVerdi++) {
            spiller.getBrikke().setPosisjon(27-terningVerdi); // stige rute# 27

            this.terning = new TerningTest(terningVerdi);
            positionAfter = spiller.startTur(terning, testBrett);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == 56);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == positionAfter);
        }

        for(terningVerdi = 1 ; terningVerdi > 6 ; terningVerdi++) {
            spiller.getBrikke().setPosisjon(61-terningVerdi); // slange rute# 61

            this.terning = new TerningTest(terningVerdi);
            positionAfter = spiller.startTur(terning, testBrett);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == 18-62);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == positionAfter);
        }




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

    class TerningTest extends Terning {
        private int statiskTerningVerdi;
        TerningTest(int statiskTerningVerdi) {
            super();
            this.statiskTerningVerdi = statiskTerningVerdi;
        }

        /**
         * Triller en terning med verdier fra 1-6
         *
         * @return verdi av terning
         */
        public int trillTerning() {

            return statiskTerningVerdi;
        }

    }
}

