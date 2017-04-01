<?php $toRoot="../../";?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	<html>
<head>
<?php include $toRoot.'styles/style.php'; ?>

<script type="text/javascript" src=<?php echo $toRoot."javascript/navBar.js" ?>></script>


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
include $toRoot.'php/header/navBarGames.php';
?>

</div>

<div id="contentDiv" class="contentDiv">
<div id="ticTacToeGameDiv" class="gameDiv">
<APPLET CODE="TicTacToe.class" CODEBASE=<?php echo $toRoot."games/TicTacToe/bin/" ?> WIDTH=600
	HEIGHT=600>This game was created with a Java Applet. Your browser does not support Applets.</APPLET>
</div>
</div>

<?php 
include $toRoot.'php/footer/footer.php';
?>

</div>





</body>

</html>