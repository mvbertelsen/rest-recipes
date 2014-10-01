
Dependencies you must install by hand:

Gradle: http://www.gradle.org/
Git/Git Bash: http://git-scm.com/
Node.js and npm:  http://nodejs.org/
Google Chrome: https://www.google.com/chrome/browser/
Bower: http://bower.io/

I run all this on windows with IntelliJ 13.1.5 Community edition.
It probably won't be too hard to add the eclipse plugin to build.gradle and use it to gen eclipse files.

Useful gradle tasks:

gradle tasks - lists the tasks
gradle test - runs unit tests
gradle functional - runs selenium and rest client tests against the app running in a jetty server
gradle startServer - runs the app in jetty so you can use it (blocks)
gradle idea - re-gens intellij project files if you changed the classpath/dependencies
gradle jshint - runs jshint javascript linter
gradle karma - runs karma javascript tests
