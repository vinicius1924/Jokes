import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

/**
 * Created by vinicius on 03/05/17.
 */

@RunWith(AndroidJUnit4.class)
public class JokeTest implements EndpointsAsyncTask.OnJokeReceivedListener
{
	CountDownLatch countDownLatch;
	String joke;

	@Test
	public void retrieveJokeTest()
	{
		try
		{
			countDownLatch = new CountDownLatch(1);
			new EndpointsAsyncTask().execute(this);
			countDownLatch.await(10, TimeUnit.SECONDS);
			assertNotNull("joke is null", joke);
			assertFalse("joke is empty", joke.isEmpty());
		}
		catch(InterruptedException e)
		{
			/* faz com que o teste falhe */
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void onReceived(String joke)
	{
		this.joke = joke;
		countDownLatch.countDown();
	}
}
