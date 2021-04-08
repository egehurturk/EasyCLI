package com.easycli;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
@DisplayName("Easy CLI tests")
public class EasyCliTest {

    @Test
    @DisplayName("Given command line arguments in array, program should make arguments accessible")
    void commandLineValueShouldBeAccessed() {
        // ./example -v --foo yesplease --bar nosir
        String[] args = {"./example", "-v", "--foo", "yesplease", "--bar", "nosir"};
        EasyCli cli = new EasyCli(args, getArguments());
        CmdIdentifier identifier = new CmdIdentifier(cli);
        if (!identifier.isSuccessful()) {
            EasyCli.Synopsis synopsis = cli.new Synopsis();
            synopsis.print();
            System.exit(identifier.getStatus());
        }

        System.out.println(identifier.has("foo"));
        if (identifier.has("bar")) {
            System.out.println("This is bar boi: " + identifier.valueOf("bar"));
        }


    }

    private CmdObjects getArguments() {
        CmdObjects objects = new CmdObjects();

        // create an argument
        // --foo|-f string
        Arg foo = Arg.with()
                .longOptionName("foo")
                .shortOptionName("f")
                .argName("string")
                .description("Foo baz go br")
                .required();

        // create an argument
        // [--bar|-b string]
        Arg bar = Arg.with()
                .longOptionName("bar")
                .shortOptionName("b")
                .argName("string")
                .description("Bar haha ez")
                .optional();

        // create a flag
        // [--version|-v]
        Flag v = Flag.with()
                .longOptionName("version")
                .shortOptionName("v")
                .description("Display current version")
                .optional();

        objects.add(foo, bar, v);
        return args;
    }

}


//https://stackoverflow.com/questions/9725675/is-there-a-standard-format-for-command-line-shell-help-text
//http://www.tfug.org/helpdesk/general/man.html
