class Circle{
    public Point center;
    public double r;
    public PrintCi(){
        center.PrintPoint();
        System.out.println("radius: " + r);
    }
    public void enlarge(double f){
        this.r *= f;
    }
    public double getAre(){
        return Math.pow(r, 2) * Math.PI;
    }
    
}