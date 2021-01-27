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

## Utiliser un Maven externe

(e.g. E:\Maven\apache-maven-3.6.1)

## Déclarer la clef SSH pour GitHub

Windows / Preferences / General / Network Connections / SSH2

SSH2 home: C:\User\Geairare\.ssh
Private keys: id_ed25519


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

# Trucs et Astuces

## Extraction GitHub en SSH

```
mkdir /home/moi

ssh-keygen -t ed25519 -C "gco.alias@laposte.net"

eval `ssh-agent -s`
ssh-add ~/.ssh/id_ed25519
clip < ~/.ssh/id_ed25519.pub
# Ajouter la clef sur GitHub


# Clone

git clone git@github.com:Geairare/MesProjets.git

```

Penser éventuellement à positionner

```
git config --local user.name "Geai rare"
git config --local user.email "gco.alias@laposte.net"
```

ou mettre à jour le fichier ~/.gitconfig

```
[user]
        name = Geai rare
        email = gco.alias@laposte.net
```


# Production release

Modifier le numéro de version des pom.xml:

```
mvn -s /e/Maven/settingsGeairare.xml -f MesProjets/pom.xml versions:set -DgenerateBackupPoms=false -DnewVersion=0.1.0-SNAPSHOT
```


```
cd MesProjets

export PATH=/c/Users/moi/bin:/mingw64/bin:/usr/local/bin:/usr/bin:/bin:/usr/bin:/e/Java/jdk-11.0.8.10-hotspot/bin:/e/Maven/apache-maven-3.6.1/bin

mvn -s /e/Maven/settingsGeairare.xml clean install

mvn -s /e/Maven/settingsGeairare.xml "-Darguments=-s E:\Maven\settingsGeairare.xml" release:prepare release:perform
```


# Markdown

[Markdown](Doc/doc/Markdown.md)
