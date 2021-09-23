public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int size = in.readInt();
        Planet[] bodyArray = new Planet[size];
        in.readDouble();
        for(int i = 0; i < size; i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            bodyArray[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return bodyArray;
    }

    private static void drawBackgroud(String imgToDraw) {
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-256, 256);
        StdDraw.clear();
        StdDraw.picture(0, 0, imgToDraw);
    }

    private static void drawBodies(Planet[] bodyArray) {
        for(int i = 0; i < bodyArray.length; i++) {
            bodyArray[i].draw();
        }
    }

    public static void main(String args[]) {
        // Read the basic information
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];

        double radius = readRadius(fileName);
        Planet[] bodyArray = readPlanets(fileName);
        
        // Draw the universe 
        String imageToDraw = "./images/starfield.jpg";
        drawBackgroud(imageToDraw);
        drawBodies(bodyArray);
        StdDraw.show();

        while (dt < T) {
            double[] forcesX = new double[bodyArray.length];
            double[] forcesY = new double[bodyArray.length];
            for(int i = 0; i < bodyArray.length; i++) {
                forcesX[i] = bodyArray[i].calcNetForceExertedByX(bodyArray);
                forcesY[i] = bodyArray[i].calcNetForceExertedByY(bodyArray);
            }
            for(int i = 0; i < bodyArray.length; i++) {
                bodyArray[i].update(dt, forcesX[i], forcesY[i]);
            }
            drawBackgroud(imageToDraw);
            drawBodies(bodyArray);
            StdDraw.show();
            StdDraw.pause(10);
            dt += 0.001; 
        }
        StdOut.printf("%d\n", bodyArray.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodyArray.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            bodyArray[i].xxPos, bodyArray[i].yyPos, bodyArray[i].xxVel,
            bodyArray[i].yyVel, bodyArray[i].mass, bodyArray[i].imgFileName);
        }
    }
}
