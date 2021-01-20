// 
// Decompiled by Procyon v0.5.36
// 

public class Animal
{
    private String type;
    private String noun;
    private String scientific_noun;
    private Double maxSizecm;
    private Double minSizecm;
    private Double size;
    private String country;
    private String naturalHabitat;
    private String color;
    private String shapeofBeak;
    private String colorOfFeather;
    private Double minWinglength;
    private Double maxWinglength;
    
    public Animal(final String t, final String n, final String sn, final Double mxs, final Double mns, final Double s, final String c, final String ct, final String nh, final String bs, final String fc, final Double minWinglength, final Double maxWinglength) {
        this.type = t;
        this.noun = n;
        this.scientific_noun = sn;
        this.maxSizecm = mxs;
        this.minSizecm = mns;
        this.size = s;
        this.country = ct;
        this.naturalHabitat = nh;
        this.color = c;
        this.shapeofBeak = bs;
        this.colorOfFeather = fc;
        this.maxWinglength = maxWinglength;
        this.minWinglength = minWinglength;
    }
    
    public void displayData() {
        System.out.println("The type : " + this.type);
        System.out.println("The noun :" + this.noun);
        System.out.println("The Scientific : " + this.scientific_noun);
        System.out.println("The MaxSizeCm : " + this.maxSizecm);
        System.out.println("The MinSizeCm :" + this.minSizecm);
        System.out.println("The size :" + this.size);
        System.out.println("The country" + this.country);
        System.out.println("The NaturalHabitat " + this.naturalHabitat);
        System.out.println("The Color :" + this.color);
        System.out.println("Shape of Beak : " + this.shapeofBeak);
        System.out.println("Color of Feather : " + this.colorOfFeather);
        System.out.println("Min Wing Length : " + this.minWinglength);
        System.out.println("Max Wing Length " + this.maxWinglength);
    }
}
