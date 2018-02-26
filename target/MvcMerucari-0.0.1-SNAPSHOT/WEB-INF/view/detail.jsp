<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <!-- css -->
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" 
    integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
    integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous"/>
  <link rel="stylesheet" href="./mercari.css"/>
  <!-- script -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <title>Rakus Items</title>
</head>
<body>
  <!-- navbar -->
  <nav class="navbar navbar-inverse">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="./list.html">Rakus Items</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <div>
        <ul class="nav navbar-nav navbar-right">
          <li><a id="logout" href="./login.html">Logout&nbsp;<i class="fa fa-power-off"></i></a></li>
        </ul>
        <p class="navbar-text navbar-right">
          <span id="loginName">user: userName</span>
        </p>
      </div>
    </div>
  </nav>

  <!-- details -->
  <div class="container">
    <a type="button" class="btn btn-default" href="./list.html"><i class="fa fa-reply"></i> back</a>
    <h2>Details</h2>
    <div id="details">
      <table class="table table-hover">
        <tbody>
          <tr>
            <th>ID</th>
            <td>1</td>
          </tr>
          <tr>
            <th>name</th>
            <td>Razer BlackWidow Chroma Keyboard</td>
          </tr>
          <tr>
            <th>price</th>
            <td>$52.0</td>
          </tr>
          <tr>
            <th>category</th>
            <td>Electronics / Computers &amp; Tablets / Components &amp; Parts</td>
          </tr>
          <tr>
            <th>brand</th>
            <td>Razer</td>
          </tr>
          <tr>
            <th>condition</th>
            <td>3</td>
          </tr>
          <tr>
            <th>description</th>
            <td>I realized his pants are on backwards after the picture. They were very dirty so I hand washed them. He has a stuffed body and painted porcelain head, hands and feet. Back before clowns were too scary. 9"" tall. No chips or cracks but minor paint loss in a few places. Clown Circus Doll Collectible</td>
          </tr>
        </tbody>
      </table>
      <a type="button" class="btn btn-default" href="./edit.html"><i class="fa fa-pencil-square-o"></i>&nbsp;edit</a>
    </div>
  </div>
</body>
</html>