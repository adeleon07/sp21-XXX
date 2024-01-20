package gitlet;

import static gitlet.Utils.*;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */

    public static void main(String[] args) {
        // TODO: what if args is empty? - complete
        validatedNumCommand(args);

        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                // TODO: handle the `init` command
                //Verify if there is a Gitlet version-control system in CWD,
                // this is done in repositoty
                Repository.init();
               // setupPersistence(); or do I defer to making persistence in the init command? I might do that instead.
                //Create
                break;
            case "add":
                // TODO: handle the `add [filename]` command
                break;
            // TODO: FILL THE REST IN
        }
    }

    private static void validatedNumCommand(String[] args) {
        if (args.length == 0) {
            Utils.error("Please enter a command.");
        }
    }


    private static void setupPersistence() {
    //TODO-AD: Setup a new gitlit repo
    }
}
