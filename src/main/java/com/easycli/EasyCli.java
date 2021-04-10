package com.easycli;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * EasyCli class to retrieve and match command line arguments
 */
public class EasyCli {

    /** actual args */
    @Getter @Setter private String[] args;
    /** client generated options to check */
    @Getter @Setter private CmdOptions options;
    private boolean success = false;

    /**
     * @param args main method args
     * @param options user generated options
     */
    public EasyCli(@NonNull String[] args, @NonNull CmdOptions options) {
        this.args = args;
        this.options = options;
    }

    /**
     * Check if all required {@link CmdObject}s in {@link #options} are
     * present in {@link #args}
     *
     * @return success
     */
    public boolean matchAllArgs() {
        for (CmdObject opt: options.getOptions()) {

            if (!opt.isOptional() &&
                    (!existsInArray("-" + opt.getShortOptionName(), args) &&
                            !existsInArray("--" + opt.getLongOptionName(), args))
            ) {
                this.success = false;
                return false;
            }
        }
        this.success = true;
        return true;
    }

    // Check if the given value exists in the given array
    private <T> boolean existsInArray(T val, T[] array) {
        for (T t: array)
            if (t.equals(val))
                return true;
        return false;
    }

    /**
     * Synopsis class for printing help message
     */
    public class Synopsis {
        // ./banzai -c|--config file_path [-v|--version] [-o|--verbose]

        @Getter private String helpMessage = "";
        private String appName;

        /**
         * Construct this with the appName
         * @param appName app name to display in help text
         */
        public Synopsis(@NonNull String appName) {
            if (appName.length() == 0)
                throw new IllegalArgumentException("App name should not be an empty string");
            this.appName = appName;
            prepareHelp();
        }

        /**
         * Print the help text
         */
        public void print() {
            System.out.println(helpMessage);
        }

        /**
         * Prepare the help text string
         */
        private void prepareHelp() {
            String firstLine = "Usage: " + appName + " ";
            String description = "";
            for (CmdObject obj: options.getOptions()) {
                String curr = "";
                if (!obj.isOptional()) {
                    firstLine += "-"+obj.getShortOptionName()+"|--"+obj.getLongOptionName() + " ";
                    curr += "\t-"+obj.getShortOptionName() + "|--"+obj.getLongOptionName() + " ";
                    if (obj.isArg()) {
                        firstLine += "<" + ((Arg) obj).getArgName() + "> ";
                        curr += "<" + ((Arg) obj).getArgName() + ">";
                    }
                } else {
                    firstLine += "[-" + obj.getShortOptionName()+"|--"+obj.getLongOptionName() + "] ";
                    curr += "\t-"+obj.getShortOptionName() + "|--"+obj.getLongOptionName();
                }
                description += padRight(curr, 30) + obj.getDescription() + "\n";

            }
            String curr = "\t-h|--help ";
            description += padRight(curr, 30) + "Print this message";
            helpMessage += firstLine + "[-h|--help]" +  "\n";
            helpMessage += description + "\n";

        }


        // Utilities
        private String padRight(String s, int n) {
            return String.format("%-" + n + "s", s);
        }

        private String padLeft(String s, int n) {
            return String.format("%" + n + "s", s);
        }

    }

    /**
     * @param aliasName alias name for options
     * @return args contain the alias option
     */
    public boolean has(@NonNull String aliasName) {
        CmdObject foundObj = findFromCmdObjectsWithAlias(aliasName);
        if (foundObj == null)
            return false;

        boolean found = false;
        for (String item: args) {
            if (item.contains("--") && item.substring(2).equals(foundObj.getLongOptionName()))
                found = true;
            else if (item.contains("-") && item.substring(1).equals(foundObj.getShortOptionName()))
                found = true;
        }
        return found;
    }

    /**
     * Get the value for {@link Arg}s
     * @param alias alias name for the arg
     * @return the value of the arg
     */
    public String get(@NonNull String alias) {
        CmdObject foundObj = findFromCmdObjectsWithAlias(alias);
        if (foundObj == null)
            return null;
        if (!foundObj.isArg())
            throw new IllegalArgumentException("The alias for the option is a Flag. Flag's cannot have values.");

        String val = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("--") && args[i].substring(2).equals(foundObj.getLongOptionName()))
                val = args[i+1];
            else if (args[i].contains("-") && args[i].substring(1).equals(foundObj.getShortOptionName()))
                val = args[i+1];
        }
        return val;
    }


    private CmdObject findFromCmdObjectsWithAlias(String alias) {
        CmdObject foundObj = null;
        for (CmdObject obj: options.getOptions())
            if (obj.getAlias().equals(alias))
                foundObj = obj;
        return foundObj;
    }


}
