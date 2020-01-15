public class Dining implements Expense{

    Destination destination;
    int nights;
    float cost;

    public Dining(Destination destination, int nights) {
        this.destination = destination;
        this.nights = nights;

        switch (destination) {
            case Mexico:
                this.cost = (float) 10.00;
                break;
            case Europe:
                this.cost = (float) 20.00;
                break;
            case Japan:
                this.cost = (float) 30.00;
                break;
            default:
                this.cost = (float) 0.00;
        }
    }

    @Override
    public float getCost() {

        float totalCost = nights * cost;

        return totalCost;
    }
}
