<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Customer</title>
    <!-- css -->
    <link href="https://fonts.googleapis.com/css?family=Pangolin:400,700|Proxima+Nova" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
        integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/header_admin.js" defer></script>
    <script src="js/footer.js" defer></script>
    <style>
        .footer {
            bottom: 0;
            position: fixed;
        }

        .button {
            display: flex;
            /* margin: 1rem 15rem; */
            justify-content: center;
            align-items: center;

        }
    </style>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top" style="background-color:  rgba(69, 69, 73, 0.8)">
        <img src="./images/logo_white.png" width="80" height="80" class="d-inline-block align-top" alt=""
            loading="lazy">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Administration</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item text-light" href="customerAdd.html">Add Customer</a></li>
                        <li><a class="dropdown-item text-light" href="transactionAdd.html">Add Transaction</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Report</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item text-light" href="customerList.html">Customer Report</a></li>
                        <li><a class="dropdown-item text-light" href="transferTransactionList.html">Tranfer Transaction Report</a></li>
                        <li><a class="dropdown-item text-light" href="withdrawTransactionList.html">Withdraw Transaction Report</a></li>
                        <li><a class="dropdown-item text-light" href="loanTransactionList.html">Loan Transaction Report</a></li>

                    </ul>
                </li>
            </ul>
            <ul class="navbar-nav navbar-right">
                <li class="dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
                            class="fas fa-user-alt"></i> Admin</span></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item text-light" href="#"><i class="fas fa-user-alt"></i> My Profile</a></li>
                        <li><a class="dropdown-item text-light" href="#" data-toggle="tooltip" data-placement="top"
                                title="Log out"><i class="fas fa-sign-out-alt"></i> Sign out</a></li>
                    </ul>
                </li>
            </ul>
    </nav>
</body>

</html>