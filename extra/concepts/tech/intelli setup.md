# setup intellij

## plugins

- sonarlint - find and fix bugs as you type
- .ignore - ignore files for git
- key promoter x - learn shortcuts
- diagrams.net - draw diagrams

## visuals

- enable the toolbar

        View > Appearance > check Toolbar

- enable zoom on text

        File > Settings > Editor > General > check Change font size (Zoom)

- colored text

        File > Settings > Editor > Color Scheme > check Semantic highlighting

- add assertj import to all test files

        File > Settings > Editor > File and Code Templates > Code
        select Junit5TestClass
        add at the top: 
            import static org.assertj.core.api.Assertions.assertThat;

## git

- commit strategy

        File > Settings > Version Control > Commit
        in the Before Commit section check
        - reformat code
        - rearrange code
        - optimize imports

## code templates

- add assertj import to all test files

        File > Settings > Editor > File and Code Templates > Code
        select Junit5TestClass
        add at the top: 
            import static org.assertj.core.api.Assertions.assertThat;

## live templates

- add log entry with shortcut `pslog`

      File > Settings > Editor > Live Templates
      
      add template (+ button)
      select Live Template
      add code:
      
      private static final Logger log = LoggerFactory.getLogger($CLASSNAME$.class);

      abbreviation: pslog
      description: private static log
      applicable in java: declaration

      edit variables > expression > className() 