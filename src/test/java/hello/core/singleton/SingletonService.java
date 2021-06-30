package hello.core.singleton;

public class SingletonService {

    // 자기자신을 객체 인스턴스로 생성
    private static final SingletonService instance = new SingletonService();

    // 조회
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() { // private 로 생성 막기
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
