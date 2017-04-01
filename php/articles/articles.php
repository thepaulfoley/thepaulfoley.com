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
<a class="link" href="breaking_things.php">Breaking Things is Just More Fun</a> - This is a modified version of a presentation I gave in college. It is a brief introduction to four types of network attacks.  
<br>
<br>
<a class="link" href="php_include.php">PHP - Including Files From Different Directories</a>
<br>
<br>
<a class="link" href="css_php.php">CSS Variables With PHP</a>
<br>
<br>
<br>
<br>
<br>
<br>

</div>

<?php 
include $toRoot.'php/footer/footer.php';
?>

</div>





</body>

</html>