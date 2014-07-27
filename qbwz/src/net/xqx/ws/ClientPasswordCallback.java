package net.xqx.ws;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class ClientPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for(int i=0;i<callbacks.length;i++)   
		{   
			 WSPasswordCallback pc = (WSPasswordCallback)callbacks[i];   
			 int usage=pc.getUsage();
			 if(usage==WSPasswordCallback.USERNAME_TOKEN){
				 pc.setPassword("xqx1234");
			 }else if(usage==WSPasswordCallback.SIGNATURE){
				 pc.setPassword("keyPassword");
			 }
		}   

		
	}

}
