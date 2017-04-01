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
include $toRoot.'php/header/navBarGames.php';
?>

</div>

<div id="contentDiv" class="contentDiv">
Note: These games were made using Java Applets. If they do not display, your browser may not support Applets.

<br /><br />

<div id="pongDiv" class="gameEntryDiv">
<div id="pongLogoDiv" class="gameLogoDiv">
<img src=<?php echo $toRoot."img/games/icon_pong.PNG" ?> width="50px" height="50px" />
</div>
<div id="pongDescriptionDiv" class="gameDescriptionDiv">
<b><a href="pong.php" class="link">Pong</a></b> - Enjoy a blast from the past with this arcade classic!
</div> 
</div>

<br /><br /><br /><br />

<div id="ticTacToeDiv" class="gameEntryDiv">
<div id="ticTacToeLogoDiv" class="gameLogoDiv">
<img src=<?php echo $toRoot."img/games/icon_ticTacToe.PNG" ?> width="50px" height="50px" />
</div>
<div id="ticTacToeDescriptionDiv" class="gameDescriptionDiv">
<b><a href="ticTacToe.php" class="link">Tic-Tac-Toe</a></b> - If you can beat the computer, you probably cheated.
</div> 
</div>

<br /><br /><br /><br />

<div id="goFishDiv" class="gameEntryDiv">
<div id="goFishLogoDiv" class="gameLogoDiv">
<img src=<?php echo $toRoot."img/games/icon_goFish.PNG" ?> width="50px" height="50px" />
</div>
<div id="goFishDescriptionDiv" class="gameDescriptionDiv">
<b><a href="goFish.php" class="link">Go Fish</a></b> - Got any 3's?
</div> 
</div>



</div>

<?php 
include $toRoot.'php/footer/footer.php';
?>

</div>





</body>

</html>