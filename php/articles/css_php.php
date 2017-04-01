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


<div id="phpIncludeTitleDiv" class="articleTitleDiv">CSS Variables With PHP</div>
<br>
<br>
<div>Normally you define your CSS in a file, let's call it style.css, that looks something like the code below.  </div>
<br>
<br>
<div style="background:#FFFFFF; width:600px; margin-left:auto; margin-right:auto; color:#000000;">
<code>
div.small{<br>
font-size:12pt;<br>
color:#F3F3F3;<br>
}<br>
div.medium{<br>
font-size:18pt;<br>
color:#F3F3F3;<br>
}<br>
div.large{<br>
font-size:24pt;<br>
color:#F3F3F3;<br>
}<br>
</code>
</div>
<br>
<br>
<div>Then in your HTML files, you would inclde the style sheet with the following code in the header of 
the file.</div>
<br>
<br>
<div style="background:#FFFFFF; width:600px; margin-left:auto; margin-right:auto; color:#000000;">
<code>
&lt;head&gt;<br>
&lt;link rel="stylesheet" type="text/css" href="style.css" /&gt;<br>
&lt;/head&gt;<br>
</code>
</div>
<br>
<br>
<div>In style.css above, notice that div.small, div.medium, and div.large all have the same color. It
 might be nice to have a variable for the color. Therefore, if we wanted to change the color of all three
  divs we would only have to make a change in one place instead of three. To do this we create a PHP file
  called style.php. Below is the code for style.php.</div>
<br>
<br>
<div style="background:#FFFFFF; width:600px; margin-left:auto; margin-right:auto; color:#000000;">
<code>
&lt;?php <br>
$color="#F3F3F3"<br>
?&gt;<br>
<br>
&lt;style type="text/css"&gt;<br>
div.small{<br>
font-size:12pt;<br>
color:&lt;?php echo $color?&gt;;<br>
}<br>
div.medium{<br>
font-size:18pt;<br>
color:&lt;?php echo $color?&gt;;<br>
}<br>
div.large{<br>
font-size:24pt;<br>
color:&lt;?php echo $color?&gt;;<br>
}<br>
<br>
&lt;/style&gt;<br>

</code>
</div>

<br>
<br>
<div>Finally in your HTML files, you would inclde style.php instead of style.css with the following 
code in the header of the file.</div>
<br>
<br>
<div style="background:#FFFFFF; width:600px; margin-left:auto; margin-right:auto; color:#000000;">
<code>
&lt;head&gt;<br>
&lt;?php include 'style.php'; ?&gt;<br>
&lt;/head&gt;<br>
</code>
</div>

</div>

<?php 
include $toRoot.'php/footer/footer.php';
?>

</div>





</body>

</html>