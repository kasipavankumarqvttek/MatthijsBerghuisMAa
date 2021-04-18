import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game
{
    int monsterCount = 5;

    player player = new player();
    monster monster = new monster("Mummie");

    Random rand = new Random();

    public void Run() throws InterruptedException
    {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("You are surrounded by a Skeleton, Slime, Zombie, Wolf and a Spider!");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("Type Attack and then the monster name");
        System.out.println("---------------------------------------");

        while (true) {
            TimeUnit.SECONDS.sleep(3);
                Scanner readChoice = new Scanner(System.in);
                String userChoice = readChoice.nextLine();
                while (true) {
                    if (!userChoice.equalsIgnoreCase("Attack Slime") && !userChoice.equalsIgnoreCase("Attack Wolf") && !userChoice.equalsIgnoreCase("Attack Zombie") && !userChoice.equalsIgnoreCase("Attack Skeleton") && !userChoice.equalsIgnoreCase("Attack Spider")) {
                        System.out.println("Choose a valid choice");
                        readChoice = new Scanner(System.in);
                        userChoice = readChoice.nextLine();
                    } else {
                        Attack();
                    }
                    if (monsterCount <= 0)
                    {
                        Win();
                    }
                    if (player.getHealth() <= 0)
                    {
                        Lose();
                    }
                    if (monster.getHealth() <= 0)
                    {
                        monster.setHealth(30);
                        break;
                    }
                }
            }
        }
        public void Attack() throws InterruptedException
        {
            if (rand.nextBoolean()) {
                monster.setHealth(monster.getHealth() - 10);
                System.out.println("---------------------");
                System.out.println("You hit the Monster!");
                System.out.println("Monster has " + monster.getHealth() + " HP left");
                System.out.println("---------------------");
            } else {
                player.setHealth(player.getHealth() - 10);
                System.out.println("---------------------");
                System.out.println("You got hit!");
                System.out.println("You have " + player.getHealth() + " HP left");
                System.out.println("---------------------");
            }
            if (monster.getHealth() <= 0)
            {
                monsterCount = monsterCount - 1;
                System.out.println("------------------------");
                System.out.println("You won the battle!");
                System.out.println( monsterCount + " monsters remaining");
                System.out.println("------------------------");
            }
            TimeUnit.SECONDS.sleep(3);
        }
    public void Win()
    {
        if (player.getHealth() > 0)
        {
            System.out.println("---------");
            System.out.println("You win!!");
            System.out.println("---------");

            System.exit(0);
        }
    }

    public void Lose()
    {
        System.out.println("-------------");
        System.out.println("You lost....");
        System.out.println("-------------");

        System.exit(0);
    }
}

