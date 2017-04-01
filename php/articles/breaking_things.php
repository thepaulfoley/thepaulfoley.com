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


<div id="breakingThingsTitleDiv" class="articleTitleDiv">Breaking Things is Just More Fun</div>
<br>

<div style="float:left;">
<div id="breakingThingsTOCDiv" class="tocTitleDiv"> <a name="toc" class="link"> Contents </a></div>

<div id="breakingThingsDiv" class="tocListDiv">
<ul style="margin-top:0px;">
<li><a class="link" href="#IPS">Internet Protocol Suite</a></li>
<li><a class="link" href="#ARP">ARP Spoofing</a></li>
<li><a class="link" href="#Smurf">Smurf Attack</a></li>
<li><a class="link" href="#SYN">SYN Flooding</a></li>
<li> <a class="link" href="#SQL">SQL Injection </a></li>
</ul>
</div>
</div>
<div style="float:right; width:450px; margin-right:50px;">
<img src=<?php echo $toRoot."img/breaking_things/kid_smashing_tv.jpg"?> width="450px" height="365px">
<br>
<div class="captionDiv" >Source: <a class="link" target="_blank" href="http://www.bolgernow.com/blog/wp-content/uploads/2009/08/bad-kid-smashing-tv.jpg">http://www.bolgernow.com/blog/wp-content/uploads/2009/08/bad-kid-smashing-tv.jpg</a></div>

</div>
<br>
<br>
<div class="articleSectionTitleDiv"><a name="IPS">Internet Protocol Suite</a></div>
<div>Before we begin discussing specific types of network attacks, lets go over one of most fundamental parts of networking, the Internet 
Protocol Suite. Computer networks are able to communicate with each other in part because they use a set of standardized protocols. A 
protocol is simply a set of rules that each party must follow in order to facillitate effective communication.  These protocols can be 
broken into four main categories: Link Layer, Internet Layer, Transport Layer, and Application Layer. The Link Layer is the lowest layer. 
Protocols in the Link Layer are responsible for communication within a single network. An example of a Link Layer protocol is ARP which 
we will discuss in more detail a little later. The Internet Layer protocols  facilitate basic communication across network boundaries. 
IPv4 and IPv6 are Internet layer protocols. Tranport Layer protocols provide end to end communication across network boundaries. Transport 
Layer Protocols provide services like flow control, congestion control, and segmentation that Internet Layer protocols do not provide. TCP 
and UDP are a couple of Transport Layer Protocols. The final layer is the Application Layer. The Application Layer provides process to 
process communication and consists of some of the better known protocols like HTTP, FTP, and SSH. </div>
<br>
<a class="link" href="#toc" name="bottom">Back to Top</a>
<br>
<br>
<div class="articleSectionTitleDiv"><a name="ARP">ARP Spoofing</a></div>
<div>ARP stands for Address Resolution Protocol and it is used to link a host's physical address(MAC address) with it's IP address.
ARP has two key message types; "who has" and "is at" messages. If a host, say Host A, on a network knows the IP address of another host but 
not the MAC address, it would send out a "who has" request. The message would have the following format "who has &lt; some IP address&gt;". 
Since Host A doesn't know which host has that IP address, the message is broadcast to all hosts on the network. Then, the host with the 
specified IP Address, say Host B, would respond with an "is at" message. The message would look like this, "&lt;some IP address&gt; is at &lt;
some MAC address&gt;". When Host A receives the "is at" response from Host B, it adds Host B's IP address and MAC address to its ARP cache. 
The ARP cache can simply be thought of as a table that stores mappings of other hosts IP address and MAC address.</div>
<br>
<div>Just to be clear lets go over a graphical example of a typical ARP communication. Below is an example of a 
network with three hosts. Below each host is their IP address followed by their MAC address.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/arp1.PNG"?> width="509px" height="350px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Now, if the host at 10.1.1.32 wants to send something to 10.1.1.31 but doesn't know their MAC address, they
would send out a "who has" request. Notice that the request is broadcast to all of the hosts.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/arp2.PNG"?> width="539px" height="350px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>The host at 10.1.1.31 will respond with an "is at" message. The other hosts will store 10.1.1.31's IP address 
and MAC address in their ARP cache.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/arp3.PNG"?> width="509px" height="401px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>So, now we've seen an example of proper communication using ARP. Now, let's see how ARP Spoofing works.
We'll start out with a network with three hosts again. However, this time we will have an attacker at 10.1.1.33.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/arp4.PNG"?> width="509px" height="350px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Once again, 10.1.1.32 will send out a "who has" request.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/arp5.PNG"?> width="539px" height="350px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>This time, our attacker replies and says that 10.1.1.31 is at his MAC address. The other hosts on the 
network add entries to their ARP cache mapping 10.1.1.31 to our attacker's MAC address.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/arp6.PNG"?> width="605px" height="350px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Now, if 10.1.1.32 tries to send data to 10.1.1.31, they will really be sending it to our attacker. This 
scenario is an example  of a man in the middle attack.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/arp7.PNG"?> width="509px" height="350px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>So, now that we've seen how ARP Spoofing works, lets talk about how to defend against it. The reason 
that ARP Spoofing can work is because, as mentioned earlier, ARP is used for communication within a single network.
Since people tend to trust  hosts within their network more than hosts outside their network they may take
fewer security measures with ARP communication  than they would with other types of communication. Luckily, 
there are some easy defenses that are being built into networked devices today. Devices can ignore unsolicited 
responses. In our example above, this means that our attacker could not send out an "is at" message unless it had 
received a "who has" request. Another defense is to only update the ARP cache after a certain amount of time. So,
if in our example above 10.1.1.31 had responded with an "is at" response before our attacker, then the attacker's 
response would not be entered into the ARP cache. A final defense is to trigger an alert if the ARP cache has 
multiple entries for the same IP address or MAC address. This would be helpful if in our example the attacker 
replied with an "is at" response and then 10.1.1.31 responded. This would result in two entries in the ARP cache for
 the same IP address. An alert would be triggered and a network administrator could determine which entry is correct
  and which host sent out the spoofed response.</div>
