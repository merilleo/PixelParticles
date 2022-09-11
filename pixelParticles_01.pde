import java.util.ArrayList;

UtilityFunctions utils;
AbstractParticleSystem ps;
Image img01;


AbstractParticle particle = new Particle();

ArrayList<AbstractForce> forces = new ArrayList<AbstractForce> ();
forces.add(new RandomForce(0.1));
forces.add(new DragForce());

ArrayList<AbstractDrawingMethode> drawingMethods = new ArrayList<AbstractDrawingMethode> ();
drawingMethods.add(new DrawSquare(10));

PImage pimage;

void setup() {
    size(250, 250);
    fill(255, 255, 255);
    rect(0, 0, width, height);


    utils = new UtilityFunctions();
	
    ps = new ParticleSystem();
    ps.addForceList(forces);
    ps.addDrawingMethodeList(drawingMethods);
    ps.spawnNumberOfParticles(25, particle);
    ps.setRandomPositions();

    img01 = new Image(width, height);
    AbstractPixel pixel = new Pixel(0, width, color(0, 0, 0));
    pimage = loadImage("frau_02_a.jpg");
    img01.importPImage(pimage, pixel);
}

void draw() {

    ps.update();

    ps.getParticleList().forEach(p - > p.setColor(
        img01.getPixel(
        utils.getNearestIndex(p.getX(), p.getY(), img01.getWidth())
        ).getColor()

        ));

    //utils.showFramerate();
}
