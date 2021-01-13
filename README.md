# MesProjets

Tests Git et bidouilles

## [MonProjetTestSwing](Tests/MonProjetTest/LisMoi.md)

## [MonProjetTest2](Tests/MonProjetTest2/LisMoi.md)

## [TestServlet](Tests/TestServlet/LisMoi.md)

## [TestStruts](Tests/TestStruts/LisMoi.md)

## [TestWeb](Tests/TestWeb/LisMoi.md)

# Eclipse

Lancement depuis MesProjets: Eclipse.bat  
Utilise MonEclipse.ini

Windows / preferences / Import: EclipsePreferences.epf

Windows / preferences / Java / Code Style
+ Code Templates: importer codetemplate.xml
+ Formatter: sélectionner JavaCodeFormatter

## Dans Java Installed JREs ajouter JDK 11

(e.g. E:\Java\jdk-11.0.8.10-hotspot)

## Détails

Windows / Preferences / General / Startup and Shutdown
+ Workspace: cocher Show full workspace path

Windows / Preferences / General / Editors / Text editors / Spelling:
+ Encoding: Other UTF-8

Windows / Preferences / General / Workspace:
+ Text file encoding Other: UTF-8
+ New text file line delimiter Other: Unix

Windows / Preferences / Java / Code Style / Formatter:
+ importer JavaCodeFormatter.xml

### Créer JavaCodeFormatter depuis Eclipse built-in et modifier:

Indentation  
+ Tab size: 3

Line Wrapping  
+ Maximum line width: 120

Off/On Tags  
+ Enable Off/On tags

### Paramétrer Java / Editor / Save Actions

+ Format edited lines
+ Organize imports
 
### Java / Code Style / Code template

Check box: Enable project specific settings

+ Comments / Files

```
/*
* Copyright (c) 2021. Geairare - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited. It is proprietary and confidential.
* Author : ${user} ${email:git_config(user.email)} on ${date}
*/
```

# Markdown


# Maven releases

[LisMoi](Doc/LisMoi.md)