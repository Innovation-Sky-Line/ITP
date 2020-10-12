<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
footer{
    background-color: #26272b;

    font-size: 15px;
    line-height: 12px;
    color: darkolivegreen;

   position: relative;
    left: 0;
    bottom: 0;

}
/*------------*/
.fcolumn{
    float: left;
    padding: 6px 6px 6px;
   
}

.fcolumn.lside{
    width: 30%;
    padding-right: 60px;
    padding-left: 80px;
}

.fcolumn.middle{
    width: 30%;
    padding-right: 80px;
}

.fcolumn.rside{
    width: 10%;
}

.frow:after {
    content: "";
    display: table;
    clear: both;
}
  
@media screen and (max-width:600px){
    .column.side, .column.middle{
        width: 100%;
    }
}
/*----------------------------------------------------*/

.m-content{
    float: left;
    padding: 10px;
  
}
.m1-left{
    width: 20%;
}

.m1-middle{
    width:100%;
}

/*--------------------------*/

footer h5{
    font-size: 16px;
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}

footer hr{
    border-top-color: burlywood;
    opacity: 2%;
    margin: 25px;
}

.fbottom{
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    padding-left: 80px; 
}

</style>
<title>Footer</title>
</head>
<body>


	<div class="footerX">
<footer>
<div class="frow">
<div class="fcolumn lside">

<div class="flist">

		
					
		
</div>

</div>

<div class="frow">
<div class="fcolumn middle">
<a href="#" class="fa fa-facebook"></a>
						<a href="#" class="fa fa-twitter"></a> <a href="#"
							class="fa fa-google"></a> <a href="#" class="fa fa-linkedin"></a>
						<a href="#" class="fa fa-youtube"></a>
</div>

<div class="frow">
<div class="fcolumn rside">

    </div>

</div>

<hr>

<p class="fbottom">Copyright &copy;INNOVATION SKYLINE 2020</p>


</div>

</div>
</footer>

</div>


</body>
</html>