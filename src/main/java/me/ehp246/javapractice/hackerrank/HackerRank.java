package me.ehp246.javapractice.hackerrank;

import java.util.Arrays;
import java.util.List;

public class HackerRank {
    public static int cookies(int k, List<Integer> A) {
	final var args = new int[A.size()];

	for (int i = 0; i < args.length; i++) {
	    args[i] = A.get(i);
	}

	Arrays.sort(args);

	int start = 0;
	int count = 0;
	while (args[start] < k && args.length - start > 1) {
	    count++;
	    int a = args[start++];
	    int b = args[start++];

	    int inserting = a + 2 * b;

	    int insertAt = start;
	    for (; insertAt < args.length && args[insertAt] < inserting; insertAt++) {
	    }
	    insertAt--;
	    final int shift = insertAt - start + 1;
	    for (int i = 0; i < shift; i++) {
		args[start + i - 1] = args[start + i];
	    }
	    start--;
	    args[insertAt] = inserting;
	}

	if (args[start] < k) {
	    return -1;
	}

	return count;
    }
}
