# Adobe Experience Manager Experiment

[![Build Status](https://travis-ci.com/RyanFleck/aem-experiment.svg?branch=master)](https://travis-ci.com/RyanFleck/aem-experiment)

**Goal:** Using **AEM Project Archetype 15** create, build and serve an AEM site.

Original maven init suggestion:
```
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate -DarchetypeGroupId=com.adobe.granite.archetypes -DarchetypeArtifactId=aem-project-archetype -DarchetypeVersion=15 -DarchetypeCatalog=https://repo.adobe.com/nexus/content/groups/public/
```

Windows cannot seem to execute this, so I had to run the following then manually select all the corrrect options. It did work, in the end.
```
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate -DarchetypeCatalog=https://repo.adobe.com/nexus/content/groups/public/
```

After the maven project was set up, this ran with no problems:
```
mvn -PautoInstallPackage -Padobe-public clean install
```

**Build fails.**
```
[INFO] Reactor Summary:
[INFO]
[INFO] aem-rcf-experiment 0.0.1-RCF-SNAPSHOT .............. SUCCESS [  0.617 s]
[INFO] AEM Experiment - Core .............................. SUCCESS [  8.540 s]
[INFO] AEM Experiment - UI apps ........................... FAILURE [ 17.760 s]
[INFO] AEM Experiment - UI content ........................ SKIPPED
[INFO] AEM Experiment - Integration Tests Bundles ......... SKIPPED
[INFO] AEM Experiment - Integration Tests Launcher 0.0.1-RCF-SNAPSHOT SKIPPED
```

**Resources:**

1. Tutorial overview - <https://helpx.adobe.com/experience-manager/kt/sites/using/getting-started-wknd-tutorial-develop.html>
2. Tutorial source code - <https://github.com/Adobe-Marketing-Cloud/aem-guides-wknd/blob/master/README.md>

AEM Notes <https://ryanfleck.github.io/aem>

Original Maven test repo: <https://github.com/RyanFleck/java-maven-travis-test>

<br />

<br />

_The following was the default README for the new maven project._

# Sample AEM project template

This is a project template for AEM-based applications. It is intended as a best-practice set of examples as well as a potential starting point to develop your own functionality.

## Modules

The main parts of the template are:

* core: Java bundle containing all core functionality like OSGi services, listeners or schedulers, as well as component-related Java code such as servlets or request filters.
* ui.apps: contains the /apps (and /etc) parts of the project, ie JS&CSS clientlibs, components, templates, runmode specific configs as well as Hobbes-tests
* ui.content: contains sample content using the components from the ui.apps
* ui.tests: Java bundle containing JUnit tests that are executed server-side. This bundle is not to be deployed onto production.
* ui.launcher: contains glue code that deploys the ui.tests bundle (and dependent bundles) to the server and triggers the remote JUnit execution

## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

If you have a running AEM instance you can build and package the whole project and deploy into AEM with

    mvn clean install -PautoInstallPackage

Or to deploy it to a publish instance, run

    mvn clean install -PautoInstallPackagePublish

Or alternatively

    mvn clean install -PautoInstallPackage -Daem.port=4503

Or to deploy only the bundle to the author, run

    mvn clean install -PautoInstallBundle

## Testing

There are three levels of testing contained in the project:

* unit test in core: this show-cases classic unit testing of the code contained in the bundle. To test, execute:

    mvn clean test

* server-side integration tests: this allows to run unit-like tests in the AEM-environment, ie on the AEM server. To test, execute:

    mvn clean verify -PintegrationTests

* client-side Hobbes.js tests: JavaScript-based browser-side tests that verify browser-side behavior. To test:

    in the browser, open the page in 'Developer mode', open the left panel and switch to the 'Tests' tab and find the generated 'MyName Tests' and run them.


## Maven settings

The project comes with the auto-public repository configured. To setup the repository in your Maven settings, refer to:

    http://helpx.adobe.com/experience-manager/kb/SetUpTheAdobeMavenRepository.html
