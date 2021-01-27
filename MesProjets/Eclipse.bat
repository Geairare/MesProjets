set ECLIPSE_HOME=E:\Eclipses\eclipse-jee-2020-06-R-win32-x86_64\eclipse
set WORKSPACE=%CD%\..\..\EspaceDeTravailEclipse

set M2_HOME=E:\Maven\apache-maven-3.6.1
set M2_REPO=E:\Maven\repository
set JDK_HOME=E:\Java\jdk-11.0.2
set JAVA_HOME=%JDK_HOME%

set WILDFLY_HOME=E:\WildFly\wildfly-15.0.1.Final


set PATH=C:\Windows\system32;C:\Windows;%JAVA_HOME%\bin

start "Eclipse" "%ECLIPSE_HOME%\eclipse.exe" -clean --launcher.ini %CD%\MonEclipse.ini -data %WORKSPACE%
