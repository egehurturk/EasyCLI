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

    /**
     * Inner class Builder that builds an Arg object
     */
    static class Builder implements  CmdObject.Builder, Optional, Required {

        Arg arg = new Arg();

        @Override
        public Builder longOptionName(String optionName) {
            if (optionName == null || optionName.equals(""))
                throw new IllegalArgumentException("Long name cannot be null or empty");
            arg.setLongOptionName(optionName);
            return this;
        }

        @Override
        public Builder shortOptionName(String shortOptionName) {
            if (shortOptionName == null || shortOptionName.equals(""))
                throw new IllegalArgumentException("Short name cannot be null or empty");
            arg.setShortOptionName(shortOptionName);
            return this;
        }

        @Override
        public Builder description(String description) {
            if (description == null || description.equals(""))
                throw new IllegalArgumentException("Description cannot be null or empty");
            arg.setDescription(description);
            return this;
        }

        public Builder argName(String argName) {
            if (argName == null || argName.equals(""))
                throw new IllegalArgumentException("Argument name cannot be null or empty");
            arg.setArgName(argName);
            return this;
        }

        @Override
        public Builder optional() {
            arg.setOptional(true);
            return this;
        }

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
}
