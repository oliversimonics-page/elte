public class Complex{
    public double im, re;
    public void PrintCo(){
        System.out.println(this.re + "+" + this.im + " i");
    }

    public double abs (){
        return Math.sqrt(Math.pow(this.im, 2) + Math.pow(this.re, 2));
    }
    public void add (Complex c){
        this.im += c.im;
        this.re += c.re;
    }
    public void sub (Complex c){
        this.im -= c.im;
        this.re -= c.re;
    }
    public void mul (Complex c){
        double tempre = this.re;
        this.re = this.re*c.re-this.im*c.im;
        this.im = tempre*c.im+this.im*c.re;
    }
}