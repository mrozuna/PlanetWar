var planetWar= planetWar || {};
planetWar.ClientID= "578212509870.apps.googleusercontent.com";
planetWar.SCOPES='https://www.googleapis.com/auth/userinfo.email ' +
'https://www.googleapis.com/auth/plus.login';
planetWar.signedIn = false;

planetWar.getEmailFromIDToken = function(idToken) {
	  if (typeof idToken !== 'string') {
		    return;
		  }

		  var segments = idToken.split('.');
		  if (segments.length !== 3) {
		    return;
		  }

		  try {
		    var claimSet = JSON.parse(atob(segments[1]));
		  } catch (e) {
		    return;
		  }

		  if (claimSet.email && typeof claimSet.email === 'string') {
		    return claimSet.email;
		  }
		}
planetWar.signout = function() {
	planetWar.signedIn = false;

	}

planetWar.signinCallback = function(authResult) {
	  var tokenEmail = planetWar.getEmailFromIDToken(
		      authResult.id_token);
		  if (authResult.access_token && tokenEmail) {
			  if(planetWar.signedIn ==false){			  
				  planetWar.signedIn = true;
			  
			  }else{
				  window.location  ="/page/index.jsp";
			  }
		    document.getElementById('signinButtonContainer').classList.remove(
		        'visible');
		    document.getElementById('signedInStatus').classList.add('visible');
		  } else {
		    document.getElementById('signinButtonContainer').classList.add('visible');
		    document.getElementById('signedInStatus').classList.remove('visible');

		    if (!authResult.error) {
		      console.log('Unexpected result');
		      console.log(authResult);
		    } else if (authResult.error !== 'immediate_failed') {
		      console.log('Unexpected error occured: ' + authResult.error);
		    } else {
		      console.log('Immediate mode failed, user needs to click Sign In.');
		    }
		  }
		};
		
planetWar.render = function() {
	  gapi.signin.render('signinButton', {
		    'callback': planetWar.signinCallback,
		    'clientid': planetWar.ClientID,
		    'cookiepolicy': 'single_host_origin',
		    'requestvisibleactions': 'http://schemas.google.com/AddActivity',
		    'scope': planetWar.SCOPES
		  });
		};
		// A quirk of the JSONP callback of the plusone client makes it so
		// our callback must exist as an element in window.
		window['planetWar.render'] = planetWar.render;

		// Recommended code to load Google+ JS library.
		(function() {
		  var newScriptElement = document.createElement('script');
		  newScriptElement.type = 'text/javascript';
		  newScriptElement.async = true;
		  newScriptElement.src = 'https://apis.google.com/js/client:plusone.js' +
		                         '?onload=planetWar.render';
		  var firstScriptElement = document.getElementsByTagName('script')[0];
		  firstScriptElement.parentNode.insertBefore(newScriptElement,
		                                             firstScriptElement);
		})();
