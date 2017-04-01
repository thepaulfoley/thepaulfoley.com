<?php

$to      = 'thepaulfoley@gmail.com';
if (isset($_GET["subject"])){
$subject = $_GET["subject"];//'the subject';
}
else{
	$subject='no subject specified';
}
if (isset($_GET["body"])){
$body = $_GET["body"];//'hello';
}
else{
	$body='no body specified';
}
$headers = 'From: paul@thepaulfoley.com' . "\r\n" .
    'Reply-To: paul@thepaulfoley.com' . "\r\n" .
    'X-Mailer: PHP/' . phpversion();

mail($to, $subject, $body, $headers);




?>