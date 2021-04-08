package com.easycli;

/** An interface to group command line arguments */
interface CmdObject {

    /** Interface for Builder Pattern */
    interface Builder {
        /** Long name for an option. */
        Builder longOptionName(String optionName);
        /** Short name for an option. */
        Builder shortOptionName(String shortOptionName);
        /** Description for an option. */
        Builder description(String description);
    }
}
