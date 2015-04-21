<html>
<head>
    <!-- Latest minified jQuery -->
    <script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>

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
    <script>
        const NUM_INVALID = "Enter a valid integer";
        const NUM_PRIME = "is a prime number";
        const NUM_NOT_PRIME = "is not a prime number";

        const RESPONSE_IS_PRIME = "true";
        const RESPONSE_IS_INVALID = -1;

        $(function () {
            var lastVal;
            const $prime = $('#prime-input');

            $prime.keyup(function () {
                if ($prime.val() != lastVal && $prime.val() != "") {
                    lastVal = $prime.val();
                    $.post('primeservlet', {
                        number: $prime.val()
                    }, function (resp) {
                        $('#query-result').text(resp == RESPONSE_IS_PRIME ? NUM_PRIME : resp == RESPONSE_IS_INVALID ? NUM_INVALID : NUM_NOT_PRIME);
                    });
                }
            });
        });
    </script>
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="jumbotron well" id="head-jumbo">
                <h1>Optimus Prime</h1>

                <p>A simple tool to verify prime numbers</p>
            </div>

            <form role="form">
                <label for="prime-input">Number</label>

                <div class="input-group">
                    <!-- type should ideally be "number", but this disables the onKeyup listener for non-int values -->
                    <input type="text" class="form-control" id="prime-input" aria-describedby="query-result" autofocus/>
                    <span class="input-group-addon" id="query-result">Please enter a number</span>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
