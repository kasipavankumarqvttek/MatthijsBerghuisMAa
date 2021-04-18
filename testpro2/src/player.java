public class player
{
    private int _health = 100;

    public void setHealth(int value)
    {
        if (value > 100) { value = 100;}
        if (value < 0) { value = 0;}
        _health = value;
    }
    public int getHealth()
    {
        return _health;
    }
}


