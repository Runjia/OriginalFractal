import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OriginalFractal extends PApplet {

private double divideAngle = 2.1f;
private double smallestEllipse= 30;
private double fractionLength = .8f;

public void setup(){
	size(800,800);
	noLoop();
}
public void draw(){
	background(0,0,0);
	noStroke();
	fill(0,255,0);
	drawEllipse1(400,400,150);
	drawEllipse2(400,400,150);
}
public void drawEllipse1(int x,int y,double radius){
	int color1=(int)(Math.random()*256);
	int color2=(int)(Math.random()*256);
	int color3=(int)(Math.random()*256);
	fill(color1,color2,color3);

	double angleA=3*Math.PI/2;

	double angle1=angleA+divideAngle;
	double angle2=angleA-divideAngle;
	radius=radius*fractionLength;

	int newX1=(int)(radius*Math.cos(angle1) + x);
	int newY1=(int)(radius*Math.sin(angle1) + y);
	int newX2=(int)(radius*Math.cos(angle2) + x);
	int newY2=(int)(radius*Math.sin(angle2) + y);

	ellipse((float)newX1,(float)newY1,(float)radius,(float)radius);
	ellipse((float)newX2,(float)newY2,(float)radius,(float)radius);

	if (radius<=smallestEllipse){
		ellipse((float)(newX1),(float)(newY1),(float)(10),(float)(10));
		ellipse((float)(newX2),(float)(newY2),(float)(10),(float)(10));
	}
	else {
		drawEllipse1(newX1,newY1,radius);
		drawEllipse1(newX2,newY2,radius);
	}
}

public void drawEllipse2(int x,int y,double radius){
	int color1=(int)(Math.random()*256);
	int color2=(int)(Math.random()*256);
	int color3=(int)(Math.random()*256);
	fill(color1,color2,color3);

	double angleB=1*Math.PI/2;

	double angle3=angleB+divideAngle;
	double angle4=angleB-divideAngle;
	radius=radius*fractionLength;

	int newX3=(int)(radius*Math.cos(angle3) + x);
	int newY3=(int)(radius*Math.sin(angle3) + y);
	int newX4=(int)(radius*Math.cos(angle4) + x);
	int newY4=(int)(radius*Math.sin(angle4) + y);

	ellipse((float)newX3,(float)newY3,(float)radius,(float)radius);
	ellipse((float)newX4,(float)newY4,(float)radius,(float)radius);

	if (radius<=smallestEllipse){
		ellipse((float)(newX3),(float)(newY3),(float)(10),(float)(10));
		ellipse((float)(newX4),(float)(newY4),(float)(10),(float)(10));
	}
	else {
		drawEllipse2(newX3,newY3,radius);
		drawEllipse2(newX4,newY4,radius);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalFractal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
