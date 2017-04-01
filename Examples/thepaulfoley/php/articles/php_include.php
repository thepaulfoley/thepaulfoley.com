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
 in the top left corner of the header.</div>

</div>

<?php 
include $toRoot.'php/footer/footer.php';
?>

</div>





</body>

</html>