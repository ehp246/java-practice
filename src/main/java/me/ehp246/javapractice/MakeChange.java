package me.ehp246.javapractice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeChange {
    public enum Denotation {
	Quarter(25), Dime(10), Penny(1);

	private final int worth;

	private Denotation(final int worth) {
	    this.worth = worth;
	}

	public int inPieces(final int amount) {
	    if (amount <= 0) {
		return 0;
	    }
	    return amount / this.worth;
	}

	public int worth() {
	    return this.worth;
	}

	public static Map<Denotation, Integer> apply(int amount) {
	    final var map = new HashMap<Denotation, Integer>();
	    for (var d : Denotation.Ordered) {
		final var pieces = d.inPieces(amount);
		map.put(d, pieces);
		amount -= pieces * d.worth();
	    }
	    return map;
	}

	public static List<Denotation> Ordered = List.of(Quarter, Dime, Penny);
    }

    public Map<Denotation, Integer> apply(int amount) {
	return Denotation.apply(amount);
    }
}
