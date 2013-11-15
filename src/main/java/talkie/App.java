package talkie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Anna Khasanova
 */
public class App {
	// I am sorry, but I tired. Now only in English
	private static final String EXIT_WORD = "Stop";

    public static void main(String[] args) {
        ReplyGenerator replyGenerator = new DefaultReplyGenerator();
        System.out.println("Ask your question:");
        try {
            talk(replyGenerator);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ok! Bye");
    }

    private static void talk(ReplyGenerator replyGenerator) throws IOException {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Can I... ");
            String question = bufferRead.readLine().trim();
            if (question.isEmpty()) {
                continue;
            }
            if (isExitCommand(question)) {
                break;
            } else {
                printQuestion(question);
                printAnswer(replyGenerator);
            }
            System.out.println("\nLet's continue!");
        }
    }

    private static boolean isExitCommand(String input) {
        return EXIT_WORD.equalsIgnoreCase(input);
    }

    private static void printQuestion(String question) {
        String questionOut = "Can you " + question;
        if (!questionOut.endsWith("?")) {
            questionOut += "?";
        }
        System.out.println(questionOut);
    }

    private static void printAnswer(ReplyGenerator replyGenerator) {
        System.out.println(replyGenerator.generate());
    }
}