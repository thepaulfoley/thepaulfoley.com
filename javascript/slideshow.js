function runSlideshow(num)
{
	num=num%3;
var url="img/home/slideshow"+num+".bmp";	
var img = document.getElementById("slideShowImg");
img.src=url;
num++;
t=setTimeout("runSlideshow("+num+")",5000);

}