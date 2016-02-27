/**
 * Created by oriola on 2015-12-05.
 */
public class PresentBox {

    private int length;
    private int width;
    private int height;

    public PresentBox(String[] dimensions){
        this.length = Integer.parseInt(dimensions[0]);
        this.width = Integer.parseInt(dimensions[1]);
        this.height = Integer.parseInt(dimensions[2]);
    }

    public PresentBox(String length, String width, String height){
        this.length = Integer.parseInt(length);
        this.width = Integer.parseInt(width);
        this.height = Integer.parseInt(height);
    }

    public int getSurfaceArea(){
        return 2*(length*width + width*height + height*length);
    }

    public int getSmallestArea(){
        return min(length*width, width*height,height*length);
    }

    private int min(int a, int b, int c){
        int x = Math.min(a,b);
        int y = Math.min(x,c);
        return y;
    }

    public int getWrappingPaperArea(){
        return getSurfaceArea() + getSmallestArea();
    }

    public int getBowRibbonLength(){
        return length*width*height;
    }

    public int getPresentRibbonLength(){
        return min(2*(length+width),2*(width+height),2*(height+length));
    }

    public int getTotalRibbonLength(){
        return getPresentRibbonLength() + getBowRibbonLength();
    }


}
