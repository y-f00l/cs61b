public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, 
            double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b){
        return Math.sqrt((b.xxPos - this.xxPos) * (b.xxPos - this.xxPos) + 
                (b.yyPos - this.yyPos) * (b.yyPos - this.yyPos)); 
    }

    public double calcForceExertedBy(Planet b){
        return this.G * b.mass * this.mass 
            / Math.pow(calcDistance(b), 2); 
    }

    public double calcForceExertedByX(Planet b){
        return calcForceExertedBy(b) 
            * (b.xxPos - this.xxPos) / calcDistance(b);
    }

    public double calcForceExertedByY(Planet b){
        return calcForceExertedBy(b)
            * (b.yyPos - this.yyPos) / calcDistance(b);
    }

    public double calcNetForceExertedByX(Planet[] bodyList) {
        int index = -1;
        for(int i = 0; i < bodyList.length; i++){
            if(this.equals(bodyList[i])) {
                index = i;
                break;
            }
        }
        double XForce = 0;
        for(int i = 0; i < bodyList.length; i++){
            if(i == index){
                continue;
            }
            XForce += calcForceExertedByX(bodyList[i]);
        }
        return XForce;
    }

    public double calcNetForceExertedByY(Planet[] bodyList) {
        int index = -1;
        for(int i = 0; i < bodyList.length; i++){
            if(this.equals(bodyList[i])) {
                index = i;
                break;
            }
        }
        double YForce = 0;
        for(int i = 0; i < bodyList.length; i++){
            if(i == index){
                continue;
            }
            YForce += calcForceExertedByY(bodyList[i]);
        }
        return YForce;
    }

    public void update(double dt, double fX, double fY){
        double aX = fX / this.mass;
        double aY = fY / this.mass;

        this.xxVel = this.xxVel + aX * dt;
        this.yyVel = this.yyVel + aY * dt;

        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(this.xxPos / 1e9, this.yyPos / 1e9, "images/" + this.imgFileName);
    }
}
