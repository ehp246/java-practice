package me.ehp246.javapractice.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

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

    public static int pairs(int k, List<Integer> arr) {
	final var set = Collections.newSetFromMap(new ConcurrentHashMap<Integer, Boolean>());

	arr.parallelStream().forEach(set::add);

	var count = 0;
	for (var one : set) {
	    if (set.contains(one + k)) {
		count++;
	    }
	    if (set.contains(one - k)) {
		count++;
	    }
	}

	return count / 2;
    }
}
