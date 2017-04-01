<?php $toRoot="../../";?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	
<html>
<head>
<?php include $toRoot.'styles/style.php'; ?>

<script type="text/javascript" src=<?php echo $toRoot."javascript/navBar.js" ?> ></script>


<title>
Welcome to ThePaulFoley
</title>
</head>

<body>

<div id="wrapperDiv" class="wrapper">

<div id="bannerOuterDiv" class="bannerOuterDiv">
<?php 
include $toRoot.'php/header/logo.php';
include $toRoot.'php/header/namePlate.php';
include $toRoot.'php/header/navBarArticles.php';
?>
</div>

<div id="contentDiv" class="contentDiv">


<div id="phpIncludeTitleDiv" class="articleTitleDiv">PHP - Including Files From Different Directories</div>
<br>
<br>
<div>When developing this site, I ran into an issue with the 
<a href="http://php.net/manual/en/function.include.php" class="link" target="_blank">include</a>
 function in PHP. The include function allows you to insert the contents of one file into a PHP file. This is 
 helpful for reusing chunks of code. For example, each page on this site reuses the same code to put the logo
 in the top left corner of the header. Below is a subset of the file structure for this site. At the top 
 level, or the root level, we have index.php which is the Home page. We also have directories for our php 
 files and our image files. In the file structure below, logo.php is included by index.php, articles.php,
  breaking_things.php and php_include.php.</div>
 <br>
 <br>
 <img src=<?php echo $toRoot."img/php_include/file_structure.PNG"?> width="281px" height="238px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Originally, I designed logo.php as shown below. Notice that there is a relative path on line 2 and 
line 3. If you check these paths against the file structure above, you can see that they are correct. The 
problem I had is that anytime I included logo.php into index.php, the logo would not show up. This is 
because, in PHP, when you include one file, say file A into another file, say file B, it's as if the 
contents of A are copied and pasted into B. Since, index.php is in a different directory than logo.php, the 
relative paths from logo.php are now incorrect when it's included in index.php. </div>
<br>
<br>
<div style="background:#FFFFFF; width:600px; margin-left:auto; margin-right:auto; color:#000000;">
<code>
	&lt;div id="bannerLogoDiv" class="bannerLogoDiv"&gt;
	<br>
	&lt;a id="logoLink" class="plain" href="../../index.php" &gt;
	<br>
	&lt;img id="logoImg" src="../../img/thepaulfoleylogo.bmp" width="75px" height="100px" border="0"/&gt;
	<br>
	&lt;/a&gt;
	<br>
	&lt;/div&gt;
</code>
</div>
<br>
<br>
<div>To solve this problem I added a PHP variable called <code>$toRoot</code> in every file that included
another file. The variable <code>$toRoot</code> is a relative path to the root directory, in this case the top
level directory called thepaulfoley. So, since index.php is in the root directory, <code>$toRoot</code>  would be 
an empty string. In articles.php, breaking_things.php and php_include.php, <code>$toRoot</code> would 
equal "../../". Then in any file that was included by another file, all relative paths were based on the 
<code>$toRoot</code> variable. So, logo.php was rewritten as shown below. The changes made are shown in red.
You can see that now the relative paths are based on the <code>$toRoot</code> variable.</div>
<br>
<br>
<div style="background:#FFFFFF; width:750px; margin-left:auto; margin-right:auto; color:#000000;">
<code>
	&lt;div id="bannerLogoDiv" class="bannerLogoDiv"&gt;
	<br>
	&lt;a id="logoLink" class="plain" href=<span style="color:red">&lt;?php echo $toRoot."index.php" ?&gt; </span> &gt;
	<br>
	&lt;img id="logoImg" src=<span style="color:red">&lt;?php echo $toRoot."img/thepaulfoleylogo.bmp" ?&gt;</span> width="75px" height="100px" border="0"/&gt;
	<br>
	&lt;/a&gt;
	<br>
	&lt;/div&gt;
	<br>
</code>
</div>
<br>
<br>
<div>To summarize, if you are including files from different directories you can eliminate problems with
relative paths by doing the following. In each file that includes another file, add a variable 
<code>$toRoot</code> whose value is the relative path to the root directory. Then, in each file that is 
included by another file, base all relative paths on the <code>$toRoot</code> variable. Finally, you may
 be wondering why I didn't just avoid these troubles by using absolute paths instead of relative paths. 
 The reason is that I host this site on a third-party server. I have a working copy of the code on my 
 local machine. When I make changes, I make them locally, test them and then upload them to the server. 
 By using relative paths, I don't have to make any changes to the code when going from my local machine 
 to the server or vice-versa.</div>

<br>

</div>

<?php 
include $toRoot.'php/footer/footer.php';
?>

</div>





</body>

</html>