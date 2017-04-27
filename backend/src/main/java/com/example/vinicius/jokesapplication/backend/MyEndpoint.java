/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.vinicius.jokesapplication.backend;

import com.example.Jokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(name = "myApi",
		  version = "v1",
		  namespace = @ApiNamespace(ownerDomain = "backend.jokesapplication.vinicius.example.com",
					 ownerName = "backend.jokesapplication.vinicius.example.com", packagePath = ""))
public class MyEndpoint
{
	@ApiMethod(name = "getJoke")
	public MyBean getJoke()
	{
		Jokes jokes = new Jokes();

		MyBean response = new MyBean();
		response.setData(jokes.getJoke());

		return response;
	}

}
