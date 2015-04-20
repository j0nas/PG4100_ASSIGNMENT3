<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://bootswatch.com/cyborg/bootstrap.min.css">

    <!-- Latest minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <title>Optimus Prime - Index</title>

    <style type="text/css">
        #head-jumbo {
            margin-top: 30px;
        }
    </style>

    <!-- Latest minified jQuery -->
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script>
        $(function () {
            const $prime = $('#prime-input');
            $prime.keyup(function () {
                $.post('MainServlet', {
                    number: $prime.val()
                }, function (resp) {
                    $('#query-result').text(resp == "true" ? "Is a prime number." : "Not a prime number");
                });
            });
        });
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="jumbotron well" id="head-jumbo">
                <h1>Welcome!</h1>

                <p>A simple tool to verify prime numbers</p>
            </div>

            <form role="form">
                <div class="form-group">
                    <label for="prime-input">Number</label>
                    <input type="number" class="form-control" id="prime-input"/>
                </div>
                <div class="form-group" id="query-result"></div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
