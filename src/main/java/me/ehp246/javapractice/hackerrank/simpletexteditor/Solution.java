package me.ehp246.javapractice.hackerrank.simpletexteditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
	try {
	    new Solution().run();
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
    }

    private StringBuilder content = new StringBuilder();
    private List<Command> unDoes = new ArrayList<>();

    static class Command {
	private final int id;
	private final String arg;

	Command(int id, String arg) {
	    this.id = id;
	    this.arg = arg;
	}

	static Command parse(final String cmdLine) {
	    final var id = Integer.parseInt(cmdLine.charAt(0) + "");
	    return new Command(id, id == 4 ? "" : cmdLine.substring(2));
	}

	int id() {
	    return this.id;
	}

	String arg() {
	    return this.arg;
	}
    }

    void run() throws IOException {
	try (final var bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
	    int q = Integer.parseInt(bufferedReader.readLine().trim());
	    IntStream.range(0, q).forEach(tItr -> {
		try {
		    doCommand(Command.parse(bufferedReader.readLine().trim()), true);
		} catch (IOException e) {
		    throw new RuntimeException(e);
		}
	    });
	}
    }

    void doCommand(final Command command, final boolean save) {
	switch (command.id()) {
	case 1:
	    this.content.append(command.arg());
	    if (save) {
		this.unDoes.add(new Command(2, command.arg().length() + ""));
	    }
	    break;
	case 2:
	    final var cutIndex = Integer.parseInt(command.arg());
	    final var cut = this.content.substring(this.content.length() - cutIndex);
	    this.content.setLength(this.content.length() - cutIndex);
	    if (save) {
		this.unDoes.add(new Command(1, cut));
	    }
	    break;
	case 4:
	    doCommand(this.unDoes.get(this.unDoes.size() - 1), false);
	    this.unDoes.remove(this.unDoes.size() - 1);
	    break;
	default:
	    System.out.println(this.content.charAt(Integer.parseInt(command.arg()) - 1));
	}
    }
}
