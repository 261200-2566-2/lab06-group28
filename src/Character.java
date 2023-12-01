public interface Character{
    void attack(Characters c);
    void equip_Ring(Ring r);
    void equip_Boot(Boot b);
    void showstatus();
    void update();
    double getElement(String s);
    String getName_CL(String s);
    int getLv();
    void assign_Element(String s, double n);

}