<br>
<a class="link" href="#toc" name="bottom">Back to Top</a>
<br>
<br>
<div class="articleSectionTitleDiv"><a name="Smurf">Smurf Attack</a></div>
<div>A Smurf Attack is a denial of service attack on the Internet Layerr. In a Smurf Attack, the attacker sends
ICMP reply request packets to broadcast addresses of many networks. An ICMP reply request packet basically says, 
"Hey, I'd like to communicate, send me a reply back.". A broadcast address on a network is an address where all
messages sent to that address are broadcast to all hosts on the network. So, if an attacker sends ICMP reply
request packets to 10 broadcast addresses and each of those addresses are on a network with 100 hosts, the 
attacker could reach 1000 hosts with just 10 packets. The key to a Smurf Attack is that the ICMP reply request 
packets have a fake source address. When the attacker sends the ICMP reply requests packets, they change the source
address to be the IP address of their target(perhaps the IP address of a web server controlling a website they want 
to take down). All the hosts that receive the ICMP reply request packets will direct their responses to the target.
If there are enough responses, the target will be overwhelmed and will not be able to handle any legitimate traffic.
</div>
<br>
<div>Below is a graphical representation of how a Smurf Attack works. In red is the attacker, in blue is the target, 
and in green are the broadcast addresses.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/smurf1.PNG"?> width="363px" height="237px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>First, we see the attacker sending the ICMP reply requests to the broadcast addresses.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/smurf2.PNG"?> width="363px" height="302px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Then, we see all the replies being directed at the target.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/smurf3.PNG"?> width="363px" height="237px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>There are two common defenses to a Smurf Attack. First, you can make sure that your system is not part of a
Smurf Attack by configuring it to not reply to ICMP requests sent to broadcast addresses. Second, if you are the 
target of a Smurf Attack, you can defend yourself using reverse path forwarding. This is when you check whether
a packet could really have originated from where it says it's from. By using reverse path forwarding, the target
could determine that the ICMP replies are not legitimate and therefore ignore them.</div>
<br>
<a class="link" href="#toc" name="bottom">Back to Top</a>
<br>
<br>
<div class="articleSectionTitleDiv"><a name="SYN">SYN Flooding</a></div>
<div>SYN Flooding is a Transport Layer denial of service attack that uses TCP(Transmission Control Protocol). TCP is a connection 
oriented protocol. This means that hosts have to create a connection with eachother before communicating. In order
to communicate, the two hosts must engage in what's called a three way handshake. Below is a demonstration of a 
three way handshake.</div>
<br>
<div>First, one host sends a SYN packet. This is like sending somebody a text saying you want to hang out.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/syn1.PNG"?> width="267px" height="62px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Then, the other host sends a SYN-ACK packet. This is like saying, "Got your message how about at 8:00pm?". It 
also creates a TCB(Transmission Control Block). A TCB is a data structure that holds important information about the 
connection being created. It's like creating a reminder that you're meeting your friend at 8:00pm. </div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/syn2.PNG"?> width="278px" height="94px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Finally, the first host sends an ACK packet. This is like saying, "Cool, see you at 8:00pm.".</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/syn3.PNG"?> width="278px" height="117px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>So, we've seen what a three way handshake looks like. Now, lets actually look at SYN Flooding. In SYN Flooding,
the attacker starts by sending a SYN packet to the target. Like in a <a class="link" href="#Smurf">Smurf Attack</a>,
the attacker sends a packet with a forged source IP address. Below we can see the first step in the attack. Once 
again, our attacker is red, our target is blue, and the hosts in green are random hosts on the internet.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/syn4.PNG"?> width="325px" height="256px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Next, the target creates a TCB and sends a SYN-ACK packet. However, since the attacker forged the source IP 
address, the target ends up sending the SYN-ACK to a random host on the Internet.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/syn5.PNG"?> width="364px" height="256px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Since the random host on the Internet that receives the SYN-ACK did not send the original SYN packet, it never
replies to the SYN-ACK. This means our target is stuck with an open connection and the TCB. So, if the attacker sends
lots of SYN packets, as shown below, the target will be stuck with lots of open connections and TCBs. If there are 
enough, the target will not be able to create any new connections. Thus, denying service to legitimate traffic.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/syn6.PNG"?> width="412px" height="256px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>One way to combat SYN Flooding is through something called SYN cookies. SYN cookies defend against a SYN 
Flooding attack because they eliminate the need to create a TCB after the original SYN packet is received in the 
three way handshake. It does this by taking advantage of the fact that each TCP packet contains a sequence number. 
When a host receives a SYN packet, they generate a cookie. The cookie is simply a number. Let's call its value c.
The host then sends a SYN-ACK packet with the sequence set to c. Then, it only creates a TCB after it receives an 
ACK packet that has an acknowledgement field equal to c+1. So, in the case of our example above, if our target was 
using SYN cookies, it would not have to create TCBs while waiting for a response, which we know will never come, 
from the random hosts on the Internet. Therefore, it could continue handling legitimate traffic.</div>
<br>

