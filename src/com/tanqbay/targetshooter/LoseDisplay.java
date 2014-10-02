package com.tanqbay.targetshooter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

public class LoseDisplay extends Item {

	private Paint paint;
	private Boolean newHighScoreReached;
	private int currentHighScore;

	public LoseDisplay(DrawingSurface drawingSurface,Boolean newHighScoreReached, int currentHighScore) {
		super(drawingSurface);
		
		this.newHighScoreReached = newHighScoreReached;
		this.currentHighScore = currentHighScore;
		
		paint = new Paint();
		
		paint.setTextSize(30);
		paint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
		
		paint.setColor(0xff00ff00);
		paint.setAntiAlias(true);
		
		
		
	}
	
	
	public void drawSelf(Canvas canvas){
		
		
		paint.setColor(0xaa000000);
		canvas.drawPaint(paint);
		
		paint.setColor(0xff00ff00);
		
		String message = "You Failed to Stop the Invaders";
		
		float textWidth = paint.measureText(message);
		
		float startX = (drawingSurface.getWidth() / 2) - (textWidth / 2);
		float startY = drawingSurface.getHeight() / 2;
		
		canvas.drawText(message,startX,startY,paint);
		
		if(newHighScoreReached){
			String highScoreMessage = "New High Score: " + String.valueOf(currentHighScore);
			
			textWidth = paint.measureText(highScoreMessage);
			
			startX = (drawingSurface.getWidth() / 2) - (textWidth / 2);
			startY = startY + 50;
			
			canvas.drawText(highScoreMessage,startX,startY,paint);
		}else{
			String highScoreMessage = "High Score: " + String.valueOf(currentHighScore);
			
			textWidth = paint.measureText(highScoreMessage);
			
			startX = (drawingSurface.getWidth() / 2) - (textWidth / 2);
			startY = startY + 50;
			
			canvas.drawText(highScoreMessage,startX,startY,paint);
			
			String yourScoreMessage = "Your Score: " + String.valueOf(drawingSurface.getHits());
			
			textWidth = paint.measureText(yourScoreMessage);
			
			startX = (drawingSurface.getWidth() / 2) - (textWidth / 2);
			startY = startY + 50;
			
			canvas.drawText(yourScoreMessage,startX,startY,paint);
		}
		
	}
	
}
