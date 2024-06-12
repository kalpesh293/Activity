package lab.com;
import java.util.*;
class Gift 
{
    private String colour;
    private int weight;
    private int size;
    private String company;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

class GiftExtract 
{
    HashSet<Gift> bag = new HashSet<>();
    public void addGift(Gift gift)
    {
        bag.add(gift);
    }
    public void viewAllGift() 
    {
        if (bag.isEmpty()) 
        {
            System.out.println("No gifts in the bag.");
        } 
        else 
        {
            Iterator<Gift> i = bag.iterator();
            while (i.hasNext()) 
            {
                Gift b = i.next();
                System.out.println("Colour: " + b.getColour() + ", Company: " + b.getCompany() + ", Size: " + b.getSize() + ", Weight: " + b.getWeight());
            }
        }
    }
    public void pickUpGift() 
    {
        Iterator<Gift> i = bag.iterator();
        if (i.hasNext()) 
        {
            Gift b = i.next();
            System.out.println("Picked up gift - Colour: " + b.getColour() + ", Company: " + b.getCompany());
            i.remove(); // Remove the gift after picking it up
        }
        else 
        {
            System.out.println("Your bag is empty, no gift found.");
        }
    }
}

public class Demo 
{
    public static void main(String[] args)
    {
        GiftExtract be = new GiftExtract();
        Scanner xyz = new Scanner(System.in);
        while (true) 
        {
            System.out.println("1: Add gift in bag");
            System.out.println("2: View all gifts in bag");
            System.out.println("3: Pickup gift from bag");
            System.out.println("4: Exit");
            System.out.println("Enter your choice:");
            int choice = xyz.nextInt();
            switch (choice)
            {
                case 1:
                    Gift gift = new Gift();
                    xyz.nextLine(); 
                    System.out.println("Enter gift colour:");
                    String colourName = xyz.nextLine();
                    System.out.println("Enter gift company:");
                    String compName = xyz.nextLine();
                    System.out.println("Enter weight of gift in gm:");
                    int weight = xyz.nextInt();
                    System.out.println("Enter size of gift:");
                    int size = xyz.nextInt();
                    gift.setColour(colourName);
                    gift.setCompany(compName);
                    gift.setWeight(weight);
                    gift.setSize(size);
                    be.addGift(gift);
                    break;
                case 2:
                    be.viewAllGift();
                    break;
                case 3:
                    be.pickUpGift();
                    break;
                case 4:
                    xyz.close();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}