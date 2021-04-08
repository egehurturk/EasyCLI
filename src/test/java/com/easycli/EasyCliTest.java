package com.easycli;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
@DisplayName("Easy CLI tests")
public class EasyCliTest {

    @Test
    @Disabled
    @DisplayName("Given command line arguments in array, program should make arguments accessible")
    void commandLineValueShouldBeAccessed() {
        // ./example -v --foo yesplease --bar nosir
        String[] args = {"./example", "-v", "--foo", "yesplease", "--bar", "nosir"};
        EasyCli cli = new EasyCli(args, null);
        if (!cli.isSuccessful()) {
            EasyCli.Synopsis synopsis = cli.new Synopsis();
            synopsis.print();
            System.exit(cli.getStatus());
        }

        System.out.println(cli.has("foo"));
        if (cli.has("bar")) {
            System.out.println("This is bar boi: " + cli.valueOf("bar"));
        }
    }

    @Test
    @DisplayName("Build an argument and check its fields")
    void buildArgs() {
        Arg foo = Arg.with()
                .longOptionName("foo")
                .shortOptionName("f")
                .argName("string")
                .description("Foo baz go br")
                .required()
                .build();
        Assertions.assertEquals("foo", foo.getLongOptionName());
        Assertions.assertEquals("f", foo.getShortOptionName());
        Assertions.assertEquals("string", foo.getArgName());
        Assertions.assertEquals("Foo baz go br", foo.getDescription());
        Assertions.assertFalse(foo.isOptional());
    }

    @Test
    @DisplayName("Build a flag and check its fields")
    void buildFlag() {
        Flag v = Flag.with()
                .longOptionName("version")
                .shortOptionName("v")
                .description("Display current version")
                .optional()
                .build();
        Assertions.assertEquals("version", v.getLongOptionName());
        Assertions.assertEquals("v", v.getShortOptionName());
        Assertions.assertEquals("Display current version", v.getDescription());
        Assertions.assertTrue(v.isOptional());
    }

    @Test
    @DisplayName("Invalid arguments should trow an exception")
    void buildArgThrowException() {
        Assertions.assertThrows(java.lang.IllegalArgumentException.class,
                () ->  Arg.with()
                        .longOptionName("")
                        .shortOptionName("hey")
                        .description("asjdasd")
                        .argName("sdfsdf")
                        .optional()
                        .build());
    }

    @Test
    @DisplayName("Invalid arguments should trow an exception")
    void buildArgThrowExceptionTwo() {
        Assertions.assertThrows(java.lang.IllegalArgumentException.class,
                () ->  Arg.with()
                        .longOptionName("hhah")
                        .shortOptionName("")
                        .description("asjdasd")
                        .argName("sdfsdf")
                        .optional()
                        .build());
    }

    @Test
    @DisplayName("Invalid arguments should trow an exception")
    void buildArgThrowExceptionThree() {
        Assertions.assertThrows(java.lang.IllegalArgumentException.class,
                () ->  Arg.with()
                        .longOptionName("hhah")
                        .shortOptionName("dflsdfsdf")
                        .description("")
                        .argName("sdfsdf")
                        .optional()
                        .build());
    }

    @Test
    @DisplayName("Invalid arguments should trow an exception")
    void buildArgThrowExceptionFour() {
        Assertions.assertThrows(java.lang.IllegalArgumentException.class,
                () ->  Arg.with()
                        .longOptionName("hhah")
                        .shortOptionName("dflsdfsdf")
                        .description("sdfsfgsdf")
                        .argName("")
                        .optional()
                        .build());
    }

    @Test
    @DisplayName("Invalid arguments should trow an exception")
    void buildFlagThrowException() {
        Assertions.assertThrows(java.lang.IllegalArgumentException.class,
                () ->  Flag.with()
                        .longOptionName("")
                        .shortOptionName("v")
                        .description("Display current version")
                        .optional()
                        .build());
    }

    @Test
    @DisplayName("Invalid arguments should trow an exception")
    void buildFlagThrowExceptionTwo() {
        Assertions.assertThrows(java.lang.IllegalArgumentException.class,
                () ->  Flag.with()
                        .longOptionName("sdjfksdfj")
                        .shortOptionName("")
                        .description("Display current version")
                        .optional()
                        .build());
    }

    @Test
    @DisplayName("Invalid arguments should trow an exception")
    void buildFlagThrowExceptionThree() {
        Assertions.assertThrows(java.lang.IllegalArgumentException.class,
                () ->  Flag.with()
                        .longOptionName("sdjfksdfj")
                        .shortOptionName("sdfsdf")
                        .description("")
                        .optional()
                        .build());
    }

}


//https://stackoverflow.com/questions/9725675/is-there-a-standard-format-for-command-line-shell-help-text
//http://www.tfug.org/helpdesk/general/man.html
