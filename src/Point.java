/**
 * Created by oriola on 2015-12-07.
 */
public class Point {

    private int x = 0;
    private int y = 0;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(Point point){
        this.x = point.x;
        this.y = point.y;
    }

    public void changePoint(Point p){
        p.x = 0;
        p = new Point(0,0);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void incrX(){
        x++;
    }

    public void decrX(){
        x--;
    }

    public void incrY(){
        y++;
    }

    public void decrY(){
        y--;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }

        if(!(o instanceof Point)){
            return false;
        }

        Point other = (Point) o;
        if(x == other.getX() && y == other.getY()){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return x*10000+y;
    }


}
