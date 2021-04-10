package com.easycli;

/**
 * Represents a flag value in command line arguments
 */
public class Flag implements CmdObject {

    /** Long name for the argument */
    private String longOptionName;
    /** Short name for the argument */
    private String shortOptionName;
    /** Description for the argument */
    private String description;
    /** Whther it is required or optional */
    private boolean optional;
    /** give an alias */
    private String alias;

    static class Builder implements  CmdObject.Builder, Optional, Required {

        Flag f = new Flag();


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
            f.setLongOptionName(optionName);
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
            f.setShortOptionName(shortOptionName);
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
            if (description.length() > 200)
                throw new IllegalArgumentException("Description is too long. It cannot be longer than 200 characters");
            f.setDescription(description);
            return this;
        }

        /**
         * Set alias
         * @param alias alias for the option
         * @return this
         */
        @Override
        public Flag.Builder alias(String alias) {
            if (alias == null || alias.equals(""))
                throw new IllegalArgumentException("Alias cannot be null or empty");
            f.setAlias(alias);
            return this;
        }

        /**
         * Set the flag as optional
         * @return this
         */
        @Override
        public Builder optional() {
            f.setOptional(true);
            return this;
        }

        /**
         * Set the flag as required. This will enforce the client to have the option.
         * @return this
         */
        @Override
        public Builder required() {
            f.setOptional(false);
            return this;
        }

        /** Build a new Flag */
        public Flag build() {
            if (f == null)
                throw new IllegalArgumentException("Cannot instantiate Flag");
            return f;
        }
    }

    @Override
    public String toString() {
        return "Flag{" +
                "longOptionName='" + longOptionName + '\'' +
                ", shortOptionName='" + shortOptionName + '\'' +
                ", description='" + description + '\'' +
                ", optional=" + optional +
                '}';
    }

    /** Call the builder for creating this class */
    public static Flag.Builder with() {
        return new Flag.Builder();
    }

    private Flag() {}

    private void setLongOptionName(String longOptionName) {
        this.longOptionName = longOptionName;
    }

    private void setShortOptionName(String shortOptionName) {
        this.shortOptionName = shortOptionName;
    }

    private void setDescription(String description) {
        this.description = description;
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

    public boolean isOptional() {
        return optional;
    }

    public boolean isArg() {return false;}

    public String getAlias() {return alias;}

}
