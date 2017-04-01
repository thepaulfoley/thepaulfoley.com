<?php 
$bannerBGColor="#000059";

$contentFontFamily="Calibri, Sans-serif";
$contentFontSizeNormal="12pt";
$contentFontColor="#D5D5D5";//#F3F3F3";

$articleTitleFontSize="24pt";
$articleSectionTitleFontSize="16pt";
$articleSectionTitleStylw="italic";

$tocFontColor="CBCBCB";//#DCDCDC";
$tocFontSize="12pt";
$tocTitleFontSize="14pt";


?>

<style type="text/css">

body{
margin:0 auto;
margin-left:0 auto;
margin-right:0 auto;
background:#8D8D8D;
}

body.comingBody{
margin:0 auto;
margin-left:0 auto;
margin-right:0 auto;
background:#000059;
}

div.comingDiv{
background: #000059;
background-repeat: no-repeat;
padding-right:0px;
padding-left:0px;
padding-top:0px;
padding-bottom:0px;
float:left;
width:100%;
text-align:center;
font-family:Candara;
font-size:24pt;
color:<? echo $contentFontColor ?>;
}

div.wrapper{
width:895px;
margin: 0 auto;
margin-left:0 auto;
margin-right:0 auto;

}
div.bannerLogoDiv{
background: <?php echo $bannerBGColor?>;
background-repeat: no-repeat;
padding-right:0px;
padding-left:0px;
padding-top:0px;
padding-bottom:0px;
float:left;
width:75px;
}

div.bannerNamePlateDiv{
background: <?php echo $bannerBGColor?>;
background-repeat: no-repeat;
padding-right:0px;
padding-left:0px;
padding-top:0px;
padding-bottom:0px;
float:left;
width:300px;
}

div.bannerOuterDiv{
background: <?php echo $bannerBGColor?>;
background-repeat: no-repeat;
padding-right:0px;
padding-left:0px;
padding-top:0px;
padding-bottom:0px;
float:left;
width:100%;
}

div.navBarDiv{
background: <?php echo $bannerBGColor?>;
background-repeat: no-repeat;
padding-right:0px;
padding-left:0px;
padding-top:0px;
padding-bottom:0px;
float:left;
width:520px;
height:100px;
}

div.navBarSpacerDiv{
background: <?php echo $bannerBGColor?>;
background-repeat: no-repeat;
padding-right:0px;
padding-left:0px;
padding-top:0px;
padding-bottom:0px;
width:520px;
height:70px;
}
	
img.navBarImg{
	width:125px;
	height:30px;
	border:0;	
	}
a.plain{
	border:0px;
	padding-right:0px;
padding-left:0px;
padding-top:0px;
padding-bottom:0px;
	}


	a:link.link {color:<? echo $contentFontColor ?>;} 
	a:visited.link {color:<? echo $contentFontColor ?>;} 
	a:hover.link {color:<? echo $contentFontColor ?>;}
	a:active.link {color:<? echo $contentFontColor ?>;}
	
div.contentDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:<?echo $contentFontSizeNormal ?>;
padding-right:2%;
padding-left:2%;
padding-top:20px;
padding-bottom:20px;
float:left;
width:96%;
color:<? echo $contentFontColor ?>;
}

div.homeSectionDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:<?echo $contentFontSizeNormal ?>;
padding:0px 0px 0px 0px;
float:left;
width:49%;
color: <? echo $contentFontColor ?>;
}
div.spacerDiv{
background: #000000;
background-repeat: no-repeat;
margin:20px 0px 20px 0px;
text-align:center;
float:left;
width:2%;
color:<? echo $contentFontColor ?>;
	}
#slideshowDiv{
	text-align:center;
	}	
div.homeSpacerDiv{
background: #000000;
background-repeat: no-repeat;
margin:20px 0px 20px 0px;
text-align:center;
float:left;
width:2%;
color:<? echo $contentFontColor ?>;
	}

div.articleTitleDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:<? echo $articleTitleFontSize ?>;
font-weight:bold;
float:none;

color:<? echo $contentFontColor ?>;
clear:both;
}
div.tocTitleDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:<? echo $tocTitleFontSize ?>;
float:none;
color:<? echo $tocFontColor ?>;
}

div.tocListDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:<? echo $tocFontSize ?>;
margin-top:0px;
float:none;
color:<? echo $tocFontColor ?>;
}

div.articleSectionTitleDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:<? echo $articleSectionTitleFontSize ?>;
font-weight:bold;
float:none;

color:<? echo $contentFontColor ?>;
clear:both;
}

div.articleImg{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:<? echo $articleSectionTitleFontSize ?>;
font-weight:bold;
float:none;

color:<? echo $contentFontColor ?>;
clear:both;
}

div.captionDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:10pt;
margin-top:0px;
float:none;
color:<? echo $tocFontColor ?>;
}

	
div.downloadPdfDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:10pt;
float:left;
width:100%;
text-align:right;
color:<? echo $contentFontColor ?>;
	}
div.indexContactLinkDiv{
	background: #000000;
	background-repeat: no-repeat;
	cursor:pointer;
	}
	
	div.downloadLinkDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
float:right;
color:<? echo $contentFontColor ?>;
text-align:right;
cursor: pointer;
	}
	
	img.pdfImg{
	width: 20px;
	height: 20px;
	float:right;
	}
	
div.gameEntryDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:<?echo $contentFontSizeNormal ?>;
padding:0px 0px 20px 0px;
float:left;
color:<? echo $contentFontColor ?>;
}	
div.gameLogoDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:<?echo $contentFontSizeNormal ?>;
padding:0px 0px 0px 0px;
float:left;
color:<? echo $contentFontColor ?>;
}	
div.gameDescriptionDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:<?echo $contentFontSizeNormal ?>;
padding:0px 0px 0px 10px;
float:left;
color:<? echo $contentFontColor ?>;
}	
div.gameDiv{
background: #000000;
background-repeat: no-repeat;
font-family:<?echo $contentFontFamily ?>;
font-size:<?echo $contentFontSizeNormal ?>;
padding:20px 0px 20px 0px;
float:left;
width:100%;
color:<? echo $contentFontColor ?>;
text-align:center;
}


	


div.contactMethodDiv{
background: #000000;
background-repeat: no-repeat;
font-family:Candara;
font-weight:bold;
font-size:36pt;
margin:40px 0px 40px 0px;
text-align:center;
float:left;
width:24%;
color:rgb(255,255,255);
cursor: pointer;
	}
	
div.contactSpacerDiv{
background: #000000;
background-repeat: no-repeat;
margin:40px 0px 40px 0px;
text-align:center;
float:left;
width:7%;
color:<? echo $contentFontColor ?>;
	}	
	
img.contactMethodImg{
	width:200px;
	heigth:175px;
	border:0px;
	}
	
	

div.footerDiv{
background: <?php echo $bannerBGColor?>;
background-repeat: no-repeat;
padding-right:0px;
padding-left:0px;
padding-top:0px;
padding-bottom:0px;
text-align:right;
float:left;
width:100%;
color:<? echo $contentFontColor ?>;
}

</style>