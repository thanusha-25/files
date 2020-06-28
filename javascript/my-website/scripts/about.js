function aboutMe()
{
    document.getElementById("heading").innerHTML="";
    document.getElementById("content").innerHTML="";
    document.getElementById("demo").innerHTML = "<h3><u>Introduction:</u></h3><br>This is Pola Thanusha.<br>I completed my graduation from Gokaraju Rangaraju Institute of Engineering and Technology.<br>"+
                                                   "At present,I am working as an intern in Zemoso Technologies,Hyderabad.<br>"+
                                                   "<h3><u>Hobbies:</u></h3>I love to play badminton.<br>I watch Korean Series.<br>"+
                                                   "<h3><u>Technical Skills:</u></h3> Knowledge on C,C++,Java,SQL,CSS,HTML<br>"+
                                                   "Have a good Knowledge on Data Structures,Operating Systems<br>"+
                                                   "Have baisc knowledge on Git Version Control.";
                                                 
}

function home()
{
    document.getElementById("heading").innerHTML="";
    document.getElementById("content").innerHTML="";
    document.getElementById("demo").innerHTML = "Hello Everyone...!!<br> This is Pola Thanusha Reddy."+
                                                   "<br>Welcome to my website.<br>"+
                                                   "<img src='images/minion.png' align='right'></img>";
}

function displaySubmit()
{
    window.alert("You would receive a mail shortly");
}
function contact()
{
    document.getElementById("heading").innerHTML="";
    document.getElementById("content").innerHTML="";
    document.getElementById("demo").innerHTML = "<center>Wanna get in touch with me ...!!!.Then feel free to fill the form. You would receive a mail from me.</center>"+
                                                "<head><style> input[type=text]  {width: 35%;margin:6px 0px ;float:center;} form{ width:40%;} label{ width: 180px;float:left;clear:left;text-align:left;margin:6px 0px}</style></head><body>"  +
                                                "<body><center><br><br>"+
                                                "<p id='error'></p>"+ "<br><br>"+
                                                
                                                  "<div><form name='myForm' onsubmit='return validateName()' action='index.html'><fieldset><legend><strong>FORM</strong></legend>"+
                                                  "<label>Full Name    : </label><input name='fname' type=text placeholder='Enter Full Name' ><br>"+
                                                  "<label>Email Id     : </label><input name='mail' type=text placeholder='Enter mail id' ><br>"+
                                                  "<label>Mobile Number: </label><input name='mobile' type=text placeholder='Enter mobile number'><br><br>"+
                                                  "<center><input type=submit value=Submit><br></center>"+
                                                  "</fieldset></form></div></center></body>"
}

function validateName()
{
    var mobile=document.forms["myForm"]["mobile"].value;
    var name=document.forms["myForm"]["fname"].value;
    var mail=document.forms["myForm"]["mail"].value;
if(name=="" || mobile==""|| mail=="")
{ document.getElementById("error").innerHTML="***Enter all feilds***";
 return false;
}
 if(name.length >20) 
 {
    document.getElementById("error").innerHTML="***Name must contain only 20 letters at maximum***";
    focus.name();
 return false; 
 }
if(isNaN(mobile) || mobile.length== 0)
{
    document.getElementById("error").innerHTML="<br><center>***Enter valid mobile number***</center><br>";
  return false;
}
 if(mobile.length!=10)
{
    document.getElementById("error").innerHTML="<br><center>***Mobile Number must be only 10 digits***<br>";
  return false;
}
var letters = "/^[A-Za-z\s]+$/";
if(name.match(letters))
{
 return true;
 }
else
{
    document.getElementById("error").innerHTML= "***Name must contain only alphabets and blank spaces***";
 return false;
}


}
