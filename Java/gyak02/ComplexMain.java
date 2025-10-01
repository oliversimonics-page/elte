public class ComplexMain{
    public static void main(String[] args){
        Complex alpha = new Complex();
        Complex beta = new Complex(); 
        alpha.re = 3;
        alpha.im = 2;
        beta.re = 1;
        beta.im = 2;

        alpha.add(beta);
        alpha.PrintCo();
        // alpha.re == 4 && alpha.im == 4 && beta.re == 1 && beta.im == 2
        alpha.sub(beta);
        alpha.PrintCo();
        // alpha.re == 3 && alpha.im == 2 && beta.re == 1 && beta.im == 2
        alpha.mul(beta);
        alpha.PrintCo();
        // alpha.re == -1 && alpha.im == 8 && beta.re == 1 && beta.im == 2
    }
}