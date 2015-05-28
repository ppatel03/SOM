package som.beans;

public class VectorCoordinate {
	private double x;
	private double y;	
	
	
	
	public boolean isOverlapping(double x, double y){
		if(Math.abs(this.x - x ) < 10 && Math.abs(this.y - y ) < 10 ){
			return true;
		}
		else{
			return false;
		}
	}



	public double getX() {
		return x;
	}



	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}



	public void setY(double y) {
		this.y = y;
	}
	
}
