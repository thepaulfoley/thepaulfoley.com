/**
 * 
 */

function mouseOver(button)
{
var elem=document.getElementById(button);	
var source=elem.src;
var newSrc=source.replace("plain.PNG","hover.PNG");
elem.src=newSrc;

}

function mouseOut(button)
{
var elem=document.getElementById(button);	
var source=elem.src;
var newSrc=source.replace("hover.PNG","plain.PNG");
elem.src=newSrc;

}
