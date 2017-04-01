<?php

$to      = 'thepaulfoley@gmail.com';
$subject = 'the subject';
$message = 'hello';
$headers = 'From: paul@thepaulfoley.com' . "\r\n" .
    'Reply-To: paul@thepaulfoley.com' . "\r\n" .
    'X-Mailer: PHP/' . phpversion();

mail($to, $subject, $message, $headers);

$response='response=message sent!';

echo $response;


?>