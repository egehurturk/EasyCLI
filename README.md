[![GitHub contributors](https://img.shields.io/github/contributors/egehurturk/EasyCLI)](https://GitHub.com/egehurturk/EasyCLI/graphs/contributors/)&nbsp;&nbsp;&nbsp;
[![Forks](https://img.shields.io/github/forks/egehurturk/EasyCLI?style=social&label=Fork&maxAge=2592000)](https://GitHub.com/egehurturk/EasyCLI/network/)
&nbsp;&nbsp;&nbsp;
[![Stargazers](https://img.shields.io/github/stars/egehurturk/EasyCLI?style=social&label=Star&maxAge=2592000)](https://GitHub.com/egehurturk/EasyCLI/stargazers/)
&nbsp;&nbsp;&nbsp;
[![Issues](https://img.shields.io/github/issues/egehurturk/EasyCLI)](https://GitHub.com/egehurturk/EasyCLI/issues/)
&nbsp;&nbsp;&nbsp;
![example workflow](https://github.com/egehurturk/EasyCLI/actions/workflows/main.yml/badge.svg)


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

`add usage here`



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
