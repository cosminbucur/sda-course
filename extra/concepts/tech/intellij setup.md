# setup intellij

## plugins

- sonarlint
- .ignore
- diagrams.net

## visuals

- enable the toolbar

        View > Appearance > check Toolbar

- enable zoom on text

        File > Settings > Editor > General > check Change font size (Zoom)

- add assertj import to all test files

        File > Settings > Editor > File and Code Templates > Code
        select Junit5TestClass
        add at the top: 
            import static org.assertj.core.api.Assertions.assertThat;
