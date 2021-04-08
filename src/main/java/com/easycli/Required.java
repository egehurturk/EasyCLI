package com.easycli;

/** An interface to mark {@link com.easycli.CmdObject}s as required */
public interface Required {
    /** mark as required */
    CmdObject.Builder required();
}
