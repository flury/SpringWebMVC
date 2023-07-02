<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Learning Web MVC | Hero Create</title>
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
              <li><a href="<c:url value='/hero-list' />">Hero List</a></li>
              <li class="active"><a href="<c:url value='/hero-create' />">Hero Create</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

		<h1>Create New Hero</h1>
		<p>This list shows all heroes as they are available in both servers, along with their assigned roles, specialties, laning recommendations, release years, and purchase costs, arranged in the alphabetical order of their names. Heroes who haven't yet received a purchase price or laning recommendations are those, who are still not available in the Official Server or during test in Advanced Server.</p>

		<c:if test="${not empty validationMessage}">
			<div class="alert alert-error">Error Message: ${validationMessage}</div>
		</c:if>
		
		<form class="form-horizontal" action="<c:url value='/hero-save-todb' />" method="post">
		  
		  <div class="control-group">
		    <label class="control-label">Hero Code</label>
		    <div class="controls">
		      <input type="text" name="heroCode" placeholder="Hero Code" value="0">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label">Hero Name</label>
		    <div class="controls">
		      <input type="text" name="heroName" placeholder="Hero Name">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label">Role</label>
		    <div class="controls">
		      <input type="text" name="heroRole" placeholder="Role">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label">Specialities</label>
		    <div class="controls">
		      <input type="text" name="heroSpecialities" placeholder="Specialities">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label">Laning</label>
		    <div class="controls">
		      <input type="text" name="heroLaning" placeholder="Laning">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label">Release Year</label>
		    <div class="controls">
		      <input type="text" name="heroReleaseYear" placeholder="Release Year">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label">Battle Point</label>
		    <div class="controls">
		      <input type="text" name="heroBattlePoint" placeholder="Battle Point" value="0">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label">Diamond</label>
		    <div class="controls">
		      <input type="text" name="heroDiamond" placeholder="Diamond" value="0">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <div class="controls">
		      <button type="submit" class="btn">Create New</button>
		    </div>
		  </div>
		  
		</form>

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
