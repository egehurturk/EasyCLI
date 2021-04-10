package com.easycli;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
@DisplayName("Easy CLI tests")
public class EasyCliTest {

    @Test
    @DisplayName("Description longer than 200 should give error")
    void testDescriptionLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Arg.with()
                .longOptionName("file")
                .shortOptionName("f")
                .argName("file_path")
                .description("This represents the file pathalsfjsdalgjs;dlfkgjs;lfkgjs;kldfj;lsdkfjgs;dlkfgjs;flkjk" +
                        "salfjasdkfja;dslkfja;ka;dslkfja;dslkfjads;lkfjadsflasfpoiauewtoiuwerpotuweprituwpeitupweirutpwio" +
                        "erwtuweroptiuewrpoituwperoituwporitpwoeritupwoireutpwoierutpoiwerutpowirutpowirutpowierutpowierutp" +
                        "woeriutewproituweprtiuwepritupweroitupweritupweirupowireutpiwerut")
                .required()
                .alias("config")
                .build());
        Assertions.assertThrows(IllegalArgumentException.class, () ->Flag.with()
                .longOptionName("debug")
                .shortOptionName("d")
                .description("Enable debugreotiuwerpoituwpeoritupweoritupweoritupeiowrutpweoirtupoweirutwpoeirutpeiru" +
                        "weropituweproitupweoritupweroitupweoirtupweoriutpwoeirutpoweirutpwerit" +
                        "weroituwerpotiuweproitupwoirtupwoerutpweoritupweoritupwoeritupeowritpweoirut")
                .optional()
                .alias("verbose")
                .build());

    }

    @Test
    @DisplayName("Test Synopsis 5")
    void testSynopsisAgainAndAgain() {
        String[] args = {"./banzai"};
        EasyCli cli = new EasyCli(args, getLongOptions());
        if (!cli.matchAllArgs()) {
            EasyCli.Synopsis helper = cli.new Synopsis("euroleague");
            helper.print();
        }
    }

    private CmdOptions getLongOptions() {
        Arg config = Arg.with()
                .longOptionName("file")
                .shortOptionName("f")
                .argName("file_path")
                .description("This represents the file pathasdlfjasdlkfjas;dlkfjas;kdfjas;dkfj;alksdfiower")
                .required()
                .alias("config")
                .build();
        Flag ver = Flag.with()
                .longOptionName("debug")
                .shortOptionName("d")
                .description("Enable debugrwqoieruowqierupqoeirupowieupoqwie")
                .optional()
                .alias("verbose")
                .build();
        return new CmdOptions(config, ver);
    }



    @Test
    @DisplayName("Easy client should not throw anything if we have nonnull args and objects")
    void testEasyClientConstructorWithNonNull() {
        String[] args = {"./banzai", "-c", "/dev/null", "-v", "-o"};
        EasyCli cli = new EasyCli(args, getOptions());
    }

    @Test
    @DisplayName("Easy client should throw nullpointerexception if we have null args or objects")
    void testEasyClientConstructorWithNull() {
        String[] args = {"./banzai", "-c", "/dev/null", "-v", "-o"};
        Assertions.assertThrows(NullPointerException.class, () ->  new EasyCli(args, null));
        Assertions.assertThrows(NullPointerException.class, () -> new EasyCli(null, getOptions()));
        Assertions.assertThrows(NullPointerException.class, () -> new EasyCli(null, null));
    }

    @Test
    @DisplayName("Easy client should return false for required and non existent options")
    void testEasyClientMatchArgs() {
        String[] args = {"./banzai", "-c", "/dev/null", "-v", "-o"};
        String[] args2 = {"./banzai", "-v", "-o"};
        String[] args3 = {"./banzai"};
        String[] args4 = {"./banzai", "-o"};
        EasyCli cli = new EasyCli(args, getOptions());
        EasyCli cli2 = new EasyCli(args2, getOptions());
        EasyCli cli3 = new EasyCli(args3, getOptions());
        EasyCli cli4 = new EasyCli(args4, getOptions());
        Assertions.assertTrue(cli.matchAllArgs());
        Assertions.assertFalse(cli2.matchAllArgs());
        Assertions.assertFalse(cli3.matchAllArgs());
        Assertions.assertFalse(cli4.matchAllArgs());
    }

    @Test
    @DisplayName("Test Synopsis")
    void testSynopsis() {
        String[] args = {"./banzai", "/dev/null", "-v", "-o"};
        EasyCli cli = new EasyCli(args, getOptions());
        if (!cli.matchAllArgs()) {
            EasyCli.Synopsis helper = cli.new Synopsis("euroleague");
            String helpMessage = helper.getHelpMessage();
            String j = "Usage: euroleague -c|--config <file path> [-v|--version] [-o|--verbose] [-h|--help]\n" +
                    "\t-c|--config <file path>      Configuration file path\n" +
                    "\t-v|--version                 Get version\n" +
                    "\t-o|--verbose                 Get version\n" +
                    "\t-h|--help                    Print this message\n";
            Assertions.assertEquals(helpMessage, j);
        }
    }

    @Test
    @DisplayName("Test Synopsis Again")
    void testSynopsisAgain() {
        String[] args = {"/dev/Null", "-h"};
        EasyCli cli = new EasyCli(args, getOptions4());
        if (!cli.matchAllArgs()) {
            EasyCli.Synopsis synop = cli.new Synopsis("<filename>");
            synop.print();
        }
    }

    private CmdOptions getOptions4() {
        Arg config = Arg.with()
                .longOptionName("file")
                .shortOptionName("f")
                .argName("file_path")
                .description("This represents the file path")
                .required()
                .alias("config")
                .build();
        Flag ver = Flag.with()
                .longOptionName("debug")
                .shortOptionName("d")
                .description("Enable debug")
                .optional()
                .alias("verbose")
                .build();
        return new CmdOptions(config, ver);
    }

    @Test
    @DisplayName("Test has method for EasyCli")
    void testHasMethod() {
        String[] args = {"--file", "/dev/null", "-d"};
        EasyCli cli = new EasyCli(args, getOptions4());
        if (!cli.matchAllArgs()) {
            EasyCli.Synopsis synopsis = cli.new Synopsis("easport");
            synopsis.print();
        }
        Assertions.assertTrue(cli.has("config"));
        Assertions.assertTrue(cli.has("verbose"));
        Assertions.assertFalse(cli.has("sldkfjsl;dkj"));
        Assertions.assertFalse(cli.has("skjfhalskjfhalsdkjfhl"));
        Assertions.assertFalse(cli.has("file"));
    }

    @Test
    @DisplayName("Test get method")
    void testGetMethod() {
        String[] args = {"--file", "/dev/null", "-d"};
        EasyCli cli = new EasyCli(args, getOptions4());
        if (!cli.matchAllArgs()) {
            EasyCli.Synopsis synopsis = cli.new Synopsis("easport");
            synopsis.print();
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> cli.get("verbose"));
        Assertions.assertEquals("/dev/null", cli.get("config"));
        Assertions.assertNull(cli.get("asdfaskdjas"));
    }



    @Test
    @DisplayName("Test CmdOptions class")
    void checkCmdOptionsEverythingSuccessful() {
        CmdOptions opt = getOptions();
        Assertions.assertTrue(opt.hasOption("version", "v"));
        Assertions.assertTrue(opt.hasOption("version", "v", "Get version"));
        Assertions.assertTrue(opt.hasOption("verbose", "o", "Get version"));
        Assertions.assertFalse(opt.hasOption("eewtre", "o"));
        Assertions.assertFalse(opt.hasOption("config", "c", "gjkrwlrejgwl;erk"));
    }

    @Test
    @DisplayName("If there are duplicate options, do not add the newer one")
    void checkDuplicateOptionsCmdOptionsClass() {
        Assertions.assertThrows(IllegalArgumentException.class, this::getDuplicateOptions);
        Assertions.assertThrows(IllegalArgumentException.class, this::getDuplicateOptions2);
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

    private CmdOptions getOptions() {

        Arg config = Arg.with()
                .longOptionName("config")
                .shortOptionName("c")
                .argName("file path")
                .description("Configuration file path")
                .required()
                .alias("configuration")
                .build();

        Flag ver = Flag.with()
                .longOptionName("version")
                .shortOptionName("v")
                .description("Get version")
                .optional()
                .alias("version")
                .build();

        Flag verbose = Flag.with()
                .longOptionName("verbose")
                .shortOptionName("o")
                .description("Get version")
                .optional()
                .alias("verbose")
                .build();

        CmdOptions options = new CmdOptions(config, ver, verbose);
        return options;
    }

    private CmdOptions getDuplicateOptions() {

        Arg config = Arg.with()
                .longOptionName("config")
                .shortOptionName("c")
                .argName("file path")
                .description("Configuration file path")
                .required()
                .build();

        Arg config2 = Arg.with()
                .longOptionName("config")
                .shortOptionName("c")
                .argName("fsdflgsd")
                .description("sdflgsdjsdf;")
                .required()
                .build();

        Flag ver = Flag.with()
                .longOptionName("version")
                .shortOptionName("v")
                .description("Get version")
                .optional()
                .build();

        Flag verbose = Flag.with()
                .longOptionName("verbose")
                .shortOptionName("o")
                .description("Get version")
                .optional()
                .build();

        CmdOptions options = new CmdOptions(config, config2, ver, verbose);
        return options;
    }

    private CmdOptions getDuplicateOptions2() {

        Arg config = Arg.with()
                .longOptionName("config")
                .shortOptionName("c")
                .argName("file path")
                .description("Configuration file path")
                .alias("configuration")
                .required()
                .build();

        Arg config2 = Arg.with()
                .longOptionName("config")
                .shortOptionName("c")
                .argName("fsdflgsd")
                .description("sdflgsdjsdf;")
                .required()
                .alias("configuration2")
                .build();

        Flag ver = Flag.with()
                .longOptionName("version")
                .shortOptionName("v")
                .description("Get version")
                .optional()
                .alias("config")
                .build();

        Flag ver2 = Flag.with()
                .longOptionName("version")
                .shortOptionName("vava")
                .description("Get version")
                .optional()
                .alias("asdasdasd")
                .build();

        Flag verbose = Flag.with()
                .longOptionName("verbose")
                .shortOptionName("o")
                .description("Get version")
                .optional()
                .alias("verbose")
                .build();

        CmdOptions options = new CmdOptions(config, config2, ver, ver2, verbose);
        return options;
    }

}


//https://stackoverflow.com/questions/9725675/is-there-a-standard-format-for-command-line-shell-help-text
//http://www.tfug.org/helpdesk/general/man.html

// TODO: limit description to 100 characters