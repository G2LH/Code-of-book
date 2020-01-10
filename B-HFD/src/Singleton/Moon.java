package Singleton;

public class Moon {
    private static Moon uniqueMoon;
    double radius;
    double distanceToEarth;

    private Moon() {
        uniqueMoon = this;
        radius = 1738;
        distanceToEarth = 363300;
    }

    public static synchronized Moon getMoon() {
        if (uniqueMoon==null) {
            uniqueMoon = new Moon();
        }
        return uniqueMoon;
    }

    public String show(){
        String string = "月亮的半径是"+radius+"km,距地球是"+distanceToEarth+"km";
        return string;
    }
}
