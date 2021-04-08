package com.easycli;

/**
 * This class stores and retrieve command line arguments
 * parsed from {@link EasyCli}.
 */
public class CmdIdentifier {

    /** Whether the command line is grammatically correct or not based on
     * the arguments defined in {@link CmdObjects}. */
    private boolean successful = false;

    /** Status code for UNIX based OS.  */
    private int status = 1;

    /**
     * @param cli Command Line Driver, expressed as EasyCli object
     */
    public CmdIdentifier(EasyCli cli) {
        System.out.println("Code later on...");
    }

    /**
     * Tell if the args include everything, i.e. the operation
     * is successful
     */
    public boolean isSuccessful() { return successful; }

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


}
