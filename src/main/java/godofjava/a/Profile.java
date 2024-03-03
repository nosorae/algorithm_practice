package godofjava.a;

// GodOfJava Vol1. 2장, 3장
/*
 커맨드 명령어 사용
 yessorae@nosoraeui-MacBookPro god_of_java % javac Profile.java <- 컴파일, .class 생성
 yessorae@nosoraeui-MacBookPro god_of_java % java Profile.java <- 실행
 */
public class Profile {
    String name;
    int age;

    public static void main(String[] args) {
        Profile profile = new Profile();
        profile.setName("No So Rae");
        profile.setAge(28);

        profile.printName();
        profile.printAge();
    }

    public void setName(String str) {
        name = str;
    }

    public void setAge(int val) {
        age = val;
    }

    public void printName() {
        System.out.println(String.format("My name is %s", name));
    }

    public void printAge() {
        System.out.println(String.format("My age is %d", age));
    }
}
