<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	  <div class="slidecontainer">
    <div id="sliderdiv">    
        <script>
            var slider = document.getElementById("sliderdiv");
          	var imagePath = ["images/haier.jpeg", "images/candy.png", "images/ki.jpeg", "images/si.jpeg","images/po.jpeg"];
          	var index = 1;
          	setInterval(slide, 3000);
          // two parameters- function and time in millisecond
          function slide() {
            if (index < imagePath.length) {
              index = index + 1;
            } else {
              index = 1;
            }
            slider.innerHTML = "<img src = " + imagePath[index - 1] + ">";
          }
        </script>
            <!-- slider section ends -->
            <h1 class="heading2"><span>Our</span> Products</h1>
            
            <section class="sec" id="explore">
  <div class="card">
      <div class="img"><img src="images/h.jpeg"></div>
      <div class="desc">abcd</div>
      <div class="box1">
          <p>Available</p>
      </div>

          <div class="box">
              <div class="price">Rs.49,999</div>
              <div class="button">Add to Cart</div>
          </div>
      </div>

      <div class="card">
          <div class="img"><img src="images/g.jpeg"></div>
          <div class="desc">superman</div>
          <div class="box1">
              <p>Available</p>
          </div>
          <div class="box">
              
              <div class="price">Rs.67,999</div>
              <div class="button">Add to Cart</div>
          </div>
      </div>

      <div class="card">
          <div class="img"><img src="images/s.png"></div>
          <div class="desc">batman</div>
          <div class="box1">
              <p>Available</p>  
          </div>
          <div class="box">
              <div class="price">Rs.112,999</div>
              <div class="button">Add to Cart</div>
          </div>
      </div>

      <div class="card">
          <div class="img"><img src="images/sonies.webp"></div>
          <div class="desc">Sharia</div>
          <div class="box1">
              <p> Not Available</p>
          </div>
          <div class="box">
              <div class="price">Rs.192,000</div>
              <div class="button">Add to Cart</div>
          </div>
      </div>
      <div class="card">
          <div class="img"><img src="images/gpp.jpeg"></div>
          <div class="desc">biswas</div>
          <div class="box1">
              <p>Available</p>
          </div>
          <div class="box">
              <div class="price">Rs.32,000</div>
              <div class="button">Add to Cart</div>
          </div>
      </div>
      <div class="card">
          <div class="img"><img src="images/canonusa.png"></div>
          <div class="desc">shibika</div>
          <div class="box1">
              <p>Not Available</p>
          </div>
          <div class="box">
              <div class="price">Rs.102,000</div>
              <div class="button">Add to Cart</div>
          </div>
      </div>

      <div class="card">
        <div class="img"><img src="images/gorilla.webp"></div>
        <div class="desc">Kishor</div>
        <div class="box1">
            <p>Available</p>  
        </div>
        <div class="box">
            <div class="price">Rs.7,000</div>
            <div class="button">Add to Cart</div>
        </div>
    </div>

    <div class="card">
      <div class="img"><img src="images/gorilla.webp"></div>
      <div class="desc">sanir</div>
      <div class="box1">
          <p> Not Available</p>  
      </div>
      <div class="box">
          <div class="price">Rs.7,000</div>
          <div class="button">Add to Cart</div>
      </div>
  </div>
  <div class="card">
    <div class="img"><img src="images/gorilla.webp"></div>
    <div class="desc">rai</div>
    <div class="box1">
        <p>Available</p>  
    </div>
    <div class="box">
        <div class="price">Rs.7,000</div>
        <div class="button">Add to Cart</div>
    </div>
</div>
  

<h1 class="heading2"><span>Learn More</span> about the Team</h1>

<div class="hero-image">
 <div class="images"><img src="images/team.jpeg"></div>
</div>
    
    
            
            
       
         
    </div>
</div>

  
</body>
</html> --%>