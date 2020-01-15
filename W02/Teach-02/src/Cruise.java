public class Cruise implements Expense{

    float cost;
    Destination destination;

    public Cruise(Destination destination) {
        this.destination = destination;

        switch (destination) {
            case Mexico:
                this.cost = (float) 1000.00;
                break;
            case Europe:
                this.cost = (float) 2000.00;
                break;
            case Japan:
                this.cost = (float) 3000.00;
                break;
            default:
                this.cost = (float) 0.00;
        }
    }

    @Override
    public float getCost() {
        return cost;
    }
}
