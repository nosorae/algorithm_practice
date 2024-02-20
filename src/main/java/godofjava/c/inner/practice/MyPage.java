package godofjava.c.inner.practice;

// GodOfJava Vol1. 16장 연습문제
// 컴파일해서 실행해보면 익명클래스는 MyPage$1.class 로 나오는 것을 확인할 수 있다.
// 여러 파일 한 번에 컴파일은 https://www.delftstack.com/ko/howto/java/compile-multiple-java-files/ 참고
public class MyPage {
    static InputBox input;
    public static void main(String[] args) {
        MyPage page = new MyPage();
        page.setUI();
        page.pressKey();
    }

    public void setUI() {
        input = new InputBox();
        KeyEventListener listener = new KeyEventListener() {
            @Override
            public void onKeyDown() {
                System.out.println("Key Down");
            }

            @Override
            public void onKeyUp() {
                System.out.println("Key Up");
            }
        };

        input.setKeyListener(listener);
    }

    public void pressKey() {
        input.listenerCalled(InputBox.KEY_DOWN);
        input.listenerCalled(InputBox.KEY_UP);
    }
}
