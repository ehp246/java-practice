package me.ehp246.javapractice.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class HackerRank {
    public static int cookies(int k, List<Integer> A) {
	final var args = new ArrayList<Integer>(A);
	args.sort(Integer::compareTo);

	int count = 0;
	while (args.stream().anyMatch(i -> i < k) && args.size() > 2) {
	    count++;
	    int a = args.remove(0);
	    int b = args.remove(0);

	    add(args, a + 2 * b);
	}

	if (args.stream().anyMatch(i -> i < k)) {
	    return -1;
	}

	return count;
    }

    static void add(final List<Integer> l, final int add) {
	if (l.get(l.size() - 1) <= add) {
	    l.add(l.size(), add);
	    return;
	}
	for (int i = 0; i < l.size(); i++) {
	    if (l.get(i) >= add) {
		l.add(i, add);
		return;
	    }
	}
    }
}
