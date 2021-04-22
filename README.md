[![GitHub contributors](https://img.shields.io/github/contributors/egehurturk/EasyCLI)](https://GitHub.com/egehurturk/EasyCLI/graphs/contributors/)&nbsp;&nbsp;&nbsp;
[![Forks](https://img.shields.io/github/forks/egehurturk/easycli?color=green)](https://img.shields.io/github/forks/egehurturk/easycli?color=green)
&nbsp;&nbsp;&nbsp;
[![Stargazers](https://img.shields.io/github/stars/egehurturk/easycli?color=green)](https://img.shields.io/github/stars/egehurturk/easycli?color=green&style=plastic)
&nbsp;&nbsp;&nbsp;
[![Issues](https://img.shields.io/github/issues/egehurturk/EasyCLI)](https://GitHub.com/egehurturk/EasyCLI/issues/)
&nbsp;&nbsp;&nbsp;
![example workflow](https://github.com/egehurturk/EasyCLI/actions/workflows/main.yml/badge.svg)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/egehurturk/EasyCLI.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/egehurturk/EasyCLI/context:java)
![release shield](https://img.shields.io/github/v/release/egehurturk/easycli)

<!-- PROJECT LOGO -->
<br>
<p align="center">

   <a href="https://github.com/egehurturk/EasyCLI">
    <img src="external/EasyCLI.png" alt="Banzai Logo" width="200" height="200">
  </a>
  <h2 align="center">EasyCLI</h2>

  <p align="center">
    A command line argument parser utility for Java 
    <br />
    <a href="https://github.com/egehurturk/EasyCli/tree/main/docs"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/egehurturk/EasyCli/issues">Report Bug</a>
    ·
    <a href="https://github.com/egehurturk/EasyCli/issues">Request Feature</a>
  </p>
</p>


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About the Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



## About the Project
EasyCli is a light-weight command line argument parser for Java. 

### Built With
* Java

## Getting Started



These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


### Prerequisites
You need to have Java and Maven installed on your local machine. 

### Installation
These steps will install EasyCli on your local machine:

1. Clone this repository:

```bash
$ git clone https://github.com/egehurturk/EasyCLI.git
```

2. Install the project (`pom.xml`) into local maven repository. 
   *  This step will install the `JAR`  and `pom.xml`  files to `~/.m2/repository/`

```bash
$ cd EasyCLI
$ ./mvnw package
$ mvn install
```

3. Add the following dependency to your Maven generated project:

```xml
<dependencies>
  <!-- Add this snippet under <dependencies> in pom.xml -->
    <dependency>
       <groupId>com.easycli</groupId>
       <artifactId>EasyCLI</artifactId>
       <version>1.0</version>
    </dependency>
</dependencies>
```

4. Use the API!


<!-- USAGE EXAMPLES -->
## Usage

You can create command line arguments and flags with EasyCli API:

### `Arg`
```java
Arg directory = Arg.with()
          .longOptionName("directory")
          .shortOptionName("d")
          .argName("project_dir")
          .description("Maven generated project path")
          .required()
          .alias("dir")
          .build();
```
* **`longOptionName(String)`**: sets the long name, i.e., the name that will be visible with `--` prefix. For instance, if you set it as `directory`, then it will be accessed with `--directory`.
* **`shortOptionName(String)`**: sets the short name, i.e., the name that will be visible with `-` prefix. For instance, if you set is as `d`, then it will be accessed with `-d`.
* **`argName(String)`**: sets the argument name that will be displayed in the help message. 
* **`description(String)`**: sets the description for the argument and will be displayed in the help message.
* **`required()`:** marks the `Arg` as required. The opposite method is **`optional()`**, which marks the `Arg` as optional.
* **`alias(String)`**: gives an alias value for the argument. This value is used to retrieve the value of an `Arg`.
* **`build()`**: builds the `Arg`
  
The code above will create an `Arg`. An `Arg` in a command line is a special parameter that has a value. For instance:
```bash
$ ./executable --directory /dev/null
```
Here, the `--directory` is defined as an `Arg`, which has a value after the flag. 



### `Flag`
```java
Flag version = Flag.with()
          .longOptionName("version")
          .shortOptionName("v")
          .description("Get the latest version")
          .optional()
          .alias("version")
          .build();
```
* **`longOptionName(String)`**: sets the long name, i.e., the name that will be visible with `--` prefix. For instance, if you set it as `version`, then it will be accessed with `--version`.
* **`shortOptionName(String)`**: sets the short name, i.e., the name that will be visible with `-` prefix. For instance, if you set is as `v`, then it will be accessed with `-v`.
* **`description(String)`**: sets the description for the argument and will be displayed in the help message.
* **`optional()`:** marks the `Flag` as required. The opposite method is **`required()`**, which marks the `Flag` as optional.
* **`alias(String)`**: gives an alias value for the argument. 
* **`build()`**: builds the `Flag`


The code above will create a `Flag`. A `Flag` is a command line parameter that does not have a value. For instance,
```bash
./executable --version
```
Here, the `--version` is defined as a `Flag`, which does not have a value and is an indicator.

### `CmdOptions`
`CmdOptions` is a class that stores `Arg`s and `Flag`s. You can create a new `CmdOptions` with either:
```java
CmdOptions options = new CmdOptions(arg1, flag1, /*...*/);
```
or
```java
CmdOptions options = new CmdOptions();
options.add(arg1);
options.add(flag1);
//...
```

### `EasyCli`
This class is the main class that provides methods to check and retrieve command line arguments. You can create a new `EasyCli` with:
```java
 EasyCli cli = new EasyCli(args, options);
```
* `args` is the argument array. This must be the parameter of the main method: `public static void main(String[] args)`
* `options` is the `CmdOptions` class that stores `Arg`s and `Flag`s

`EasyCli` class provides a method to check if all required `Arg`s and `Flag`s exist in the `args` array. This method is `matchAllArgs` and returns a boolean:
```java
boolean success = cli.matchAllArgs();
```
* A typical usage of this method is to print the help message when required parameters do not exist in the array:
  ```java
   if (!cli.matchAllArgs()) {
      EasyCli.Synopsis helper = cli.new Synopsis("<exec_name>");
      helper.print();
  }
  ```

You can check if a parameter (an `Arg` or a `Flag`) exists with the `has(String)` method. The method accepts the **alias** value set for the particular parameter:
```java
boolean versionExists = cli.has("version");
```
* Here, the `"version"` is the alias name

You can get **`Arg`** values with the `get(String)` method. The method accepts the **alias** value set for an `Arg`:
```java
String dirValue = cli.get("dir");
```
* If a `Flag` alias is given, then the method throws `IllegalArgumentException`
* If the `Arg` with the given alias is not found, the return value will be `null`.
  * You can combine `has(String)` and `get(String)`:
    ```java
    if (cli.has("dir")) 
        String dir = cli.get("dir");
    ```
    * This will prevent `dir` from being `null`.

#### `EasyCli.Synopsis`
This class provides a method to print the synopsis of the given `CmdOptions` object. You can instantiate this class with:
```java
EasyCli.Synopsis synopsis = cli.new Synopsis("<executable>");
```
* `"<executable>"` is the name of the executable you are running. 

You can print the help message with the `print()` method:
```java
synopsis.print();
```

This will produce an output like:
```
Usage: <executable> -d|--dir <project_dir> [-v|--version] [-h|--help]
	-d|--directory <project_dir>              Maven generated project
	-v|--version                              Get the latest version
	-h|--help                                 Print this message
```
* `[]` indicates that the value is optional. 
* `|` is a separator for mutually exclusive items; choose one
* `<>` is a placeholder for which you must supply a value

The recommended way to use `EasyCli` is like this:
```java
EasyCli cli = new EasyCli(args, options /* CmdOptions object */);
if (!cli.matchAllArgs()) {
    EasyCli.Synopsis help = cli.new Synopsis("<exec_name>");
    help.print();
    System.exit(1);
}
String dirVal = cli.get("dir");
//...
```


<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/egehurturk/EasyCLI/issues) for a list of proposed features (and known issues).



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Your Name - [@egehurturk](https://twitter.com/egehurturk) - ege.hurturk@gmail.com

Project Link: [https://github.com/egehurturk/EasyCli](https://github.com/egehurturk/EasyCli)



<!-- ACKNOWLEDGEMENTS -->





<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
