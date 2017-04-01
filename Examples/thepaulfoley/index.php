<?php $toRoot="";?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" />
<?php include $toRoot.'styles/style.php'; ?>
<script type="text/javascript" src="javascript/navBar.js"></script>
<!--  <script type="text/javascript" src="javascript/slideshow.js"></script> -->

<title>
Welcome to ThePaulFoley
</title>
</head>

<body onload="runSlideshow(0);">

<div id="wrapperDiv" class="wrapper">

<div id="bannerOuterDiv" class="bannerOuterDiv">

<?php 
include 'php/header/logo.php';
include 'php/header/namePlate.php';
include 'php/header/navBarHome.php';
?>

</div>

<div id="contentDiv" class="contentDiv">

<div id="bioDiv" class="homeSectionDiv">
Hello, and welcome to my little piece of the Internet. I enjoy talking about myself almost as much as I enjoy 

a good bowl of soup(there is no such thing as a good bowl of soup). So here are the facts. 

<br>
<br>
My name is Paul Foley. I grew up in Green Harbor, Massachusetts. I graduated from Northeastern University in 2012 with a 

Bachelor's Degree in Computer Science. I like chicken, I like salad, but I can't stand chicken salad. 
<br>
<br>
So, that's a little bit about me. If you want to know more, feel free to <a class="link" href="php/contact/contact.php">contact me</a>. 
From time to time I'll add articles to the site about things I find interestiong and hopefully you'll find some of them interesting too.
</div>

<div id="homeSpacer2Div" class="homeSpacerDiv"></div>

<div id="slideshowDiv" class="homeSectionDiv">
<img id="slideShowImg" src="img/home/Green_Harbor.jpg" width="300px" height="325px" />
</div>


</div>

<?php 
include 'php/footer/footer.php';
?>

</div>





</body>

</html>
