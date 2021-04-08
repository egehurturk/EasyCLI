package com.easycli;

import java.util.Arrays;


public class EasyCli {

    public EasyCli(String[] args, CmdObjects objects) {
        System.out.println("Args: " + Arrays.toString(args));
        System.out.println("CmdObjects: " + objects);
    }

    class Synopsis {
        public void print() {
            System.out.println("Print called");
        }

    }
}
