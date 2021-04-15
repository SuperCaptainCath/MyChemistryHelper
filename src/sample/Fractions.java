
package sample;


/**
 *
 * @author Ioana Maria Jivan
 */
public class Fractions {
    private String fraction = "0/1";
    
    public Fractions(String string){
        this.fraction = string;
    }
    
    public Fractions(Fractions frac){
        this.fraction = frac.toString();
    }
    
    @Override
    public String toString(){
        return this.fraction;
    }
    
    public Fractions multiply(Fractions frac){
        int num1 = this.getNumeratorInInt();
        int num2 = frac.getNumeratorInInt();
        int denom1 = this.getDenominatorInInt();
        int denom2 = frac.getDenominatorInInt();
        
        int numf = num1 * num2;
        int denomf = denom1 * denom2;
        Fractions finalF = new Fractions(numf + "/" + denomf);
        return new Fractions(Fractions.simplify(finalF));
    }
    
    public Fractions divide(Fractions frac){
        int num1 = this.getNumeratorInInt();
        int num2 = frac.getNumeratorInInt();
        int denom1 = this.getDenominatorInInt();
        int denom2 = frac.getDenominatorInInt();
        
        int numf = num1 * denom2;
        int denomf = denom1 * num2;
        Fractions finalF = new Fractions(numf + "/" + denomf);
        return new Fractions(Fractions.simplify(finalF));
    }
    
    public Fractions add(Fractions frac){
        int num1 = this.getNumeratorInInt();
        int num2 = frac.getNumeratorInInt();
        int denom1 = this.getDenominatorInInt();
        int denom2 = frac.getDenominatorInInt();
        
        int[] arrayOfDenoms = {denom1, denom2};
        
        int lcmOfDenom = Fractions.lcm(arrayOfDenoms);
        
        int numF = (num1 * (lcmOfDenom/denom1)) + (num2 * (lcmOfDenom/denom2));
        
        Fractions finalF = new Fractions(numF + "/" + lcmOfDenom);
        return new Fractions(Fractions.simplify(finalF));
    }
    
    public Fractions subtract(Fractions frac){
        int num1 = this.getNumeratorInInt();
        int num2 = frac.getNumeratorInInt();
        int denom1 = this.getDenominatorInInt();
        int denom2 = frac.getDenominatorInInt();
        
        int[] arrayOfDenoms = {denom1, denom2};
        
        int lcmOfDenom = Fractions.lcm(arrayOfDenoms);
        
        int numF = (num1 * (lcmOfDenom/denom1)) - (num2 * (lcmOfDenom/denom2));
        
        Fractions finalF = new Fractions(numF + "/" + lcmOfDenom);
        return new Fractions(Fractions.simplify(finalF));
    }
    
    public void multiplyV(Fractions frac){
        int num1 = this.getNumeratorInInt();
        int num2 = frac.getNumeratorInInt();
        int denom1 = this.getDenominatorInInt();
        int denom2 = frac.getDenominatorInInt();
        
        int numf = num1 * num2;
        int denomf = denom1 * denom2;
        Fractions finalF = new Fractions(numf + "/" + denomf);
        this.fraction = Fractions.simplify(finalF);
    }
    
    public void divideV(Fractions frac){
        int num1 = this.getNumeratorInInt();
        int num2 = frac.getNumeratorInInt();
        int denom1 = this.getDenominatorInInt();
        int denom2 = frac.getDenominatorInInt();
        
        int numf = num1 * denom2;
        int denomf = denom1 * num2;
        Fractions finalF = new Fractions(numf + "/" + denomf);
        this.fraction = Fractions.simplify(finalF);
    }
    
    public void addV(Fractions frac){
        int num1 = this.getNumeratorInInt();
        int num2 = frac.getNumeratorInInt();
        int denom1 = this.getDenominatorInInt();
        int denom2 = frac.getDenominatorInInt();
        
        int[] arrayOfDenoms = {denom1, denom2};
        
        int lcmOfDenom = Fractions.lcm(arrayOfDenoms);
        
        int numF = (num1 * (lcmOfDenom/denom1)) + (num2 * (lcmOfDenom/denom2));
        
        Fractions finalF = new Fractions(numF + "/" + lcmOfDenom);
        this.fraction = Fractions.simplify(finalF);
    }
    
    public void subtractV(Fractions frac){
        int num1 = this.getNumeratorInInt();
        int num2 = frac.getNumeratorInInt();
        int denom1 = this.getDenominatorInInt();
        int denom2 = frac.getDenominatorInInt();
        
        int[] arrayOfDenoms = {denom1, denom2};
        
        int lcmOfDenom = Fractions.lcm(arrayOfDenoms);
        
        int numF = (num1 * (lcmOfDenom/denom1)) - (num2 * (lcmOfDenom/denom2));
        
        Fractions finalF = new Fractions(numF + "/" + lcmOfDenom);
        this.fraction = Fractions.simplify(finalF);
    }
    
    public Fractions getDenominatorInFrac(){
        String[] splitString = this.fraction.split("/");
        return new Fractions(splitString[1] + "/1");
    }
    
    public Fractions getNumeratorInFrac(){
        String[] splitString = this.fraction.split("/");
        return new Fractions(splitString[0] + "/1");
    }
    
    public int getDenominatorInInt(){
        String[] splitString = this.fraction.split("/");
        return Integer.parseInt(splitString[1]);
    }
    
    public int getNumeratorInInt(){
        String[] splitString = this.fraction.split("/");
        return Integer.parseInt(splitString[0]);
    }
    
    public double toDouble(){
        String[] splitString = this.fraction.split("/");
        return (Double.parseDouble(splitString[0]) / Double.parseDouble(splitString[1]));
    }
    
    public static int lcm(int[] arrayOfIntDenoms){
        int t = 1;
        boolean isNotDivisible = true;
        
        while(isNotDivisible){
            isNotDivisible = false;
            
            for(int i = 0; i < arrayOfIntDenoms.length; i++){
                if(t % arrayOfIntDenoms[i] != 0){
                    isNotDivisible = true;
                    t = t + 1;
                    i = 0;
                }
            }
        }
        
        return t;
    }
    
    public static String simplify(Fractions frac){
        int num = frac.getNumeratorInInt();
        int denom = frac.getDenominatorInInt();
        
        if(denom < 0){
            num = -num;
            denom = -denom;
        }
        
        //find smallest
        int smallest;
        if(num < denom){
            smallest = num;
        }
        else{
            smallest = denom;
        }
        
        //gcd
        int gcd = 1;
        if(num == denom){
            gcd = num;
        }
        else{
            for(int i = 1; i <= smallest; i++){
                if(num % i == 0 && denom % i == 0){
                    gcd = i;
                }
            }
        }
        
        if(num == 0){
            return "0/1";
        }
        else{
            return (num / gcd) + "/" + (denom / gcd);
        }
    
    }
}
 