<a class="link" href="#toc" name="bottom">Back to Top</a>
<br>
<br>
<div class="articleSectionTitleDiv"><a name="SQL">SQL Injection</a></div>
<div>SQL Injection attacks are Application Layer attacks that involve inserting text into a form on a web page that 
will cause a SQL query to behave differently than expected. Below we have an example of a typical login screen.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/sql1.PNG"?> width="442px" height="245px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Next, we enter a valid username and password.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/sql2.PNG"?> width="451px" height="258px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Upon clicking the "Log In" button, we are greeted by a friendly although slightly exaggerated welcome screen.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/sql3.PNG"?> width="626px" height="249px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Now, lets look at the code behind the login screen. Below is the HTML code for the login form. The form is
 made up of two text boxes, one for the username and one for the password, and one button, the "Log In" button. The 
 other important part of this code is in the first line where it says <code>action="login.php"</code>. This means 
 that login.php is run when you click the "Log In" button.</div>
<br>
<br>
<div style="background:#FFFFFF; width:600px; margin-left:auto; margin-right:auto; color:#000000;">
<code>
&lt;form action="login.php" method="post"&gt;
<br>
&lt;div style="float:left;"&gt;Username:&lt;/div&gt; 
<br>
&lt;input type="text" size="20"  name="usernameInput" /&gt;
<br>&lt;br/&gt;
<br>
&lt;div style="float:left;"&gt;Passwoord:&lt;/div&gt;<br>
&lt;input type="password" size="20" name="passwordInput" /&gt;
<br>&lt;br/&gt;
<br>&lt;br/&gt;
<br>
&lt;div style="width:250px;text-align:center"&gt;<br>
&lt;input type="submit" value="Log in" /&gt;<br>
&lt;/div&gt;<br>
&lt;/form&gt;<br>
</code>
</div>
<br>
<br>
<div>Below are three lines of code from login.php that get run when you click the "Log In" button. These three lines
 are important because they take the user input from the login form and generate a SQL query. The first line gets 
 the username that was entered into the form. The second line gets the password that was entered into the form. The 
 third line generates a SQL query. This query sees if there are any entries in the "user" table whose username and password 
 match the username and password entered by the user. If there is a matching entry, the user is directed to the welcome 
 screen. Otherwise, they are sent back to the login screen.</div>
