package me.ehp246.javapractice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MergedLinkedList {
    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	int t = Integer.parseInt(bufferedReader.readLine().trim());
	final var merged = new ArrayList<List<Integer>>();
	IntStream.range(0, t).forEach(tItr -> {
	    final var nList = new ArrayList<Integer>();
	    final var mList = new ArrayList<Integer>();

	    try {
		int n = Integer.parseInt(bufferedReader.readLine().trim());
		for (int iN = 0; iN < n; iN++) {
		    nList.add(Integer.parseInt(bufferedReader.readLine().trim()));
		}

		int m = Integer.parseInt(bufferedReader.readLine().trim());
		for (int iM = 0; iM < m; iM++) {
		    mList.add(Integer.parseInt(bufferedReader.readLine().trim()));
		}

		merged.add(merge(nList, mList));
	    } catch (IOException ex) {
		throw new RuntimeException(ex);
	    }
	});

	bufferedReader.close();

	for (int i = 0; i < t; i++) {
	    for (int j = 0; j < merged.get(i).size(); j++) {
		System.out.print(merged.get(i).get(j) + " ");
	    }
	    System.out.println();
	}
    }

    static ArrayList<Integer> merge(final List<Integer> nList, final List<Integer> mList) {
	final var merged = new ArrayList<Integer>(nList);
	merged.addAll(mList);
	merged.sort(Integer::compareTo);
	return merged;
    }
}
