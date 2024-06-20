package gitlet;


import java.io.IOException;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */

    public static void main(String[] args) throws IOException {
        //TODO: what if args is empty? - complete
        //validatedNumCommand(args);

        //String firstArg = args[0];
        // switch(firstArg) {

        /* test line */ switch("init") {
            case "init":
                // TODO: handle the `init` command - complete
                Repository.init();
               // setupPersistence(); or do I defer to making persistence in the init command? I might do that instead.
                break;
            case "add":
                // TODO: handle the `add [filename]` command
                try {
                    Repository.add(args[1]);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            // TODO: FILL THE REST IN
        }
    }

    private static void validatedNumCommand(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter a command.");
            System.exit(0);
        }
    }


    //private static void setupPersistence() {
    //TODO-AD: Setup a new gitlit repo?
    //}
}
