import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rabbit_RegExTest
{
    //Testing Rabbit Names!!
    @Test //TEST ONE
    void testCapitalRabbitName()
    {
        Rabbit_RegEx rabbit_Name = new Rabbit_RegEx();
        rabbit_Name.setRabbitName("Butterscotch");
        assertTrue(rabbit_Name.getRabbitName().matches("[A-Za-z-]*"));
    }//end rabbit name w/1st letter capital

    @Test //TEST TWO
    void testlowerRabbitName()
    {
        Rabbit_RegEx rabbit_Name = new Rabbit_RegEx();
        rabbit_Name.setRabbitName("snowflake");
        assertTrue(rabbit_Name.getRabbitName().matches("[A-Za-z-]*"));
    }//end rabbit name w/all lowercase

    @Test //TEST THREE
    void testallNumbersRabbitName()
    {
        Rabbit_RegEx rabbit_Name = new Rabbit_RegEx();
        rabbit_Name.setRabbitName("12345");
        assertFalse(rabbit_Name.getRabbitName().matches("[A-Za-z-]*"));
    }//end numbers in name

    @Test //TEST FOUR
    void testOneNumberinRabbitName()
    {
        Rabbit_RegEx rabbit_Name = new Rabbit_RegEx();
        rabbit_Name.setRabbitName("MO0N");
        assertFalse(rabbit_Name.getRabbitName().matches("[A-Za-z-]*"));
    }//end one number in rabbit name

    @Test //TEST FIVE
    void testSpecialCharactersRabbitName()
    {
        Rabbit_RegEx rabbit_Name = new Rabbit_RegEx();
        rabbit_Name.setRabbitName("Pot!at!*"); //potat or potato w/out an o
        assertFalse(rabbit_Name.getRabbitName().matches("[A-Za-z-]*"));
    }//end special character within name


    //Testing Breed Names!
    @Test //TEST ONE
    void testCapital1stLetterBreedName()
    {
        Rabbit_RegEx rabbit_breed = new Rabbit_RegEx();
        rabbit_breed.setBreedName("AmericanFuzzyLop"); //American Fuzzy Lop, very cute!
        assertTrue(rabbit_breed.getBreedName().matches("^[A-Za-z][a-zA-Z-][a-zA-z- ]*"));
    }//end 1st letter is capital and some random capitals

    @Test //TEST TWO
    void testallLowerBreedName()
    {
        Rabbit_RegEx rabbit_breed = new Rabbit_RegEx();
        rabbit_breed.setBreedName("dwarfhotot"); //Dwarf Hotot
        assertTrue(rabbit_breed.getBreedName().matches("^[A-Za-z][a-zA-Z-][a-zA-z- ]*"));
    }//end only lowercase

    @Test //TEST THREE
    void testallNumbersBreedName()
    {
        Rabbit_RegEx rabbit_breed = new Rabbit_RegEx();
        rabbit_breed.setBreedName("282003");
        assertFalse(rabbit_breed.getBreedName().matches("^[A-Za-z][a-zA-Z-][a-zA-z- ]*"));
    }//end only numbers in breed name

    @Test //TEST FOUR
    void testSpacesAndCapitalsBreedName()
    {
        Rabbit_RegEx rabbit_breed = new Rabbit_RegEx();
        rabbit_breed.setBreedName("Netherland Dwarf");
        assertTrue(rabbit_breed.getBreedName().matches("^[A-Za-z][a-zA-Z-][a-zA-z- ]*"));
    }//end spaces & capitals

    @Test //TEST FIVE
    void testSpacesAndLowercaseBreedName()
    {
        Rabbit_RegEx rabbit_breed = new Rabbit_RegEx();
        rabbit_breed.setBreedName("silver fox");
        assertTrue(rabbit_breed.getBreedName().matches("^[A-Za-z][a-zA-Z-][a-zA-z- ]*"));
    }//end spaces & lowercase

    @Test //TEST SIX
    void testSpecialCharactersBreedName()
    {
        Rabbit_RegEx rabbit_breed = new Rabbit_RegEx();
        rabbit_breed.setBreedName("Champagne d'Argent");
        assertFalse(rabbit_breed.getBreedName().matches("^[A-Za-z][a-zA-Z- ][a-zA-z- ]*"));
    }//end testing for special characters


    //Testing ages and if it's a baby bun!!
    @Test //TEST ONE
    void testNegativeAge()
    {
        Rabbit_RegEx rabbit_age = new Rabbit_RegEx();
        rabbit_age.setAge(-5);
        rabbit_age.setIsBaby(true);
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 0 weeks\n" +
                "Weight: 0.0 in ounces\n" +
                "Color: ";
        assertEquals(expected, rabbit_age.toString());
    }//end negative age + baby set to true

    @Test //TEST TWO
    void testPositiveLowAge()
    {
        Rabbit_RegEx rabbit_age = new Rabbit_RegEx();
        rabbit_age.setAge(4);
        rabbit_age.setIsBaby(true);
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 0.0 in ounces\n" +
                "Color: ";
        assertEquals(expected, rabbit_age.toString());
    }//end positive low age + baby set to true

    @Test //TEST THREE
    void testPositiveHighAge()
    {
        Rabbit_RegEx rabbit_age = new Rabbit_RegEx();
        rabbit_age.setAge(10);
        rabbit_age.setIsBaby(false);
        String expected = "Is the rabbit a baby?: false\n" +
                "How old is the rabbit?: 10 years\n" +
                "Weight: 0.0 in pounds\n" +
                "Color: ";
        assertEquals(expected, rabbit_age.toString());
    }//end positive high age + baby set to false

    @Test //TEST FOUR
    void testOverAgeLimit()
    {
        Rabbit_RegEx rabbit_age = new Rabbit_RegEx();
        rabbit_age.setAge(18);
        rabbit_age.setIsBaby(false);
        String expected = "Is the rabbit a baby?: false\n" +
                "How old is the rabbit?: 10 years\n" +
                "Weight: 0.0 in pounds\n" +
                "Color: ";
        assertEquals(expected, rabbit_age.toString());
    }//end age over 10


    //Testing Weight!!
    @Test //TEST ONE
    void testNegativeWeight()
    {
        Rabbit_RegEx rabbit_weight = new Rabbit_RegEx();
        rabbit_weight.setWeight(-5.0);
        rabbit_weight.setIsBaby(true);
        rabbit_weight.setAge(1);
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 1 weeks\n" +
                "Weight: 1.0 in ounces\n" +
                "Color: ";
        assertEquals(expected, rabbit_weight.toString());
    }//end negative weight

    @Test //TEST TWO
    void testPositiveLowWeightAndBabyBun()
    {
        Rabbit_RegEx rabbit_weight = new Rabbit_RegEx();
        rabbit_weight.setWeight(3.5);
        rabbit_weight.setIsBaby(true);
        rabbit_weight.setAge(2);
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 2 weeks\n" +
                "Weight: 3.5 in ounces\n" +
                "Color: ";
        assertEquals(expected, rabbit_weight.toString());
    }//end positive low weight and baby bun

    @Test //TEST THREE
    void testPositiveLowWeight()
    {
        Rabbit_RegEx rabbit_weight = new Rabbit_RegEx();
        rabbit_weight.setWeight(2.5);
        rabbit_weight.setIsBaby(false);
        rabbit_weight.setAge(3);
        String expected = "Is the rabbit a baby?: false\n" +
                "How old is the rabbit?: 3 years\n" +
                "Weight: 2.5 in pounds\n" +
                "Color: ";
        assertEquals(expected, rabbit_weight.toString());
    } //end adult bun, low weight (dwarfs/smaller breeds)

    @Test //TEST FOUR
    void testPositiveHighWeight()
    {
        Rabbit_RegEx rabbit_weight = new Rabbit_RegEx();
        rabbit_weight.setWeight(15);
        rabbit_weight.setIsBaby(false);
        rabbit_weight.setAge(4);
        String expected = "Is the rabbit a baby?: false\n" +
                "How old is the rabbit?: 4 years\n" +
                "Weight: 15.0 in pounds\n" +
                "Color: ";
        assertEquals(expected, rabbit_weight.toString());
    }//end positive high weight

    @Test //TEST FIVE
    void testPositiveOverLimitWeight()
    {
        Rabbit_RegEx rabbit_weight = new Rabbit_RegEx();
        rabbit_weight.setWeight(17);
        rabbit_weight.setIsBaby(false);
        rabbit_weight.setAge(5);
        String expected = "Is the rabbit a baby?: false\n" +
                "How old is the rabbit?: 5 years\n" +
                "Weight: 15.0 in pounds\n" +
                "Color: ";
        assertEquals(expected, rabbit_weight.toString());
    }//end weight over limit


    //Rabbit colors!
    @Test //TEST ONE
    void testUppercaseAgoutiColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("Agouti");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: Agouti";
        assertEquals(expected, rabbit_color.toString());
    }//end test uppercase color agouti

    @Test //TEST TWO
    void testLowercaseAgoutiColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("agouti");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: agouti";
        assertEquals(expected, rabbit_color.toString());
    }//end lowercase color agouti

    @Test //TEST THREE
    void testUppercaseBlackColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("Black");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: Black";
        assertEquals(expected, rabbit_color.toString());
    }//end uppercase color black

    @Test //TEST FOUR
    void testLowercaseBlackColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("black");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: black";
        assertEquals(expected, rabbit_color.toString());
    }//end lowercase color black

    @Test //TEST FIVE
    void testUppercaseBlackOtterColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("Black Otter");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: Black Otter";
        assertEquals(expected, rabbit_color.toString());
    }//end test uppercase color black otter

    @Test //TEST SIX
    void testLowercaseBlackOtterColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("black otter");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: black otter";
        assertEquals(expected, rabbit_color.toString());
    }//end lowercase color black otter

    @Test //TEST SEVEN
    void testUppercaseBlueColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("Blue");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: Blue";
        assertEquals(expected, rabbit_color.toString());
    }//end lowercase color blue

    @Test //TEST EIGHT
    void testLowercaseBlueColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("blue");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: blue";
        assertEquals(expected, rabbit_color.toString());
    }//end lowercase color blue

    @Test //TEST NINE
    void testUppercaseBlueOtterColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("Blue Otter");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: Blue Otter";
        assertEquals(expected, rabbit_color.toString());
    }//end uppercase color blue otter

    @Test //TEST TEN
    void testLowercaseBlueOtterColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("blue otter");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: blue otter";
        assertEquals(expected, rabbit_color.toString());
    }//end lowercase color blue otter

    @Test //TEST ELEVEN
    void testUppercaseBlueSteelColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("Blue Steel");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: Blue Steel";
        assertEquals(expected, rabbit_color.toString());
    }//end uppercase color blue steel

    @Test //TEST TWELVE
    void testLowercaseBlueSteelColor()
    {
        Rabbit_RegEx rabbit_color = new Rabbit_RegEx();
        rabbit_color.setIsBaby(true);
        rabbit_color.setWeight(2);
        rabbit_color.setAge(4);
        rabbit_color.setColor("blue steel");
        String expected = "Is the rabbit a baby?: true\n" +
                "How old is the rabbit?: 4 weeks\n" +
                "Weight: 2.0 in ounces\n" +
                "Color: blue steel";
        assertEquals(expected, rabbit_color.toString());
    }//end lowercase color blue steel


    //Test True Dwarf Gene!
    @Test //TEST ONE
    void testHollandLopTrueDwarfGene()
    {
        Rabbit_RegEx rabbit_gene = new Rabbit_RegEx();
        rabbit_gene.setTrueDwarfGene(true);
        rabbit_gene.setBreedName("Holland Lop");

        boolean expected = true;
        assertEquals(expected, rabbit_gene.getTrueDwarfGene());
    }//end test when dwarf gene is true w/holland lop

    @Test //TEST TWO
    void testNetherlandDwarfTrueDwarfGene()
    {
        Rabbit_RegEx rabbit_gene = new Rabbit_RegEx();
        rabbit_gene.setTrueDwarfGene(true);
        rabbit_gene.setBreedName("Netherland Dwarf");
        boolean expected = true;
        assertEquals(expected, rabbit_gene.getTrueDwarfGene());
    }//end test dwarf gene true w/netherland dwarf

    @Test
    void testAmericanTrueDwarfGene()
    {
        Rabbit_RegEx rabbit_gene = new Rabbit_RegEx();
        rabbit_gene.setTrueDwarfGene(true);
        rabbit_gene.setBreedName("American");
        boolean expected = false;
        assertEquals(expected, rabbit_gene.getTrueDwarfGene());
    }
}//end class test don't try to put tests underneath this!!