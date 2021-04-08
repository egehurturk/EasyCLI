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

    static class Builder implements  CmdObject.Builder, Optional, Required {

        Flag f = new Flag();

        @Override
        public Builder longOptionName(String optionName) {
            if (optionName == null || optionName.equals(""))
                throw new IllegalArgumentException("Long name cannot be null or empty");
            f.setLongOptionName(optionName);
            return this;
        }

        @Override
        public Builder shortOptionName(String shortOptionName) {
            if (shortOptionName == null || shortOptionName.equals(""))
                throw new IllegalArgumentException("Short name cannot be null or empty");
            f.setShortOptionName(shortOptionName);
            return this;
        }

        @Override
        public Builder description(String description) {
            if (description == null || description.equals(""))
                throw new IllegalArgumentException("Description cannot be null or empty");
            f.setDescription(description);
            return this;
        }

        @Override
        public Builder optional() {
            f.setOptional(true);
            return this;
        }

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
}
