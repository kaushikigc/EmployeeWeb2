
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.108.0">
    <title>Signin Template · Bootstrap v5.3</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">

     <link href="css/bootstrap.min.css" rel="stylesheet"integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" >
        <link href="css/sign-in.css" rel="stylesheet">  
        <link href="css/menu.css" rel="stylesheet"> 
        <link href="css/product.css" rel="stylesheet"> 

    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
<link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#712cf9">
<link href="css/menu.css" rel="stylesheet"><!-- comment -->
<link href="css/product.css" rel="stylesheet"><!-- comment -->
<link href="css/bootstrap.min.css" rel="stylesheet">



    
    <!-- Custom styles for this template -->
    <link href="css/sign-in.css" rel="stylesheet">
  </head>
  <body class="text-center">
    
<main class="form-signin w-100 m-auto">
    <form action="SignUp" method="Post">
    <img class="mb-4" src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Please sign Up</h1>
    <div class="alert alert-danger" role="alert">
  <%=request.getAttribute("ErrorMsg")%>
    </div>
    
   

    <div class="form-floating">
        <input type="password" class="form-control" id="floatingInput" placeholder="First Name" name="firstName" required>
      <label for="floatingInput">First Name</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingInput" placeholder="Last Name" name="lastName" required>
      <label for="floatingInput">Last Name</label>
    </div>
    <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="emailAddress" required>
      <label for="floatingInput">Email address</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" required>
      <label for="floatingPassword">Password</label>
    </div>

    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign Up</button>
<!--    <p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>-->
<br></br>
</main>


    
  </body>
</html>
