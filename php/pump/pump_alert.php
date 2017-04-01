<?php $toRoot="../../";?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" />
<?php include $toRoot.'styles/style.php'; ?>
<script type="text/javascript" >

function sendAlert()
{
alert('in sendAlert');

var xmlhttp;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  alert('created http object');

xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("alertSentDiv").innerHTML=$response;
    }
  
  else{
	//alert('not done yet');
  }
  }
xmlhttp.open("GET", "send_alert.php?q=1" ,true);
xmlhttp.send();

}

</script>

<script type="text/javascript" src=<?php echo $toRoot."javascript/navBar.js" ?> ></script>

<!--  <script type="text/javascript" src="javascript/slideshow.js"></script> -->

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
include $toRoot.'php/header/navBarHome.php';
?>

</div>

<div id="contentDiv" class="contentDiv">

<input type="button" value="Alert Email" onclick="sendAlert()" /> <div id="alertSentDiv" class="gameDescriptionDiv"> </div>

</div>

<?php 
include $toRoot.'php/footer/footer.php';
?>

</div>





</body>

</html>
