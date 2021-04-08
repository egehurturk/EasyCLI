package com.easycli;

/** An interface to mark {@link com.easycli.CmdObject}s as optional */
public interface Optional {
    /** mark as optional */
    CmdObject.Builder optional();
}
