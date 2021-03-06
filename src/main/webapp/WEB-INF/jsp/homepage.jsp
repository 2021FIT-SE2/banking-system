<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/script.js" defer></script>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
            integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
            crossorigin="anonymous"></script>
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script> -->
    <!--Cần để vẽ chart-->
    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <script src="js/footer.js" defer></script>
    <style>

        body {
            margin: 0;

        }

        .container-1 {
            font-size: small;
            margin: auto;
            margin-left: 2rem;

            display: flex;


        }

        .card {
            color: rgb(6, 90, 17);
            margin-right: 2rem !important;
            margin-top: 2rem;
            background-color: rgb(195, 196, 247);
        }

        .card-header, .text-title {
            font-weight: bold;
        }

        .container {
            margin-top: 5rem;
            margin-bottom: 5rem;
            display: block;
        }

        p {
            font-weight: 900;
        }

        .container .card-header {
            border: 1px solid red;
            border-top-right-radius: 10px;
            border-top-left-radius: 10px;
            border-bottom: 0;
            margin-top: 30px;

        }

        .container .chart {
            border: 1px solid red;
            border-top: 0;
            margin-bottom: 60px;
            border-bottom-right-radius: 10px;
            border-bottom-left-radius: 10px;
        }

        .overal {
            /* margin: 1rem 1rem; */
            margin: auto;
            margin-top: 1rem;
            display: flex;
        }

        .charts {
            width: 30%;
            margin-right: 1rem;
            border: 1px solid red;
            /* border-top: 0; */
            border-radius: 10px;
            margin: auto;
            /* border-bottom-right-radius: 10px;
            border-bottom-left-radius: 10px; */
        }

        @media only screen and (max-width: 600px) {
            .container-1 {
                display: block;
            }
        }


        @media only screen and (max-width: 600px) {
            .overal {
                display: block;
            }

            .charts {
                margin-bottom: 1rem;
                width: 90%;
            }
        }

    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color:  rgba(79, 89, 148, 0.9)">
    <a href="homePage.html"><img src="./images/logo_white.png" width="80" height="80" class="d-inline-block align-top"
                                 alt="" loading="lazy"></a>
    <!-- <a class="navbar-brand" href="#">
      Home
    </a> -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Hi, Guest!<span class="sr-only"></span></a>
            </li>
        </ul>
        <ul class="navbar-nav navbar-right">
            <li class="nav-item">
                <a class="nav-link" href="login.html" data-toggle="tooltip" data-placement="top" title="Sign in"><i
                        class="fas fa-sign-in-alt"></i><span class="sr-only">(current)</span>&nbsp;&nbsp;Sign in</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tooltip" data-placement="top" title="Sign up" href="#"><i
                        class="fas fa-user-plus"></i><span class="sr-only"></span>&nbsp;&nbsp;Sign up</a>
            </li>
        </ul>
    </div>
</nav>
<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
        <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="images/Banner+web+bidv+1440+x+740-100.webp" class="d-block w-100" alt="banner">
        </div>
        <div class="carousel-item">
            <img src="images/BIDV_BannerWeb_380x213px.webp" class="d-block w-100" alt="banner">
        </div>
        <div class="carousel-item">
            <img src="images/1440x840-01.webp" class="d-block w-100" alt="banner">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<br>
<div class="container-1">
    <div class="card">
        <img src="./images/img-06.jpg" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Partners</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                content.</p>
            <a href="#">View details >></a>
        </div>
    </div>
    <div class="card">
        <img src="./images/activities.png" class="card-img-top" alt="Activities">
        <div class="card-body">
            <h5 class="card-title">Activities</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                content.</p>
            <a href="#">View Details >></a>
        </div>
    </div>
    <div class="card">
        <img src="./images/tile-1.jpg" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">Services</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                content.</p>
            <a href="#">More services >></a>
        </div>
    </div>
</div>
<div class="overal">
    <!--Chart 1-->
    <div class="charts">
        <div class="card-header">
            <p>Rating</p>
        </div>
        <div class="chart">
            <canvas id="myChart2" width="5" height="4"></canvas>
        </div>
    </div>


    <!--Chart 2-->
    <div class="charts">
        <div class="chart3">
            <div class="card-header">
                <p>Transaction Frequency</p>
            </div>
            <div class="chart">
                <canvas id="myChart1" width="5" height="4"></canvas>
            </div>
        </div>
    </div>
    <div class="charts">
        <div class="card-header">
            <p>Most in-demand actions</p>
        </div>
        <div class="chart">
            <canvas id="myChart3" width="5" height="4"></canvas>
        </div>
    </div>
</div>
</div>
<div class="footer"></div>
</body>
</html>
