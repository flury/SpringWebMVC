<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Learning Web MVC | Hero List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="<c:url value='/assets/css/bootstrap.css' />" rel="stylesheet">
    <style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        color: white;
	    background-image: url("<c:url value='/assets/img/mobile-legend/Site-background-dark.webp' />");
      }
    </style>
    <link href="<c:url value='/assets/css/bootstrap-responsive.css' />" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='/assets/ico/apple-touch-icon-144-precomposed.png' />">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value='/assets/ico/apple-touch-icon-114-precomposed.png' />">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value='/assets/ico/apple-touch-icon-72-precomposed.png' />">
                    <link rel="apple-touch-icon-precomposed" href="<c:url value='/assets/ico/apple-touch-icon-57-precomposed.png' />">
                                   <link rel="shortcut icon" href="<c:url value='/assets/ico/favicon.png' />">
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Gaming</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li><a href="<c:url value='/index' />">Home</a></li>
              <li class="active"><a href="<c:url value='/hero-list' />">Hero List</a></li>
              <li><a href="#about">Hero Create</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

		<h1>Hero List</h1>
		<p>This list shows all heroes as they are available in both servers, along with their assigned roles, specialties, laning recommendations, release years, and purchase costs, arranged in the alphabetical order of their names. Heroes who haven't yet received a purchase price or laning recommendations are those, who are still not available in the Official Server or during test in Advanced Server.</p>

		<table class="table table-bordered">
			<tr>
				<th>Hero</th>
				<th>Name</th>
				<th>Hero Code</th>
				<th>Roles</th>
				<th>Specialities</th>
				<th>Laning</th>
				<th>Release Year</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${listTableHero}" var="recs" varStatus="index">
			<tr>
				<td><img width="40%" src="<c:url value='/assets/img/mobile-legend/Hero${recs.heroCode}1-icon.webp' />" class="img-circle" alt="icon-hero"></td>
				<td>${recs.heroName}</td>
				<td>${recs.heroCode}</td>
				<td><img width="20%" src="<c:url value='/assets/img/mobile-legend/${recs.heroRole}_Icon.webp' />" class="img-circle" alt="icon-hero">${recs.heroRole}</td>
				<td>${recs.heroSpecialities}</td>
				<td>${recs.heroLaning}</td>
				<td>${recs.heroReleaseYear}</td>
				<td><img width="10%" src="<c:url value='/assets/img/mobile-legend/Battle_Points.webp' />" class="img-circle" alt="icon-hero">: ${recs.heroBattlePoint} | <img width="10%" src="<c:url value='/assets/img/mobile-legend/Diamond.webp' />" class="img-circle" alt="icon-hero">: ${recs.heroDiamond}</td>
			</tr>
			</c:forEach>
		</table>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value='/assets/js/jquery.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-transition.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-alert.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-modal.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-dropdown.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-scrollspy.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-tab.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-tooltip.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-popover.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-button.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-collapse.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-carousel.js' />"></script>
    <script src="<c:url value='/assets/js/bootstrap-typeahead.js' />"></script>

  </body>
</html>
