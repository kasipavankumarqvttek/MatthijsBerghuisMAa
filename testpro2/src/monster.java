public class monster
{
    private int _health = 20;

    private String name = "Slime";
    public monster(String name){
        this.name = name;
    }
    public void setHealth(int value)
    {
        if (value > 20) { value = 20;}
        if (value < 0) { value = 0;}
        _health = value;
    }
    public int getHealth()
    {
        return _health;
    }
}
