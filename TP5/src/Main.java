import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Network n = Parser.parse("input.in");
		Output.output(n.caches, "test.out");
	}
}
