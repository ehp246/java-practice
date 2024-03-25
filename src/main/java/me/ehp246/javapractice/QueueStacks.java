package me.ehp246.javapractice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class QueueStacks {
    private static final Queue<String> queue = new LinkedList<String>();

    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	int q = Integer.parseInt(bufferedReader.readLine().trim());
	IntStream.range(0, q).forEach(tItr -> {
	    try {
		processOneLine(bufferedReader.readLine().trim());
	    } catch (IOException e) {
		throw new RuntimeException(e);
	    }
	});

	bufferedReader.close();
    }

    static void processOneLine(final String input) {
	if (input.startsWith("1 ")) {
	    queue.add(input.substring(input.lastIndexOf(" ") + 1));
	} else if (input.startsWith("2")) {
	    queue.remove();
	} else if (input.startsWith("3")) {
	    System.out.println(queue.element());
	}
    }
}
