import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import stigespill.Brett;
import stigespill.Spiller;
import stigespill.Terning;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

class SpillTest {
    Brett testBrett = new Brett(100);
    Spiller spiller = new Spiller("Chen", "White");
    Terning terning = new Terning();
    Random random = new Random();

    /**
     * Skjekk at en spiller aldri kommer utenfor brettet
     *
     */
    @Test
    void startTurBrettPosisjon() {
        //
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





    }
    /**
     *  Skjekk 3 kast med 6'ere sender spiller til posisjon 0
     *
     */
    @Test
    void kasteSeksere() {
        for (int testStartPosisjon = 0 ; testStartPosisjon < 100; testStartPosisjon++) {
            spiller.getBrikke().setPosisjon(testStartPosisjon);
            int terningVerdi = 6;
            this.terning = new TerningTest(terningVerdi);
            int positionAfter = spiller.startTur(terning, testBrett);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == 0);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == positionAfter);
        }

    }


    /**
     *   // Skjekk at stigene og slangene fungerer
     *
     */
    @Test
    void stigerOgSlanger() {

        // stige rute# 4
        spiller.getBrikke().setPosisjon(0);
        int terningVerdi = 3;
        this.terning = new TerningTest(terningVerdi);
        int positionAfter = spiller.startTur(terning,testBrett);
        Assertions.assertTrue(spiller.getBrikke().getPosisjon() == 13);
        Assertions.assertTrue(spiller.getBrikke().getPosisjon() == positionAfter);

        // stige rute# 27
        for(terningVerdi = 1 ; terningVerdi > 6 ; terningVerdi++) {
            spiller.getBrikke().setPosisjon(27-terningVerdi);

            this.terning = new TerningTest(terningVerdi);
            positionAfter = spiller.startTur(terning, testBrett);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == 56);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == positionAfter);
        }

        // slange rute# 61
        for(terningVerdi = 1 ; terningVerdi > 6 ; terningVerdi++) {
            spiller.getBrikke().setPosisjon(61-terningVerdi);

            this.terning = new TerningTest(terningVerdi);
            positionAfter = spiller.startTur(terning, testBrett);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == 18-62);
            Assertions.assertTrue(spiller.getBrikke().getPosisjon() == positionAfter);
        }

        }

    /**
     *   Skjekk at riktig vinner blir valgt
     *
     */
    @Test
    void skjekkVinner() {
        Spiller spiller2 = new Spiller("Jens", "Rosa");
        Spiller spiller3 = new Spiller("Atle", "Sort");
        ArrayList<Spiller> spillere = new ArrayList<Spiller>();

        spillere.add(spiller);
        spillere.add(spiller2);
        spillere.add(spiller3);

        for (int testStartPosisjon = 0 ; testStartPosisjon < 99; testStartPosisjon++) {
            int pos = testStartPosisjon;
            spillere.forEach( s -> s.getBrikke().setPosisjon(pos));


            Assertions.assertTrue(spillere.stream().filter(s -> s.getBrikke().getPosisjon() == 99).map(s -> s.getNavn()).collect(Collectors.joining()).equals(""));

        }
        spiller3.getBrikke().setPosisjon(99);
        Assertions.assertTrue(spillere.stream().filter(s -> s.getBrikke().getPosisjon() == 99).map(s -> s.getNavn()).collect(Collectors.joining()).equals("Atle"));


    }
    /**
     *   Skjekk at brettet lager spesial ruter
     *
     */
    @Test
    void testBrett() {
        Brett brett = new Brett(100);
        Assertions.assertTrue(brett.getSpillerBrett().length == 100);

        // Stiger
        Assertions.assertTrue(brett.getSpillerBrett()[1].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[3].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[7].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[20].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[27].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[35].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[50].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[70].getFlyttAntallRuter() != 0);

        //Slanger

        Assertions.assertTrue(brett.getSpillerBrett()[15].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[46].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[48].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[55].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[61].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[63].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[85].getFlyttAntallRuter() != 0);
        Assertions.assertTrue(brett.getSpillerBrett()[91].getFlyttAntallRuter() != 0);



    }


    /**
     * Kontrolerbar vektet test Terning klasse
     * @author Ehrensverd
     *
     */
    class TerningTest extends Terning {
        private int statiskTerningVerdi;
        TerningTest(int statiskTerningVerdi) {
            super();
            this.statiskTerningVerdi = statiskTerningVerdi;
        }

        /**
         * Triller en terning med vektet verdi
         *
         * @return verdi av terning
         */
        public int trillTerning() {

            return statiskTerningVerdi;
        }

    }
}

