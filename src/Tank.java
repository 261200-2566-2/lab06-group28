public class Tank extends Characters{
    /** Create Characters has class Tank.
     * @param CL have to be only "Tank".
     */
    Tank(int level, double speed, String name ,String CL) {
        super(level, speed, name ,CL);
    }

    /** Increase deff of the Character by 20% of Tank's deff.
     * effect: Increase Character's deff by 20% of Tank's deff but maximum that can be increased is 1000.
     * effect: "Tank's name defence Character's name by 20% of Tank's deff." is printed
     *          if Character's deff is less than 1000.
     * effect: "Your deff is max." is printed if Character's deff is more than 1000.
     */
    void defence(Characters c){
        if(c.getElement("deff") < 1000){
//            c.deff += this.deff*0.2;
            c.assign_Element("deff",c.getElement("deff")+this.getElement("deff")*0.2);
            if(c.getElement("deff") >= 1000) c.assign_Element("deff",1000);
            System.out.println(this.getName_CL("name") + " defence " + c.getName_CL("name")
            + " " + this.getElement("deff")*0.2);
        }else{
            System.out.println("Your deff is max.");
        }
    }
}
