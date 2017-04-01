<?php $toRoot="../../"; ?>

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
include $toRoot.'php/header/navBarContact.php';
?>

</div>

<div id="contentDiv" class="contentDiv">
<div id="contactSpacer1Div" class="contactSpacerDiv"></div>

<div id="emailDiv" class="contactMethodDiv" onclick="alert('Please direct emails to paul@thepaulfoley.com.')">
Send<br/>
<img src=<?php echo $toRoot."img/contact/email.PNG" ?> id="emailImg" class="contactMethodImg"/>
</div>

<div id="contactSpacer2Div" class="contactSpacerDiv"></div>

<div id="facebookDiv" class="contactMethodDiv" onclick="window.open('http://www.facebook.com/foley.paul'); return false;">
Friend<br/>
<img src=<?php echo $toRoot."img/contact/facebook.PNG" ?> id="facebookImg" class="contactMethodImg" />
</div>

<div id="contactSpacer3Div" class="contactSpacerDiv"></div>


<div id="linkedinDiv" class="contactMethodDiv" onclick="window.open('http://www.linkedin.com/in/thepaulfoley'); return false;">
Connect<br />
<img src=<?php echo $toRoot."img/contact/linkedin.PNG" ?> id="facebookImg" class="contactMethodImg" />
</div>

<div id="contactSpacer4Div" class="contactSpacerDiv"></div>
</div>

<?php 
include $toRoot.'php/footer/footer.php';
?>

</div>





</body>

</html>