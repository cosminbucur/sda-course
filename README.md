# Group XX

## 1. Project structure
The project contains multiple sub-modules, each with a similar structure:

        module name (ex: java-advanced)
            scr.main.java.com.sda.advanced (packages)
                topic (ex: collections)
                    subtopic (ex: map)
                        code examples

## 2. Modules

## java core
- fundamentals
- testing
- java-advanced
- design-patterns

## persistence
- sql
- jdbc
- hibernate
- spring-data-jpa

## spring
- spring-core
- parent-boot-2
- spring-boot

## web
- spring-thymeleaf
- spring-boot-rest

## security
- spring-security-memory
- spring-security-jpa-mysql
- spring-security-thymeleaf

## testing
- testing-advanced

---

## 3. Extra materials

- extra/`concepts`

  lists with all the essentials concepts you need to know in order

- extra/concepts/tech/`intellij.md`

  essential operations with intellij

- extra/concepts/tech/`intellij-setup.md`

  essential plugins and settings for intellij

- extra/concepts/tech/`intellij-shortcuts.md`

  essential shortcuts for intellij

- extra/`diagrams`

  diagrams that put concepts into context. visual representation help you remember

- extra/`samples`

  sample properties files for various types of projects

## 4. How to set up your local environment

In order to work easily with this, you need the following setup:

- create a new folder on the drive where you keep your data `D:\dev`


- open terminal in `D:\dev` folder like so:

      go to `D:\dev` and right click > select Git Bash here (or terminal)


- clone my project `sda-group22` with the command:

        git clone https://github.com/cosminbucur/sda-groupXX

  You will update this project regularly since the trainer will push code changes
  after each training day, in case you get behind during training.


- clone the sample project `sda-course-sample` with this command:

      git clone https://github.com/cosminbucur/sda-course-sample

  From this project you can grab pom files and copy the packages for each module.


If you did everything right, you should have the following:

    D:\dev
        sda-course        
        sda-course-sample
        sda-groupXX

- open my project in intellij:

      open project C:\dev\sda-groupXX
      check auto import
      wait 5 minutes for intellij to download dependencies and index files

- create your own project `sda-course` at `D:\dev\sda-course`

  This is where you will write the code during training.


Congratulations! You have now started your developer journey.

Now get back to coding!
