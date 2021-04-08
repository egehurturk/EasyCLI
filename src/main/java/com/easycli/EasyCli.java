package com.easycli;

import java.util.Arrays;


/**
 * Command Line Argument Parser.
 * This class accepts the arguments (<code>String[] args</code>) and a
 * {@link CmdObjects} object to parse arguments.
 *
 * The inner class {@link Synopsis} provides methods to automatically
 * print help message containing the synopsis of the required or optional arguments.
 */
public class EasyCli {

    /** Whether the command line is grammatically correct or not based on
     * the arguments defined in {@link CmdObjects}. */
    private boolean succesfull;

    /** Status code for UNIX based OS.  */
    private int status = 1;

    /** Command Line Objects containing {@link Arg}s or {@link Flag}s */
    private CmdObjects commandLineObjects;

    /** Actual arguments entered by client. The String array is a parameter of
     * the <code>main</code> method, as seen in <code>public static void main(String[] args)</code>
     * */
    private String[] clientArguments;

    /**
     * Tell if the args include everything, i.e. the operation
     * is successful
     */
    public boolean isSuccessful() { return succesfull; }

    /**
     * Get the value for status code
     */
    public int getStatus() { return this.status; }

    /**
     * Tell whether the command line arguments
     * include the given argument, as string.
     * @param arg Argument name
     */
    public boolean has(String arg) {
        System.out.println("Code later on...");
        return false;
    }

    /**
     * Get the value of the given command
     * line argument.
     * <p>
     * If the argument is the argument name
     * of {@link Flag}, then an empty string is returned.
     *
     * @param arg argument name
     * @return the value of arg
     *
     */
    public String valueOf(String arg) {
        return "none";
    }


    /**
     * Constructor with an array of arguments and CmdObjects object.
     * The parameter args is the actual arguments entered by the client,
     * and is used to check if that contains {@link Arg}s and {@link Flag}s added
     * to the objects parameter
     *
     * @param args command line argument array, the parameter of <code>public static void main(String[] args)</code>
     * @param objects desired objects stored as {@link CmdObjects}
     */
    public EasyCli(String[] args, CmdObjects objects) {
        System.out.println("Args: " + Arrays.toString(args));
        System.out.println("CmdObjects: " + objects);
    }


    /**
     * This class is used to print synopsis and help messages
     * containing useful information about arguments, e.g., whether
     * they are required or optional, etc.
     * <p>
     * The general format for help is described below. The <code>-h | --help</code> flag
     * is always automatically added to {@link #commandLineObjects}.
     */
    class Synopsis {
        public void print() {
            System.out.println("Print called");
        }

    }
}
