
  function display()
  {
      var a=JSON.parse(localStorage.getItem("session"));
      document.getElementById("heading").innerHTML=" ";
      document.getElementById("content").innerHTML=" ";
      document.getElementById("demo").innerHTML=" ";
      for(var i=0;i<a.length;i++)
      {
          
      document.getElementById("content").innerHTML+="<img src="+a[i].url+">"+a[i].url+" "+a[i].name+" "+a[i].info+" "+a[i].date+"<br>";
      }
  }


    function gallery_admin()
    {
        document.getElementById("demo").innerHTML=
        document.getElementById("content").innerHTML=" ";
      document.getElementById("heading").innerHTML=" <center> <button id='subButton' onclick='add()'>Add image </button>"+
       "<button id='subButton' onclick='edit()'>Edit image</button>"+
        "<button id='subButton' onclick='remove()'>Remove image </button></center>" 
    }

    function add()
    {
        document.getElementById("content").innerHTML="<head><style> input[type=text] ,input[type=date] {width: 35%;height:35%;margin:6px 0px ;float:center;} form{ width:40%;} label{ width: 150px;float:left;clear:left;text-align:left;margin:3px 0px}</style></head>"+
                                                      "<body><center><form name='add_image' onsubmit='receive()' action='json.html'><fieldset><legend><strong>ADD IMAGE</strong></legend>"+
                                                      "<label>Image URL:</label><input type='text' name='url'><br>"+
                                                      "<label>Name:</label><input type='text' name='name'><br>"+
                                                      "<label>Information:</label><input type='text' name='info'><br>"+
                                                      "<label>Uploaded Date:</label><input type='date' name='date'><br><br>"+
                                                      "<center><input type='submit' value='Add image'><br></center>"+
                                                      "</fieldset></form></center></body>"
    }
   

    function receive()
    {
        let image={
           url : document.forms["add_image"]["url"].value,
           name :document.forms["add_image"]["name"].value,
           info:document.forms["add_image"]["info"].value ,
           date : document.forms["add_image"]["date"].value
        }   
        // localStorage.clear();
        // console.log(localStorage.getItem('session'));   
        if(image.url==""||image.name==""||image.info==""||image.date=="")
         {
             document.getElementById("content").innerHTML="Enter all fields to upload an image";
         }
         else if((Date.parse(image.date))> new Date().getTime())
         {
             console.log("enter valid date");
            document.getElementById("content").innerHTML="Enter a valid date";
         }

        else
        {
         if(localStorage.getItem('session')===null)
         {
            var a=[];    
             a.push(image);
             a.flat(Infinity);
             localStorage.setItem('session',JSON.stringify(a));
            console.log(JSON.parse(localStorage.getItem('session')));
         }
         else
           {
            var a=[]; 
            var cont="";   
             a.push(JSON.parse(localStorage.getItem('session')));
              a.push(image);
              a=a.flat(Infinity);
              for(var i=0;i<a.length;i++)
              cont+=a[i].url+" ";
              document.getElementById("content").innerHTML=cont;
              localStorage.setItem('session', JSON.stringify(a));
              console.log(JSON.parse(localStorage.getItem('session')));
           }
        }
    }
    

    function edit()
    {
        document.getElementById("content").innerHTML= "<head><style> input[type=text] ,input[type=date] {width: 35%;height:35%;margin:6px 0px ;float:center;} form{ width:40%;} label{ width: 150px;float:left;clear:left;text-align:left;margin:3px 0px}</style></head>"+
                                                        "<body><center>"+
                                                        "<form name='edit_image' action='json.html' onsubmit='modify()'><fieldset><legend>EDIT IMAGE</legend>"+
                                                       "<label>Image URL :</label><input type='text' name='url'><br>"+
                                                       "<label>Name:</label><input type='text' name='name'><br>"+
                                                       "<label>Information:</label><input type='text' name='info'><br>"+
                                                       "<label>Uploaded Date:</label><input type='date' name='date'><br><br>"+
                                                      "<center><input type='submit' value='Edit image'><br></center>"+
                                                      "</fieldset></form></center></body>"
    }


    function modify()
    {
        console.log("modify");
        var url=document.forms["edit_image"]["url"].value;
        var name=document.forms["edit_image"]["name"].value;
        var info=document.forms["edit_image"]["info"].value;
        var date=document.forms["edit_image"]["date"].value;
        document.getElementById("content").innerHTML=" modify "+url+" "+name+" "+info+" "+date;
       
        var a= JSON.parse(localStorage.getItem("session"));
        for(var i=0;i<a.length;i++)
        {
            var n= url.localeCompare(a[i].url);
            if(n==0)
            {
                a[i].name=name;
                a[i].info=info;
                a[i].date=date;
                localStorage.setItem("session",JSON.stringify(a));
                console.log(a[i]);
                document.getElementById("content").innerHTML="Given image is modified with the updated information";
                break;
            }
        }
        if(i==a.length)
        document.getElementById("content").innerHTML="Enter a valid URL to edit";
    }

   

    function remove()
    {
        document.getElementById("content").innerHTML="<head><style> input[type=text] ,input[type=date] {width: 35%;height:35%;margin:6px 0px ;float:center;} form{ width:40%;} label{ width: 150px;float:left;clear:left;text-align:left;margin:3px 0px}</style></head>"+
                                                      "<body><center><form name='remove_image' action='json.html' onsubmit='erase()'><fieldset><legend>REMOVE IMAGE</legend>"+
                                                      "<label> Enter Url:</label><input type='text' name='url'><br><br>"+
                                                      "<input type='submit' value='Remove image'><br>"+
                                                      "</fieldset></form></center></body>";
    }

    function erase()
    {
      console.log("remove");
      var url=document.forms["remove_image"]["url"].value;
     
      var a=JSON.parse(localStorage.getItem("session"));
      for(var i=0;i<a.length;i++)
      {
       var n = url.localeCompare(a[i].url);
           
          if(n==0)
          {
               a.splice(i,1);
               localStorage.setItem("session",JSON.stringify(a));
             document.getElementById("content").innerHTML="Given URL is removed";
             break;
          }
      }
      if(i==a.length)
      document.getElementById("content").innerHTML="Enter valid URL to delete";
    }
