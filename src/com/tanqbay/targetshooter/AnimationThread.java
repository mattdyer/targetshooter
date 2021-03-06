package com.tanqbay.targetshooter;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.content.Context;
import java.lang.Error;

public class AnimationThread extends Thread {
	private SurfaceHolder surfaceHolder;
	private ISurface panel;
	private boolean run = false;
	private Context context;
	
	public AnimationThread(SurfaceHolder surfaceHolder, ISurface panel, Context context) {
		this.surfaceHolder = surfaceHolder;
		this.panel = panel;
		this.context = context;		

		panel.onInitalize();
	}
	
	public void setRunning(boolean value) {
		run = value;
	}
	
	private long timer;

	@Override
	public void run() {
		
		Canvas c;
		while (run) {

			try{
				c = null;
				timer = System.currentTimeMillis();
				panel.onUpdate((double) timer);

				try {
					//Thread.sleep(500);
					c = surfaceHolder.lockCanvas(null);
					synchronized (surfaceHolder) {
						panel.onRedraw(c);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				finally {
					// do this in a finally so that if an exception is thrown
					// during the above, we don't leave the Surface in an
					// inconsistent state
					if (c != null) {
						surfaceHolder.unlockCanvasAndPost(c);
					}
				}
			}catch(Exception e2){
				DebugNotifier.notify(e2,context);


			}catch(Error e3){
			   DebugNotifier.notify(e3,context);
			   
			   throw e3;
			}
		}    		
	}
}