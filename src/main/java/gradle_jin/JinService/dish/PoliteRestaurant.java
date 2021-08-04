package gradle_jin.JinService.dish;

public class PoliteRestaurant {
    public static void main(String[] args) {
        PoliteServer server = new PoliteServer(new KitchenService());

        server.doingMyJob().subscribe(
                dish -> System.out.println("Consuming " + dish),
                throwable -> System.err.println(throwable)
        );
    }
}
