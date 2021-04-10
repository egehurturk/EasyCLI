package com.easycli;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to store {@link Arg}s and {@link Flag}s .
 */
public class CmdOptions {

    /** List of command line objects ({@link Arg}s and {@link Flag}s */
    private final List<CmdObject> options;

    /**
     * Constructor
     */
    public CmdOptions() {
        options = new ArrayList<CmdObject>();
    }

    /**
     * Variadic argument constructor
     * @param varargs varargs
     */
    public CmdOptions(CmdObject... varargs) {
        options = new ArrayList<CmdObject>();

        for (CmdObject obj: varargs)
            add(obj);
    }

    /**
     * Add an object to the collection. Returns this
     * @param obj command line object
     * @return the current state of this
     */
    public CmdOptions add(CmdObject obj) {

        for (CmdObject clio: options) {
            if (clio.getShortOptionName().equals(obj.getShortOptionName()) || clio.getLongOptionName().equals(obj.getLongOptionName())
            || clio.getAlias().equals(obj.getAlias())) {
                throw new IllegalArgumentException("The object " + obj + " is already present.");
            }
        }

        this.options.add(obj);
        return this;
    }

    /**
     * Get all options
     * @return {@link #options}
     */
    public List<CmdObject> getOptions() {
        return options;
    }


    @Override
    public String toString() {
        return "CmdOptions{" +
                "options=" + options +
                '}';
    }

    /**
     * Check if the list contains this option
     * @param obj option
     * @return {@link #options} contains obj
     */
    public boolean hasOption(CmdObject obj) {
        return this.options.contains(obj);
    }

    /**
     * Check if the list contains this option
     * @param longName long name
     * @param shortName short name
     * @param description description
     * @return {@link #options} contains obj
     */
    public boolean hasOption(String longName, String shortName, String description) {
        for (CmdObject obj: options)
            if (obj.getLongOptionName().equals(longName) && obj.getShortOptionName().equals(shortName) &&
            obj.getDescription().equals(description))
                return true;
        return false;
    }

    /**
     * Check if this class contains the given option
     * @param longName long name
     * @param shortName short name
     * @return true/false
     */
    public boolean hasOption(String longName, String shortName) {
        for (CmdObject obj: options)
            if (obj.getLongOptionName().equals(longName) && obj.getShortOptionName().equals(shortName))
                return true;
        return false;
    }

    /**
     * Check if this class contains the given option
     * @param alias alias name
     * @return true/false
     */
    public boolean hasOption(String alias) {
        for (CmdObject obj: options)
            if (obj.getAlias().equals(alias))
                return true;
        return false;
    }

}
