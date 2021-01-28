# Markdown

##Table des matiéres
[TOC levels=1-4 bullet hierarchy numbered]

Retour vers [README](../README.md)

# Usage

C.f. [markdown-page-generator-plugin](https://github.com/vsch/markdown-page-generator-plugin "markdown")

## Utilisation Markdown Maven plugin

```xml
<plugin>
  <groupId>com.vladsch.flexmark</groupId>
  <artifactId>markdown-page-generator-plugin</artifactId>
  <version>0.18.2</version>
  <executions>
    <execution>
      <id>generate-docs</id>
      <goals>
        <goal>generate</goal>
      </goals>
      <phase>install</phase>
    </execution>
  </executions>
  <configuration>
    <alwaysUseDefaultTitle>true</alwaysUseDefaultTitle>
    <copyDirectories>css,images</copyDirectories>
    <defaultTitle>Titre par dï¿½faut</defaultTitle>
    <footerHtmlFile>doc/footer.html</footerHtmlFile>
    <headerHtmlFile>doc/header.html</headerHtmlFile>
    <inputDirectory>doc</inputDirectory>
    <inputEncoding>${project.build.sourceEncoding}</inputEncoding>
    <outputDirectory>target/doc/html/generated2</outputDirectory>
    <outputEncoding>${project.build.sourceEncoding}</outputEncoding>
    <pegdownExtensions>AUTOLINKS,ANCHORLINKS,EXTANCHORLINKS,INSERTED,FENCED_CODE_BLOCKS,FOOTNOTES,TABLES,TOC</pegdownExtensions>
  </configuration>
</plugin>
```

Modification d'attributs dans la section configuration...

```xml
<configuration>
	<attributes>
		<attribute>TableBlock|style="border-collapse:collapse;"</attribute>
		<attribute>TableHead|style="border:1px solid black;"</attribute>
		<attribute>TableRow|style="border:1px solid black;"</attribute>
		<attribute>TableCell|style="border:1px solid black;"</attribute>
		<attribute>BlockQuote|style="color:blue;border-left: .5em solid #eee;padding: 0 1em;"</attribute>
		<attribute>OrderedListItem|style="color:red;"</attribute>
		<attribute>Code|style="color:blue;"</attribute>
	</attributes>
</configuration>
```

Ou en utilisant des fichiers CSS:

> TableBlock attribute overrides provided markdown.css
```java
table {
	border-collapse: collapse;
}
```

### Doc/header.html

```html
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>titleToken</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="css/markdown5.css">
 </head>
 ```

### doc/footer.html

```html
<footer>
	<img alt="logo" src="images/logo.gif">
	Mes projets, mes tests
</footer>
</html>
```

### CSS file css/markdown5.css

Extract from CSS file

```css
body {
	margin: 0 auto;
	background-color: white;
	font-family: Georgia, Palatino, serif;
	color: #333333; /* dark gray not black */
	line-height: 1;
	max-width: none;
	padding: 30px;
	font-size: 18px;
	counter-reset: h1counter h2counter h3counter;
}

footer {
	position: relative;
	margin-top: 25px;
	bottom: 0px;
	width: 100%;
	background-color: #c0c0c0;
	display: table;
}

h1 {
	font-size: 300%;
	padding: 0px;
	font-variant: small-caps;
	page-break-before: always;
	border-bottom: 8px solid #B60050;
	counter-reset: h2counter h3counter;
}

h2 {
	font-size: 150%/margin: 24px 0 6px;
	border-bottom: 2px solid #B60050;
}

h3 {
	font-size: 120%;
	border-bottom: 1px solid #B60050;
}

h4 {
	font-size: 100% font-variant:small-caps;
}

h5 {
	font-size: 80% font-weight: 100;
}

h6 {
	font-size: 80% font-weight: 100;
	color: red;
	font-variant: small-caps;
}

pre {
	white-space: nowrap;
	white-space: -moz-pre-wrap;
	white-space: -o-pre-wrap;
	-moz-tab-size: 2; /* tab-size code for Firefox */
	-o-tab-size: 2; /* tab-size code for Opera */
	tab-size: 2;
}

code {
	display: block;
	background: #EEE;
	border-color: black;
	border-style: solid;
	border-radius: 5px;
	border-width: thin;
	font-family: Consolas, Monaco, Andale Mono, monospace;
	line-height: 1.5;
	font-size: 13px;
	white-space: pre-wrap;
	padding: 0.5em 1em;
}

blockquote p {
	/* color: #666; */
	max-width: none;
}

hr {
	text-align: left;
	margin: 0 auto 0 0;
	color: #999;
	width: auto;
}
```

## MD file

### Quote

> Quote

```
> Quote
```


### Underline (inserted)
++inserted++

~~~
++inserted++
~~~

### HTML integration

```html
<div>
	<hr/>
		<p>This paragraph has a footnote<sup id="fnref-1"><a href="#fn-1" class="footnote-ref">1</a></sup> and another footnote<sup id="fnref-2"><a href="#fn-2" class="footnote-ref">2</a></sup>.</p>
		<p>This one has more but out of sequence<sup id="fnref-3"><a href="#fn-3" class="footnote-ref">3</a></sup> and<sup id="fnref-4"><a href="#fn-4" class="footnote-ref">4</a></sup>. </p>
	<hr/>
	<div class="footnotes">
		<ol style="list-style-type: decimal;">
			<li id="fn-1"><p>Footnote 1<a href="#fnref-1" class="footnote-backref">&#8617;</a></p></li>
			<li id="fn-2"><p>Footnote 2 with a bit more text  and another continuation line<a href="#fnref-2" class="footnote-backref">&#8617;</a></p></li>
			<li id="fn-3"><p>Out of sequence footnote<a href="#fnref-3" class="footnote-backref">&#8617;</a></p></li>
			<li id="fn-4"><p>Have one that is used.<a href="#fnref-4" class="footnote-backref">&#8617;</a></p></li>
		</ol>
	</div>
</div>
```

<div>
	<hr/>
		<p>This paragraph has a footnote<sup id="fnref-1"><a href="#fn-1" class="footnote-ref">1</a></sup> and another footnote<sup id="fnref-2"><a href="#fn-2" class="footnote-ref">2</a></sup>.</p>
		<p>This one has more but out of sequence<sup id="fnref-3"><a href="#fn-3" class="footnote-ref">3</a></sup> and<sup id="fnref-4"><a href="#fn-4" class="footnote-ref">4</a></sup>. </p>
	<hr/>
	<div class="footnotes">
		<ol style="list-style-type: decimal;">
			<li id="fn-1"><p>Footnote 1<a href="#fnref-1" class="footnote-backref">&#8617;</a></p></li>
			<li id="fn-2"><p>Footnote 2 with a bit more text  and another continuation line<a href="#fnref-2" class="footnote-backref">&#8617;</a></p></li>
			<li id="fn-3"><p>Out of sequence footnote<a href="#fnref-3" class="footnote-backref">&#8617;</a></p></li>
			<li id="fn-4"><p>Have one that is used.<a href="#fnref-4" class="footnote-backref">&#8617;</a></p></li>
		</ol>
	</div>
</div>

### Table

| Column 1 title | Column 2 title | Column 3 title | Column 4 title |
| --- | :--- | :--- | :--- |
| Column 1 line 1 | Column 2 line 1  [(1)](#1) | Column 3 line 1  [(2)](#2) | Column 4 line 1  [(3)](#3) |
| Column 1 line 2 | Column 2 line 2 | Column 3 line 2 | Column 4 line 2 |
| Column 1 line 3 | Column 2 line 3 | Column 3 line 3 | Column 4 line 3 |


###### (1)
Marker 1 :+1:
Bla bla bla

###### (2)
Marker 2
Bla bla bla

###### (3)
Marker 3
Bla bla bla

### Footnote

Footnote[^1] always appear at the end of document

~~~
Footnote[^1] example

[^1]: Foot note text
Bla bla bla
~~~

[^1]: Foot note text
Bla bla bla

Return to [Table des matiéres](Table des matiéres)