<br>
<br>
<div style="background:#FFFFFF; width:600px; margin-left:auto; margin-right:auto; color:#000000;">
<code>
	$user=$_POST["usernameInput"];
	<br>
	$password=$_POST["passwordInput"];
	<br>
	<br>
	<br>
	
	$sql="SELECT * FROM user WHERE username='".$user."' AND password='".$password."'";
	<br>
</code>
</div>
<br>
<br>
<div>So, now let's look at how we could use a SQL Injection attack to log in even if we don't have a valid username 
and password. Below is one possible string of text we could enter into the username field in order to get the SQL 
query to think we've supplied a valid username and password.</div>
<br>
<br>
<img src=<?php echo $toRoot."img/breaking_things/sql4.PNG"?> width="433px" height="280px" style="display:block; margin-left:auto; margin-right:auto;" />
<br>
<br>
<div>Just as a reminder, here is the code that generates the SQL query in login.php.</div>
<br>
<br>
<div style="background:#FFFFFF; width:600px; margin-left:auto; margin-right:auto; color:#000000;">
<code>
	$sql="SELECT * FROM user WHERE username='".$user."' AND password='".$password."'";
</code>
</div>
<br>
<br>
<div>So, if we replace <code>$user</code> and <code>$password</code> with what we entered into the login form, we
get the query shown below. Just to be clear, the text in red is what we entered into the form. So, we can see that by 
starting our username with a single quote, we are able to close the opening quote that precedes the username. By 
closing the quote, now the rest of what we typed as our username will be interpreted as SQL commands. So, then we 
add OR 1. Since, 1 equates to TRUE and anything OR TRUE equals TRUE, this will always evaluate to true. However, 
there is still the second half of the query that checks if the password is correct. We deal with this by adding two 
hyphens to our username. In SQL, two hyphens signify the start of a comment. So, anything after the hyphens, 
including the word "anything", will be ignored. Now, this query will return a list of all users and the way 
login.php is designed, you would be logged in as the first user in the "user" table.</div>
<br>
<br>
<div style="background:#FFFFFF; width:600px; margin-left:auto; margin-right:auto; color:#000000;">
<code>
	$sql="SELECT * FROM user WHERE username='<span style="color:red;">' OR 1 -- anything</span>' AND password=''";
</code>
</div>
<br>
<br>
<div>Although, SQL Injection attacks like this are pretty easy to carry out, they are also easy to defend against. One
of the the best ways is to escape all special characters from user input before inserting it into a query. In PHP, 
you can do this with the <span style="font-style:italic;">addslashes</span> function. If we had run the 
<span style="font-style:italic;">addslashes</span> function on our login form input above, the SQL query would have looked 
like the following.</div>
<br>
<br>
<div style="background:#FFFFFF; width:600px; margin-left:auto; margin-right:auto; color:#000000;">
<code>
	$sql="SELECT * FROM user WHERE username='<span style="color:red;">\' OR 1 -- anything</span>' AND password=''";
</code>
</div>
<br>
<br>
<div>By adding a backslash before the single quote, the query now looks for an entry in the "user" table whose 
username equals " ' OR 1 -- anything" and whose password is blank. Unless there is an entry that matches this 
criteria, you will not be able to log in.</div>
<br>
<br>
<div>If you would like to download the code for the login page, please click the links below. </div>
<a href=<?php echo $toRoot."txt/breaking_things/index.php.txt"?> class="link">index.php</a> - This is the login 
screen.
<br>
<a href=<?php echo $toRoot."txt/breaking_things/login.php.txt"?> class="link">login.php</a> - This is the script 
that gets run when you click the "Log In" button. It either displays the welcome screen or returns you to the 
login screen.


<br>
<br>
<a class="link" href="#toc" name="bottom">Back to Top</a>
</div>

<?php 
include $toRoot.'php/footer/footer.php';
?>

</div>





</body>

</html>