package com.easycli;

/**
 * Represents an argument in command line arguments.
 * <p>
 * Arguments are written in the format:
 *
 * <code>./executable --option argument</code>
 */
public class Arg implements CmdObject {

    /** Long name for the argument */
    private String longOptionName;
    /** Short name for the argument */
    private String shortOptionName;
    /** Description for the argument */
    private String description;
    /** Name of the argument */
    private String argName;
    /** Whther it is required or optional */
    private boolean optional;
    /** give an alias */
    private String alias;

    /**
     * Inner class Builder that builds an Arg object
     */
    public static class Builder implements  CmdObject.Builder, Optional, Required {

        // New arg for builder pattern
        Arg arg = new Arg();

        /**
         * Set long option name
         * @param optionName long option name, queried with "--". For example,
         *                   if longName is config, then you can access the long option with
         *                   --config
         * @return this
         */
        @Override
        public Builder longOptionName(String optionName) {
            if (optionName == null || optionName.equals(""))
                throw new IllegalArgumentException("Long name cannot be null or empty");
            arg.setLongOptionName(optionName);
            return this;
        }

        /**
         * Set short option name
         * @param shortOptionName short option name, queried with "-". For example,
         *                        if shortName is c, then you can access the short option with
         *                        -c
         * @return this
         */
        @Override
        public Builder shortOptionName(String shortOptionName) {
            if (shortOptionName == null || shortOptionName.equals(""))
                throw new IllegalArgumentException("Short name cannot be null or empty");
            arg.setShortOptionName(shortOptionName);
            return this;
        }

        /**
         * Set description
         * @param description description for the argument. Will be visible in help text
         * @return this
         */
        @Override
        public Builder description(String description) {
            if (description == null || description.equals(""))
                throw new IllegalArgumentException("Description cannot be null or empty");
            if (description.length() >= 200)
                throw new IllegalArgumentException("Description is too long. It cannot be longer than 200 characters");
            arg.setDescription(description);
            return this;
        }

        /**
         * Set argument name for arguments
         * @param argName argument name. Will be visible in help text
         * @return this
         */
        public Builder argName(String argName) {
            if (argName == null || argName.equals(""))
                throw new IllegalArgumentException("Argument name cannot be null or empty");
            arg.setArgName(argName);
            return this;
        }

        /**
         * Set alias
         * @param alias alias for the option
         * @return this
         */
        @Override
        public Arg.Builder alias(String alias) {
            if (alias==null || alias.equals(""))
                throw new IllegalArgumentException("Alias cannot be null or empty");
            arg.setAlias(alias);
            return this;
        }

        /**
         * Set the argument as optional
         * @return this
         */
        @Override
        public Builder optional() {
            arg.setOptional(true);
            return this;
        }

        /**
         * Set the argument as required. This will enforce the client to have the option.
         * @return this
         */
        @Override
        public Builder required() {
            arg.setOptional(false);
            return this;
        }

        /** Build the argument */
        public Arg build() {
            if (arg.longOptionName == null)
                throw new IllegalArgumentException("Cannot instantiate Arg");
            return arg;
        }

    }

    @Override
    public String toString() {
        return "Arg{" +
                "longOptionName='" + longOptionName + '\'' +
                ", shortOptionName='" + shortOptionName + '\'' +
                ", description='" + description + '\'' +
                ", argName='" + argName + '\'' +
                ", optional=" + optional +
                '}';
    }

    /** Call builder for building this class */
    public static Builder with() {
        return new Builder();
    }

    private Arg() {}

    private void setLongOptionName(String longOptionName) {
        this.longOptionName = longOptionName;
    }

    private void setShortOptionName(String shortOptionName) {
        this.shortOptionName = shortOptionName;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setArgName(String argName) {
        this.argName = argName;
    }

    private void setOptional(boolean optional) {
        this.optional = optional;
    }

    private void setAlias(String alias) {this.alias = alias;}

    public String getLongOptionName() {
        return longOptionName;
    }

    public String getShortOptionName() {
        return shortOptionName;
    }

    public String getDescription() {
        return description;
    }

    public String getArgName() {
        return argName;
    }

    public boolean isOptional() {
        return optional;
    }

    public boolean isArg() {return true;}

    public String getAlias() {return alias;}
}
