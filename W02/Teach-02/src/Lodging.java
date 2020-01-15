public class Lodging implements Expense {
    Destination destination;
    float cost;
    int nights;

    public Lodging(Destination destination, int nights) {
        this.destination = destination;
        this.nights = nights;

        switch (destination) {
            case Mexico:
                this.cost = (float) (100.00 * nights);
                break;
            case Europe:
                this.cost = (float) ((200.00 * nights) * 1.1);
                break;
            case Japan:
                this.cost = (float) ((300.00 * nights) * 1.3);
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
