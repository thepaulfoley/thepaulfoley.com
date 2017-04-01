<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>




<title>
Welcome to Example.com
</title>
</head>
<?php 
//fill in the host, username, and password for your database
$con = mysql_connect("host","username","password");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }
else {
	//fill in name of your database
	mysql_select_db("db", $con);
	
	$user=$_POST["usernameInput"];
	$password=$_POST["passwordInput"];
	
	$sql="SELECT * FROM user WHERE username='".
	$user."' AND password='".$password."'";
	
	

	$result = mysql_query($sql);
	mysql_close($con);

if(count($result)==1)
  {
  $row=mysql_fetch_array($result); 
  if(count($row)>=4){


?>
<body >

<h1>Welcome <?php echo $row[2]." ".$row[3]?>, to the best website ever!</h1><br/><br/>
<?php 
/*echo "Connected to database!<br>";
echo "sql=".$sql."<br/>";
echo "count(row)=".count($row)."<br/>";

for($i=0;$i<count($row);$i++){
echo "row[".$i."] = ".$row[$i]."<br/>";
}
*/
?>



</body>
<?php }
	else{
?>

<body onload="window.location.href='index.php?fail=true'"></body>
<!-- 
<body>
<?php 
echo "sql=".$sql."<br/>";
?>
</body>
 -->

<?php 

	}
	}
	}?>
</html>
