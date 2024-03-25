package me.ehp246.javapractice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MakeChangeTest {

    @Test
    void test_01() {
	final var map = new MakeChange().apply(11);

	Assertions.assertEquals(0, map.get(MakeChange.Denotation.Quarter));
	Assertions.assertEquals(1, map.get(MakeChange.Denotation.Dime));
	Assertions.assertEquals(1, map.get(MakeChange.Denotation.Penny));
    }

    @Test
    void test_02() {
	final var map = new MakeChange().apply(31);

	Assertions.assertEquals(1, map.get(MakeChange.Denotation.Quarter));
	Assertions.assertEquals(0, map.get(MakeChange.Denotation.Dime));
	Assertions.assertEquals(6, map.get(MakeChange.Denotation.Penny));
    }
}
