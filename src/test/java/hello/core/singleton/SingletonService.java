package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    // 이렇게 하면 메모리에 하나만 올라가게 된다

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출 ");
    }
}
